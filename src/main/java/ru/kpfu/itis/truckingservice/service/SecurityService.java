package ru.kpfu.itis.truckingservice.service;

import ru.kpfu.itis.truckingservice.entity.AppUser;

public interface SecurityService {

    AppUser getCurrentUser();
}
