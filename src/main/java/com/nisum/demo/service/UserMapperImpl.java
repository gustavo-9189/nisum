package com.nisum.demo.service;

import com.nisum.demo.dto.PhoneRequest;
import com.nisum.demo.dto.PhoneResponse;
import com.nisum.demo.dto.UserRequest;
import com.nisum.demo.dto.UserResponse;
import com.nisum.demo.model.Phone;
import com.nisum.demo.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {

    @Override
    public User userRequestToUser(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.email());
        user.setPassword(userRequest.password());
        user.setName(userRequest.name());
        user.setPhones(this.phonesRequestToPhones(userRequest.phones()));
        return user;
    }

    private List<Phone> phonesRequestToPhones(List<PhoneRequest> phoneRequests) {
        List<Phone> phones = new ArrayList<>();
        phoneRequests.forEach(phoneRequest -> phones.add(this.phoneRequestToPhone(phoneRequest)));
        return phones;
    }

    private Phone phoneRequestToPhone(PhoneRequest phoneRequest) {
        Phone phone = new Phone();
        phone.setNumber(phoneRequest.number());
        phone.setCityCode(phoneRequest.cityCode());
        phone.setCountryCode(phoneRequest.countryCode());
        return phone;
    }

    @Override
    public UserResponse userToUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                this.phonesToPhoneResponses(user.getPhones()),
                user.getCreated(),
                user.getModified(),
                user.getLastLogin(),
                user.getToken(),
                user.getIsActive()
        );
    }

    private List<PhoneResponse> phonesToPhoneResponses(List<Phone> phones) {
        List<PhoneResponse> phoneResponses = new ArrayList<>();
        phones.forEach(phone -> phoneResponses.add(this.phoneToPhoneResponse(phone)));
        return phoneResponses;
    }

    private PhoneResponse phoneToPhoneResponse(Phone phone) {
        return new PhoneResponse(
                phone.getId(),
                phone.getNumber(),
                phone.getCityCode(),
                phone.getCountryCode(),
                phone.getCreated(),
                phone.getModified()
        );
    }

    @Override
    public User userUpdate(UserRequest userRequest, User user) {
        if (userRequest.name() != null) user.setName(userRequest.name());
        if (userRequest.email() != null) user.setEmail(userRequest.email());
        if (userRequest.password() != null)
            user.setPassword(new BCryptPasswordEncoder().encode(userRequest.password()));
        if (userRequest.phones() != null) user.setPhones(this.phonesRequestToPhones(userRequest.phones()));
        user.getPhones().forEach(phone -> phone.setUser(user));
        return user;
    }

    @Override
    public List<UserResponse> usersToUserResponses(List<User> users) {
        List<UserResponse> userResponses = new ArrayList<>();
        users.forEach(user -> userResponses.add(this.userToUserResponse(user)));
        return userResponses;
    }
}
