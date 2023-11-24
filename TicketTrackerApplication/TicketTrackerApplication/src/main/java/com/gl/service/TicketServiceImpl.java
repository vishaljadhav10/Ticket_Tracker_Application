package com.gl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.DAO.TicketRepository;
import com.gl.Model.TicketDetails;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	TicketRepository dao;
	
	@Override
	public List<TicketDetails> getAllTicketDetails(){
		return dao.findAll();
	}
	
	@Override
	public TicketDetails addDetails(TicketDetails details) {
		return dao.save(details);
	}
	
	@Override
	public void deleteDetail(int id) {
		dao.deleteById(id);
	}
	
	@Override
	public TicketDetails findById(int id) {
		return dao.findById(id).get();
		
	}
}
