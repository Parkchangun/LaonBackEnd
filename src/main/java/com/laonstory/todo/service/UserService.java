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

//    @Transactional
//    public UserDto login(UserDto userDto){
//        User user = userDto.toEntity();
//        if(userRepository.findByUserIDAndPassword(user.getUserID(), user.getPassword()) != null){
//            return userDto;
//        }else {
//            return null;
//        }
//    }

    @Transactional
    public void signup(UserDto userDto){
        userRepository.save(userDto.toEntity());
    }

    @Transactional
    public boolean ckeckUserIDDuplicate(String userID){
        return userRepository.existsByUserID(userID);
    }

    @Transactional
    public boolean ckeckPassword(String password){
        return userRepository.existsByPassword(password);
    }
}
