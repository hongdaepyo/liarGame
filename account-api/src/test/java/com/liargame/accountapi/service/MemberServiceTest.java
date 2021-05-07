package com.liargame.accountapi.service;

import com.liargame.accountapi.domain.Member;
import com.liargame.accountapi.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@Transactional
@SpringBootTest
@ExtendWith(SpringExtension.class)
class MemberServiceTest {
    @Mock
    MemberRepository memberRepository;

    @Test
    @DisplayName("회원 가입")
    void addMember() {
        Member member = Member.builder()
                .nickname("test")
                .age(19)
                .sex("m")
                .country("kr")
                .insertTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        when(memberRepository.save(member)).thenReturn(1L);

    }
}