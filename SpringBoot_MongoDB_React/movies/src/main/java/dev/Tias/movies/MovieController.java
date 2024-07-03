package dev.Tias.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

// MovieController class is API Gateway layer that handles incoming HTTP requests and sends them to the appropriate service class.
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    // @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
    // It is used to map HTTP GET requests onto specific handler methods.
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<List<Movie>>(movieService.getMovies(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id)
    {
        return new ResponseEntity<Optional<Movie>>(movieService.getSingleMovie(id), HttpStatus.OK);
    }
    @GetMapping("/imdb/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable String imdbId)
    {
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieByImdbId(imdbId), HttpStatus.OK);
    }

}
