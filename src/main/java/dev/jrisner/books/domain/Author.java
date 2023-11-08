package dev.jrisner.books.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
@Entity
@Table(name = "authors")
public class Author {
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
  private Long id;
  private String name;
  private Integer age;

  //#region Constructors
  public Author() {
  }

  public Author(Long id, String name, Integer age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }
  //#endregion Constructors

  //#region Getters/Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
  //#endregion Getters/Setters

  //#region Utils
  @Override
  public String toString() {
    return "Author [id=%d, name='%s', age=%d]".formatted(id, name, age);
  }
  //#endregion Utils
}
