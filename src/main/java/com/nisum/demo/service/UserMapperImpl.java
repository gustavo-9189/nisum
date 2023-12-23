package com.nisum.demo.service;

import com.nisum.demo.dto.PhoneRequest;
import com.nisum.demo.dto.PhoneResponse;
import com.nisum.demo.dto.UserRequest;
import com.nisum.demo.dto.UserResponse;
import com.nisum.demo.model.Phone;
import com.nisum.demo.model.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {
    @Override
    public User userRequestToUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public List<Phone> phonesRequestToPhones(List<PhoneRequest> phoneRequests) {
        return null;
    }

    @Override
    public Phone phoneRequestToPhone(PhoneRequest phoneRequest) {
        return null;
    }

    @Override
    public UserResponse userToUserResponse(User user) {
        return null;
    }

    @Override
    public List<PhoneResponse> phonesToPhoneResponses(List<Phone> phones) {
        return null;
    }

    @Override
    public PhoneResponse phoneToPhoneResponse(Phone phone) {
        return null;
    }

    @Override
    public User userUpdate(UserRequest userRequest, User user) {
        return null;
    }

    @Override
    public List<UserResponse> usersToUserResponses(List<User> users) {
        return null;
    }
}
