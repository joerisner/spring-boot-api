package dev.jrisner.books.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.jrisner.books.domain.dto.AuthorDto;
import dev.jrisner.books.domain.entities.AuthorEntity;
import dev.jrisner.books.mappers.Mapper;
import dev.jrisner.books.services.AuthorService;

@RestController
public class AuthorController {

  private AuthorService authorService;
  private Mapper<AuthorEntity, AuthorDto> authorMapper;

  public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDto> authorMapper) {
    this.authorService = authorService;
    this.authorMapper = authorMapper;
  }

  @PostMapping(path = "/authors")
  public AuthorDto createAuthor(@RequestBody AuthorDto author) {
    AuthorEntity authorEntity = authorMapper.mapFrom(author);
    AuthorEntity savedAuthorEntity = authorService.createAuthor(authorEntity);

    return authorMapper.mapTo(savedAuthorEntity);
  }
}
