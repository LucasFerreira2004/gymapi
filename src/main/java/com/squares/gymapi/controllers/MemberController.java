package com.squares.gymapi.controllers;

import com.squares.gymapi.dto.MemberIdDTO;
import com.squares.gymapi.dto.MemberRequestDTO;
import com.squares.gymapi.dto.MemberResponseDTO;
import com.squares.gymapi.services.MemberService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    
    @PostMapping("/")
    public ResponseEntity<MemberIdDTO> createMember(@RequestBody @Valid MemberRequestDTO memberRequestDTO) {
        MemberIdDTO memberCreatedIdDTO = this.memberService.create(memberRequestDTO);
        return new ResponseEntity<>(memberCreatedIdDTO, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDTO> getMember(@PathVariable("id") String id) {
        MemberResponseDTO resultMember = this.memberService.getMember(id);
        return new ResponseEntity<>(resultMember, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public ResponseEntity<List<MemberResponseDTO>> listMembers() {
        return new ResponseEntity<>(this.memberService.getAllMembers(), HttpStatus.OK);
    }
}
