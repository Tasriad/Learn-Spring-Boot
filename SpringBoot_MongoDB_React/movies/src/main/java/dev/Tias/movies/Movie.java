package dev.Tias.movies;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

// Movie class is a model class that represents a movie entity in the database.
// It is annotated with @Document to indicate that it is a MongoDB document.
// It contains fields that represent the attributes of a movie, such as title, release date, genres, and backdrops.
// It also contains annotations such as @Id and @DocumentReference to specify the primary key and reference to other documents.
// It is used to map the movie entity to a MongoDB document.
// It is a POJO (Plain Old Java Object) class that represents a movie entity in the database.

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private ObjectId _id;
    private String title;
    private String imdbId;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference
    private List<Review> reviewIds;
}
