package de.openknowledge.fruehauf.domain;

import de.openknowledge.fruehauf.web.BaseTodoDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tab_todo")
public class Todo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "col_id")
    private long id;

    @Column(name = "col_name")
    private String name;

    @Column(name = "col_desc")
    private String description;

    @Column(name = "col_state")
    private boolean status;

    @Column(name = "col_due")
    private LocalDateTime dueDate;

    public Todo () {}

    public Todo(final long id, final String name, final String description, final boolean status, final LocalDateTime dueDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }

    public Todo(final BaseTodoDTO baseTodoDTO) {
        this.name = baseTodoDTO.getName();
        this.description = baseTodoDTO.getDescription();
        this.status = baseTodoDTO.isStatus();
        this.dueDate = LocalDateTime.parse(baseTodoDTO.getDueDate().substring(0,19));
    }

    public Todo(final long todoId, final BaseTodoDTO baseTodoDTO) {
        this.id = todoId;
        this.name = baseTodoDTO.getName();
        this.description = baseTodoDTO.getDescription();
        this.status = baseTodoDTO.isStatus();
        this.dueDate = LocalDateTime.parse(baseTodoDTO.getDueDate().substring(0,19));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(final boolean status) {
        this.status = status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(final LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", dueDate=" + dueDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id &&
                status == todo.status &&
                Objects.equals(name, todo.name) &&
                Objects.equals(description, todo.description) &&
                Objects.equals(dueDate, todo.dueDate);
    }

}
