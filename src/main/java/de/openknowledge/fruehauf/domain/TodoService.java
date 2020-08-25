package de.openknowledge.fruehauf.domain;

import de.openknowledge.fruehauf.infrastructure.stereotypes.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private List<Todo> mockTodoList = new ArrayList<>();

    private static final Logger LOG = LoggerFactory.getLogger(TodoService.class);

    public TodoService() {
        LOG.info("TodoService initialized");
    }

    public List<Todo> allTodos() {
        LOG.info("Get all todos");
        mockTodoList.add(new Todo(1, "Putzen", "Ganze Wohnung", true, LocalDateTime.of(2020, Month.AUGUST, 31, 23, 59, 00)));
        mockTodoList.add(new Todo(2, "Einkaufen", "Milch, Eier, Mehl", true, LocalDateTime.of(2020, Month.AUGUST, 20, 23, 59, 00)));
        mockTodoList.add(new Todo(3, "Haus streichen", "in gelb", false, LocalDateTime.of(2020, Month.JULY, 20, 23, 59, 00)));
        return mockTodoList;
    }
}
