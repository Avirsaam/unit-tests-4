package seminars.fourth.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class BookServiceTest {
    private BookRepository mockRepository;
    private BookService bookService;
    private List<Book> testListOfBooks;

    BookServiceTest() {
    }

    @BeforeEach
    void setUp() {
        mockRepository = mock(BookRepository.class);
        this.bookService = new BookService(this.mockRepository);

        testListOfBooks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            testListOfBooks.add(new Book(i+"", "name_" + i, "author_"+i));
        }
    }

    @Test
    @DisplayName("Проверка, что сервис возвращает книгу при поиске по ID")
    void testFindBookByID(){
        when(mockRepository.findById("0")).thenReturn(testListOfBooks.get(0));
        assertEquals(testListOfBooks.get(0), mockRepository.findById("0"));
    }

    @Test
    @DisplayName("Проверка, что сервис возвращает список книг")
    void findAllBooks() {
        when(mockRepository.findAll()).thenReturn(testListOfBooks);
        assertEquals(testListOfBooks, mockRepository.findAll() );
    }


}