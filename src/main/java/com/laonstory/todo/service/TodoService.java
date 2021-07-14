package com.laonstory.todo.service;

import com.laonstory.todo.domain.entity.Todo;
import com.laonstory.todo.domain.repository.TodoRepository;
import com.laonstory.todo.dto.TodoDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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
        if(todoRepository.save(todoDto.toEntity()).getList_num() != null){
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
                    .list_num(todo.getList_num())
                    .userID(todo.getUserID())
                    .content(todo.getContent())
                    .done(todo.getDone())
                    .build();

            todoDtoList.add(todoDto);
        }
        return todoDtoList;
    }
}
