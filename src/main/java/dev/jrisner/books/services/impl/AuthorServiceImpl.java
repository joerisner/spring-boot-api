package dev.jrisner.books.services.impl;

import org.springframework.stereotype.Service;

import dev.jrisner.books.domain.entities.AuthorEntity;
import dev.jrisner.books.repositories.AuthorRepository;
import dev.jrisner.books.services.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

  private AuthorRepository authorRepository;

  public AuthorServiceImpl(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @Override
  public AuthorEntity createAuthor(AuthorEntity authorEntity) {
    return authorRepository.save(authorEntity);
  }
}
