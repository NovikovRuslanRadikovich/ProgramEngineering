package ru.kpfu.itis.truckingservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.truckingservice.dto.AppUserDto;
import ru.kpfu.itis.truckingservice.service.AppUserService;
import ru.kpfu.itis.truckingservice.utils.ApiResponse;
import ru.kpfu.itis.truckingservice.utils.ResponseCreator;

@RestController
public class AppUserController extends ResponseCreator {


    @Autowired
    AppUserService userService;

    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<String>> signUp(@RequestBody AppUserDto userDto) {
        try {
            userService.createUser(userDto);
        } catch (Exception e) {
            return createBadResponse(e.getMessage());
        }
        return createGoodResponse();
    }




}
