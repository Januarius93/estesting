package com.estesting.gateway.security;

import com.estesting.gateway.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  @Autowired private JwtService jwtService;
  private final UserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(
      @NotNull HttpServletRequest request,
      @NotNull HttpServletResponse response,
      @NotNull FilterChain filterChain)
      throws ServletException, IOException {
    final String authHeader = request.getHeader("Authorization");
    final String jwt;
    final String userLogin;
    if (authHeader == null) {
      filterChain.doFilter(request, response);
      return;
    } else {

      jwt = authHeader.substring(7);
      userLogin = jwtService.extractUserLogin(jwt);
      if (userLogin != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(userLogin);
        if (jwtService.isTokenValid(jwt, userDetails)) {
          UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
              new UsernamePasswordAuthenticationToken(
                  userDetails, null, userDetails.getAuthorities());
          usernamePasswordAuthenticationToken.setDetails(
              new WebAuthenticationDetailsSource().buildDetails(request));
          SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
      }
      filterChain.doFilter(request, response);
    }
}

}
