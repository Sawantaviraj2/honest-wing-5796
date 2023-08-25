package com.masaischool.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyExceptionClass {

	private String message;
	private String description;
	private LocalDateTime timeStamp;

}