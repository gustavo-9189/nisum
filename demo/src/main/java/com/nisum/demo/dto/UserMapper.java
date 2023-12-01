package com.nisum.demo.dto;

import com.nisum.demo.model.Phone;
import com.nisum.demo.model.User;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
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
