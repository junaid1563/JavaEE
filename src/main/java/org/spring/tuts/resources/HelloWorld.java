package org.spring.tuts.resources;

import java.util.List;

import org.spring.tuts.entity.Message;
import org.spring.tuts.service.MessageService;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class HelloWorld {

	private Message message = new Message();
	private List<Message> messages;

	@Inject
	private MessageService messageService;

	@PostConstruct
	public void init() {
		messages = messageService.findAllMessages();
	}

	public void submit() {
//		add message to database
		messageService.create(message);
//		add message to list
		messages.add(message);
	}

	public Message getMessage() {
		return message;
	}

	public List<Message> getMessages() {
		return messages;
	}
	
	
}
