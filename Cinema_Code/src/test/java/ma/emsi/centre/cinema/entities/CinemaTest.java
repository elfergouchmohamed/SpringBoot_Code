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
class CinemaTest {

    @InjectMocks
    private Cinema cinema;

    @Mock
    private Salle mockSalle;

    @Mock
    private Ville mockVille;

    @Test
    void testId() {
        Long expectedId = 1L;
        cinema.setId(expectedId);
        assertEquals(expectedId, cinema.getId());
    }

    @Test
    void testName() {
        String expectedName = "ABC Cinema";
        cinema.setName(expectedName);
        assertEquals(expectedName, cinema.getName());
    }

    @Test
    void testLongitude() {
        double expectedLongitude = 35.12345;
        cinema.setLongitude(expectedLongitude);
        assertEquals(expectedLongitude, cinema.getLongitude());
    }

    @Test
    void testLatitude() {
        double expectedLatitude = -85.6789;
        cinema.setLatitude(expectedLatitude);
        assertEquals(expectedLatitude, cinema.getLatitude());
    }

    @Test
    void testAltitude() {
        double expectedAltitude = 500.0;
        cinema.setAltitude(expectedAltitude);
        assertEquals(expectedAltitude, cinema.getAltitude());
    }

    @Test
    void testNombreSalles() {
        int expectedNombreSalles = 5;
        cinema.setNombreSalles(expectedNombreSalles);
        assertEquals(expectedNombreSalles, cinema.getNombreSalles());
    }

    @Test
    void testSalles() {
        Collection<Salle> expectedSalles = Collections.singletonList(mockSalle);
        cinema.setSalles(expectedSalles);
        assertEquals(expectedSalles, cinema.getSalles());
    }

    @Test
    void testVille() {
        cinema.setVille(mockVille);
        assertEquals(mockVille, cinema.getVille());
    }

    // Add more tests as needed for specific behavior or validation rules
}
