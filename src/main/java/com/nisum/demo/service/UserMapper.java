package com.nisum.demo.service;

import com.nisum.demo.dto.PhoneRequest;
import com.nisum.demo.dto.PhoneResponse;
import com.nisum.demo.dto.UserRequest;
import com.nisum.demo.dto.UserResponse;
import com.nisum.demo.model.Phone;
import com.nisum.demo.model.User;
import java.util.List;

public interface UserMapper {

    User userRequestToUser(UserRequest userRequest);

    List<Phone> phonesRequestToPhones(List<PhoneRequest> phoneRequests);

    Phone phoneRequestToPhone(PhoneRequest phoneRequest);

    UserResponse userToUserResponse(User user);

    List<PhoneResponse> phonesToPhoneResponses(List<Phone> phones);

    PhoneResponse phoneToPhoneResponse(Phone phone);

    User userUpdate(UserRequest userRequest, User user);

    List<UserResponse> usersToUserResponses(List<User> users);
}
