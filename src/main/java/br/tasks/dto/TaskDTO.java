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
    private String title;

    /**
     * Task description.
     */
    private String description;

    /**
     * Task status: true for finished, false not finished.
     */
    private boolean status;

    /**
     * Task conclusion date.
     */
    private LocalDate dateOfConclusion;

}
