package ma.emsi.centre.cinema.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TicketTest {

    @InjectMocks
    private Ticket ticket;

    @Mock
    private Projection mockProjection;

    @Mock
    private Place mockPlace;

    @Test
    void testId() {
        Long expectedId = 1L;
        ticket.setId(expectedId);
        assertEquals(expectedId, ticket.getId());
    }

    @Test
    void testNomClient() {
        String expectedNomClient = "John Doe";
        ticket.setNomClient(expectedNomClient);
        assertEquals(expectedNomClient, ticket.getNomClient());
    }

    @Test
    void testPrix() {
        double expectedPrix = 25.0;
        ticket.setPrix(expectedPrix);
        assertEquals(expectedPrix, ticket.getPrix(), 0.001); // Specify a delta for double comparison
    }

    @Test
    void testCodePayement() {
        int expectedCodePayement = 123456;
        ticket.setCodePayement(expectedCodePayement);
        assertEquals(expectedCodePayement, ticket.getCodePayement());
    }

    @Test
    void testReserve() {
        assertFalse(ticket.isReserve()); // By default, should be false
        ticket.setReserve(true);
        assertTrue(ticket.isReserve());
    }

    @Test
    void testProjection() {
        ticket.setProjection(mockProjection);
        assertEquals(mockProjection, ticket.getProjection());
    }

    @Test
    void testPlace() {
        ticket.setPlace(mockPlace);
        assertEquals(mockPlace, ticket.getPlace());
    }
}
