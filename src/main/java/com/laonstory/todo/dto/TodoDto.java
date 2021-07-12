package com.laonstory.todo.dto;

import com.laonstory.todo.domain.entity.Todo;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TodoDto {
    private Integer id;
    private String text;
    private Boolean done;

    public Todo toEntity(){
        Todo build = Todo.builder()
                .id(id)
                .text(text)
                .done(done)
                .build();
        return build;
    }

    @Builder
    public TodoDto(Integer id, String text, Boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }
}
