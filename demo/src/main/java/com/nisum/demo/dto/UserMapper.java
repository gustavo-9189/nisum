package com.nisum.demo.dto;

import com.nisum.demo.model.Phone;
import com.nisum.demo.model.User;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userRequestToUser(UserRequest userRequest);

    List<Phone> phonesRequestToPhones(List<PhoneRequest> phoneRequests);

    Phone phoneRequestToPhone(PhoneRequest phoneRequest);

    UserResponse userToUserResponse(User user);

    List<PhoneResponse> phonesToPhoneResponses(List<Phone> phones);

    PhoneResponse phoneToPhoneResponse(Phone phone);

    User userUpdate(UserRequest userRequest, @MappingTarget User user);

    List<UserResponse> usersToUserResponses(List<User> users);
}
