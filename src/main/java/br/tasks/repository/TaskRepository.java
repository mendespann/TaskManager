package br.tasks.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.tasks.dto.TaskDTO;

public interface TaskRepository extends JpaRepository<TaskDTO, Long> {
  
}
