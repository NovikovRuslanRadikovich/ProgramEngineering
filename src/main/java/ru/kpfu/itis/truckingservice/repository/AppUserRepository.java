package ru.kpfu.itis.truckingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.truckingservice.entity.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {


    AppUser findOneByUsername(String username);

    AppUser findOneByPhoneNumber(String phone);
}
