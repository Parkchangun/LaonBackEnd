package com.laonstory.todo.domain.repository;

import com.laonstory.todo.domain.entity.User;
import com.laonstory.todo.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
//    public UserDto findByUserIDAndPassword(String userID, String password);
    public boolean existsByUserID(String userID);
    public boolean existsByPassword(String password);
}
