package com.laonstory.todo.domain.repository;

import com.laonstory.todo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    public User findByUserIDAndPassword(String userID, String password);
    public Boolean existsByUserID(String userID);
}
