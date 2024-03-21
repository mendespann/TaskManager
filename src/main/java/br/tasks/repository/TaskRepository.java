package br.tasks.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.tasks.dto.TaskDTO;
/**
 * This interface is a JPA repository for the Task entity.
 */
public interface TaskRepository extends JpaRepository<TaskDTO, Long> { }
