package com.laonstory.todo.domain.entity;

import lombok.Data;

import javax.persistence.Column;;
import java.io.Serializable;

@Data
public class TodoPK implements Serializable {
    private Integer listNum;
    private String userID;
}
