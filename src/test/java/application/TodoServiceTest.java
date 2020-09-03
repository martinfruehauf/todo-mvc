package application;

import de.openknowledge.fruehauf.domain.Todo;
import de.openknowledge.fruehauf.domain.TodoRepository;
import de.openknowledge.fruehauf.domain.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @Mock
    private TodoRepository repository;

    @InjectMocks
    private TodoService service;

    @Test
    public void testAllTodos() {
        ArrayList<Todo> expected = new ArrayList<>();

        expected.add(new Todo(1, "Rasen mähen", "den ganzen Garten", false, LocalDateTime.of(2020, Month.JANUARY, 10, 7, 30)));
        expected.add(new Todo(2, "Treppe putzen", "meine Etage", true, LocalDateTime.of(2019, Month.FEBRUARY, 10, 7, 30)));

        ArrayList<Todo> mock = new ArrayList<>();

        mock.add(new Todo(1, "Rasen mähen", "den ganzen Garten", false, LocalDateTime.of(2020, Month.JANUARY, 10, 7, 30)));
        mock.add(new Todo(2, "Treppe putzen", "meine Etage", true, LocalDateTime.of(2019, Month.FEBRUARY, 10, 7, 30)));

        Mockito.doReturn(mock)
                .when(repository)
                .getAllTodos();

        assertEquals(expected, this.service.allTodos());
    }

    @Test
    public void testGetTodoById() {
        Todo expected = new Todo(1, "Rasen mähen", "den ganzen Garten", false, LocalDateTime.of(2020, Month.JANUARY, 10, 7, 30));
        Todo mock = new Todo(1, "Rasen mähen", "den ganzen Garten", false, LocalDateTime.of(2020, Month.JANUARY, 10, 7, 30));

        Mockito.doReturn(mock)
                .when(repository)
                .findById(1L);

        assertEquals(expected, this.service.getTodoById(1L));

    }
}
