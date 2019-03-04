package ui.controls.splitToolView;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import ui.controls.itemList.ItemList;
import ui.controls.listItem.ListItem;
import ui.mvc.Model;
import ui.mvc.View;

public class SplitToolModel extends Model
{
  private ObjectProperty<ItemList> itemList = new SimpleObjectProperty<>();
  private ObjectProperty<View> toolContent = new SimpleObjectProperty<>();
  private ListProperty<ListItem> listItems = new SimpleListProperty<>();

  public ItemList getItemList()
  {
    return itemList.get();
  }

  public ObjectProperty<ItemList> itemListProperty()
  {
    return itemList;
  }

  public void setItemList(ItemList itemList)
  {
    this.itemList.set(itemList);
  }

  public View getToolContent()
  {
    return toolContent.get();
  }

  public ObjectProperty<View> toolContentProperty()
  {
    return toolContent;
  }

  public void setToolContent(View toolContent)
  {
    this.toolContent.set(toolContent);
  }

  public ObservableList<ListItem> getListItems()
  {
    return listItems.get();
  }

  public ListProperty<ListItem> listItemsProperty()
  {
    return listItems;
  }

  public void setListItems(ObservableList<ListItem> listItems)
  {
    this.listItems.set(listItems);
  }
}
