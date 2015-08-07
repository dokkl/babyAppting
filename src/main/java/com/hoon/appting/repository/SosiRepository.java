package com.hoon.appting.repository;

import com.hoon.appting.entity.Sosi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by hoon on 2015-07-21.
 */
@Repository
public interface SosiRepository extends JpaRepository<Sosi, Long>, QueryDslPredicateExecutor<Sosi> {

}
