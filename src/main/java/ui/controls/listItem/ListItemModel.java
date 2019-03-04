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

package ui.controls.listItem;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.ListCell;
import ui.mvc.Model;
import ui.mvc.View;

/**
 * The {@link Model} associated with the {@link ListItem} custom control.
 */
public class ListItemModel extends Model
{
  private StringProperty name = new SimpleStringProperty("ListItem");
  private ObjectProperty<ListCell<View>> cell = new SimpleObjectProperty<>();

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName()
  {
    return name.get();
  }

  /**
   * Name property string property.
   *
   * @return the string property
   */
  public StringProperty nameProperty()
  {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name)
  {
    this.name.set(name);
  }

  public ListCell<View> getCell()
  {
    return cell.get();
  }

  public ObjectProperty<ListCell<View>> cellProperty()
  {
    return cell;
  }

  public void setCell(ListCell<View> cell)
  {
    this.cell.set(cell);
  }
}
