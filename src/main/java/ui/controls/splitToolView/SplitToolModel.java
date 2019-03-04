package ui.controls.splitToolView;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import ui.controls.listItem.ListItem;
import ui.mvc.Model;

public class SplitToolModel extends Model
{
  private ReadOnlyObjectProperty<AnchorPane> contentRoot = new SimpleObjectProperty<>();
  private ListProperty<ListItem> listItems = new SimpleListProperty<>();

  public AnchorPane getContentRoot()
  {
    return contentRoot.get();
  }

  public ReadOnlyObjectProperty<AnchorPane> contentRootProperty()
  {
    return contentRoot;
  }

  public ObservableList<ListItem> getListItems()
  {
    return listItems.get();
  }

  public ListProperty<ListItem> listItemsProperty()
  {
    return listItems;
  }
}
