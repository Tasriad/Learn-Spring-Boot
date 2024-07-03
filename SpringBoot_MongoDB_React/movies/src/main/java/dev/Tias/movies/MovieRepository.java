package dev.Tias.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// MovieRepository is the repository layer that interacts with the database.
// It is responsible for querying the database and returning the results to the service layer.
// It extends the MongoRepository interface, which provides CRUD operations for MongoDB.
// It is an interface that extends the MongoRepository interface and provides methods for querying the database.
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    Optional<Movie> findMovieByImdbId(String imdbId);
}
