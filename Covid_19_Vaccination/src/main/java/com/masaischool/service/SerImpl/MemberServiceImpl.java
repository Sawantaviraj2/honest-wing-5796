package com.masaischool.service.SerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	/**
	 * Retrieves a list of all members.
	 * 
	 * @return A list of all members in the repository.
	 */
	public List<Member> getAllMember() {
		List<Member> list = memberRepository.findAll();
		return list;
	}


	/**
	 * Retrieves a member by their ID.
	 * 
	 * @param id The ID of the member to retrieve.
	 * @return The member with the specified ID.
	 * @throws InvalidMemberException If no member is found with the given ID.
	 */
	public Member getMemberById(Integer id) throws InvalidMemberException{
		Member member = memberRepository.findById(id).orElseThrow(()-> new InvalidMemberException("No Member found for this id : "+id));
		return member;
	}

	/**
	 * Retrieves a member by their Aadhar number.
	 * 
	 * @param aadharNo The Aadhar number of the member to retrieve.
	 * @return The member with the specified Aadhar number.
	 * @throws InvalidMemberException If no member is found with the given Aadhar number.
	 */
	public Member getMemberByAadharNo(String aadharNo) throws InvalidMemberException {
		Member member = memberRepository.findByAadharNo(aadharNo).orElseThrow(()-> new InvalidMemberException("No Member found for this Aadhar No : "+aadharNo));
		return member;
	}

	/**
	 * Retrieves a member by their PAN number.
	 * 
	 * @param panNo The PAN number of the member to retrieve.
	 * @return The member with the specified PAN number.
	 * @throws InvalidMemberException If no member is found with the given PAN number.
	 */
	public Member getMemberByPanNo(String panNo) throws InvalidMemberException {
		Member member = memberRepository.findByPanNo(panNo).orElseThrow(()-> new InvalidMemberException("No Member found for this Aadhar No : "+panNo));
		return member;
	}

	/**
	 * Adds a new member and associates it with a user.
	 * 
	 * @param member The member to add.
	 * @param userId The ID of the associated user.
	 * @return The added member.
	 * @throws InvalidMemberException If there is an issue with the member or associated user.
	 */
	public Member addMember(Member member, Integer userId) throws InvalidMemberException {
		User user = userRepository.findById(userId).orElseThrow(()-> new InvalidMemberException("No User found for this id : "+userId));
		member.setUser(user);
		return memberRepository.save(member);
	}

	/**
	 * Updates an existing member's information.
	 * 
	 * @param member The updated member information.
	 * @param memberId The ID of the member to update.
	 * @return The updated member.
	 * @throws InvalidMemberException If no member is found with the given ID.
	 */
	public Member updateMember(Member member, Integer memberId) throws InvalidMemberException {
		Member member2 = memberRepository.findById(memberId).orElseThrow(()-> new InvalidMemberException("No Member found for this id : "+memberId));
		
		if(member.getDose1Status()!=null) {
			member2.setDose1Status(member.getDose1Status());
		}
		if(member.getDose2Status()!=null) {
			member2.setDose2Status(member.getDose2Status());
		}
		if(member.getDose1Date()!=null) {
			member2.setDose1Date(member.getDose1Date());
		}
		if(member.getDose2Date()!=null) {
			member2.setDose2Date(member.getDose2Date());
		}
		if(member.getDateOfRegistration()!=null) {
			member2.setDateOfRegistration(member.getDateOfRegistration());
		}
		return memberRepository.save(member2);
	}

	/**
	 * Deletes a member by their ID.
	 * 
	 * @param memberId The ID of the member to delete.
	 * @return True if the member was deleted successfully, false otherwise.
	 * @throws InvalidMemberException If no member is found with the given ID.
	 */
	public Boolean deleteMember(Integer memberId) throws InvalidMemberException {
		Member member2 = memberRepository.findById(memberId).orElseThrow(()-> new InvalidMemberException("No Member found for this id : "+memberId));
		if(member2!=null) {
			memberRepository.delete(member2);
			return true;
		}
		
		return false;
	}

}
