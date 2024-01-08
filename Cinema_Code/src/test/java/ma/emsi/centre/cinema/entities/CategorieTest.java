package ma.emsi.centre.cinema.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Collections;

import ma.emsi.centre.cinema.entities.Categorie;
import ma.emsi.centre.cinema.entities.Film;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CategorieTest {

    @InjectMocks
    private Categorie categorie;

    @Mock
    private Film mockFilm;

    @Test
    void testId() {
        Long expectedId = 1L;
        categorie.setId(expectedId);
        assertEquals(expectedId, categorie.getId());
    }

    @Test
    void testNom() {
        String expectedNom = "Action";
        categorie.setNom(expectedNom);
        assertEquals(expectedNom, categorie.getNom());
    }

    @Test
    void testFilms() {
        Collection<Film> expectedFilms = Collections.singletonList(mockFilm);
        categorie.setFilms(expectedFilms);
        assertEquals(expectedFilms, categorie.getFilms());
    }

    // Add more tests as needed for specific behavior or validation rules
}
