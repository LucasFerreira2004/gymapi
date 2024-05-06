package com.squares.gymapi.services;

import com.squares.gymapi.domain.Member;
import com.squares.gymapi.dto.MemberIdDTO;
import com.squares.gymapi.dto.MemberRequestDTO;
import com.squares.gymapi.dto.MemberResponseDTO;
import com.squares.gymapi.repositories.MemberRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    
    public MemberIdDTO create(MemberRequestDTO memberRequestDTO) {
        Member member = new Member();
        
        member.setName(memberRequestDTO.name());
        member.setDateOfBirth(memberRequestDTO.dateOfBirth());
        member.setGender(memberRequestDTO.gender());
        member.setAddress(memberRequestDTO.address());
        member.setNumber(memberRequestDTO.number());
        member.setUnit(memberRequestDTO.unit());
        member.setZipCode(memberRequestDTO.zipCode());
        member.setCity(memberRequestDTO.city());
        member.setState(memberRequestDTO.state());
        member.setPhoneNumber(memberRequestDTO.phoneNumber());
        member.setEmail(memberRequestDTO.email());
        member.setMembershipPlan(memberRequestDTO.membershipPlan());
        
        member.setJoinDate(LocalDateTime.now());
        member.setActive(Boolean.TRUE);
        
        Member createdMember = this.memberRepository.save(member);
        
        return new MemberIdDTO(createdMember.getId());
    }
    
    public MemberResponseDTO getMember(String id) {
        Optional<Member> memberSearchResult = this.memberRepository.findById(id);
        
        if (!memberSearchResult.isPresent()) {
            throw new RuntimeException("The member does not exists.");
        }
        
        Member resultMember = memberSearchResult.get();
        
        return new MemberResponseDTO(
                resultMember.getName(),
                resultMember.getDateOfBirth(),
                resultMember.getGender(),
                resultMember.getAddress(),
                resultMember.getNumber(),
                resultMember.getUnit(),
                resultMember.getZipCode(),
                resultMember.getCity(),
                resultMember.getState(),
                resultMember.getPhoneNumber(),
                resultMember.getEmail(),
                resultMember.getMembershipPlan(),
                resultMember.getActive());
    }
    
    public List<MemberResponseDTO> getAllMembers() {
        List<Member> allMembers = this.memberRepository.findAll();
        
        List<MemberResponseDTO> result = allMembers.stream().map(member -> {
            return new MemberResponseDTO(
                    member.getName(),
                    member.getDateOfBirth(),
                    member.getGender(),
                    member.getAddress(),
                    member.getNumber(),
                    member.getUnit(),
                    member.getZipCode(), 
                    member.getCity(),
                    member.getState(),
                    member.getPhoneNumber(),
                    member.getEmail(),
                    member.getMembershipPlan(),
                    member.getActive());
        }).toList();
        
        return result;
    }
}
