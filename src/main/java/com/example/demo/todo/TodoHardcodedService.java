package com.example.demo.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class TodoHardcodedService {

	private static List<Todo> todos = new ArrayList();
	private static long idCounter = 0;

	static {
		todos.add(new Todo(++idCounter, "praful", "test1", new Date(), false));
		todos.add(new Todo(++idCounter, "praful", "test2", new Date(), false));
		todos.add(new Todo(++idCounter, "praful", "test3", new Date(), false));

	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo save(Todo todo) {
		if (todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	public Todo deleteById(long id) {
		System.out.println("In deleteById");
		Todo todo = findById(id);
		if (todo == null)
			return null;
		if (todos.remove(todo)) {
			System.out.println("In deleteById: " + todo);
			return todo;
		}
		return null;
	}

	public Todo findById(long id) {
		System.out.println("In deleteById");
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				System.out.println("In findbyId: " + todo);
				return todo;
			}
		}
		return null;
	}

}
