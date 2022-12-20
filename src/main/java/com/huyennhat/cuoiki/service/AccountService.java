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

  public Account checkAccount(Account account) {
    String email = account.getEmail();
    String password = account.getPassword();
    if (email != null && password != null) {
      return repo.findOneByEmailIgnoreCaseAndPassword(email, password);
    }
    return null;//thong tin rong
  }

  public Account updateAccount(Account account) {
    Account existingAccount = repo.findById(account.getId()).orElse(null);
    existingAccount.setName(account.getName());
    existingAccount.setPassword(account.getPassword());
    return repo.save(existingAccount);
  }
}
