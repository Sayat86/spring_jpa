package com.example.spring_jpa_sayat.controller;

import com.example.spring_jpa_sayat.model.Movie;
import com.example.spring_jpa_sayat.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieRepository movieRepository;

    @GetMapping("/find-by-year")
    public List<Movie> findByReleaseYear(@RequestParam int releaseYear) {
        return movieRepository.findByReleaseYear(releaseYear);
    }

    @GetMapping("/before-year")
    public List<Movie> findByReleaseYearBefore(@RequestParam int beforeYear) {
        return movieRepository.findByReleaseYearBefore(beforeYear);
    }

    @GetMapping("/movie-name")
    public List<Movie> findByTitleContaining(@RequestParam String movieName) {
        return movieRepository.findByTitleContaining(movieName);
    }

    @GetMapping("/between-date")
    public List<Movie> findByReleaseYearBetween(@RequestParam int beforeDate, @RequestParam int afterDate) {
        return movieRepository.findByReleaseYearBetween(beforeDate, afterDate);
    }

    @GetMapping("/years-and-rating")
    public List<Movie> findByReleaseYearInAndRatingBetween(@RequestParam List<Integer> years,
                                                           @RequestParam Double minRating,
                                                           @RequestParam Double maxRating) {
        return movieRepository.findByReleaseYearInAndRatingBetween(years, minRating, maxRating);
    }

    @GetMapping("filter-by-rating")
    public List<Movie> findMoviesByRatingBetween(@RequestParam Double minRating,
                                                 @RequestParam Double maxRating,
                                                 @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return movieRepository.findMoviesByRatingBetween(minRating, maxRating, pageable).getContent();
    }

    @GetMapping("filter-by-rating-year")
    public List<Movie> findMoviesByRatingBetweenAndReleaseYearIsBetween(@RequestParam Double minRating,
                                                                        @RequestParam Double maxRating,
                                                                        @RequestParam int startYear,
                                                                        @RequestParam int endYear,
                                                                        @RequestParam(defaultValue = "releaseYear") String sortBy,
                                                                        @RequestParam String sortOrder,
                                                                        @RequestParam(defaultValue = "0") int page,
                                                                        @RequestParam(defaultValue = "5") int size) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return movieRepository.findMoviesByRatingBetweenAndReleaseYearIsBetween(
                minRating, maxRating, startYear, endYear, pageable).getContent();
    }
}
