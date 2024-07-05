package model;

import entity.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EditBookOfDAOBookTest {

    @Test
    void EditBookWithNull() {
        DAOBook daoBook = new DAOBook();
        Book book = null;

        Exception exception = assertThrows(NullPointerException.class, () -> {
           daoBook.editBook(book);
        });

        assertEquals("", exception.getMessage());
    }



}
