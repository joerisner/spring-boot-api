package dev.jrisner.books.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.jrisner.books.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
}
