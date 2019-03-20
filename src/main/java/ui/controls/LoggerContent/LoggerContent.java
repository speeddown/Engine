package ui.controls.LoggerContent;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import ui.controls.MessageCell.MessageCell;
import ui.mvc.View;

import java.io.IOException;
import java.util.List;

public class LoggerContent extends View<LoggerContentController, LoggerContentModel>
{
	private ListProperty<MessageCell> messages = new SimpleListProperty<>();

	public LoggerContent()
	{
		load();
	}

	@Override public void load()
	{
		internalModel = new LoggerContentModel();
		bindModelToExternalProperties();

		FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/LoggerContentView.fxml"));
		loader.setRoot(this);
		loader.setControllerFactory(param ->
		{
			return new LoggerContentController(internalModel);
		});

		try
		{
			loader.load();
		}
		catch (IOException e)
		{
			this.getChildren().add(new Label("Failed to load LoggerContent"));
		}
	}

	@Override
	public void bindModelToExternalProperties()
	{
		internalModel.messagesProperty().bind(messages);
	}

	public void addMessage(String message, String error)
	{
		MessageCell cell = new MessageCell();
		if(error != null)
		{
			cell.setMessage(message + "\n" + error);
		}
		else
		{
			cell.setMessage(message);
		}
	}

	public void setMessages(List<String> messages)
	{
		ObservableList<MessageCell> messageCells = FXCollections.observableArrayList();
		for(String message : messages)
		{
			MessageCell cell = new MessageCell();
			cell.setMessage(message);
			messageCells.add(cell);
		}
		this.messages.set(messageCells);
	}

	public ObservableList<MessageCell> messagesProperty()
	{
		return this.messages;
	}
}
