package ma.emsi.centre.cinema.service;

import ma.emsi.centre.cinema.dao.*;
import ma.emsi.centre.cinema.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class CinemaInitServiceImpl implements ICinemaInitService {
    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private SalleRepository salleRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private SeanceRepository seanceRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ProjectionRepository projectionRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void initVilles() {
        Stream.of("Casablanca", "Marrakech", "Rabat").forEach(v -> {
            Ville ville = new Ville();
            ville.setName(v);
            villeRepository.save(ville);
        });
    }

    @Override
    public void initCinemas() {
        villeRepository.findAll().forEach(ville -> {
            Stream.of("MegaRAMA", "IMAX", "FOUNOUN", "CHAHRAZAD").forEach(cinemaName -> {
                Cinema cinema = new Cinema();
                cinema.setName(cinemaName);
                cinema.setVille(ville);
                cinema.setNombreSalles(3 + (int) (Math.random() * 7));
                cinemaRepository.save(cinema);
            });
        });
    }

    @Override
    public void initSalles() {
        cinemaRepository.findAll().forEach(cinema -> {
            for (int i = 0; i < cinema.getNombreSalles(); i++) {
                Salle salle = new Salle();
                salle.setNom("Salle " + (i + 1));
                salle.setCinema(cinema);
                salle.setNombrePlaces(15 + (int) (Math.random() * 20));
                 salleRepository.save(salle);
            }
        });
    }

    @Override
    public void initSeances() {
        DateFormat df = new SimpleDateFormat("HH:mm");
        Stream.of("12:00", "15:00", "17:00", "19:00", "21:00").forEach(s -> {
            Seance seance = new Seance();
            try {
                seance.setHeureDebut(df.parse(s));
                seanceRepository.save(seance);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void initPlaces() {
        salleRepository.findAll().forEach(salle -> {
            for (int i=0; i < salle.getNombrePlaces(); i++){
                Place place = new Place();
                place.setNumero(i+1);
                place.setSalle(salle);
                placeRepository.save(place);
            }
        });
    }

    @Override
    public void initCategories() {
        Stream.of("Action", "Fiction", "Drama", "Histoire").forEach(cat -> {
            Categorie categorie = new Categorie();
            categorie.setNom(cat);
            categorieRepository.save(categorie);
        });
    }

    @Override
    public void initFilms() {
        double[] durees = new double[]{1,1.5,2,2.5,3};
        List<Categorie> categories = categorieRepository.findAll();
        Stream.of("Hitman","Iron Man","Spider Man","Cat Women")
                .forEach(titreFilm -> {
                    Film film = new Film();
                    film.setTitre(titreFilm);
                    film.setDuree(durees[new Random().nextInt(durees.length)]);
                    film.setPhoto(titreFilm.replaceAll(" ","")+".jpg");
                    film.setCategorie(categories.get(new Random().nextInt(categories.size())));
                    filmRepository.save(film);
                });
    }
    @Override
    public void initProjections() {
        double[] prices = new double[] {30, 40, 50, 60, 70, 80};
        List<Film> films = filmRepository.findAll();
        villeRepository.findAll().forEach(ville -> {
            ville.getCinemas().forEach(cinema -> {
                cinema.getSalles().forEach(salle -> {
                    int index = new Random().nextInt(films.size());
                    Film film = films.get(index);
                    seanceRepository.findAll().forEach(seance -> {
                        Projection projection = new Projection();
                        projection.setDateProjection(new Date());
                        projection.setFilm(film);
                        projection.setPrix(prices[new Random().nextInt(prices.length)]);
                        projection.setSalle(salle);
                        projection.setSeance(seance);
                        projectionRepository.save(projection);
                    });
                });
            });
        });
    }

    @Override
    public void initTickets() {
        projectionRepository.findAll().forEach(projection -> {
            projection.getSalle().getPlaces().forEach(place -> {
                Ticket ticket = new Ticket();
                ticket.setPlace(place);
                ticket.setPrix(projection.getPrix());
                ticket.setProjection(projection);
                ticket.setReserve(false);
                ticketRepository.save(ticket);
            });
        });
    }

}
