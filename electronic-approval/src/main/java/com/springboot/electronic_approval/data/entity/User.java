package com.springboot.electronic_approval.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = true)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "user_name")
    private String name;

    @Column(nullable = false, name = "user_email")
    private String email;

    @Column(nullable = false, name = "user_pw")
    private String pw;

    //FK 가지고 있는 쪽이 부모가 되는 듯.
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
}
