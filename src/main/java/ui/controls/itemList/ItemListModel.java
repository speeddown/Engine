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

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ui.controls.listItem.ListItem;
import ui.mvc.Model;

/**
 * The {@link Model} associated with the {@link ItemList} custom control.
 */
public class ItemListModel extends Model
{
  private ListProperty<ListItem> listItems = new SimpleListProperty<>(FXCollections.emptyObservableList());

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
