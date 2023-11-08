package dev.jrisner.books.util;

import dev.jrisner.books.domain.Author;
import dev.jrisner.books.domain.Book;

public final class TestDataUtil {

  // This class should never be instantiated. Don't expose the constructor.
  private TestDataUtil() {}

  public static Author createAuthorObject() {
    return Author.builder()
    .id(1L)
    .name("Lois Lowry")
    .age(25)
    .build();
  }

  public static Author createAuthorObjectB() {
    return Author.builder()
    .id(2L)
    .name("C.S Lewis")
    .age(54)
    .build();
  }

  public static Book createBookObject(final Author author) {
    return Book.builder()
    .isbn("9780007141425")
    .title("The Giver")
    .author(author)
    .build();
  }

  public static Book createBookObjectB(final Author author) {
    return Book.builder()
    .isbn("9780001831803")
    .title("The Lion, the Witch, and the Wardrobe")
    .author(author)
    .build();
  }
}
