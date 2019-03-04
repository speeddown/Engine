/*-------------------------------------------------------------------------------------------------
| *** UNCLASSIFIED ***
|--------------------------------------------------------------------------------------------------
| U.S. Army Research, Development, and Engineering Command
| Aviation and Missile Research, Development, and Engineering Center
| Software Engineering Directorate, Redstone Arsenal, AL
|--------------------------------------------------------------------------------------------------
| Export-Control Act Warning: Warning - This Document contains technical data whose export is
| restricted by the Arms Export Control Act (Title 22, U.S.C., Sec 2751, et seq) or the Export
| Administration Act of 1979, as amended, Title 50, U.S.C., App. 2401 et seq. Violations of these
| export laws are subject to severe criminal penalties. Disseminate in accordance with provisions
| of DoD Directive 5230.25.
|--------------------------------------------------------------------------------------------------
| Distribution Statement C:  Distribution authorized to U.S. Government Agencies and their
| contractors, Export Controlled, Critical Technology, 13 Feb 2017. Other request for this document
| shall be referred to U.S. Army Aviation and Missile Research Development and Engineering Center
| Software Engineering Directorate, Attn: RDMR-BAW, Redstone Arsenal, AL 35898.
--------------------------------------------------------------------------------------------------*/

package ui.controls.itemList;

import java.io.IOException;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import ui.controls.listItem.ListItem;
import ui.mvc.View;

/**
 * Custom control that handles displaying, opening, and managing a list of {@link ListItem}s
 */
public class ItemList extends View<ItemListController, ItemListModel>
{
  private ListProperty<ListItem> listItems = new SimpleListProperty<>();

  /**
   * {@inheritDoc}
   */
  @Override
  protected void bindModelToExternalProperties(ItemListModel internalModel)
  {
    internalModel.listItemsProperty().bind(listItemsProperty());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void load()
  {
    ItemListModel externalModel = new ItemListModel();
    bindModelToExternalProperties(externalModel);

    FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("views.controls.ItemList.fxml"));
    loader.setRoot(this);
    loader.setControllerFactory(param ->
    {
      return new ItemListController(externalModel);
    });

    try
    {
      loader.load();
    }
    catch (IOException e)
    {
      this.getChildren().add(new Label("Failed to load ItemList"));
    }
  }

  /**
   * Gets list items.
   *
   * @return the list items
   */
  public ObservableList<ListItem> getListItems()
  {
    return listItems.get();
  }

  /**
   * List items property list property.
   *
   * @return the list property
   */
  public ListProperty<ListItem> listItemsProperty()
  {
    return listItems;
  }

  /**
   * Sets list items.
   *
   * @param listItems the list items
   */
  public void setListItems(ObservableList<ListItem> listItems)
  {
    this.listItems.set(listItems);
  }
}
