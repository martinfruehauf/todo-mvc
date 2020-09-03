package de.openknowledge.fruehauf.domain;

import de.openknowledge.fruehauf.infrastructure.stereotypes.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

@Service
public class TodoService {
    @Inject
    private TodoRepository todoRepository;

    private static final Logger LOG = LoggerFactory.getLogger(TodoService.class);

    public TodoService() {
    }

    public List<Todo> allTodos() {
        LOG.info("Get all todos");
        return todoRepository.getAllTodos();
    }

    public Todo getTodoById(final long todoId) {
        LOG.info("Get todo by id: {}", todoId);
        Todo todo = todoRepository.findById(todoId);
        if (todo == null) {
            LOG.info("Todo by id {} does not exist", todoId);
            throw new IllegalArgumentException("Could not find todo with id: " + todoId);
        }
        return todo;
    }
}
