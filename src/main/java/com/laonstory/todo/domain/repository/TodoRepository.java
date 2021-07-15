package com.laonstory.todo.domain.repository;

import com.laonstory.todo.domain.entity.Todo;
import com.laonstory.todo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    @Query(value = "select count(*) from Todo t where t.userID = ?1" )
    public Integer countByUserID(String userID);
    public List<Todo> findByUserID(String userID);
    public Todo findByListNumAndUserID(Integer listNum, String userID);
    @Query(value = "select max(t.listNum) from Todo t where t.userID = ?1" )
    public Integer MaxByUserID(String userID);
}
