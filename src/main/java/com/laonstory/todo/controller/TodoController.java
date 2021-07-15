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

    @PostMapping("/post") //입력 후 list 반환
    public ResponseEntity<List<TodoDto>> post(@RequestBody TodoDto todoDto){
        Integer num = todoService.countUserIDPost(todoDto.getUserID());
        todoDto.setListNum(num);
        todoDto.setDone(false);
        if(todoService.savePost(todoDto)){ //front list 반환
            List<TodoDto> todoDtoList = todoService.getTodoList(todoDto.getUserID());
            System.out.println(todoDtoList);
            return ResponseEntity.ok(todoDtoList);
        }else{
            return ResponseEntity.ok(null);
        }
    }
  
    @PutMapping("/update")
    public ResponseEntity<List<TodoDto>> update(@RequestBody TodoDto todoDto){
        if(todoService.update(todoDto)){
            List<TodoDto> todoDtoList = todoService.getTodoList(todoDto.getUserID());
            System.out.println(todoDtoList);
            return ResponseEntity.ok(todoDtoList);
        }else{
            return ResponseEntity.ok(null);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> delete(@RequestBody Integer listNum, @RequestBody String userID){
        return ResponseEntity.ok(todoService.delete(listNum, userID));
    }


    
}

