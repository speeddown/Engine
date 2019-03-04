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
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ui.controls.panel.Panel;
import ui.mvc.Model;

/**
 * The {@link Model} associated with the {@link ListItem} custom control.
 */
public class ListItemModel extends Model
{
  private StringProperty name = new SimpleStringProperty("ListItem");
  private ObjectProperty<Panel> panel = null;

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

  public Panel getPanel()
  {
    return panel.get();
  }

  public ObjectProperty<Panel> panelProperty()
  {
    return panel;
  }

  public void setPanel(Panel panel)
  {
    if(this.panel.isNull().getValue())
    {
      this.panel.set(panel);
    }
  }
}
