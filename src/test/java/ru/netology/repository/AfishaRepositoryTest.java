package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    private Movie first = new Movie(1, 1, "movie1", "genre1", "image1");
    private Movie second = new Movie(2, 2, "movie2", "genre2", "image2");
    private Movie third = new Movie(3, 3, "movie3", "genre3", "image3");
    private Movie fourth = new Movie(4, 4, "movie4", "genre4", "image4");
    private Movie fifth = new Movie(5, 5, "movie5", "genre5", "image5");
    private Movie sixth= new Movie(6, 6, "movie6", "genre6", "image6");
    private Movie seventh = new Movie(7, 7, "movie7", "genre7", "image7");
    private Movie eight = new Movie(8, 8, "movie8", "genre8", "image8");
    private Movie ninth = new Movie(9, 9, "movie9", "genre9", "image9");
    private Movie tenth = new Movie(10, 10, "movie10", "genre10", "image10");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eight);
        repository.save(ninth);
        repository.save(tenth);
    }

    @Test
    public void shouldFindAll() {
        Movie[] actual = repository.findAll();
        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eight, ninth, tenth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByIdIfExists() {
        int idToFind = 8;
        Movie actual = repository.findById(idToFind);
        Movie expected = eight;

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotFindByIdIfNotExists() {
        int idToFind = 11;
        Movie actual = repository.findById(idToFind);
        Movie expected = null;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfExists() {
        int idToRemove = 5;
        repository.removeById(idToRemove);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, sixth, seventh, eight, ninth, tenth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        repository.removeAll();
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{};

        assertArrayEquals(expected, actual);
    }
}
