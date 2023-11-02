package com.example.hotel.model.user.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "table_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private int idAccount;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "password_name", nullable = false)
    @JsonIgnore
    private String passwordName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    private int isDelete;
    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

}
