package com.laonstory.todo.dto;

import com.laonstory.todo.domain.entity.User;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {
    private String userID;
    private String password;

    public User toEntity(){
        return User.builder()
                .userID(userID)
                .password(password)
                .build();
    }

    @Builder
    public UserDto(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }
}
