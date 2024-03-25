package br.tasks;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.server.ResponseStatusException;

import br.tasks.dto.TaskDTO;
import br.tasks.repository.TaskRepository;
import br.tasks.service.impl.TaskServiceImpl;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class TaskApplicationTests {

    @Autowired
    private TaskServiceImpl taskService;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    public void testCreateTask_Success() {
        TaskDTO task = new TaskDTO(null, "Task 1", "Description 1", false, LocalDate.of(2023, 3, 20));

        when(taskRepository.save(any(TaskDTO.class))).thenReturn(task);
        when(taskRepository.findAll()).thenReturn(Arrays.asList(task));

        List<TaskDTO> tasks = taskService.createTask(task);
        assertEquals(1, tasks.size());
        assertEquals(task, tasks.get(0));
    }

    @Test
    public void testCreateTaskFailure() {
        TaskDTO task = new TaskDTO(null, "", "", false, LocalDate.of(2023, 3, 20));

        when(taskRepository.save(any(TaskDTO.class)))
                .thenThrow(new IllegalArgumentException("Erro ao salvar a tarefa"));

        assertThrows(IllegalArgumentException.class, () -> taskService.createTask(task));
    }

    @Test
    public void testUpdateTaskSuccess() {
        TaskDTO task = new TaskDTO(1L, "Task 1", "Description 1", false, LocalDate.of(2023, 3, 20));

        when(taskRepository.save(any(TaskDTO.class))).thenReturn(task);
        when(taskRepository.findAll()).thenReturn(Arrays.asList(task));

        List<TaskDTO> tasks = taskService.updateTask(task);
        assertEquals(1, tasks.size());
        assertEquals(task, tasks.get(0));
    }

    @Test
    public void testUpdateTaskFailure() {
        TaskDTO task = new TaskDTO(null, "", "", false, LocalDate.of(2023, 3, 20));

        when(taskRepository.save(any(TaskDTO.class)))
                .thenThrow(new IllegalArgumentException("Erro ao atualizar a tarefa"));

        assertThrows(IllegalArgumentException.class, () -> taskService.updateTask(task));
    }

    @Test
    public void testlistTasksSuccess() {
        TaskDTO task1 = new TaskDTO(1L, "Task 1", "Description 1", false, LocalDate.of(2023, 3, 20));
        TaskDTO task2 = new TaskDTO(2L, "Task 2", "Description 2", false, LocalDate.of(2023, 4, 20));

        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        List<TaskDTO> tasks = taskService.listAll();
        assertEquals(2, tasks.size());
        assertEquals(task1, tasks.get(0));
        assertEquals(task2, tasks.get(1));
    }

    @Test
    public void testlistAllFailure() {
        when(taskRepository.findAll()).thenThrow(new IllegalStateException("Erro ao listar tarefas"));

        assertThrows(IllegalStateException.class, () -> taskService.listAll());
    }

    @Test
    public void testDeleteTaskSuccess() {
        Long id = 1L;
        when(taskRepository.existsById(id)).thenReturn(true);
        doNothing().when(taskRepository).deleteById(id);

        assertDoesNotThrow(() -> taskService.deleteTask(id));
        verify(taskRepository, times(1)).deleteById(id);
    }

    @Test
    public void testdeleteTaskFailure() {
        Long id = 1L;
        when(taskRepository.existsById(id)).thenReturn(false);

        assertThrows(ResponseStatusException.class, () -> taskService.deleteTask(id));
        verify(taskRepository, times(0)).deleteById(id);
    }

}
