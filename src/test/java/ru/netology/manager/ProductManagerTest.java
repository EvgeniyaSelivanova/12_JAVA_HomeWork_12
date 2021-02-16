package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    ProductManager manager = new ProductManager();

    private Product firstBook = new Book(1, "Book1", 10, "Author1");
    private Product secondBook = new Book(2, "Book2", 20, "Author2");
    private Product thirdBook = new Book(3, "Book3", 30, "Author3");
    private Product firstPhone = new Smartphone(4, "Smartphone1", 10, "Producer1");
    private Product secondPhone = new Smartphone(5, "Smartphone2", 20, "Producer2");
    private Product thirdPhone = new Smartphone(6, "Smartphone3", 30, "Producer3");
    private Product firstBookPhone = new Book(7, "Smartphone1", 10, "Producer1");
    private Product firstPhoneBook = new Smartphone(8, "Book1", 10, "Author1");

    @BeforeEach
    public void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(firstPhone);
        manager.add(secondPhone);
        manager.add(thirdPhone);
        manager.add(firstBookPhone);
        manager.add(firstPhoneBook);
    }

    @Test
    public void shouldShowAllProducts() {
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{firstPhoneBook, firstBookPhone, thirdPhone, secondPhone, firstPhone, thirdBook, secondBook, firstBook};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveFirstProductById() {
        manager.removeById(1);
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{firstPhoneBook, firstBookPhone, thirdPhone, secondPhone, firstPhone, thirdBook, secondBook};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveLastProductById() {
        manager.removeById(8);
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{firstBookPhone, thirdPhone, secondPhone, firstPhone, thirdBook, secondBook, firstBook};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOnlyBookByName() {
        Product[] actual = manager.searchBy("Book2");
        Product[] expected = new Product[]{secondBook};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOnlySmartphoneByProducer() {
        Product[] actual = manager.searchBy("Producer3");
        Product[] expected = new Product[]{thirdPhone};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookAndSmartphoneByName() {
        Product[] actual = manager.searchBy("Book1");
        Product[] expected = new Product[]{firstPhoneBook, firstBook};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookAndSmartphoneByAuthor() {
        Product[] actual = manager.searchBy("Producer1");
        Product[] expected = new Product[]{firstBookPhone, firstPhone};
        assertArrayEquals(expected, actual);
    }
}