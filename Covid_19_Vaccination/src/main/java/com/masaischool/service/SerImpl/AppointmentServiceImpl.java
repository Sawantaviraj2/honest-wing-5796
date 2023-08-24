package com.masaischool.service.SerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masaischool.entity.*;
import com.masaischool.exception.AppointmentNotFoundException;
import com.masaischool.repository.AppointmentRepository;
import com.masaischool.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	
	// Injects a dependency into the class
	@Autowired 
	private AppointmentRepository appointmentRepository;
	

	@Override
	public Appointment getAppointmentDetails(Integer bookingId) {
		return appointmentRepository.findById(bookingId)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with ID: " + bookingId));
	}

	@Override
	public Appointment addAppointment(Integer memberId, Integer vaxCenterId, Appointment appointment) {
		 Member member = new Member();
	     member.setId(memberId);
	     VaccinationCenter vaccinationCenter = new VaccinationCenter();
	     vaccinationCenter.setCenterId(vaxCenterId);

	     appointment.setMemberId(member);
	     appointment.setVaxCenter(vaccinationCenter);

	     return appointmentRepository.save(appointment);
	}

	@Override
	public Appointment updateAppointment(Integer bookingId, Appointment appointment) {
		Appointment existingAppointment = appointmentRepository.findById(bookingId)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with ID: " + bookingId));

        existingAppointment.setDateOfBooking(appointment.getDateOfBooking());
        existingAppointment.setSlot(appointment.getSlot());
        // Update other fields as needed

        return appointmentRepository.save(existingAppointment);
	}

	@Override
	public Appointment deleteAppointment(Integer bookingId) {
		Appointment appointment = appointmentRepository.findById(bookingId)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with ID: " + bookingId));

        appointmentRepository.delete(appointment);
        return appointment;
	}

}
