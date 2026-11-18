package com.careerpilot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerpilot.model.DashboardStats;
import com.careerpilot.repository.DashboardRepository;

@Service
public class DashboardService {

	@Autowired
	private DashboardRepository dashboardRepository;

	public DashboardStats getDashboardStats(int userId) {

		return dashboardRepository.getDashboardStats(userId);
	}
}