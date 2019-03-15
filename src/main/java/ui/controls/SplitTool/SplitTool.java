package ui.controls.SplitTool;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import ui.mvc.View;

import java.io.IOException;

public class SplitTool extends View<SplitToolController, SplitToolModel>
{
	private ObjectProperty<View> itemContentRoot = new SimpleObjectProperty<>();

	public SplitTool()
	{
		bindModelToExternalProperties();
	}

	@Override
	public void load()
	{
		Parent parent = null;

		internalModel = new SplitToolModel();
		bindModelToExternalProperties();

		FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/SplitToolView.fxml"));
		loader.setRoot(this);
		loader.setControllerFactory(param ->
		{
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

	@Override
	public void bindModelToExternalProperties()
	{
	}

	public View getItemContentRoot()
	{
		return itemContentRoot.get();
	}

	public ObjectProperty<View> itemContentRootProperty()
	{
		return itemContentRoot;
	}

	public void setItemContentRoot(View itemContentRoot)
	{
		this.itemContentRoot.set(itemContentRoot);
	}
}
