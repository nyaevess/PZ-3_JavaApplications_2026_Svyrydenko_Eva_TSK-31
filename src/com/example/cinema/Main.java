package com.example.cinema; // пакет

import java.util.*; // імпорт колекцій
import java.util.stream.Collectors; // імпорт для collect()

public class Main { // головний клас

    public static void main(String[] args) { // точка входу в програму

        CinemaDatabase db = new CinemaDatabase(); // створення бази даних

        // створення акторів
        Actor a1 = new Actor("Actor 1"); // актор 1
        Actor a2 = new Actor("Actor 2"); // актор 2
        Actor a3 = new Actor("Actor 3"); // актор 3
        Actor a4 = new Actor("Actor 4"); // актор без фільмів (для перевірки задачі 1)

        // створення фільмів
        Film f1 = new Film("Film A"); // перший фільм
        Film f2 = new Film("Film B"); // другий фільм

        // встановлення зв'язків (двосторонніх!)

        f1.addActor(a1); // додаємо актора 1 у фільм 1
        f1.addActor(a2); // додаємо актора 2 у фільм 1

        f2.addActor(a2); // додаємо актора 2 у фільм 2
        f2.addActor(a3); // додаємо актора 3 у фільм 2

        a1.addFilm(f1); // додаємо фільм 1 актору 1
        a2.addFilm(f1); // додаємо фільм 1 актору 2
        a2.addFilm(f2); // додаємо фільм 2 актору 2
        a3.addFilm(f2); // додаємо фільм 2 актору 3

        // додаємо все у базу
        db.addActor(a1);
        db.addActor(a2);
        db.addActor(a3);
        db.addActor(a4);

        db.addFilm(f1);
        db.addFilm(f2);

        // ================================
        // 1) Чи є актор без жодного фільму
        // ================================

        boolean hasActorWithoutFilms = db.getActors().stream() // перетворюємо список акторів у Stream
                .anyMatch(actor -> actor.getFilms().isEmpty()); // перевіряємо, чи є актор з порожнім списком фільмів

        System.out.println("1) Є актор без фільмів: " + hasActorWithoutFilms); // вивід результату

        // ================================
        // 2) Актори, що грали разом із заданим
        // ================================

        Actor target = a2; // обираємо актора (з яким шукаємо колег)

        List<Actor> coActors = target.getFilms().stream() // беремо всі фільми цього актора
                .flatMap(film -> film.getActors().stream()) // отримуємо всіх акторів з цих фільмів (розгортання списків)
                .filter(actor -> !actor.equals(target)) // прибираємо самого актора
                .distinct() // видаляємо дублікати
                .collect(Collectors.toList()); // збираємо результат у список

        System.out.println("2) Колеги актора " + target + ": " + coActors); // вивід

        // ================================
        // 3) Фільм з найбільшою кількістю акторів
        // ================================

        Optional<Film> maxFilm = db.getFilms().stream() // перетворюємо список фільмів у Stream
                .max(Comparator.comparingInt(f -> f.getActors().size())); // шукаємо максимум за кількістю акторів

        maxFilm.ifPresent(f -> System.out.println("3) Найбільше акторів у: " + f)); // якщо знайдено — виводимо
    }
}