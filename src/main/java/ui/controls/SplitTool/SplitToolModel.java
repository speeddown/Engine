package ui.controls.SplitTool;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import ui.mvc.Model;
import ui.mvc.View;

public class SplitToolModel<V extends View> extends Model
{
	private ObservableList items = FXCollections.observableArrayList();
	private ObjectProperty<AnchorPane> contentParent = new SimpleObjectProperty<>();

	public ObservableList getItems()
	{
		return items;
	}

	public void setItems(ObservableList items)
	{
		this.items = items;
	}

	public AnchorPane getContentParent()
	{
		return contentParent.get();
	}

	public ObjectProperty<AnchorPane> contentParentProperty()
	{
		return contentParent;
	}

	public void setContentParent(AnchorPane contentParent)
	{
		this.contentParent.set(contentParent);
	}
}
