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

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import ui.controls.listItem.ListItem;
import ui.mvc.Controller;

/**
 * The {@link Controller} class associated with the {@link ItemList} custom
 * control.
 */
public class ItemListController extends Controller<ItemListModel>
{
  @FXML
  private ListView<ListItem> items;

  /**
   * Instantiates a new Item list controller.
   *
   * @param model the internal model for the custom controller
   */
  ItemListController(ItemListModel model)
  {
    super(model);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void initialize(URL location, ResourceBundle resources)
  {
    internalModel.listItemsProperty().get().addListener((ListChangeListener<? super ListItem>) c ->
    {
      while(c.next())
      {
        if(c.wasAdded())
        {
          for(ListItem item : c.getAddedSubList())
          {
            items.itemsProperty().get().add(item);
          }
        }
        else if(c.wasRemoved())
        {
          items.itemsProperty().get().removeAll(c.getRemoved());
        }
      }
    });
  }
}
