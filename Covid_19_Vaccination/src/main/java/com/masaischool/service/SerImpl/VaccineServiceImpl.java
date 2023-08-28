
package com.masaischool.service.SerImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.masaischool.entity.Member;
import com.masaischool.entity.Vaccine;
import com.masaischool.exception.VaccineNotFoundException;
import com.masaischool.repository.MemberRepository;
import com.masaischool.repository.VaccineRepository;
import com.masaischool.service.VaccineService;

@Service
public class VaccineServiceImpl implements VaccineService {

	private VaccineRepository vaccineRepository;
	private MemberRepository memberRepository;

	@Autowired
	public VaccineServiceImpl(VaccineRepository vaccineRepository, MemberRepository memberRepository) {
		super();
		this.vaccineRepository = vaccineRepository;
		this.memberRepository = memberRepository;
	}

	@Override
	public List<Vaccine> getAllVaccine(Pageable pageable) {
		Page<Vaccine> Vaccinelist = vaccineRepository.findAll(pageable);
		if (Vaccinelist == null) {
			throw new VaccineNotFoundException("Vaccine Not Found");
		}
		return Vaccinelist.toList();
	}

	@Override
	public Vaccine getVaccineByName(String vaccineName) {
		return vaccineRepository.findByVaxName(vaccineName).get();
	}

	@Override
	public Vaccine getVaccineById(Integer vaccineId) {

		Vaccine vaccine = vaccineRepository.findById(vaccineId).get();

		if (vaccine == null) {
			throw new VaccineNotFoundException("vaccine not with id " + vaccineId);
		}
		return vaccine;
	}

	@Override
	public Vaccine addVaccine(Vaccine vaccine, Integer memberId) {
		Member member = memberRepository.findById(memberId).get();
		if (member == null) {
			throw new VaccineNotFoundException("vaccine not with id " + memberId);
		}
		vaccine.setMember(member);

		return vaccineRepository.save(vaccine);
	}

	@Override
	public Vaccine updateVaccine(Integer vaccineId, Vaccine vaccine) {
		Vaccine v = vaccineRepository.findById(vaccineId)
				.orElseThrow(() -> new VaccineNotFoundException("invalid vaccine ID" + vaccineId));

		if (vaccine.getDescription() != null) {
			v.setDescription(vaccine.getDescription());
		}
		if (vaccine.getMember() != null) {
			v.setMember(vaccine.getMember());
		}
		if (vaccine.getVaccineCount() != null) {
			v.setVaccineCount(vaccine.getVaccineCount());
		}
		if (vaccine.getVaxName() != null) {
			v.setVaxName(vaccine.getVaxName());
		}

		return vaccineRepository.save(v);
	}

	@Override
	public String deleteVaccine(Integer vaccineId) {
		Optional<Vaccine> findById = vaccineRepository.findById(vaccineId);
		if (findById.isEmpty())
			throw new VaccineNotFoundException("Given Vaccine Does Not Exist");
		vaccineRepository.deleteById(vaccineId);
		return "Vaccine Deleted Successfully & VaccineId is " + vaccineId;
	}

}
