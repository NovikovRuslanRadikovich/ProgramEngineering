package ru.kpfu.itis.truckingservice.service;

import ru.kpfu.itis.truckingservice.dto.AppUserDto;
import ru.kpfu.itis.truckingservice.entity.AppUser;

public interface AppUserService {

    void createUser(AppUserDto userDto) throws Exception;

    AppUser findOneByUsername(String currentUserUsername);
}
