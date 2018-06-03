package br.net.ti2.MarinaAbramovick.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

import br.net.ti2.MarinaAbramovick.service.Fila;
import br.net.ti2.MarinaAbramovick.service.Marina;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping
public class Endpoint {

	private final Marina marina;
	private final Fila fila;

	@Autowired
	public Endpoint(Marina m, Fila f) {
		this.marina = m;
		this.fila = f;
	}
	
	@PostMapping("marina")
	public ResponseEntity<?> getIntention(@RequestBody Message message) {
		
		MessageResponse messageResponse = marina.exec(message.getText());
		
		this.fila.sendMessage(messageResponse);
		
		return new ResponseEntity<MessageResponse>(messageResponse, HttpStatus.OK);
	}
	
	
	@GetMapping(path = "ping")
	public ResponseEntity<?> ping() {
		return new ResponseEntity<>("pong",HttpStatus.OK);
	}

	@GetMapping("question-is-whats-is-a-mahna-mahna-the")
	public ResponseEntity<?> questionIsWhatsIsAMahnaMahnaThe(){
		return new ResponseEntity<String>("Question is who care?", HttpStatus.OK);
	}

}

class Message{
	private String userName;
	private String text;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Message [userName=" + userName + ", text=" + text + "]";
	}
	
	
}

class Texto {
	private String userText;

	public String getUserText() {
		return userText;
	}

	public void setUserText(String userText) {
		this.userText = userText;
	}

}
