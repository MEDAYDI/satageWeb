package com.example.libary.Repository;

import com.example.libary.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
    void deleteBookById(Long id);
    Book findBookById(Long id);
}
