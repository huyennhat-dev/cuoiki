package com.huyennhat.cuoiki.repo;

import com.huyennhat.cuoiki.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Integer> {
    Account findOneByEmailIgnoreCaseAndPassword(String email, String password);

}
