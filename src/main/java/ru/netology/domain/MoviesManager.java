package ru.netology.domain;

public class MoviesManager {
    private Movies[] movies = new Movies[0];
    private int limit;

    public MoviesManager() {
        this.limit = 5;
    }

    public MoviesManager(int limit) {
        this.limit = limit;
    }

    public void add(Movies movie) {
        Movies[] tmp = new Movies[movies.length + 1]; //новый массив больше на 1 фильм
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        this.movies = tmp;
    }

    public Movies[] findAll() {
        return movies;
    }

    public Movies[] findLast() {
        int resultLength = movies.length;
        if (resultLength > limit) {
            resultLength = limit;
        } else {
            resultLength = movies.length;
        }
        Movies[] ans = new Movies[resultLength];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = movies[movies.length - 1 - i];
        }
        return ans;
    }
}
