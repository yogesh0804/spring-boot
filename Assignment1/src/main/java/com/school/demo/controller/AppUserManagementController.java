package com.school.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.demo.model.AppUser;

@RestController
@RequestMapping("/api")
public class AppUserManagementController {

	public AppUser getUserDetails() {
		return null;
	}
}
