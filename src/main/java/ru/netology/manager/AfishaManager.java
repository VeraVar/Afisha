package ru.netology.manager;

import ru.netology.domain.Movie;

public class AfishaManager {
    private Movie[] items = new Movie[0];
    int returnMovies = 10;


    public AfishaManager(int returnMovies) {
        this.returnMovies = returnMovies;
    }

    public AfishaManager() {
    }

    public void add(Movie item) {
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie[] showLast() {
        int length = returnMovies;
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