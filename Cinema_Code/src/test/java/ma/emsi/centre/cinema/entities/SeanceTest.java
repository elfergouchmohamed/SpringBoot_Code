package ma.emsi.centre.cinema.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javax.persistence.TemporalType;
import java.util.Calendar;
import java.util.Date;

class SeanceTest {

    @Test
    void testId() {
        Seance seance = new Seance();
        Long expectedId = 1L;
        seance.setId(expectedId);
        assertEquals(expectedId, seance.getId());
    }

    @Test
    void testHeureDebut() {
        Seance seance = new Seance();
        Date expectedHeureDebut = getTimeInFuture();
        seance.setHeureDebut(expectedHeureDebut);
        assertEquals(expectedHeureDebut, seance.getHeureDebut());
    }

    private Date getTimeInFuture() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 1);
        return calendar.getTime();
    }

}
