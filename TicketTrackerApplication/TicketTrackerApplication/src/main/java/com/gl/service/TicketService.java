package com.gl.service;

import java.util.List;

import com.gl.Model.TicketDetails;

public interface TicketService {

	List<TicketDetails> getAllTicketDetails();

	TicketDetails addDetails(TicketDetails details);

	void deleteDetail(int id);

	TicketDetails findById(int id);

}