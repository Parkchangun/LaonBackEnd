package com.laonstory.todo.domain.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@IdClass(TodoPK.class)
@Table(name = "todolist")
public class Todo {
    @Id
    private Integer list_num;
    @Id
    @Column(length = 30, nullable = false)
    private String userID;
    @Column(length = 100, nullable = false)
    private String content;
    @Column(columnDefinition = "boolean default false")
    private Boolean done;

    @Builder
    public Todo(Integer list_num, String userID, String content, Boolean done) {
        this.list_num = list_num;
        this.userID = userID;
        this.content = content;
        this.done = done;
    }
}
