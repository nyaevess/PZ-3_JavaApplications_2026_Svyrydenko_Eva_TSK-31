package com.example.cinema; // оголошення пакету (щоб всі класи були в одному просторі)

import java.util.ArrayList; // імпорт класу ArrayList
import java.util.List;      // імпорт інтерфейсу List

public class Actor { // оголошення класу Actor

    private String name; // поле для зберігання імені актора
    private List<Film> films; // список фільмів, в яких знімався актор (типізований список)

    public Actor(String name) { // конструктор класу
        this.name = name; // ініціалізація імені
        this.films = new ArrayList<>(); // створення списку через Collection Framework (не масив!)
    }

    public String getName() { // геттер для отримання імені
        return name; // повертаємо ім'я
    }

    public List<Film> getFilms() { // геттер для списку фільмів
        return films; // повертаємо список
    }

    public void addFilm(Film film) { // метод додавання фільму актору
        films.add(film); // додаємо фільм у список
    }

    @Override
    public String toString() { // перевизначення методу для красивого виводу
        return name; // повертаємо ім'я замість стандартного Object
    }
}