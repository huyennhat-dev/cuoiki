package com.huyennhat.cuoiki.service;

import com.huyennhat.cuoiki.model.Account;
import com.huyennhat.cuoiki.repo.AccountRepo;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

  private final AccountRepo repo;

  public AccountService(AccountRepo repo) {
    this.repo = repo;
  }

  public Account saveAccount(Account account) {
    return repo.save(account);
  }

  public int checkAccount(Account account) {
    String email = account.getEmail();
    String password = account.getPassword();
    if (email != null && password != null) {
      Account acc = repo.findByEmail(email);
      if (acc != null) {
        if (password == acc.getPassword()) {
          return 0;//login thanh cong
        }
        return 1;//sai mat khau
      }
      //tai khoan khong ton tai
      return 2;
    }
    return 3;//thong tin rong
  }

  public Account updateAccount(Account account) {
    Account existingAccount = repo.findById(account.getId()).orElse(null);
    existingAccount.setName(account.getName());
    existingAccount.setPassword(account.getPassword());
    return repo.save(existingAccount);
  }
}
