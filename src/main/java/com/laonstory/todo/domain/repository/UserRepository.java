package com.laonstory.todo.domain.repository;

import com.laonstory.todo.domain.entity.User;
import com.laonstory.todo.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
    public User findByUserIDAndPassword(String userID, String password);
    public Boolean existsByUserID(String userID);
}
