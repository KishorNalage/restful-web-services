package com.kishor.rest.webservices.restful_web_services.todo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kishor.rest.webservices.restful_web_services.todo.beans.Todo;
import com.kishor.rest.webservices.restful_web_services.todo.service.HardCodedService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoController {

	@Autowired
	private HardCodedService todoService;
	
	@GetMapping(path = "/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username)
	{
		return todoService.findAll();
		
	}
	
	@GetMapping(path = "/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username,@PathVariable long id)
	{
		return todoService.findTodoById(id);
		
	}
	
	@DeleteMapping(path = "/users/{username}/todos/{id}")
	public ResponseEntity<Void> removeTodoById(@PathVariable String username,@PathVariable long id)
	{
		Todo todo= todoService.deleTodoById(id);
		if(todo!=null){
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(path = "/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username,@PathVariable long id,@RequestBody Todo todo)
	{
		Todo todoUpdated= todoService.saveTodo(todo);
		return new ResponseEntity <Todo>(todoUpdated,HttpStatus.OK);
	}
	
	@PostMapping(path = "/users/{username}/todos")
	public ResponseEntity<Void> addTodo(@PathVariable String username,@RequestBody Todo todo)
	{
		Todo createdTodo= todoService.saveTodo(todo);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	

}
