package com.laonstory.todo.service;

import com.laonstory.todo.domain.entity.Todo;
import com.laonstory.todo.domain.repository.TodoRepository;
import com.laonstory.todo.dto.TodoDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TodoService {
    private TodoRepository todoRepository;

    @Transactional
    public Integer countUserIDPost(String userID){ //테스트 완료
        return todoRepository.countByUserID(userID);
    }

    @Transactional
    public Boolean savePost(TodoDto todoDto){
        if(todoRepository.save(todoDto.toEntity()).getListNum() != null){
            return true;
        }else {
            return false;
        }
    }

    @Transactional
    public List<TodoDto> getTodoList(String userID){
        List<Todo> todos = todoRepository.findByUserID(userID);
        List<TodoDto> todoDtoList = new ArrayList<>();

        for(Todo todo : todos){
            TodoDto todoDto = TodoDto.builder()
                    .listNum(todo.getListNum())
                    .userID(todo.getUserID())
                    .text(todo.getText())
                    .done(todo.getDone())
                    .build();

            todoDtoList.add(todoDto);
        }
        return todoDtoList;
    }
}
