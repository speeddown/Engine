package ui.controls.SplitTool;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import services.LoggingService;
import ui.Viewable;
import ui.mvc.View;

import java.io.IOException;

public class SplitTool extends View<SplitToolController, SplitToolModel>
{
	public SplitTool()
	{
		load();
	}

	@Override public void load()
	{
		Parent parent = null;

		internalModel = new SplitToolModel();

		FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/SplitToolView.fxml"));
		loader.setRoot(this);
		loader.setControllerFactory(param -> {
			return new SplitToolController(internalModel);
		});

		try
		{
			parent = loader.load();
		}
		catch (IOException e)
		{
			this.getChildren().add(new Label("Failed to load SplitTool" + "\n" + e.getMessage()));
		}
	}

	public void setItems(ObservableList<Viewable> items)
	{
		this.internalModel.setItems(items);
	}
}