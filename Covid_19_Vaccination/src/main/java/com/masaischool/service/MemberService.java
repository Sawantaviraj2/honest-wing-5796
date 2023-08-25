package com.masaischool.service;

import java.util.List;

import com.masaischool.entity.Member;
import com.masaischool.exception.InvalidArgumentsException;
import com.masaischool.exception.InvalidUserException;

public interface MemberService {

	public List<Member> getAllMember()throws InvalidArgumentsException;
	public Member getMemberById(Integer id) throws InvalidUserException;
	public Member getMemberByAadharNo(String aadharNo);
	public Member getMemberByPanNo(String panNo);
	public Member addMember(Member member, Integer userId );
	public Member updateMember(Member member);
	public Boolean deleteMember(Integer id);	
}
