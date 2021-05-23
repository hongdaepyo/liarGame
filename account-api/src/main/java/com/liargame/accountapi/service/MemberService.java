package com.liargame.accountapi.service;

import com.liargame.accountapi.domain.Member;
import com.liargame.accountapi.repository.MemberRepository;
import com.liargame.accountapi.request.CreateMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Member addMember(CreateMember createMember) {
        Member member = Member.builder()
                .nickname(createMember.getNickname())
                .age(createMember.getAge())
                .sex(createMember.getSex())
                .country(createMember.getCountry())
                .insertTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        memberRepository.save(member);

        return member;
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = findMember(memberId);
        // todo. 회원정보가 없을 때 처리
        member.deleteMember();

        memberRepository.delete(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.find(memberId);
    }
}
