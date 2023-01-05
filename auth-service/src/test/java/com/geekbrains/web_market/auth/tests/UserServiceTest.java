package com.geekbrains.web_market.auth.tests;


import com.geekbrains.web_market.auth.entities.User;
import com.geekbrains.web_market.auth.repositories.UserRepository;
import com.geekbrains.web_market.auth.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;

@SpringBootTest(classes = UserService.class)
public class UserServiceTest {
    @Mock
    List<String> mockedList;
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    void setUserService() {

    }

    @Test
    public void findOneUserTest() {
        User userFromDb = new User();
        userFromDb.setUsername("John");
        userFromDb.setEmail("john@mail.ru");
        userFromDb.setId(1L);

        Mockito.doReturn(Optional.of(userFromDb))
                .when(userRepository)
                .findByUsername("John");
        User userJohn = userService.findByUsername("John").get();
        userJohn.setId(1L);
        Optional<User> optionalUser = userService.findById(1L);

        Assertions.assertNotNull(userJohn);
        Assertions.assertEquals("john@mail.ru", userJohn.getEmail());
        verify(userRepository, Mockito.times(1)).findByUsername(ArgumentMatchers.eq("John"));
        Assertions.assertEquals(1L, userJohn.getId());

        Mockito.doReturn(Optional.of(optionalUser)).when(userRepository).findById(1L);
        verify(userRepository, Mockito.times(1)).findById(ArgumentMatchers.eq(1L));
        Mockito.verify(userRepository, Mockito.times(1)).findById(ArgumentMatchers.eq(1L));

    }
}
