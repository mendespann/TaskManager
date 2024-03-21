package br.tasks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.tasks.dto.TaskDTO;

/**
 * The TaskService interface provides methods to manage tasks.
 */
@Service
public interface TaskService {
  public List<TaskDTO> createTask(TaskDTO task);
  public List<TaskDTO> listAll();
  public List<TaskDTO> updateTask(TaskDTO task);
  public List<TaskDTO> deleteTask(Long id);
}
