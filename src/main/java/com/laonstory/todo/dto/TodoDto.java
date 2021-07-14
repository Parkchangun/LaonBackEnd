package com.laonstory.todo.dto;

import com.laonstory.todo.domain.entity.Todo;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TodoDto {
    private Integer listNum;
    private String userID;
    private String text;
    private Boolean done;

    public Todo toEntity(){
        Todo build = Todo.builder()
                .listNum(listNum)
                .userID(userID)
                .text(text)
                .done(done)
                .build();
        return build;
    }

    @Builder
    public TodoDto(Integer listNum, String userID, String text, Boolean done) {
        this.listNum = listNum;
        this.userID = userID;
        this.text = text;
        this.done = done;
    }
}
