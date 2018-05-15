package ru.kpfu.itis.truckingservice.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppUserDto {

     String role;
     String username;
     String surname;
     String password;
     String phoneNumber;

}
