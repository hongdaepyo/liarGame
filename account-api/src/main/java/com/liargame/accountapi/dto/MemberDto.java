package com.liargame.accountapi.dto;

import com.liargame.accountapi.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class MemberDto {
    private Long id;
    private String nickname;
    private String sex;
    private int age;
    private LocalDateTime insertTime;

    @Builder
    protected MemberDto(Member member) {
        this.id = member.getId();
        this.nickname = member.getNickname();
        this.sex = member.getSex();
        this.age = member.getAge();
        this.insertTime = member.getInsertTime();
    }
}
