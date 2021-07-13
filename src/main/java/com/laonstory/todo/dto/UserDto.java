package com.laonstory.todo.dto;

import com.laonstory.todo.domain.entity.User;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {
    @NotBlank(message = "ID를 입력해주세요.")
    private String userID;
    @NotBlank(message = "PASSWORD를 입력해주세요.")
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
