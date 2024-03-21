/**
 * Package for task-related service implementation classes.
 */
package br.tasks.service.impl;

import br.tasks.dto.TaskDTO;
import br.tasks.repository.TaskRepository;
import br.tasks.service.TaskService;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Implementation of the task service.
 */
@Service
public final class TaskServiceImpl implements TaskService {
    /**
     * Repository for tasks.
     */
    private final TaskRepository repository;

    /**
     * Constructs a new task service implementation.
     * @param taskRepository the repository for tasks
     */
    public TaskServiceImpl(final TaskRepository taskRepository) {
        this.repository = taskRepository;
    }

    /**
     * Creates a new task and returns all tasks.
     * @param task the task to create
     * @return all tasks
     */
    public List<TaskDTO> createTask(final TaskDTO task) {
        repository.save(task);
        return listAll();
    }

    /**
     * Returns all tasks.
     * @return all tasks
     */
    public List<TaskDTO> listAll() {
        return repository.findAll();
    }

    /**
     * Updates a task and returns all tasks.
     * @param task the task to update
     * @return all tasks
     */
    public List<TaskDTO> updateTask(final TaskDTO task) {
        repository.save(task);
        return listAll();
    }

    /**
     * Deletes a task by its ID and returns all tasks.
     * @param id the ID of the task to delete
     * @return all tasks
     */
    public List<TaskDTO> deleteTask(final Long id) {
        repository.deleteById(id);
        return listAll();
    }

}
