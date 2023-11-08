package dev.jrisner.books.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
@Entity
@Table(name = "books")
public class Book {
  
  @Id
  private String isbn;
  
  private String title;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "author_id")
  private Author author;

  //#region Constructors
  public Book() {
  }

  public Book(String isbn, String title, Author author) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
  }
  //#endregion Constructors

  //#region Getters/Setters
  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }
  //#endregion Getters/Setters

  //#region Utils
  @Override
  public String toString() {
    return "Book [isbn=%s, title='%s', author=%d]".formatted(isbn, title, author.getId());
  }  
  //#endregion Utils
}
