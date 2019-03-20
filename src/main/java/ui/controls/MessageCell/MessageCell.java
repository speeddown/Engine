package ui.controls.MessageCell;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import ui.mvc.View;

import java.io.IOException;

public class MessageCell extends View<MessageCellController, MessageCellModel>
{
	private StringProperty message = new SimpleStringProperty();

	public MessageCell()
	{
		load();
	}

	@Override public void load()
	{
		internalModel = new MessageCellModel();
		bindModelToExternalProperties();

		FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/MessageCellView.fxml"));
		loader.setRoot(this);
		loader.setControllerFactory(param ->
		{
			return new MessageCellController(internalModel);
		});

		try
		{
			loader.load();
		}
		catch (IOException e)
		{
			this.getChildren().add(new Label("Failed to load MessageCell"));
		}
	}

	@Override
	public void bindModelToExternalProperties()
	{
		internalModel.messageProperty().bind(message);
	}

	public String getMessage()
	{
		return message.get();
	}

	public StringProperty messageProperty()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message.set(message);
	}
}
