package com.laonstory.todo.service;

import com.laonstory.todo.domain.entity.Todo;
import com.laonstory.todo.domain.entity.User;
import com.laonstory.todo.domain.repository.TodoRepository;
import com.laonstory.todo.dto.TodoDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Transactional
    public Integer countUserIDPost(String userID){
        return todoRepository.countByUserID(userID);
    }

    @Transactional
    public Integer maxListNum(String userID){
        return todoRepository.MaxByUserID(userID);
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
                    .content(todo.getContent())
                    .done(todo.getDone())
                    .build();

            todoDtoList.add(todoDto);
        }
        return todoDtoList;
    }

    @Transactional
    public Boolean update(TodoDto update){
        Todo todo = todoRepository.findByListNumAndUserID(update.getListNum(), update.getUserID());
        todo.setDone(update.getDone());
        todo.setContent(update.getContent());
        if(todoRepository.save(todo).getListNum() != null){
            return true;
        }else {
            return false;
        }
    }

    @Transactional
    public Boolean delete(Integer listNum, String userID) {
        Todo todo = todoRepository.findByListNumAndUserID(listNum, userID);
        if(todo.getListNum().equals(listNum)){
            todoRepository.delete(todo);
            return true;
        }
        return false;
    }

}
