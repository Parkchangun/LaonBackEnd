package com.laonstory.todo.dto;

import com.laonstory.todo.domain.entity.Todo;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TodoDto {
    private Integer list_num;
    private String userID;
    private String content;
    private Boolean done;

    public Todo toEntity(){
        Todo build = Todo.builder()
                .list_num(list_num)
                .userID(userID)
                .content(content)
                .done(done)
                .build();
        return build;
    }

    @Builder
    public TodoDto(Integer list_num, String userID, String content, Boolean done) {
        this.list_num = list_num;
        this.userID = userID;
        this.content = content;
        this.done = done;
    }
}
