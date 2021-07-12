package com.laonstory.todo.service;

import com.laonstory.todo.domain.entity.User;
import com.laonstory.todo.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserService{
    private UserRepository userRepository;

    @Transactional
    public User signup(User user){
        return userRepository.save(user);
    }
}
