package com.huyennhat.cuoiki.controller;

import com.huyennhat.cuoiki.model.Account;
import com.huyennhat.cuoiki.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {

  private final AccountService service;

  public AccountController(AccountService service) {
    this.service = service;
  }

  @PostMapping("/register")
  public Account register(@RequestBody Account account) {
    return service.saveAccount(account);
  }

  @PostMapping("/login")
  public  Account login(@RequestBody Account account){
     return service.checkAccount(account);
  }
}
