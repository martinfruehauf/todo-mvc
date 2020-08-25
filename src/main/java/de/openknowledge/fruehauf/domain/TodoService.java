package de.openknowledge.fruehauf.domain;

import de.openknowledge.fruehauf.infrastructure.stereotypes.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private List<Todo> mockTodoList = new ArrayList<>();

    public TodoService() {
    }

    public List<Todo> allTodos() {
        mockTodoList.add(new Todo(1, "Putzen", "Ganze Wohnung", true, LocalDateTime.of(2020, Month.AUGUST, 31, 23, 59, 00)));
        mockTodoList.add(new Todo(2, "Einkaufen", "Milch, Eier, Mehl", true, LocalDateTime.of(2020, Month.AUGUST, 20, 23, 59, 00)));
        mockTodoList.add(new Todo(3, "Haus streichen", "in gelb", false, LocalDateTime.of(2020, Month.JULY, 20, 23, 59, 00)));
        return mockTodoList;
    }
}
