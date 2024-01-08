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
class VilleTest {

    @InjectMocks
    private Ville ville;

    @Mock
    private Cinema mockCinema;

    @Test
    void testId() {
        Long expectedId = 1L;
        ville.setId(expectedId);
        assertEquals(expectedId, ville.getId());
    }

    @Test
    void testName() {
        String expectedName = "City";
        ville.setName(expectedName);
        assertEquals(expectedName, ville.getName());
    }

    @Test
    void testLongitude() {
        double expectedLongitude = 12.34;
        ville.setLongitude(expectedLongitude);
        assertEquals(expectedLongitude, ville.getLongitude());
    }

    @Test
    void testLatitude() {
        double expectedLatitude = 56.78;
        ville.setLatitude(expectedLatitude);
        assertEquals(expectedLatitude, ville.getLatitude());
    }

    @Test
    void testAltitude() {
        double expectedAltitude = 100.0;
        ville.setAltitude(expectedAltitude);
        assertEquals(expectedAltitude, ville.getAltitude());
    }

    @Test
    void testCinemas() {
        Collection<Cinema> expectedCinemas = Collections.singletonList(mockCinema);
        ville.setCinemas(expectedCinemas);
        assertEquals(expectedCinemas, ville.getCinemas());
    }

    // Add more tests as needed for specific behavior or validation rules
}
