package com.demo.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.TodoDao;
import com.demo.dao.UserDao;
import com.demo.model.DAOTodo;
import com.demo.model.Todo;

@Service
public class TodoResourceService {

	/*
	 * private static List<Todo> todos; static { todos=new ArrayList<>();
	 * todos.add(new Todo(1, "Spring boot", "Learn Spring boot with mvc",
	 * convertDateFormat("MM/dd/yyyy"), true)); todos.add(new Todo(2, "Angular",
	 * "Angular With JAVA Script", convertDateFormat("dd/MM/yyyy"), false));
	 * todos.add(new Todo(3, "Oracle", "Oracle 12g",
	 * convertDateFormat("E, MMM dd yyyy HH:mm:ss"), false)); }
	 */
	
	@Autowired
	private TodoDao todoDao;
	
	public Iterable<DAOTodo> getTodos() {
		return todoDao.findAll();
	}
	
	public Optional<DAOTodo> getTodo(long id) {
		Optional<DAOTodo> todo=findById(id);
		return todo;
	}
	
	/*
	 * private static String convertDateFormat(String format) { SimpleDateFormat
	 * formatter=new SimpleDateFormat(format); String date1 = null; date1 =
	 * formatter.format(new Date()); return date1; }
	 */
	
	public void deleteById(long id) {
		 todoDao.deleteById(id);
		/*
		 * Todo todo=findById(id); if (todo != null) { todos.remove(todo); return todo;
		 * } return null;
		 */
	}

	public Optional<DAOTodo> findById(long id) {
		/*
		 * for (Todo todo : todos) { if (todo.getId()==id) { return todo; } } return
		 * null;
		 */
		return todoDao.findById(id);
	}
	
public Optional<DAOTodo> upDateTodo(Todo todo) {
		/*
		 * deleteById(todo.getId()); todos.add(todo); return todo;
		 */
	int id= todoDao.updateById(todo.getDescription(), todo.isDone(), todo.getTargetDate(), todo.getUserName(), todo.getId());
	long key=id;
	return todoDao.findById(key);
}
	
public DAOTodo saveTodo(Todo todo) {
		DAOTodo daoTodo=new DAOTodo();
		daoTodo.setUserName(todo.getUserName());
		daoTodo.setDescription(todo.getDescription());
		daoTodo.setDone(todo.isDone());
		daoTodo.setTargetDate(todo.getTargetDate());
		return todoDao.save(daoTodo);
}
}