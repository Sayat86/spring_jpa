package com.example.spring_jpa_sayat.repository;

import com.example.spring_jpa_sayat.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByReleaseYear(int releaseYear);

    List<Movie> findByReleaseYearBefore(int beforeYear);

    List<Movie> findByTitleContaining(String keyword);

    List<Movie> findByReleaseYearBetween(int beforeDate, int afterDate);

    List<Movie> findByReleaseYearInAndRatingBetween(List<Integer> years, Double minRating, Double maxRating);

    Page<Movie> findMoviesByRatingBetween(Double minRating, Double maxRating, Pageable pageable);

    Page<Movie> findMoviesByRatingBetweenAndReleaseYearIsBetween(Double minRating, Double maxRating, int startYear,
                                                                 int endYear, Pageable pageable);
}
