package ru.kpfu.itis.truckingservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.kpfu.itis.truckingservice.entity.AppUser;
import ru.kpfu.itis.truckingservice.service.SecurityService;
import ru.kpfu.itis.truckingservice.service.AppUserService;

public class SecurityServiceImpl implements SecurityService {


    @Autowired
    AppUserService userService;

    @Override
    public AppUser getCurrentUser() {
        return userService.findOneByUsername(getCurrentUserUsername());
    }

    private String getCurrentUserUsername() {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        return (String) token.getPrincipal();
    }
}
