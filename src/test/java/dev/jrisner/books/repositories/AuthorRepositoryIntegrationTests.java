package dev.jrisner.books.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.jrisner.books.domain.entities.AuthorEntity;
import dev.jrisner.books.util.TestDataUtil;

@SpringBootTest
@ExtendWith(SpringExtension.class)
// Fresh DB after each test run
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorRepositoryIntegrationTests {

  private AuthorRepository underTest;

  // Inform Spring Boot to inject the underTest dependency when the test runs
  @Autowired
  public AuthorRepositoryIntegrationTests(AuthorRepository underTest) {
    this.underTest = underTest;
  }
  
  @Test
  public void testAuthorCanBeCreated() {
    AuthorEntity author = TestDataUtil.createAuthorObject();
    
    underTest.save(author);
    Optional<AuthorEntity> result = underTest.findById(author.getId());

    assertThat(result).isPresent();
    assertThat(result.get()).isEqualTo(author);
  }

  @Test
  public void testMultipleAuthorsCanBeCreated() {
    AuthorEntity authorA = TestDataUtil.createAuthorObject();
    AuthorEntity authorB = TestDataUtil.createAuthorObjectB();
    
    underTest.save(authorA);
    underTest.save(authorB);
    Iterable<AuthorEntity> result = underTest.findAll();

    assertThat(result).hasSize(2).containsExactly(authorA, authorB);
  }

  @Test
  public void testAuthorCanBeUpdated() {
    AuthorEntity author = TestDataUtil.createAuthorObject();
    
    underTest.save(author);
    author.setName("Updated");
    underTest.save(author);
    Optional<AuthorEntity> result = underTest.findById(author.getId());

    assertThat(result).isPresent();
    assertThat(result.get().getName()).isEqualTo("Updated");
  }

  @Test
  public void testAuthorCanBeDeleted() {
    AuthorEntity author = TestDataUtil.createAuthorObject();
    
    underTest.save(author);
    underTest.delete(author);
    Optional<AuthorEntity> result = underTest.findById(author.getId());

    assertThat(result).isEmpty();
  }

  @Test
  public void testGetAuthorsWithAgeLessThan() {
    AuthorEntity authorA = TestDataUtil.createAuthorObject();
    AuthorEntity authorB = TestDataUtil.createAuthorObjectB();
    underTest.saveAll(List.of(authorA, authorB));

    Iterable<AuthorEntity> result = underTest.ageLessThan(50);

    assertThat(result).containsExactly(authorA);
  }

  @Test
  public void testGetAuthorsWithAgeGreaterThan() {
    AuthorEntity authorA = TestDataUtil.createAuthorObject();
    AuthorEntity authorB = TestDataUtil.createAuthorObjectB();
    underTest.saveAll(List.of(authorA, authorB));

    Iterable<AuthorEntity> result = underTest.findAuthorsWithAgeGreaterThan(50);

    assertThat(result).containsExactly(authorB);
  }
}
