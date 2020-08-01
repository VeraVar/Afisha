package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
  @Mock
  private AfishaRepository repository;
  @InjectMocks
  private AfishaManager manager;
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

  @Test
  public void shouldAddAllMovies() {
    manager.add(first);
    manager.add(second);
    manager.add(third);
    manager.add(fourth);
    manager.add(fifth);
    manager.add(sixth);
    manager.add(seventh);
    manager.add(eight);
    manager.add(ninth);
    manager.add(tenth);
    Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eight, ninth, tenth};
    doReturn(returned).when(repository).findAll();

    Movie[] actual = manager.showLast();
    Movie[] expected = new Movie[]{tenth, ninth, eight, seventh, sixth, fifth, fourth, third, second, first};

  assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldAddOneMovie() {
    manager.add(first);
    Movie[] returned = new Movie[]{first};
    doReturn(returned).when(repository).findAll();

    Movie[] actual = manager.showLast();
    Movie[] expected = new Movie[]{first};

  assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldNotExist(){
    Movie[] returned = new Movie[]{};
    doReturn(returned).when(repository).findAll();

    Movie[] actual = manager.showLast();
    Movie[] expected = new Movie[]{};

  assertArrayEquals(expected, actual);
  }
}