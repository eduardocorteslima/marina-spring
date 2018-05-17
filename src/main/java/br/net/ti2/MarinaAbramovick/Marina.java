package br.net.ti2.MarinaAbramovick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.Context;

@Service
public class Marina {

	@Autowired
	Conversation conversationService;
	InputData input;
	MessageOptions options;
	MessageResponse response;
	Context context;
	
	@Value("${app.WORKSPACE_ID}")
	String WORKSPACE_ID;

	

	public Marina() {
	}

	/*public void exec() {

		input = new InputData.Builder("o Neto corrigiu as provas?").build();

		options = new MessageOptions.Builder(c).input(input).build();
		response = conversationService.message(options).execute();
		System.out.println(response);

	}*/
	
	public MessageResponse exec(String userText) {
		input = new InputData.Builder(userText).build();
		options = new MessageOptions.Builder(WORKSPACE_ID).input(input).context(context).build();
		response = conversationService.message(options).execute();
		return response;
	}

}
