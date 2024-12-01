package com.example.spring_jpa_sayat.controller;

import com.example.spring_jpa_sayat.model.Movie;
import com.example.spring_jpa_sayat.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
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
}
