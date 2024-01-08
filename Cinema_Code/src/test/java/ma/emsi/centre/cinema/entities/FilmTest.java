package ma.emsi.centre.cinema.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FilmTest {

    @InjectMocks
    private Film film;

    @Mock
    private Projection mockProjection;

    @Mock
    private Categorie mockCategorie;

    @Test
    void testId() {
        Long expectedId = 1L;
        film.setId(expectedId);
        assertEquals(expectedId, film.getId());
    }

    @Test
    void testTitre() {
        String expectedTitre = "Inception";
        film.setTitre(expectedTitre);
        assertEquals(expectedTitre, film.getTitre());
    }

    @Test
    void testDescription() {
        String expectedDescription = "A mind-bending thriller";
        film.setDescription(expectedDescription);
        assertEquals(expectedDescription, film.getDescription());
    }

    @Test
    void testRealisateur() {
        String expectedRealisateur = "Christopher Nolan";
        film.setRealisateur(expectedRealisateur);
        assertEquals(expectedRealisateur, film.getRealisateur());
    }

    @Test
    void testDateSortie() {
        Date expectedDateSortie = new Date();
        film.setDateSortie(expectedDateSortie);
        assertEquals(expectedDateSortie, film.getDateSortie());
    }

    @Test
    void testDuree() {
        double expectedDuree = 150.5;
        film.setDuree(expectedDuree);
        assertEquals(expectedDuree, film.getDuree());
    }

    @Test
    void testPhoto() {
        String expectedPhoto = "inception.jpg";
        film.setPhoto(expectedPhoto);
        assertEquals(expectedPhoto, film.getPhoto());
    }

    @Test
    void testProjections() {
        film.setProjections(Collections.singletonList(mockProjection));
        assertEquals(Collections.singletonList(mockProjection), film.getProjections());
    }

    @Test
    void testCategorie() {
        film.setCategorie(mockCategorie);
        assertEquals(mockCategorie, film.getCategorie());
    }
}
