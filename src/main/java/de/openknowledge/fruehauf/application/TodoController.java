package de.openknowledge.fruehauf.application;

import de.openknowledge.fruehauf.domain.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Path("/todos")
@Controller
public class TodoController {

    private static final Logger LOG = LoggerFactory.getLogger(TodoController.class);

    @Inject
    private Models models;

    public TodoController() {
        LOG.info("Todo Controller created");
    }

    //Create Mocked Todo List, will later be omitted when Service has been implemented
    private List<Todo> mockTodoList = new ArrayList<>();

    @GET
    @View("todos.xhtml")  // Here is generally described how the todos will be displayed
    public void allTodos() {
        LOG.info("Fetching all todos");

        // Add data to mockTodoList (later omitted)
        mockTodoList.add(new Todo(1, "Putzen", "Ganze Wohnung", true, LocalDateTime.of(2020, Month.AUGUST, 31, 23, 59, 00)));
        mockTodoList.add(new Todo(2, "Einkaufen", "Milch, Eier, Mehl", true, LocalDateTime.of(2020, Month.AUGUST, 20, 23, 59, 00)));
        mockTodoList.add(new Todo(3, "Haus streichen", "in gelb", false, LocalDateTime.of(2020, Month.JULY, 20, 23, 59, 00)));

        models.put("todos", mockTodoList); // the String "todos" can be used to access the mockTodoList in the todos.xhtml
    }

}

