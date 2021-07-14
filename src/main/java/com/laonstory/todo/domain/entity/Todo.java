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
    private Integer listNum;
    @Id
    @Column(length = 30, nullable = false)
    private String userID;
    @Column(length = 100, nullable = false)
    private String text;
    @Column(columnDefinition = "boolean default false")
    private Boolean done;

    @Builder
    public Todo(Integer listNum, String userID, String text, Boolean done) {
        this.listNum = listNum;
        this.userID = userID;
        this.text = text;
        this.done = done;
    }

}
