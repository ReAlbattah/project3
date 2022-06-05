package com.example.project3.service;

import com.example.project3.exception.BookLendedBeforException;
import com.example.project3.exception.InvalidIdException;
import com.example.project3.model.Book;
import com.example.project3.model.Loan;
import com.example.project3.model.MyUser;
import com.example.project3.repo.BookRepo;
import com.example.project3.repo.LoanRepo;
import com.example.project3.repo.MyUserRepo;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service @AllArgsConstructor
public class BookService {
    private final BookRepo bookRepo;
    private final MyUserRepo myUserRepo;
    private final LoanRepo loanRepo;

    public List<Book> getBooks(){
      return bookRepo.findAll();
    }

    public Book getBook(Integer bookid){
        return bookRepo.findById(bookid).get();
    }

    public void addBook(Book book){
        bookRepo.save(book);
    }

//    public void returnB(Integer bookid){
//
//        Book book = bookS
////        Book book = bookRepo.findById(bookid).orElseThrow(()->{
////            throw new BookLendedBeforException("Book Id is wrong!");
////        });
////        return book.getLoans();
//    }

}
