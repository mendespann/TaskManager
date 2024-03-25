/**
 * Package for Tasks DTO.
 */
package br.tasks.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Class DTO for tasks.
 */
@Entity
@Data
@Table(name = "task")
public class TaskDTO {
    /**
     * Task ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Task title.
     */
    @NotBlank
    private String title;

    /**
     * Task description.
     */
    @NotBlank
    private String description;

    /**
     * Task status: true for finished, false not finished.
     */
    private boolean completed;

    /**
     * Task conclusion date.
     */
    private LocalDate dateOfConclusion;

    public TaskDTO(Long id, String title, String description, boolean completed, LocalDate dateOfConclusion) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.dateOfConclusion = dateOfConclusion;
    }
}
