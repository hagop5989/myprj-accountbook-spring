package com.springmytestprj0527.controller.member;

import com.springmytestprj0527.domain.member.Member;
import com.springmytestprj0527.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService service;

    @PostMapping("test")
    public void signup() {
        System.out.println("working!");
    }

    @PostMapping("signup")
    public ResponseEntity signup(@RequestBody Member member) {
        if (service.validate(member)) {
            service.insert(member);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "signupCheck", params = "email")
    public ResponseEntity signupEmailCheck(@RequestParam("email") String email) {
        if (email == null || email.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }


        return service.signupEmailCheck(email);
    }


    @GetMapping(value = "signupCheck", params = "nickName")
    public ResponseEntity signupNickNameCheck(@RequestParam("nickName") String nickName) {
        if (nickName == null || nickName.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return service.signupNickNameCheck(nickName);
    }

    @PostMapping("token")
    public ResponseEntity token(@RequestBody Member member) {
        Map<String, Object> token = service.getToken(member);
        if (token == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(token);
    }
}
