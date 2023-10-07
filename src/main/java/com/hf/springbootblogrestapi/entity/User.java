package com.hf.springbootblogrestapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "users",uniqueConstraints ={ @UniqueConstraint(columnNames = {"username"}),@UniqueConstraint(columnNames = {"email"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;
    private String username;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "Id"),inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "Id"))
    private Set<ROLE> roles;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "Id = " + Id + ", " +
                "name = " + name + ", " +
                "username = " + username + ", " +
                "email = " + email + ", " +
                "password = " + password + ")";
    }
}
