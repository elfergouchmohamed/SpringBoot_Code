package ma.emsi.centre.cinema;

import ma.emsi.centre.cinema.CinemaApplication;
import ma.emsi.centre.cinema.service.ICinemaInitService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CinemaApplicationTest {

	@InjectMocks
	private CinemaApplication cinemaApplication;

	@Mock
	private ICinemaInitService cinemaInitService;

	@Test
	void testRun() throws Exception {
		// Arrange: Set up any necessary data or expectations
		// For example, if you have specific expectations for the init methods

		// Act: Call the run method
		cinemaApplication.run();

		// Assert: Verify that the expected methods were called
		verify(cinemaInitService).initVilles();
		verify(cinemaInitService).initCategories();
		verify(cinemaInitService).initCinemas();
		verify(cinemaInitService).initSalles();
		verify(cinemaInitService).initPlaces();
		verify(cinemaInitService).initSeances();
		verify(cinemaInitService).initFilms();
		verify(cinemaInitService).initProjections();
		verify(cinemaInitService).initTickets();

		// You can add more assertions based on your specific requirements
	}
}
