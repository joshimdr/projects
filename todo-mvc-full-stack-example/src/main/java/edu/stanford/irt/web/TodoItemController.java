package edu.stanford.irt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.stanford.irt.domain.TodoItem;
import edu.stanford.irt.service.TodoItemService;

@RestController
public class TodoItemController {
	@Autowired
	private TodoItemService todoItemService;

	@RequestMapping(value = "/api/todo-items", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Transactional(readOnly = true)
	public List<TodoItem> getTodoItems() {
		return todoItemService.list();
	}

	/**
	 * Method creates a TodoItem in the H2 Database
	 * 
	 * @param todoItem
	 * @return
	 */
	@RequestMapping(value = "/api/todo-items", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TodoItem createTodoItem(@RequestBody TodoItem todoItem) {

		System.out.println("Creating new task :" + todoItem.getDescription());

		return todoItemService.create(todoItem);
	}

	/**
	 * Method Deletes the item using id from H2 database.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/api/todo-items/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<TodoItem> deleteItem(@PathVariable("id") long id) {
		System.out.println("Fetching & Deleting task with id " + id);

		TodoItem item = todoItemService.findById(id);
		if (item == null) {
			System.out.println("Unable to delete. Item with id " + id + " not found");
			return new ResponseEntity<TodoItem>(HttpStatus.NOT_FOUND);
		}

		todoItemService.delete(id);
		return new ResponseEntity<TodoItem>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Method updates the TodoItem object based on the values passed as an
	 * object.
	 * 
	 * @param item
	 * @return
	 */
	@RequestMapping(value = "/api/todo-items/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<TodoItem> updateItem(@PathVariable("id") long id, @RequestBody TodoItem item) {

		todoItemService.update(item);
		return new ResponseEntity<TodoItem>(HttpStatus.NO_CONTENT);
	}

}