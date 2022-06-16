package com.example.libary.Controller;

import com.example.libary.Model.Book;
import com.example.libary.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/libary")
public class BookController {

    BookService bookService;
    public BookController(BookService bookService){
        this.bookService=bookService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAll(){
       List<Book> Books= bookService.findAllBook();
       return new ResponseEntity<>(Books, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id){
        Book book =bookService.findBookById(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook=bookService.addBook(book);
        return new ResponseEntity<>(newBook,HttpStatus.CREATED);
    }

   @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        Book updateBook=bookService.updateBook(book);
        return new ResponseEntity<>(updateBook,HttpStatus.OK);
   }

   @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
   }





}
