package dev.jrisner.books.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.jrisner.books.domain.Author;
import dev.jrisner.books.domain.Book;
import dev.jrisner.books.util.TestDataUtil;

@SpringBootTest
@ExtendWith(SpringExtension.class)
// Fresh DB after each test run
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryIntegrationTests {

  private BookRepository underTest;
  
  // Inform Spring Boot to inject the underTest dependency when the test runs
  @Autowired
  public BookRepositoryIntegrationTests(BookRepository underTest) {
    this.underTest = underTest;
  }

  @Test
  public void testBookCanBeCreated() {
    Author author = TestDataUtil.createAuthorObject();
    Book book = TestDataUtil.createBookObject(author);

    underTest.save(book);
    Optional<Book> result = underTest.findById(book.getIsbn());

    assertThat(result).isPresent();
    assertThat(result.get()).isEqualTo(book);
  }

  @Test
  public void testMultipleBooksCanBeCreated() {
    Author authorA = TestDataUtil.createAuthorObject();
    Author authorB = TestDataUtil.createAuthorObjectB();
    Book bookA = TestDataUtil.createBookObject(authorA);
    Book bookB = TestDataUtil.createBookObjectB(authorB);
    
    underTest.save(bookA);
    underTest.save(bookB);
    Iterable<Book> result = underTest.findAll();

    assertThat(result).hasSize(2).containsExactly(bookA, bookB);
  }

  @Test
  public void testBookCanBeUpdated() {
    Author author = TestDataUtil.createAuthorObject();
    Book book = TestDataUtil.createBookObject(author);
    
    underTest.save(book);
    book.setTitle("Updated");
    underTest.save(book);
    Optional<Book> result = underTest.findById(book.getIsbn());

    assertThat(result).isPresent();
    assertThat(result.get().getTitle()).isEqualTo("Updated");
  }

  @Test
  public void testBookCanBeDeleted() {
    Author author = TestDataUtil.createAuthorObject();
    Book book = TestDataUtil.createBookObject(author);

    underTest.save(book);
    underTest.delete(book);
    Optional<Book> result = underTest.findById(book.getIsbn());

    assertThat(result).isEmpty();
  }
}
