package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MovieManagerTest {
    Movie movie1 = new Movie(1, "Бладшот", "боевик");
    Movie movie2 = new Movie(2, "Вперед", "мультфильм");
    Movie movie3 = new Movie(3, "Отель Белград", "комедия");
    Movie movie4 = new Movie(4, "Джентльмены", "боевик");
    Movie movie5 = new Movie(5, "Человек-невидимка", "ужасы");
    Movie movie6 = new Movie(6, "Тролли. Мировой тур", "мультфильм");
    Movie movie7 = new Movie(7, "Номер один", "комедия");
    //Movie movie8 = new Movie(8, "Отель", "комедия");

    @Test
    public void shouldAddMovie() {
       MovieManager manager = new MovieManager();

        manager.add(movie1);
        manager.add(movie2);

       String[] expected = {movie1,movie2};
       String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void should0Movie() {
        MovieManager manager = new MovieManager();
        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions. assertArrayEquals(expected, actual);
    }


    @Test
    public void FirstMovie() {
        MovieManager manager = new MovieManager();

        manager.add(movie1);

        String[] expected ={movie1};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //количество фильмов = лимиту
    public void shouldAllMovie() {
        MovieManager manager = new MovieManager();

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);

        String[] expected ={movie1, movie2, movie3, movie4, movie5, movie6, movie7};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //вывод фильмов в обратном порядке
    public void shouldLastMovie() {
        MovieManager manager = new MovieManager();

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);

        String[] expected ={movie7, movie6, movie6, movie4, movie3, movie2, movie1};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldLastMovieNewLimit(5) {
        MovieManager manager = new MovieManager();

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);

        String[] expected ={movie7, movie6, movie5, movie4, movie3};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test //количество фильмов < лимита
    public void shouldLastMovieLessLimit() {
        MovieManager manager = new MovieManager();

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);

        String[] expected ={movie4, movie3, movie2, movie1};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}
