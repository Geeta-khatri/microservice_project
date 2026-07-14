
package com.UserService.Consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

import com.UserService.Entity.Users;
import com.UserService.Repository.UserRepo;
import com.UserService.Service.MailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MailConsumer {

	private final UserRepo urepo;
	private final MailService mailService;

	public MailConsumer(MailService mailService,UserRepo urepo) {
		  this.urepo = urepo;
		this.mailService = mailService;
	}
	
	@RabbitListener(queues="order.queue")
	public void triggerMail(Integer userId) {
		log.debug("inside triggermail");
		Users user=urepo.findById(userId).orElseThrow();
		System.out.println("===== Rabbit message received userId="+user.getEmail());
		log.debug("user is found "+user.getEmail());
		mailService.sendMail(user.getEmail(), "testing mail", "lukewarm Regards");
		System.out.println("mail senddddd");
		log.debug("mail sent");
	}
	
	
	
}
