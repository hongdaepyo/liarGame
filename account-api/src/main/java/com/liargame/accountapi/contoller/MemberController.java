package com.liargame.accountapi.contoller;

import com.liargame.accountapi.domain.Member;
import com.liargame.accountapi.dto.MemberDto;
import com.liargame.accountapi.request.CreateMember;
import com.liargame.accountapi.response.ResultBody;
import com.liargame.accountapi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/member/new", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResultBody> addMember(
            @Valid CreateMember createMember
    ) {
        Member member = memberService.addMember(createMember);
        return ResponseEntity.ok(new ResultBody(getMemberDto(member)));
    }

    private MemberDto getMemberDto(Member member) {
        return MemberDto.builder().member(member).build();
    }
}
