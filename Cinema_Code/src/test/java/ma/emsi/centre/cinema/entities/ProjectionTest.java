package ma.emsi.centre.cinema.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProjectionTest {

    @InjectMocks
    private Projection projection;

    @Mock
    private Salle mockSalle;

    @Mock
    private Film mockFilm;

    @Mock
    private Ticket mockTicket;

    @Mock
    private Seance mockSeance;

    @Test
    void testId() {
        Long expectedId = 1L;
        projection.setId(expectedId);
        assertEquals(expectedId, projection.getId());
    }

    @Test
    void testDateProjection() {
        Date expectedDateProjection = new Date();
        projection.setDateProjection(expectedDateProjection);
        assertEquals(expectedDateProjection, projection.getDateProjection());
    }

    @Test
    void testPrix() {
        double expectedPrix = 15.99;
        projection.setPrix(expectedPrix);
        assertEquals(expectedPrix, projection.getPrix(), 0.001);
    }

    @Test
    void testSalle() {
        projection.setSalle(mockSalle);
        assertEquals(mockSalle, projection.getSalle());
    }

    @Test
    void testFilm() {
        projection.setFilm(mockFilm);
        assertEquals(mockFilm, projection.getFilm());
    }

    @Test
    void testTickets() {
        Collection<Ticket> expectedTickets = Collections.singletonList(mockTicket);
        projection.setTickets(expectedTickets);
        assertEquals(expectedTickets, projection.getTickets());
    }

    @Test
    void testSeance() {
        projection.setSeance(mockSeance);
        assertEquals(mockSeance, projection.getSeance());
    }

    // Add more tests as needed for specific behavior or validation rules
}
