package com.laonstory.todo.controller;

import com.laonstory.todo.domain.entity.TodoForm;
import com.laonstory.todo.dto.TodoDto;
import com.laonstory.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("/todo") //모든 일일 리스트 출력
    public ResponseEntity<List<TodoDto>> list(@RequestBody String userID){
        List<TodoDto> todoDtoList = todoService.getTodoList(userID);
        System.out.println(todoDtoList);
        return ResponseEntity.ok(todoDtoList);
    }

    @PostMapping("/post") //입력
    public ResponseEntity<Boolean> post(@RequestBody TodoDto todoDto){
        Integer num = todoService.countUserIDPost(todoDto.getUserID());
        todoDto.setList_num(num);
        return ResponseEntity.ok(todoService.savePost(todoDto));
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> update(@RequestBody TodoForm form, @PathVariable Integer list_num){
        return ResponseEntity.ok(todoService.update(form.convertBoardEntity(), list_num));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> delete(@PathVariable Integer list_num, @RequestParam String userID){
        return ResponseEntity.ok(todoService.delete(list_num, userID));
    }

}