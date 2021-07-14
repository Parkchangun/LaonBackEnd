package com.laonstory.todo.domain.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "Todo_List")
public class Todo{
    @Id
    private Integer list_num;
    @Column(length = 30, nullable = false)
    private String userID;
    @Column(columnDefinition = "TEXT", nullable = false)
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

    public Todo update(Todo newBoard){
        this.list_num = newBoard.getList_num();
        this.userID = newBoard.getUserID();
        this.content = newBoard.getContent();
        this.done = newBoard.getDone();
        return this;
    }

}
