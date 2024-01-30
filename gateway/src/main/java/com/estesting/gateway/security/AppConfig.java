package com.estesting.gateway.security;

import com.estesting.gateway.PasswordEncoderImpl;
import com.estesting.gateway.model.User;
import com.estesting.gateway.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

  @Autowired private UserRepository userRepository;

  @Bean
  public UserDetailsService userDetailsService() {


    return username -> {
      List<User> userEmailLogin = userRepository.findByEmail(username);
      List<User> userUsername = userRepository.findByUsername(username);

      return Objects.requireNonNull(
              Stream.of(userEmailLogin, userUsername)
                  .filter(userList -> !userList.isEmpty())
                  .toList()
                  .stream()
                  .findFirst()
                  .orElse(null))
          .stream()
          .findFirst()
          .orElse(null);
    };
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService());
    authenticationProvider.setPasswordEncoder(new PasswordEncoderImpl());
    return authenticationProvider;
  }

  @SneakyThrows
  @Bean
  public AuthenticationManager authenticationManager(
      AuthenticationConfiguration authenticationConfiguration) {
    return authenticationConfiguration.getAuthenticationManager();
  }
}
