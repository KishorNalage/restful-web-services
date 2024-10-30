package com.kishor.rest.webservices.restful_web_services.todo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kishor.rest.webservices.restful_web_services.todo.beans.Todo;

@Service
public class HardCodedService {
	
	private static List<Todo> todoList= new ArrayList<>();
	private static int idCounter=0;
	
	static
	{
		todoList.add(new Todo(++idCounter, "In28Minutes", "Learn to Dance", new Date(), false));
		todoList.add(new Todo(++idCounter, "In28Minutes", "Learn to MicroServices", new Date(), true));
		todoList.add(new Todo(++idCounter, "In28Minutes", "Learn to Angular", new Date(), false));
	}
	
	public  List<Todo> findAll() {
		return todoList;		
	}
	
	public Todo deleTodoById(long id) {
		Todo todo=findTodoById(id);
		 if(todo==null) return null;
		 if(todoList.remove(todo)) {
			 return todo;
		 }
		 return null;
	}
	
	public Todo saveTodo(Todo todo) {
		if(todo.getId()==-1 || todo.getId()==0)
		{
			todo.setId(++idCounter);
			todoList.add(todo);
		}
		else {
			{
			deleTodoById(todo.getId());
			todoList.add(todo);
			}
		}
		return todo;
	}

	public Todo findTodoById(long id) {
		for(Todo todo:todoList)
		{
			if(todo.getId()==id)
				return todo;
		}
		return null;
	}

}
