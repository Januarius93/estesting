package com.estesting.gateway.model;

import static com.estesting.dependencies.commons.ErrorCodes.THIS_IS_NOT_EMAIL;
import static com.estesting.dependencies.commons.Regex.EMAIL_REGEX;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "user_entity")
@Table(name = "USERS")
@Data
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Pattern(regexp = EMAIL_REGEX, message = THIS_IS_NOT_EMAIL)
  @Column(name = "EMAIL", length = 50, nullable = false, unique = true)
  private String email;

  @Column(name = "LOGIN", length = 50)
  private String login;

  @Column(name = "USERNAME", length = 50, nullable = false, unique = true)
  private String username;

  @Column(name = "PASSWORD", length = 200, nullable = false)
  @Getter
  private String password;

  @Column(name = "OLD_PASSWORD", length = 200)
  @Getter
  private String oldPassword;

  @Column(name = "AGE", length = 3, nullable = false)
  private Integer age;

  @Enumerated(EnumType.STRING)
  private Role role;

  public User(String login, String password) {
    this.username = login;
    this.password = password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
