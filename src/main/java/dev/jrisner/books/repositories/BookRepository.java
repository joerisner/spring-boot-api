package dev.jrisner.books.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.jrisner.books.domain.entities.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, String> {
}
