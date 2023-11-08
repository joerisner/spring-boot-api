package dev.jrisner.books.util;

import dev.jrisner.books.domain.entities.AuthorEntity;
import dev.jrisner.books.domain.entities.BookEntity;

public final class TestDataUtil {

  // This class should never be instantiated. Don't expose the constructor.
  private TestDataUtil() {}

  public static AuthorEntity createAuthorObject() {
    return AuthorEntity.builder()
    .id(1L)
    .name("Lois Lowry")
    .age(25)
    .build();
  }

  public static AuthorEntity createAuthorObjectB() {
    return AuthorEntity.builder()
    .id(2L)
    .name("C.S Lewis")
    .age(54)
    .build();
  }

  public static BookEntity createBookObject(final AuthorEntity author) {
    return BookEntity.builder()
    .isbn("9780007141425")
    .title("The Giver")
    .author(author)
    .build();
  }

  public static BookEntity createBookObjectB(final AuthorEntity author) {
    return BookEntity.builder()
    .isbn("9780001831803")
    .title("The Lion, the Witch, and the Wardrobe")
    .author(author)
    .build();
  }
}
