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
        return todoRepository.allTodos();
    }
}
