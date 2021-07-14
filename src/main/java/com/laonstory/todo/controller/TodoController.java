package com.laonstory.todo.controller;

import com.laonstory.todo.dto.TodoDto;
import com.laonstory.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("/todo") //모든 list 출력
    public ResponseEntity<List<TodoDto>> list(@RequestBody String userID){
        userID = userID.replace("=", "");
        List<TodoDto> todoDtoList = todoService.getTodoList(userID);
        System.out.println(todoDtoList);
        return ResponseEntity.ok(todoDtoList);
    }

    @PostMapping("/post") //입력
    public ResponseEntity<TodoDto> post(@RequestBody TodoDto todoDto){
        Integer num = todoService.countUserIDPost(todoDto.getUserID());
        todoDto.setList_num(num);
        todoDto.setDone(false);
        return ResponseEntity.ok(todoService.savePost(todoDto));
    }
}

