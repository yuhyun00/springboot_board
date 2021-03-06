package com.study.springboot_board.domain;

import com.study.springboot_board.dto.UserForm;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long userId;

    @Column(length = 50, nullable = false)
    private String email;

    @Column( length = 50, nullable = false)
    private String userName;

    @Column( length = 50, nullable = false)
    private String password;

    public User(UserForm userForm) {
        this.email = userForm.getEmail();
        this.userName = userForm.getUserName();
        this.password = userForm.getPassword();
    }

    public static User createUser(UserForm userForm){
        return new User(userForm);
    }
}
