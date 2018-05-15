package ru.kpfu.itis.truckingservice.converter;

import com.google.common.base.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.itis.truckingservice.dto.AppUserDto;
import ru.kpfu.itis.truckingservice.entity.AppUser;

public class AppUserConverter extends Converter<AppUserDto,AppUser> {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected AppUser doForward(AppUserDto userDto) {

        return AppUser.builder()
                .username(userDto.getUsername())
                .surname(userDto.getSurname())
                .password(bCryptPasswordEncoder.encode(userDto.getPassword()))
                .phoneNumber(userDto.getPhoneNumber())
                .build();

    }

    @Override
    protected AppUserDto doBackward(AppUser user) {
        return null;
    }
}
