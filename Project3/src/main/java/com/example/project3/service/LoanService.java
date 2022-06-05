package com.example.project3.service;

import com.example.project3.exception.InvalidIdException;
import com.example.project3.model.Book;
import com.example.project3.model.Loan;
import com.example.project3.model.MyUser;
import com.example.project3.repo.LoanRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class LoanService {
    private final LoanRepo loanRepo;
//    private final BookRepo bookRepo;
//    private final MyUserRepo myUserRepo;

    private final BookService bookService;
    private final MyUserService myUserService;

    public List<Loan> getLoans() {
        return loanRepo.findAll();
    }

    public void addLoan(Loan loan) {
        loanRepo.save(loan);
    }

    public void lendBook(Integer userid, Integer bookid){
        //Optional<Book> book = bookRepo.findById(bookid);
        Book book = bookService.getBook(bookid);
        if (book.equals(null)) {
            throw new InvalidIdException("Book Id is wrong!");
        }
        MyUser myUser = myUserService.getUser(userid);
        if (myUser.equals(null)) {
            throw new InvalidIdException("User Id is wrong!");
        }

        Loan newLoan = new Loan(null, myUser.getId(),book.getId());
        book.getLoans().add(newLoan);
        newLoan.getBooks().add(book);
//
//        newLoan.setUserid(userid);
//        newLoan.setBookid(bookid);
        loanRepo.save(newLoan);

    }



//    public void lendBook(Integer userid, Integer bookid) {
//
//        Optional<Book> book = bookRepo.findById(bookid);
//        if (book.isEmpty()) {
//            throw new InvalidIdException("Book Id is wrong!");
//        }
//        Optional<MyUser> myUser = myUserRepo.findById(userid);
//        if (myUser.isEmpty()) {
//            throw new InvalidIdException("User Id is wrong!");
//        }
//        Optional<Loan> newLoan = Optional.of(new Loan());
//        newLoan.get().setBookid(bookid);
//        newLoan.get().setUserid(userid);
//        loanRepo.save(newLoan.get());
//    }

    public void returnB(Integer bookid){
        Book book= bookService.getBook(bookid);
        for(Loan loan: loanRepo.findAll()){
            if(loan.getBooks().contains(book)){
                loan.getBooks().remove(book);
            }
        }
    }

}
