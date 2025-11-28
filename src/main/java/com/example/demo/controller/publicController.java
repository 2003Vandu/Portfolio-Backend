package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.ContactMessage;
import com.example.demo.Repository.ContactRepository;
import com.example.demo.Service.EmailService;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins ="https://2003vandu.github.io/my-landing-page/")
public class publicController 
{
   
	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private EmailService emailService;
	
	@PostMapping
	public ContactMessage submitContact(@RequestBody ContactMessage submission)
	{
		ContactMessage saveMessage = contactRepository.save(submission);
		try {
			emailService.sendNewSubmissionNotification(submission);
		}catch (Exception e) {
			System.err.println("Fail to send email notification"+e.getMessage());
		}
		return saveMessage;
	}
	
	@Override
    public String toString() {
        String name = null;
		String id = null;
		String email = null;
		String massage = null;
		return "ContactMessage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", massage='" + massage + '\'' +
                '}';
    }
	
}
