package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Product phone = new Smartphone(4, "Smartphone1", 10, "Producer1");

    @Test
    public void shouldMatchesBookByName() {
        assertEquals(true, phone.matches("Smartphone1"));
    }

    @Test
    public void shouldMatchesBookByAuthor() {
        assertEquals(true, phone.matches("Producer1"));
    }

    @Test
    public void shouldMatchesBookByNoneExistName() {
        assertEquals(false, phone.matches("Author2"));
    }


}