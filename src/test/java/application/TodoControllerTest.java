package application;

import de.openknowledge.fruehauf.application.FullTodoDTO;
import de.openknowledge.fruehauf.application.TodoController;
import de.openknowledge.fruehauf.domain.Todo;
import de.openknowledge.fruehauf.domain.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.mvc.Models;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.Assert.assertNull;

@ExtendWith(MockitoExtension.class)
public class TodoControllerTest {

    @Mock
    private Models models = Mockito.mock(Models.class);

    @Mock
    private TodoService service;

    @InjectMocks
    private TodoController controller;

    @Test
    public void testAllTodos() {
        ArrayList<FullTodoDTO> expected = new ArrayList<>();

        expected.add(new FullTodoDTO(1, "Rasen mähen", "den ganzen Garten", false, LocalDateTime.of(2020, Month.JANUARY, 10, 7, 30).toString()));
        expected.add(new FullTodoDTO(2, "Treppe putzen", "meine Etage", true, LocalDateTime.of(2019, Month.FEBRUARY, 10, 7, 30).toString()));

        ArrayList<Todo> mock = new ArrayList<>();

        mock.add(new Todo(1, "Rasen mähen", "den ganzen Garten", false, LocalDateTime.of(2020, Month.JANUARY, 10, 7, 30)));
        mock.add(new Todo(2, "Treppe putzen", "meine Etage", true, LocalDateTime.of(2019, Month.FEBRUARY, 10, 7, 30)));

        Mockito.doReturn(mock)
                .when(service)
                .allTodos();

        Mockito.when(models.put(ArgumentMatchers.anyString(), ArgumentMatchers.anyList())).thenReturn(null);

        this.controller.allTodos();
        assertNull(null, models.get("todos"));
    }
}
