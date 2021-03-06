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
    private String content;
    private Boolean done;

    public Todo toEntity(){
        Todo build = Todo.builder()
                .listNum(listNum)
                .userID(userID)
                .content(content)
                .done(done)
                .build();
        return build;
    }

    @Builder
    public TodoDto(Integer listNum, String userID, String content, Boolean done) {
        this.listNum = listNum;
        this.userID = userID;
        this.content = content;
        this.done = done;
    }
}
