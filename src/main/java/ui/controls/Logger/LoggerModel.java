package ui.controls.Logger;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import ui.controls.LoggerContent.LoggerContent;
import ui.mvc.Model;

public class LoggerModel extends Model
{
	private ObjectProperty<LoggerContent> content = new SimpleObjectProperty<>();

	public LoggerContent getContent()
	{
		return content.get();
	}

	public ObjectProperty<LoggerContent> contentProperty()
	{
		return content;
	}

	public void setContent(LoggerContent content)
	{
		this.content.set(content);
	}
}
