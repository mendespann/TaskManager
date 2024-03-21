package br.tasks.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import br.tasks.service.TaskService;
import br.tasks.dto.TaskDTO;

@RestController
@RequestMapping("/tasks")
public class TaskController {
  private TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping("/create")
  List<TaskDTO> createTask(@RequestBody TaskDTO task) {
    return taskService.createTask(task);
  }

  @GetMapping("/list")
  List<TaskDTO> listAll() {
    return taskService.listAll();
  }

  @PutMapping("/update")
  List<TaskDTO> updateTask(@RequestBody TaskDTO task) {
    return taskService.updateTask(task);
  }

  @DeleteMapping("/delete/{id}")
  List<TaskDTO> deleteTask(@PathVariable Long id) {
    return taskService.deleteTask(id);
  }

}
