package com.masaischool.service.SerImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masaischool.entity.*;
import com.masaischool.exception.AppointmentNotFoundException;
import com.masaischool.repository.AppointmentRepository;
import com.masaischool.repository.MemberRepository;
import com.masaischool.repository.VaccinationCenterRepository;
import com.masaischool.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	// Injects a dependency into the class
	private AppointmentRepository appointmentRepository;
	private MemberRepository memberRepository;
	private VaccinationCenterRepository vaccinationCenterRepository;

	@Autowired
	public AppointmentServiceImpl(AppointmentRepository appointmentRepository, MemberRepository memberRepository,
			VaccinationCenterRepository vaccinationCenterRepository) {
		super();
		this.appointmentRepository = appointmentRepository;
		this.memberRepository = memberRepository;
		this.vaccinationCenterRepository = vaccinationCenterRepository;
	}

	@Override
	public Appointment getAppointmentDetails(Integer bookingId) {
		return appointmentRepository.findById(bookingId)
				.orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with ID: " + bookingId));
	}

	@Override
	public Appointment addAppointment(Integer memberId, Integer vaxCenterId, Appointment appointment) {
		if (appointment == null)
			throw new AppointmentNotFoundException("Appointment couldn't saved");

		Member member = memberRepository.findById(memberId).orElseThrow(
				() -> new AppointmentNotFoundException("Please Provide a valid MemberId to book an Appointment"));
		VaccinationCenter vaxCenter = vaccinationCenterRepository.findById(vaxCenterId)
				.orElseThrow(() -> new AppointmentNotFoundException(
						"Please Provide a valid Vaccination center id to book an Appointment"));

		member.setAppointment(appointment);

		vaxCenter.getAppointments().add(appointment);

		appointment.setMemberId(member);
		appointment.setVaxCenter(vaxCenter);
		appointment.setSlot(Slot.SLOT1);
		Appointment appoint = appointmentRepository.save(appointment);
		return appoint;
	}

	@Override
	public Appointment updateAppointment(Integer bookingId, Appointment appointment) {
		if (bookingId == null)
			throw new AppointmentNotFoundException("Please provide Appointment id you want to update");
		if (appointment == null)
			throw new AppointmentNotFoundException("Please provide Updated Appointment details");
		appointment.setBookingId(bookingId);
		return appointmentRepository.save(appointment);
	}

	@Override
	public Appointment deleteAppointment(Integer bookingId) {
		if (bookingId == null)
			throw new AppointmentNotFoundException("Please provide Appointment id you want to delete");
		Optional<Appointment> optional = appointmentRepository.findById(bookingId);
		if (optional.isEmpty())
			throw new AppointmentNotFoundException("Appointment Not Found");
		Appointment appointment = optional.get();
		appointmentRepository.delete(appointment);
		return appointment;
	}

}