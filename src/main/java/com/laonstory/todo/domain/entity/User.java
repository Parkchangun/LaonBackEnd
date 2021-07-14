package com.laonstory.todo.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(length = 30, nullable = false)
    private String userID;
    @Column(length = 50, nullable = false)
    private String password;

    @Builder
    public User(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }
}
