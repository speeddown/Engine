package ui.controls.splitToolView;

import java.io.IOException;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import ui.controls.listItem.ListItem;
import ui.mvc.View;

/**
 * The SplitToolView is a root view used as the root of a Tool.
 */
public class SplitToolView extends View<SplitToolController, SplitToolModel>
{
  private ListProperty<ListItem> listItems = new SimpleListProperty<>(FXCollections.emptyObservableList());

  /**
   * {@inheritDoc}
   */
  @Override
  protected void bindModelToExternalProperties(SplitToolModel internalModel)
  {
    internalModel.listItemsProperty().bind(listItems);
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
