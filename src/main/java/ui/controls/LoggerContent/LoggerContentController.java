package ui.controls.LoggerContent;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import ui.controls.MessageCell.MessageCell;
import ui.mvc.Controller;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggerContentController extends Controller<LoggerContentModel>
{
	@FXML
	private VBox messages;

	/**
	 * Instantiates a new Controller.
	 *
	 * @param model the internal {@link LoggerContentModel}
	 */
	public LoggerContentController(LoggerContentModel model)
	{
		super(model);
	}

	@Override
	public void initialize(URL url, ResourceBundle bundle)
	{
		internalModel.messagesProperty().addListener((ListChangeListener<? super MessageCell>) c ->
		{
			while(c.next())
			{
				if(c.wasAdded())
				{
					messages.getChildren().addAll(c.getAddedSubList());
				}
				else if(c.wasRemoved())
				{
					messages.getChildren().removeAll(c.getRemoved());
				}
			}
		});
	}
}
