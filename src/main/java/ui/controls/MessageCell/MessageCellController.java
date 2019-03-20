package ui.controls.MessageCell;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ui.mvc.Controller;

import java.net.URL;
import java.util.ResourceBundle;

public class MessageCellController extends Controller<MessageCellModel>
{
	@FXML
	private Label message;

	/**
	 * Instantiates a new Controller.
	 *
	 * @param model the internal {@link MessageCellModel}
	 */
	public MessageCellController(MessageCellModel model)
	{
		super(model);
	}

	@Override
	public void initialize(URL url, ResourceBundle bundle)
	{
		message.textProperty().bind(internalModel.messageProperty());
	}
}
