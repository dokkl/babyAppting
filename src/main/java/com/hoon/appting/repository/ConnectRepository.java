package com.hoon.appting.repository;

import com.hoon.appting.entity.Connect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by hoon on 2015-08-11.
 */
@Repository
public interface ConnectRepository extends JpaRepository<Connect, Long>, QueryDslPredicateExecutor<Connect> {
}
