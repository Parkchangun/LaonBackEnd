package com.laonstory.todo.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoForm {
    private Integer list_num;
    private String userID;
    private String content;
    private boolean done;

    @Builder
    public TodoForm(Integer list_num, String userID, String content, boolean done){
        this.list_num = list_num;
        this.userID = userID;
        this.content = content;
        this.done = done;
    }

    public Todo convertBoardEntity(){
        return Todo.builder()
                .list_num(this.list_num)
                .userID(this.userID)
                .content(this.content)
                .done(this.done)
                .build();
    }
}
