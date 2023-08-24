package com.masaischool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
