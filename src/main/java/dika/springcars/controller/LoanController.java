package dika.springcars.controller;

import dika.springcars.exception.UserNotFoundException;
import dika.springcars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private final UserService userService;

    @Autowired
    public LoanController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public BigDecimal getLoan(@RequestParam(required = false) Long userId) throws UserNotFoundException {
        return userService.getLoanSum(userId);
    }
}

///loan?user=1 -> requestParam
///loan/1?sort=123 -> pathVariable