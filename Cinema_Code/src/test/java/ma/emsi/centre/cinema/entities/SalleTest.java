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
class SalleTest {

    @InjectMocks
    private Salle salle;

    @Mock
    private Cinema mockCinema;

    @Mock
    private Place mockPlace;

    @Mock
    private Projection mockProjection;

    @Test
    void testId() {
        Long expectedId = 1L;
        salle.setId(expectedId);
        assertEquals(expectedId, salle.getId());
    }

    @Test
    void testNom() {
        String expectedNom = "Salle A";
        salle.setNom(expectedNom);
        assertEquals(expectedNom, salle.getNom());
    }

    @Test
    void testNombrePlaces() {
        int expectedNombrePlaces = 100;
        salle.setNombrePlaces(expectedNombrePlaces);
        assertEquals(expectedNombrePlaces, salle.getNombrePlaces());
    }

    @Test
    void testCinema() {
        salle.setCinema(mockCinema);
        assertEquals(mockCinema, salle.getCinema());
    }

    @Test
    void testPlaces() {
        Collection<Place> expectedPlaces = Collections.singletonList(mockPlace);
        salle.setPlaces(expectedPlaces);
        assertEquals(expectedPlaces, salle.getPlaces());
    }

    @Test
    void testProjections() {
        Collection<Projection> expectedProjections = Collections.singletonList(mockProjection);
        salle.setProjections(expectedProjections);
        assertEquals(expectedProjections, salle.getProjections());
    }

    // Add more tests as needed for specific behavior or validation rules
}
