package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Product book = new Book(1, "Book1", 10, "Author1");

    @Test
    public void shouldMatchesBookByName() {
        assertEquals(true, book.matches("Book1"));
    }

    @Test
    public void shouldMatchesBookByAuthor() {
        assertEquals(true, book.matches("Author1"));
    }

    @Test
    public void shouldMatchesBookByNoneExistName() {
        assertEquals(false, book.matches("Author2"));
    }

}