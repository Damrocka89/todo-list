package academy.learn.model;

import lombok.*;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
public class TodoItem {

    private Integer id;
    private String title;
    private String details;
    private LocalDate deadline;

    public TodoItem(String title, String details, LocalDate deadline) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
    }
}
