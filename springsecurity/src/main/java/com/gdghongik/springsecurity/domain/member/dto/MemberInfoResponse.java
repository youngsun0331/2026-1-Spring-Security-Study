package com.gdghongik.springsecurity.domain.member.dto;

import com.gdghongik.springsecurity.domain.member.entity.Member;
import lombok.Getter;


public record MemberInfoResponse(
        Long memberId,
        String username

) {
    // 예: Member 엔티티 객체를 받아 생성하는 생성자
    public MemberInfoResponse(Member member) {
        this(member.getId(), member.getUsername());
    }

}
