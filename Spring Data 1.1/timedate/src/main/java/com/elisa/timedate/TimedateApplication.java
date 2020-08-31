package com.elisa.timedate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

@SpringBootApplication
@Controller
public class TimedateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimedateApplication.class, args);
	}
	 @RequestMapping("/")
     public String home(HttpSession session, Model model) {
			Integer count=(Integer)session.getAttribute("count");
			if(count==null) {
				count=0;
			}else {
			count +=1;	
			}
			session.setAttribute("count", count);
			model.addAttribute("count");
			return "Home.jsp";
     }
	 @RequestMapping("/counter")
	 public String counter(Model model, HttpSession session) {
		 Integer count=(Integer)session.getAttribute("count");
		 session.setAttribute("count", count);
		 model.addAttribute("count", count);
		 return "Counter.jsp";
		 
	 }
	 @RequestMapping("/date")
	 public String date(Model model) {
		 LocalDate fecha = LocalDate.now();
		 DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM, yyyy");
		 String formattedDate = fecha.format(format);
		 model.addAttribute("localDate", formattedDate);
		 return "Date.jsp";
	 }
	 @RequestMapping("/time")
	 public String time(Model model) {
		 LocalTime hora = LocalTime.now();
		 DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm a");
		 String formattedTime = hora.format(format);
		 model.addAttribute("localTime", formattedTime);
		 return "Time.jsp";
	 }

}
