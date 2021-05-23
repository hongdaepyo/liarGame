package com.liargame.accountapi.repository;

import com.liargame.accountapi.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Repository
public class MemberRepository {

    private final EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public void delete(Member member) {
        em.merge(member);
    }

    public Member find(Long memberId) {
        return em.find(Member.class, memberId);
    }
}
