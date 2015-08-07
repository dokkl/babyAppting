package com.hoon.appting.repository;

import com.hoon.appting.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hoon on 2015-04-26.
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> , QueryDslPredicateExecutor<Member> {
    Member findByMail(String mail);

    List<Member> findBySex(String sex);
}
