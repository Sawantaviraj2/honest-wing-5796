package com.masaischool.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.masaischool.entity.Member;
import com.masaischool.exception.InvalidMemberException;

public interface MemberService {

	/**
	 * Retrieves a list of all members.
	 * 
	 * @return A list of all members in the repository.
	 */
	public List<Member> getAllMember(Pageable pageable);

	/**
	 * Retrieves a member by their ID.
	 * 
	 * @param id The ID of the member to retrieve.
	 * @return The member with the specified ID.
	 * @throws InvalidMemberException If no member is found with the given ID.
	 */

	public Member getMemberById(Integer id) throws InvalidMemberException;

	/**
	 * Retrieves a member by their Aadhar number.
	 * 
	 * @param aadharNo The Aadhar number of the member to retrieve.
	 * @return The member with the specified Aadhar number.
	 * @throws InvalidMemberException If no member is found with the given Aadhar
	 *                                number.
	 */
	public Member getMemberByAadharNo(String aadharNo) throws InvalidMemberException;

	/**
	 * Retrieves a member by their PAN number.
	 * 
	 * @param panNo The PAN number of the member to retrieve.
	 * @return The member with the specified PAN number.
	 * @throws InvalidMemberException If no member is found with the given PAN
	 *                                number.
	 */
	public Member getMemberByPanNo(String panNo) throws InvalidMemberException;

	/**
	 * Adds a new member and associates it with a user.
	 * 
	 * @param member The member to add.
	 * @param userId The ID of the associated user.
	 * @return The added member.
	 * @throws InvalidMemberException If there is an issue with the member or
	 *                                associated user.
	 */
	public Member addMember(Member member, Integer userId) throws InvalidMemberException;

	/**
	 * Updates an existing member's information.
	 * 
	 * @param member   The updated member information.
	 * @param memberId The ID of the member to update.
	 * @return The updated member.
	 * @throws InvalidMemberException If no member is found with the given ID.
	 */
	public Member updateMember(Member member, Integer memberId) throws InvalidMemberException;

	/**
	 * Deletes a member by their ID.
	 * 
	 * @param memberId The ID of the member to delete.
	 * @return True if the member was deleted successfully, false otherwise.
	 * @throws InvalidMemberException If no member is found with the given ID.
	 */
	public Boolean deleteMember(Integer id) throws InvalidMemberException;
}
