package com.laonstory.todo.domain.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TodoPK implements Serializable {
    private Integer list_num;
    private String userID;
}
