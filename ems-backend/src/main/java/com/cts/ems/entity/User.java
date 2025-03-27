package com.cts.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
//  Generating ID.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//  Generating name.
    private String name;
    
//  Generating username.
    @Column(nullable = false, unique = true)
    private String username;
    
//  Generating email.
    @Column(nullable = false, unique = true)
    private String email;
    
//  Generating password.
    @Column(nullable = false)
    private String password;

//  Many to may relationship between user and role.
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // When users are fetched their roles will also get fetched. 
//  Cascade type all means whatever changes we are making within user they will automatically get applied to roles also.
    @JoinTable(name = "users_roles",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), // refers to the column in the join table that links to user table.
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id") // Column in join table that links to role table.
    )
//  Field in user entity that stores the role assigned to the user.
    private Set<Role> roles;
}