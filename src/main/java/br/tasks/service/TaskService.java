/**
 * Package for task-related service classes.
 */
package br.tasks.service;

import java.util.List;

import br.tasks.dto.TaskDTO;

/**
 * The TaskService interface provides methods to manage tasks.
 */
public interface TaskService {
    /**
     * Creates a new task and returns all tasks.
     * @param task the task to create
     * @return all tasks
     */
    List<TaskDTO> createTask(TaskDTO task);

    /**
     * Returns all tasks.
     * @return all tasks
     */
    List<TaskDTO> listAll();

    /**
     * Updates a task and returns all tasks.
     * @param task the task to update
     * @return all tasks
     */
    List<TaskDTO> updateTask(TaskDTO task);

    /**
     * Deletes a task by its ID and returns all tasks.
     * @param id the ID of the task to delete
     * @return all tasks
     */
    List<TaskDTO> deleteTask(Long id);
}
