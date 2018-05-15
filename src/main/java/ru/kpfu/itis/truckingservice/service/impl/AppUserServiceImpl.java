package ru.kpfu.itis.truckingservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.truckingservice.converter.AppUserConverter;
import ru.kpfu.itis.truckingservice.dto.AppUserDto;
import ru.kpfu.itis.truckingservice.entity.AppUser;
import ru.kpfu.itis.truckingservice.repository.AppUserRepository;
import ru.kpfu.itis.truckingservice.service.AppUserService;
import ru.kpfu.itis.truckingservice.utils.AppUserDtoValidator;
import ru.kpfu.itis.truckingservice.utils.Errors;

import static java.util.Collections.emptyList;

@Service
public class AppUserServiceImpl extends AppUserConverter implements AppUserService, UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppUserDtoValidator appUserDtoValidator;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findOneByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(username);
        return new User(user.getUsername(), user.getPassword(), emptyList());
    }


    @Override
    public void createUser(AppUserDto appUserDto) throws Exception {
        if (appUserDtoValidator.isValidSignUpData(appUserDto)) {
            if (appUserRepository.findOneByUsername(appUserDto.getUsername()) != null) {
                throw new Exception(Errors.USER_ALREADY_EXISTS);
            }
            AppUser user = doForward(appUserDto);

            appUserRepository.save(user);
        }
    }

    @Override
    public AppUser findOneByUsername(String currentUserUsername) {
        return appUserRepository.findOneByUsername(currentUserUsername);
    }
}
