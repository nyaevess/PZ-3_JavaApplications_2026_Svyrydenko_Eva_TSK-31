package com.example.cinema; // пакет

import java.util.ArrayList; // імпорт списку
import java.util.List;      // імпорт інтерфейсу

public class Film { // клас Film

    private String title; // назва фільму
    private List<Actor> actors; // список акторів у фільмі

    public Film(String title) { // конструктор
        this.title = title; // задаємо назву
        this.actors = new ArrayList<>(); // створюємо список акторів
    }

    public String getTitle() { // геттер назви
        return title; // повертаємо назву
    }

    public List<Actor> getActors() { // геттер акторів
        return actors; // повертаємо список
    }

    public void addActor(Actor actor) { // додавання актора у фільм
        actors.add(actor); // додаємо в список
    }

    @Override
    public String toString() { // перевизначення для виводу
        return title; // повертаємо назву
    }
}