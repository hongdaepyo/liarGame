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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

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

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/member/{memberId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<ResultBody> deleteMember(
            @PathVariable Long memberId
    ) {
        memberService.deleteMember(memberId);
        return ResponseEntity.ok(new ResultBody());
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/member/{memberId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResultBody> findMember(
            @PathVariable Long memberId
    ) {
        Member member = memberService.findMember(memberId);
        return ResponseEntity.ok(new ResultBody(member));
    }
}
