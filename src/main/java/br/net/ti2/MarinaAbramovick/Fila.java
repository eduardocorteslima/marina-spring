package br.net.ti2.MarinaAbramovick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

@Service
public class Fila {

	@Autowired
	ProfileCredentialsProvider credentialsProvider;

	@Autowired
	SendMessageRequest sendMsgMequest;

	final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
	private String QUEUE_NAME = "MarinaQueue";

	CreateQueueResult create_result;
	String queueUrl;

	public Fila() {
		try {
			create_result = sqs.createQueue(QUEUE_NAME);
		} catch (AmazonSQSException e) {
			if (!e.getErrorCode().equals("QueueAlreadyExists")) {
				throw e;
			}
		}
		queueUrl = sqs.getQueueUrl(QUEUE_NAME).getQueueUrl();

	}

	public void sendMessage(String txt) {
		System.out.println(queueUrl);
		sendMsgMequest.withQueueUrl(queueUrl).withMessageBody("hello world").withDelaySeconds(5);
		sqs.sendMessage(sendMsgMequest);
	}

	public void sendMessage(MessageResponse messageResponse) {
		System.out.println(queueUrl);
		sendMsgMequest.withQueueUrl(queueUrl).withMessageBody(messageResponse.toString()).withDelaySeconds(5);
		sqs.sendMessage(sendMsgMequest);
	}

}
