package com.example.project3.controller;

import com.example.project3.model.API;
import com.example.project3.model.Book;
import com.example.project3.model.Loan;
import com.example.project3.model.MyUser;
import com.example.project3.service.BookService;
import com.example.project3.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        logger.info("Get Books");
        return ResponseEntity.status(200).body(bookService.getBooks());
    }

    @PostMapping
    public ResponseEntity<API> addBook(@RequestBody @Valid Book book){
        logger.info("Add new Book");
        bookService.addBook(book);
        return ResponseEntity.status(201).body(new API("Book added",201));
    }

//    @PostMapping("/loanbook/{bookid}")
//    public ResponseEntity<Set<Loan>> getLoanBook(@PathVariable Integer bookid){
//        logger.info("Get loans book by book ID");
//        return ResponseEntity.status(201).body(bookService.getLoanBook(bookid));
//    }
}
