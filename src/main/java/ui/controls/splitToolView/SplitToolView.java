package ui.controls.splitToolView;

import java.io.IOException;

import javafx.beans.DefaultProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import ui.controls.listItem.ListItem;
import ui.mvc.View;

/**
 * The SplitToolView is a root view used as the root of a Tool. The
 */
@DefaultProperty("content")
public class SplitToolView extends View<SplitToolController, SplitToolModel>
{
  // The {@link ListItem}s that are held in the {@link ui.controls.itemList.ItemList}
  ListProperty<ListItem> items = new SimpleListProperty<>();
  ObjectProperty<AnchorPane> toolContent = new SimpleObjectProperty<>();

  /**
   * {@inheritDoc}
   */
  @Override
  protected void bindModelToExternalProperties(SplitToolModel internalModel)
  {
    internalModel.listItemsProperty().bind(items);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void load()
  {
    SplitToolModel internalModel = new SplitToolModel();
    bindModelToExternalProperties(internalModel);

    FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("SplitToolView.fxml"));
    loader.setRoot(this);
    loader.setControllerFactory(param ->
    {
      return new SplitToolController(internalModel);
    });

    try
    {
      loader.load();
    }
    catch (IOException e)
    {
      getChildren().add(new Label("Failed to load SplitToolView"));
    }
  }

  /**
   * Returns the list of {@link ListItem}s in the {@link ui.controls.itemList.ItemList}
   *
   * @return the list items
   */
  public ObservableList<ListItem> getItems()
  {
    return items.get();
  }

  /**
   * The ListProperty containing all {@link ListItem}s
   *
   * @return the list property of list items
   */
  public ListProperty<ListItem> itemsProperty()
  {
    return items;
  }

  public AnchorPane getToolContent()
  {
    return toolContent.get();
  }

  public ObjectProperty<AnchorPane> toolContentProperty()
  {
    return toolContent;
  }

  public void setToolContent(AnchorPane toolContent)
  {
    this.toolContent.set(toolContent);
  }
}
