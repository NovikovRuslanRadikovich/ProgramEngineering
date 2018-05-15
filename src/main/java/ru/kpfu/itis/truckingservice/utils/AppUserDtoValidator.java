package ru.kpfu.itis.truckingservice.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.truckingservice.dto.AppUserDto;
import ru.kpfu.itis.truckingservice.repository.AppUserRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class AppUserDtoValidator extends ResponseCreator{

    private final String USERNAMEREGEX = "[A-ZА-Я].{8,12}";
    private final String PASSWORDREGEX = ".{9,14} ";
    private final String PHONENUMBERREGEX = "\\+7\\d{10}";

    private Pattern pattern;
    private Matcher matcher;

    @Autowired
    AppUserRepository userRepository;

    public boolean isValidSignUpData(AppUserDto userDto) throws Exception {
        if (userDto.getPassword() == null || !this.isPasswordCorrect(userDto.getPassword())) {
            throw new Exception(Errors.INCORRECT_PASSWORD);
        }
        if (userDto.getUsername() == null || !this.isUsernameCorrect(userDto.getUsername())) {
            throw new Exception(Errors.INVALID_USERNAME);
        }
        if (userDto.getPhoneNumber() != null) {
            if (!this.isPhoneNumberCorrect(userDto.getPhoneNumber())) {
                throw new Exception(Errors.INVALID_PHONENUMBER);
            }
        }

        if (userDto.getPhoneNumber() != null) {
            if (this.isPhoneNumberAlreadyExists(userDto.getPhoneNumber())) {
                throw new Exception(Errors.PHONENUMBER_ALREADY_EXISTS);
            }
        }

        return true;
    }

    private boolean isUsernameCorrect(String name) {
        pattern = Pattern.compile(USERNAMEREGEX);
        matcher = pattern.matcher(name);
        return matcher.matches();

    }

    private boolean isPhoneNumberCorrect(String phonenumber) {
        pattern = Pattern.compile(PHONENUMBERREGEX);
        matcher = pattern.matcher(phonenumber);
        return matcher.matches();

    }


    private boolean isPasswordCorrect(String password) {
        pattern = Pattern.compile(PASSWORDREGEX);
        matcher = pattern.matcher(password);
        return matcher.matches();

    }

    private boolean isPhoneNumberAlreadyExists(String phone) {
        return userRepository.findOneByPhoneNumber(phone) != null;
    }


}
