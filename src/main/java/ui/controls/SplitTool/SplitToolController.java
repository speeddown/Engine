package ui.controls.SplitTool;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import ui.mvc.Controller;
import ui.mvc.Model;
import ui.mvc.View;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @param <V> the {@link View} type that will be displayed when an item of the list is
 *           selected
 */
public class SplitToolController<V extends View> extends Controller<SplitToolModel<V>>
{
	@FXML
	private AnchorPane itemContentRoot;

	@FXML
	private ListView listItems;

	@FXML
	private ToolBar toolBar;

	@FXML
	private MenuBar menuBar;

	/**
	 * Instantiates a new Controller.
	 *
	 * @param model the internal {@link Model}
	 */
	public SplitToolController(SplitToolModel model)
	{
		super(model);
	}

	@Override public void initialize(URL url, ResourceBundle resourceBundle)
	{
		listItems.setItems(internalModel.getItems());
		listItems.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null)
			{
				itemContentRoot.getChildren().clear();
				itemContentRoot.getChildren().add((Node) newValue);
				AnchorPane.setBottomAnchor((Node) newValue, 0d);
				AnchorPane.setLeftAnchor((Node) newValue, 0d);
				AnchorPane.setRightAnchor((Node) newValue, 0d);
				AnchorPane.setTopAnchor((Node) newValue, 0d);
			}
		});

		listItems.setCellFactory(param -> new LinkCell<V>());
	}

	public class LinkCell<V extends View> extends ListCell<V>
	{
		@Override public void updateItem(V obj, boolean empty)
		{
			super.updateItem(obj, empty);
		}

		public void setListText(String text)
		{
			super.setText(text);
		}
	}

	@FXML public void addTestItemClicked()
	{

	}
}