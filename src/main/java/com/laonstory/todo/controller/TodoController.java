package com.laonstory.todo.controller;

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

    @GetMapping("/todo") //모든 일일 리스트 출력
    public ResponseEntity<?> list(){
        List<TodoDto> todoDtoList = todoService.getTodoList();
        return ResponseEntity.ok(todoDtoList);
    }
}


/*
//test용
@Controller
@AllArgsConstructor
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String list(Model model){
        List<TodoDto> todoDtoList = todoService.getTodoList();
        model.addAttribute("todoList", todoDtoList);
        return "board/list.html";
    }

    @GetMapping("/post") //수정하세요
    public String write(){
        return "board/write.html";
    }

    @PostMapping("/post") //수정하세요
    public String write(TodoDto todoDto){
        todoService.savePost(todoDto);
        return "redirect:/";
    }
}
*/
/*
//test용
@RestController
@RequestMapping("/api")
public class TodoController {

    @GetMapping("/todo")
    public ResponseEntity<?> list(){
        TodoDto todoDto = new TodoDto(1, "확인하기", true);
        return ResponseEntity.ok(todoDto);
    }
}
*/