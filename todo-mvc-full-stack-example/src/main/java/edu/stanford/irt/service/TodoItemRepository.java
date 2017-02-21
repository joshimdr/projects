package edu.stanford.irt.service;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.stanford.irt.domain.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}