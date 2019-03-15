package ui.controls.SplitTool;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import ui.mvc.Controller;
import ui.mvc.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class SplitToolController extends Controller<SplitToolModel>
{
	@FXML
	private AnchorPane itemContentRoot;

	@FXML
	private ListView listItems;
	/**
	 * Instantiates a new Controller.
	 *
	 * @param model the internal {@link Model}
	 */
	public SplitToolController(SplitToolModel model)
	{
		super(model);
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle)
	{
		listItems.itemsProperty().bind(internalModel.itemsProperty());
		internalModel.itemContentRootProperty().addListener((observable, oldValue, newValue) ->
		{
			if(newValue != null)
			{
				itemContentRoot.getChildren().clear();
				itemContentRoot.getChildren().add(newValue);
				AnchorPane.setBottomAnchor(newValue, 0d);
				AnchorPane.setLeftAnchor(newValue, 0d);
				AnchorPane.setRightAnchor(newValue, 0d);
				AnchorPane.setTopAnchor(newValue, 0d);
			}
		});
	}
}
