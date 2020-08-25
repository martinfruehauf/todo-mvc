package de.openknowledge.fruehauf.application;

import de.openknowledge.fruehauf.domain.Todo;
import de.openknowledge.fruehauf.domain.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("/todos")
@Controller
public class TodoController {

    private static final Logger LOG = LoggerFactory.getLogger(TodoController.class);

    @Inject
    private Models models;

    @Inject
    private TodoService todoService;

    public TodoController() {
        LOG.info("Todo Controller created");
    }

    public TodoController(final TodoService todoService) {
        this.todoService = todoService;
    }

    @GET
    @View("todos.xhtml")
    public void allTodos() {
        LOG.info("Fetching all todos");
        List<FullTodoDTO> listFullTodoDTO = new ArrayList<>();
        for (Todo todo: todoService.allTodos()) {
            listFullTodoDTO.add(new FullTodoDTO(todo));
        }
        models.put("todos", listFullTodoDTO);
    }

}

