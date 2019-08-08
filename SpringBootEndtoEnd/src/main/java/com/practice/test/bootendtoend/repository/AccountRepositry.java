package com.practice.test.bootendtoend.repository;

import com.practice.test.bootendtoend.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface AccountRepositry extends JpaRepository<Account,Long> {

}
