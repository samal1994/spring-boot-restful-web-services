package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.DAOTodo;
import com.demo.model.Todo;
import com.demo.services.TodoResourceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResourceController {

	@Autowired
	private TodoResourceService tService;
	
	@GetMapping("/users/todos")
	private List<?> getAllTodos(){
		return (List<?>) tService.getTodos();
	}
	
	@GetMapping("/uptodo/{id}")
	private Optional<DAOTodo> getTodo(@PathVariable Long id) {
		return tService.getTodo(id);
	}
	
	@DeleteMapping("/users/todos/{id}")
	private ResponseEntity<Void> deleteTodo(@PathVariable long id) {
		tService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping("/update" )
	private ResponseEntity<Optional<DAOTodo>> updateTodo(@RequestBody Todo todo) {
		 Optional<DAOTodo> upDatedtodo=tService.upDateTodo(todo);
		return new ResponseEntity<Optional<DAOTodo>>(upDatedtodo,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	private ResponseEntity<?> addTodo(@RequestBody Todo todo){
		DAOTodo upDatedtodo= tService.saveTodo(todo);
		return new ResponseEntity<DAOTodo>(upDatedtodo,HttpStatus.OK);
	}
	
}
