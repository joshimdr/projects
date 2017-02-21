package edu.stanford.irt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.stanford.irt.domain.TodoItem;

@Service
@Transactional
public class TodoItemService {
	
	@Autowired
	private TodoItemRepository todoItemRepository;

	public List<TodoItem> list() {
		return todoItemRepository.findAll();
	}

	public TodoItem create(TodoItem todoItem) {
		return todoItemRepository.save(todoItem);
	}

	public TodoItem findById(long id) {
		return todoItemRepository.getOne(id);
	}

	public TodoItem save(TodoItem item) {
		return todoItemRepository.save(item);
	}

	public TodoItem update(TodoItem item) {
		if (item!=null && todoItemRepository.exists(item.getId())) {
			TodoItem itemStored = todoItemRepository.getOne(item.getId());
			itemStored.setCreated(item.getCreated());
			itemStored.setDescription(item.getDescription());
			itemStored.setCompleted(item.isCompleted());
			// todoItemRepository.save(itemStored);
			
		}
		return item;
	}

	public void delete(long id) {
		todoItemRepository.delete(id);
	}

	

}
