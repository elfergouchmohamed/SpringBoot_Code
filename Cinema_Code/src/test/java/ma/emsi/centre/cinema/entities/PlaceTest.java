package ma.emsi.centre.cinema.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PlaceTest {

    @InjectMocks
    private Place place;

    @Mock
    private Salle mockSalle;

    @Mock
    private Ticket mockTicket;

    @Test
    void testId() {
        Long expectedId = 1L;
        place.setId(expectedId);
        assertEquals(expectedId, place.getId());
    }

    @Test
    void testNumero() {
        int expectedNumero = 10;
        place.setNumero(expectedNumero);
        assertEquals(expectedNumero, place.getNumero());
    }

    @Test
    void testLongitude() {
        double expectedLongitude = 45.6789;
        place.setLongitude(expectedLongitude);
        assertEquals(expectedLongitude, place.getLongitude());
    }

    @Test
    void testLatitude() {
        double expectedLatitude = -12.3456;
        place.setLatitude(expectedLatitude);
        assertEquals(expectedLatitude, place.getLatitude());
    }

    @Test
    void testAltitude() {
        double expectedAltitude = 100.0;
        place.setAltitude(expectedAltitude);
        assertEquals(expectedAltitude, place.getAltitude());
    }

    @Test
    void testSalle() {
        place.setSalle(mockSalle);
        assertEquals(mockSalle, place.getSalle());
    }

    @Test
    void testTickets() {
        Collection<Ticket> expectedTickets = Collections.singletonList(mockTicket);
        place.setTickets(expectedTickets);
        assertEquals(expectedTickets, place.getTickets());
    }

    // Add more tests as needed for specific behavior or validation rules
}
