package ru.kpfu.itis.truckingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.truckingservice.entity.enums.Role;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "appusers")
public class AppUser extends AbstractEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "surname")
    private String surname;

    @Column(name = "password")
    private String password;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "appuser",cascade = CascadeType.ALL)
    private Set<Order> orders;

    @PrePersist
    void preInsert() {
        if (this.role == null)
            this.role = Role.USER;
    }
}
