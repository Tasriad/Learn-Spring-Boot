package dev.Tias.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// MovieService class is the service layer that contains the business logic of the application.
// It interacts with the repository layer to fetch and manipulate data.
// It is responsible for processing data and applying business rules.
@Service
public class MovieService {
    // @Autowired is used to inject dependencies into a Spring bean.
    // It tells Spring to automatically inject the dependency when the bean is created.
    // It is used to inject the MovieRepository bean into the MovieService bean.

    @Autowired
    private  MovieRepository movieRepository;
    public List<Movie> getMovies()
    {
        return movieRepository.findAll();
    }
    // Optional is used to represent a value that may or may not be present.
    public Optional<Movie> getSingleMovie(ObjectId id)
    {
        return movieRepository.findById(id);
    }
    // we shouldn't expose our object id to the client
    public Optional<Movie> getMovieByImdbId(String imdbId)
    {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
