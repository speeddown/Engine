package ui.controls.LoggerContent;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import ui.controls.MessageCell.MessageCell;
import ui.mvc.Model;

public class LoggerContentModel extends Model
{
	private ListProperty<MessageCell> messages = new SimpleListProperty<>();

	public ObservableList<MessageCell> getMessages()
	{
		return messages.get();
	}

	public ListProperty<MessageCell> messagesProperty()
	{
		return messages;
	}

	public void setMessages(ObservableList<MessageCell> messages)
	{
		this.messages.set(messages);
	}
}
