package com.laonstory.todo.service;

import com.laonstory.todo.domain.entity.User;
import com.laonstory.todo.domain.repository.UserRepository;
import com.laonstory.todo.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserService{
    private UserRepository userRepository;

    @Transactional
    public String login(UserDto userDto){
        User user = userDto.toEntity();
        if(userRepository.findByUserIDAndPassword(user.getUserID(), user.getPassword()) != null){
            return userDto.getUserID();
        }else {
            return null;
        }
    }

    @Transactional
    public void signup(UserDto userDto){
        userRepository.save(userDto.toEntity());
    }

    @Transactional
    public Boolean ckeckUserIDDuplicate(String userID){
        return userRepository.existsByUserID(userID);
    }

}
