package com.gl.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.Model.TicketDetails;

public interface TicketRepository extends JpaRepository<TicketDetails, Integer> {

}
