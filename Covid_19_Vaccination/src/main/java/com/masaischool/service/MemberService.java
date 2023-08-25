package com.masaischool.service;

import java.util.List;

import com.masaischool.entity.Member;
import com.masaischool.exception.InvalidArgumentsException;
import com.masaischool.exception.InvalidMemberException;
import com.masaischool.exception.InvalidUserException;

public interface MemberService {

	public List<Member> getAllMember();
	public Member getMemberById(Integer id) throws InvalidMemberException;
	public Member getMemberByAadharNo(String aadharNo) throws InvalidMemberException;
	public Member getMemberByPanNo(String panNo) throws InvalidMemberException;
	public Member addMember(Member member, Integer userId ) throws InvalidMemberException;
	public Member updateMember(Member member, Integer memberId) throws InvalidMemberException;
	public Boolean deleteMember(Integer id) throws InvalidMemberException;	
}
