package ui.controls.SplitTool;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import ui.mvc.Model;
import ui.mvc.View;

public class SplitToolModel extends Model
{
	private ListProperty items = new SimpleListProperty();
	private ObjectProperty<View> itemContentRoot = new SimpleObjectProperty<>();

	public Object getItems()
	{
		return items.get();
	}

	public ListProperty itemsProperty()
	{
		return items;
	}

	public void setItems(Object items)
	{
		this.items.set(items);
	}

	public View getItemContent()
	{
		return itemContentRoot.get();
	}

	public ObjectProperty<View> itemContentRootProperty()
	{
		return itemContentRoot;
	}

	public void setItemContent(View itemContentRoot)
	{
		this.itemContentRoot.set(itemContentRoot);
	}
}
