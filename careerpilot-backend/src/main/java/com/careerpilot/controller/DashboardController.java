package com.careerpilot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.careerpilot.model.DashboardStats;
import com.careerpilot.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	@GetMapping("/user/{userId}")
	public DashboardStats getDashboardStats(
			@PathVariable int userId) {

		return dashboardService.getDashboardStats(userId);
	}
}