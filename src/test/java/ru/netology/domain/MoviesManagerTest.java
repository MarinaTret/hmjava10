package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MoviesManagerTest {
    Movies movie1 = new Movies(1, "Бладшот", "боевик");
    Movies movie2 = new Movies(2, "Вперед", "мультфильм");
    Movies movie3 = new Movies(3, "Отель Белград", "комедия");
    Movies movie4 = new Movies(4, "Джентльмены", "боевик");
    Movies movie5 = new Movies(5, "Человек-невидимка", "ужасы");
    Movies movie6 = new Movies(6, "Тролли. Мировой тур", "мультфильм");
    Movies movie7 = new Movies(7, "Номер один", "комедия");
    //Movies movie8 = new Movie(8, "Отель", "комедия");

    @Test
    public void shouldAddMovie() {
       MoviesManager manager = new MoviesManager();

        manager.add(movie1);
        manager.add(movie2);

       Movies[] expected = {movie1,movie2};
       Movies[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void should0Movie() {
        MoviesManager manager = new MoviesManager();
        Movies[] expected = {};
        Movies[] actual = manager.findAll();

        Assertions. assertArrayEquals(expected, actual);
    }


    @Test
    public void FirstMovie() {
        MoviesManager manager = new MoviesManager();

        manager.add(movie1);

        Movies[] expected ={movie1};
        Movies[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //количество фильмов = лимиту
    public void shouldAllMovie() {
        MoviesManager manager = new MoviesManager();

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);

        Movies[] expected ={movie1, movie2, movie3, movie4, movie5, movie6, movie7};
        Movies[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //вывод фильмов в обратном порядке
    public void shouldLastMovie() {
        MoviesManager manager = new MoviesManager();

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);

        Movies[] expected ={movie7, movie6, movie5, movie4, movie3};
        Movies[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldLastMovieNewLimit() {
        MoviesManager manager = new MoviesManager(5);

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);
        manager.add(movie7);

        Movies[] expected ={movie7, movie6, movie5, movie4, movie3};
        Movies[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test //количество фильмов < лимита
    public void shouldLastMovieLessLimit() {
        MoviesManager manager = new MoviesManager();

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);

        Movies[] expected ={movie4, movie3, movie2, movie1};
        Movies[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}
