package com.example.cinema; // пакет

import java.util.ArrayList; // імпорт списку
import java.util.List;      // імпорт інтерфейсу

public class CinemaDatabase { // клас бази даних

    private List<Film> films;   // список усіх фільмів
    private List<Actor> actors; // список усіх акторів

    public CinemaDatabase() { // конструктор
        films = new ArrayList<>();  // ініціалізація списку фільмів
        actors = new ArrayList<>(); // ініціалізація списку акторів
    }

    public List<Film> getFilms() { // геттер фільмів
        return films; // повертаємо список
    }

    public List<Actor> getActors() { // геттер акторів
        return actors; // повертаємо список
    }

    public void addFilm(Film film) { // додавання фільму в базу
        films.add(film); // додаємо у список
    }

    public void addActor(Actor actor) { // додавання актора в базу
        actors.add(actor); // додаємо у список
    }
}