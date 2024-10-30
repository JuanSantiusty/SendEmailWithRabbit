package co.edu.unicauca.events;

import co.edu.unicauca.events.dao.EventRepository;
import co.edu.unicauca.events.domain.Event;
import co.edu.unicauca.events.services.EventService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EventsApplicationTests {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventService eventService;

    private Event event;

    @BeforeEach
    void setUp() {
        event = new Event();
        event.setId(1L);
        event.setName("Concierto");
    }

    @Test
    public void testFindAll() {
        List<Event> events = Arrays.asList(event);
        when(eventRepository.findAll()).thenReturn(events);

        List<Event> result = eventService.findAll();

        assertEquals(1, result.size());
        assertEquals("Concierto", result.get(0).getName());
        verify(eventRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        when(eventRepository.findById(1L)).thenReturn(Optional.of(event));

        Event result = eventService.findById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Concierto", result.getName());
        verify(eventRepository, times(1)).findById(1L);
    }

    @Test
    public void testSave() {
        when(eventRepository.save(event)).thenReturn(event);

        Event result = eventService.create(event);

        assertNotNull(result);
        assertEquals("Concierto", result.getName());
        verify(eventRepository, times(1)).save(event);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(eventRepository).deleteById(1L);

        eventService.deleteById(1L);

        verify(eventRepository, times(1)).deleteById(1L);
    }
}

