package com.nisum.demo.dto;

import com.nisum.demo.model.User;
import java.util.List;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserMapperTests {

    @InjectMocks
    private UserMapperImpl userMapper;
    private final Faker faker = new Faker();
    @Test
    public void testUserRequestToUser() {
        UserRequest userRequest = new UserRequest();
        userRequest.setName(faker.name().fullName());
        userRequest.setEmail(faker.internet().emailAddress());
        userRequest.setPassword(faker.internet().password());

        PhoneRequest phoneRequest = new PhoneRequest();
        phoneRequest.setNumber(faker.phoneNumber().cellPhone());
        phoneRequest.setCitycode(faker.phoneNumber().extension());
        phoneRequest.setCountrycode(faker.phoneNumber().extension());

        userRequest.setPhones(List.of(phoneRequest));

        User user = userMapper.userRequestToUser(userRequest);

        assertEquals(userRequest.getName(), user.getName());
        assertEquals(userRequest.getEmail(), user.getEmail());
        assertEquals(userRequest.getPassword(), user.getPassword());
        assertEquals(userRequest.getPhones().size(), user.getPhones().size());
    }
}
