package com.laonstory.todo.controller;


import com.laonstory.todo.domain.entity.User;
import com.laonstory.todo.dto.TodoDto;
import com.laonstory.todo.dto.UserDto;
import com.laonstory.todo.service.TodoService;
import com.laonstory.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto, HttpServletRequest req){
        System.out.println("login start");
        HttpSession session = req.getSession();
        String login = userService.login(userDto);
        if(login == null){
            session.setAttribute("user",null);
            return ResponseEntity.ok(null);
        }else {
            session.setAttribute("user", login);
            return ResponseEntity.ok(login);
        }
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest req){
        req.getSession().invalidate();
        req.getSession(true);
    }

    @PostMapping("/signup")

    public Boolean SignUp(@RequestBody UserDto userDto){
        System.out.println("join start");
        //중복되는 경우 true
        if(!userService.ckeckUserIDDuplicate(userDto.getUserID())){
            userService.signup(userDto);
            System.out.println("join done");
            return true;
        }
        System.out.println("join failed");
        return false;
    }

    //아이디 중복 검사(true/false) 버튼
    @GetMapping("/duplicateTest")
    public ResponseEntity<Boolean> checkUserIDDuplicate(@RequestBody String userID){
        System.out.println("userID Duplicate start");
        return ResponseEntity.ok(userService.ckeckUserIDDuplicate(userID));
    }
}
