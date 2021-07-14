package com.laonstory.todo.domain.repository;

import com.laonstory.todo.domain.entity.Todo;
import com.laonstory.todo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    @Query(value = "select count(*)+1 from Todo t where t.userID = ?1" )
    public Integer countByUserID(String userID);
    public List<Todo> findByUserID(String userID);
    @Query(value = "update Todo set content =?3 done = ?4 where list_num= ?1, userID= ?2")
    public void updateByDone(Integer list_num, String userID, String content, Boolean done);
}
