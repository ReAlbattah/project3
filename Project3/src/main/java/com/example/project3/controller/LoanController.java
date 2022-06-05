package com.example.project3.controller;

import com.example.project3.model.API;
import com.example.project3.model.Loan;
import com.example.project3.model.MyUser;
import com.example.project3.service.LoanService;
import com.example.project3.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/loan")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;
    Logger logger= LoggerFactory.getLogger(LoanController.class);

    @GetMapping
    public ResponseEntity<List<Loan>> getLoans(){
        logger.info("Get loans");
        return ResponseEntity.status(200).body(loanService.getLoans());
    }

    @PostMapping
    public ResponseEntity<API> addLoan(@RequestBody @Valid Loan loan){
        logger.info("Add new loan ");
        loanService.addLoan(loan);
        return ResponseEntity.status(201).body(new API("Loan added",201));
    }

    @PostMapping("/lendbook/{userid}/{bookid}")
    public ResponseEntity<API> lendbook(@PathVariable Integer userid,@PathVariable Integer bookid){
        logger.info("Lend new book ");
        loanService.lendBook(userid,bookid);
        return ResponseEntity.status(201).body(new API("Book has be loaned ",201));
    }

    @PostMapping("/returnbook/{bookid}")
    public ResponseEntity<API> returnB(@PathVariable Integer bookid){
        logger.info("Return book ");
        loanService.returnB(bookid);
        return ResponseEntity.status(201).body(new API("Book has be return ",201));
    }

}
