package br.tasks.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import br.tasks.service.TaskService;
import br.tasks.dto.TaskDTO;

/**
 * This class is a controller for the Task entity.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {
    /**
     * This attribute is a service for the Task entity.
     */
    private final TaskService taskService;

    /**
     * Constructor for the TaskController class.
     *
     * @param taskServiceParam
     */
    public TaskController(final TaskService taskServiceParam) {
        this.taskService = taskServiceParam;
    }

    /**
     * This method creates a task.
     *
     * @param task
     * @return List<TaskDTO>
     */
    @PostMapping("/create")
    List<TaskDTO> createTask(@RequestBody final TaskDTO task) {
        return taskService.createTask(task);
    }

    /**
     * This method lists all tasks.
     *
     * @return List<TaskDTO>
     */
    @GetMapping("/list")
    List<TaskDTO> listAll() {
        return taskService.listAll();
    }

    /**
     * This method updates a task.
     *
     * @param task
     * @return List<TaskDTO>
     */
    @PutMapping("/update")
    List<TaskDTO> updateTask(@RequestBody final TaskDTO task) {
        return taskService.updateTask(task);
    }

    /**
     * This method deletes a task.
     *
     * @param id
     * @return List<TaskDTO>
     */
    @DeleteMapping("/delete/{id}")
    List<TaskDTO> deleteTask(@PathVariable final Long id) {
        return taskService.deleteTask(id);
    }

}
