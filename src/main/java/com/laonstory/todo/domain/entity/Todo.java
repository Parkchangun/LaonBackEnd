package com.laonstory.todo.domain.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "todolist")
public class Todo{
    @Id
    private Integer id;
    @Column(length = 100, nullable = false)
    private String text;
    @Column(columnDefinition = "boolean default false")
    private Boolean done;

    @Builder
    public Todo(Integer id, String text, Boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }
}
