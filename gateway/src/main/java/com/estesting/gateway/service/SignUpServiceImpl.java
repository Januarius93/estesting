package com.estesting.gateway.service;

import com.estesting.gateway.form.SignUpForm;
import com.estesting.gateway.model.User;
import com.estesting.gateway.model.UserEntityMapper;
import com.estesting.gateway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {
  @Autowired private UserRepository userRepository;

  @Override
  public void createUser(SignUpForm signUpForm) {
    User user = new UserEntityMapper(signUpForm).generateUser();
    userRepository.save(user);
  }
}
