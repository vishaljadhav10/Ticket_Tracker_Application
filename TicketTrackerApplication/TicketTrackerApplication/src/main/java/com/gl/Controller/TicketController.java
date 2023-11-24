package com.gl.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.Model.TicketDetails;
import com.gl.service.TicketService;

@Controller
@RequestMapping("/admin")
public class TicketController {
	@Autowired
	TicketService ser;
	
	@RequestMapping("/tickets")
	public String getAllDetails(Model m) {
		m.addAttribute("info", ser.getAllTicketDetails());
		return "ticketDetails";
	}
	
	@RequestMapping("/showFormForAdd")
	public String addTicketDetails(Model m) {
		m.addAttribute("ticketdetails", new TicketDetails());
		return "ticketForm";
	}
	
	@PostMapping("/savedetails")
		public String saveDetails(@ModelAttribute("ticketdetails") TicketDetails ticketdetails) {
		ser.addDetails(ticketdetails);
		return "redirect:tickets";
	}
	
	@PostMapping("/deleteDetails")
	public String deleteDetails(@RequestParam("repId")int id) {
		ser.deleteDetail(id);
		return "redirect:tickets";
	} 
	
	@PostMapping("/showFormForUpdate")
	public String update(@RequestParam("repId")int id,Model m) {
		m.addAttribute("ticketdetails",ser.findById(id) );
		return "ticketForm";
	}
	
	@PostMapping("/viewdetail")
	public String viewDetails(@RequestParam("repId")int id,Model m) {
		m.addAttribute("info",ser.findById(id) );
		return "view";
	}
}
