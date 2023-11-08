package dev.jrisner.books.mappers;

public interface Mapper<A,B> {
  
  B mapTo(A a);
  A mapFrom(B b);
}
