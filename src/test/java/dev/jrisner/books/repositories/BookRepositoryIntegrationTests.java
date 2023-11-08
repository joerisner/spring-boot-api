package dev.jrisner.books.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.jrisner.books.domain.entities.AuthorEntity;
import dev.jrisner.books.domain.entities.BookEntity;
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
    AuthorEntity author = TestDataUtil.createAuthorObject();
    BookEntity book = TestDataUtil.createBookObject(author);

    underTest.save(book);
    Optional<BookEntity> result = underTest.findById(book.getIsbn());

    assertThat(result).isPresent();
    assertThat(result.get()).isEqualTo(book);
  }

  @Test
  public void testMultipleBooksCanBeCreated() {
    AuthorEntity authorA = TestDataUtil.createAuthorObject();
    AuthorEntity authorB = TestDataUtil.createAuthorObjectB();
    BookEntity bookA = TestDataUtil.createBookObject(authorA);
    BookEntity bookB = TestDataUtil.createBookObjectB(authorB);
    
    underTest.save(bookA);
    underTest.save(bookB);
    Iterable<BookEntity> result = underTest.findAll();

    assertThat(result).hasSize(2).containsExactly(bookA, bookB);
  }

  @Test
  public void testBookCanBeUpdated() {
    AuthorEntity author = TestDataUtil.createAuthorObject();
    BookEntity book = TestDataUtil.createBookObject(author);
    
    underTest.save(book);
    book.setTitle("Updated");
    underTest.save(book);
    Optional<BookEntity> result = underTest.findById(book.getIsbn());

    assertThat(result).isPresent();
    assertThat(result.get().getTitle()).isEqualTo("Updated");
  }

  @Test
  public void testBookCanBeDeleted() {
    AuthorEntity author = TestDataUtil.createAuthorObject();
    BookEntity book = TestDataUtil.createBookObject(author);

    underTest.save(book);
    underTest.delete(book);
    Optional<BookEntity> result = underTest.findById(book.getIsbn());

    assertThat(result).isEmpty();
  }
}
