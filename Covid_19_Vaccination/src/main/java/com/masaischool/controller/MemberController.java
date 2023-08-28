package com.masaischool.controller;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.entity.Member;
import com.masaischool.exception.InvalidMemberException;
import com.masaischool.service.MemberService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(value = "*")
public class MemberController {
	private MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/getallmembers/{pageNumber}/{pageSize}")
	public ResponseEntity<List<Member>> getMemberList(@PathVariable int pageNumber, @PathVariable int pageSize){
		log.info("Retrieves a list of Members");
		Pageable pageRequest = PageRequest.of(pageNumber-1, pageSize);
		return new ResponseEntity<List<Member>>(memberService.getAllMember(pageRequest),HttpStatus.OK);
	}
	
	@GetMapping("/members/{memberId}")
	public ResponseEntity<Member> getMemberById(@PathVariable Integer memberId) throws InvalidMemberException {
		log.info("Retrieve a Member by id");
		return new ResponseEntity<Member>(memberService.getMemberById(memberId), HttpStatus.OK);
	}
	
	@GetMapping("/members/aadhar/{aadharNo}")
	public ResponseEntity<Member> getMemberByAadharNo(@PathVariable String aadharNo) throws InvalidMemberException {
		log.info("Retrieve a Member by Aadhar No");
		return new ResponseEntity<Member>(memberService.getMemberByAadharNo(aadharNo), HttpStatus.OK);
	}
	
	@GetMapping("/members/pan/{panNo}")
	public ResponseEntity<Member> getMemberByPanNo(@PathVariable String panNo) throws InvalidMemberException {
		log.info("Retrieve a Member by Pan No");
		return new ResponseEntity<Member>(memberService.getMemberByPanNo(panNo), HttpStatus.OK);
	}
	
	@PostMapping("/members/{userId}")
	public ResponseEntity<Member> addMember(@PathVariable Integer userId,@Valid @RequestBody Member member) throws InvalidMemberException{
		log.info("Adds a new member and associates it with a user.");
		return new ResponseEntity<Member>(memberService.addMember(member,userId), HttpStatus.CREATED);
	}
	
	@PutMapping("/members/{memberId}")
	public ResponseEntity<Member> updateMember(@PathVariable Integer memberId,@Valid @RequestBody Member member) throws InvalidMemberException{
		log.info("Update a member by member id");
		return new ResponseEntity<Member>(memberService.updateMember(member, memberId),HttpStatus.OK);
	}
	
	@DeleteMapping("/members/{memberId}")
	public ResponseEntity<Boolean> deleteMember(@PathVariable Integer memberId) throws InvalidMemberException{
		log.info("Delete a member by member id");
		return new ResponseEntity<Boolean>(memberService.deleteMember(memberId),HttpStatus.OK);
	}
}
