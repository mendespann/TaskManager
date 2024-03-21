package br.tasks.service.impl;

import br.tasks.dto.TaskDTO;
import br.tasks.repository.TaskRepository;
import br.tasks.service.TaskService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskDTO> createTask(TaskDTO task) {
        taskRepository.save(task);
        return listAll();
    }

    public List<TaskDTO> listAll() {
        return taskRepository.findAll();
    }

    public List<TaskDTO> updateTask(TaskDTO task) {
        taskRepository.save(task);
        return listAll();
    }

    public List<TaskDTO> deleteTask(Long id) {
        taskRepository.deleteById(id);
        return listAll();
    }

}
