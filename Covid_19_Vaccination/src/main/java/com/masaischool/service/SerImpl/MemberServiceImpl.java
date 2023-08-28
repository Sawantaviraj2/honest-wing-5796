package com.masaischool.service.SerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.masaischool.entity.Member;
import com.masaischool.entity.User;
import com.masaischool.exception.InvalidMemberException;
import com.masaischool.repository.MemberRepository;
import com.masaischool.repository.UserRepository;
import com.masaischool.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberRepository memberRepository;
	private UserRepository userRepository;

	@Autowired
	public MemberServiceImpl(MemberRepository memberRepository, UserRepository userRepository) {
		this.memberRepository = memberRepository;
		this.userRepository = userRepository;
	}

	public List<Member> getAllMember(Pageable pageable) {
		return memberRepository.findAll(pageable).toList();
	}

	public Member getMemberById(Integer id) throws InvalidMemberException {
		Member member = memberRepository.findById(id)
				.orElseThrow(() -> new InvalidMemberException("No Member found for this id : " + id));
		return member;
	}

	public Member getMemberByAadharNo(String aadharNo) throws InvalidMemberException {
		Member member = memberRepository.findByAadharNo(aadharNo)
				.orElseThrow(() -> new InvalidMemberException("No Member found for this Aadhar No : " + aadharNo));
		return member;
	}

	public Member getMemberByPanNo(String panNo) throws InvalidMemberException {
		Member member = memberRepository.findByPanNo(panNo)
				.orElseThrow(() -> new InvalidMemberException("No Member found for this Pan No : " + panNo));
		return member;
	}

	public Member addMember(Member member, Integer userId) throws InvalidMemberException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new InvalidMemberException("No User found for this id : " + userId));
		member.setUser(user);
		return memberRepository.save(member);
	}

	public Member updateMember(Member member, Integer memberId) throws InvalidMemberException {
		Member member2 = memberRepository.findById(memberId)
				.orElseThrow(() -> new InvalidMemberException("No Member found for this id : " + memberId));

		if (member.getDose1Status() != null) {
			member2.setDose1Status(member.getDose1Status());
		}
		if (member.getDose2Status() != null) {
			member2.setDose2Status(member.getDose2Status());
		}
		if (member.getDose1Date() != null) {
			member2.setDose1Date(member.getDose1Date());
		}
		if (member.getDose2Date() != null) {
			member2.setDose2Date(member.getDose2Date());
		}
		if (member.getDateOfRegistration() != null) {
			member2.setDateOfRegistration(member.getDateOfRegistration());
		}
		return memberRepository.save(member2);
	}

	public Boolean deleteMember(Integer memberId) throws InvalidMemberException {
		Member member2 = memberRepository.findById(memberId)
				.orElseThrow(() -> new InvalidMemberException("No Member found for this id : " + memberId));
		if (member2 != null) {
			memberRepository.delete(member2);
			return true;
		}

		return false;
	}

}
