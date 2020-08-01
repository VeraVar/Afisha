package ru.netology.manager;

import ru.netology.repository.AfishaRepository;
import ru.netology.domain.Movie;

public class AfishaManager {
    private AfishaRepository repository;
    int returnMovies = 10;

    public AfishaManager(AfishaRepository repository, int returnMovies) {
        this.repository = repository;
        this.returnMovies = returnMovies;
    }

    public AfishaManager() {
    }

    public AfishaManager(int returnMovies) {
        this.returnMovies = returnMovies;
    }

    public void add(Movie item) {
        repository.save(item);
    }

    public Movie[] showLast() {
        int length = returnMovies;
        Movie[] items = repository.findAll();
        if (length > items.length) {
            length = items.length;
        }
        if (returnMovies <= 0) {
            length = items.length;
        }
        Movie[] result = new Movie[length];
        for (int i = 0; i < length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}