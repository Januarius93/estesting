package com.estesting.gateway.repository;

import com.estesting.gateway.GatewayApplication;
import com.estesting.gateway.model.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Configuration
@EnableJpaRepositories(basePackages = "com.estesting.gateway.repository")
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

//    @BeforeTest
//    public void setUpBeforeTest() {
//        userRepository.saveAll(List.of(
//                new User(), new User(), new User(), new User(), new User()
//        ));
//    }

    @Test
    public void saveEntityTest() {
        User user = new User();
        user.setEmail("blaba@blabal.com");
        userRepository.save(user);
        assertThat(userRepository.findById(user.getId()).get().getEmail(),equalTo("blaba@blabal.com"));
    }
}
