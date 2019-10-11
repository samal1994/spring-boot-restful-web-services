package com.demo.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.DAOTodo;

@Repository
public interface TodoDao extends CrudRepository<DAOTodo, Long> {
	
	@Transactional
	@Modifying
	@Query("update DAOTodo t set t.description = ?1, t.isDone = ?2,t.targetDate= ?3,t.userName= ?4 where t.id = ?5")
	int  updateById(String description, boolean is_done, String targetDate,String userName,long userId);
}
