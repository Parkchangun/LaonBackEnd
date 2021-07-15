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
        System.out.println("read");
        userID = userID.replace("=", "");
        List<TodoDto> todoDtoList = todoService.getTodoList(userID);
        return ResponseEntity.ok(todoDtoList);
    }

    @PostMapping("/post") //입력 후 list 반환
    public ResponseEntity<List<TodoDto>> post(@RequestBody TodoDto todoDto){
        System.out.println("create");
        Integer num = todoService.countUserIDPost(todoDto.getUserID());
        todoDto.setListNum(num);
        todoDto.setDone(false);
        if(todoService.savePost(todoDto)){ //front list 반환
            List<TodoDto> todoDtoList = todoService.getTodoList(todoDto.getUserID());
            //System.out.println(todoDtoList);
            return ResponseEntity.ok(todoDtoList);
        }else{
            return ResponseEntity.ok(null);
        }
    }
  
    @PostMapping("/update")
    public ResponseEntity<List<TodoDto>> update(@RequestBody TodoDto todoDto){
        System.out.println("update");
        if(todoService.update(todoDto)){ //front list 반환
            List<TodoDto> todoDtoList = todoService.getTodoList(todoDto.getUserID());
            //System.out.println(todoDtoList);
            return ResponseEntity.ok(todoDtoList);
        }else{
            return ResponseEntity.ok(null);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<List<TodoDto>> delete(@RequestBody TodoDto todoDto){
        System.out.println("delete");
        if(todoService.delete(todoDto.getListNum(), todoDto.getUserID())){
            List<TodoDto> todoDtoList = todoService.getTodoList(todoDto.getUserID());
            //System.out.println(todoDtoList);
            return ResponseEntity.ok(todoDtoList);
        }else{
            return ResponseEntity.ok(null);
        }
    }

}

