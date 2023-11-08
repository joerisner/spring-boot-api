package dev.jrisner.books.services;

import dev.jrisner.books.domain.entities.AuthorEntity;

public interface AuthorService {
  
  AuthorEntity createAuthor(AuthorEntity author);
}
