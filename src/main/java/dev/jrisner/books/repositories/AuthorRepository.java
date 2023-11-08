package dev.jrisner.books.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.jrisner.books.domain.entities.AuthorEntity;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {

  // No need to provide an implementation for this method. Spring deduces an implemenation
  // based on the method signature and provides a metaprogrammed implementation.
  Iterable<AuthorEntity> ageLessThan(int age);

  // HQL Query (not SQL) that should be executed when this method is invoked
  @Query("SELECT a FROM AuthorEntity a where a.age > ?1")
  Iterable<AuthorEntity> findAuthorsWithAgeGreaterThan(int age);
}
