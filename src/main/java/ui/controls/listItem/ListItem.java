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

import java.io.IOException;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import ui.controls.itemList.ItemList;
import ui.controls.panel.Panel;
import ui.mvc.View;

/**
 * A ListItem is a custom control that lives inside of a {@link ItemList} custom control
 */
public class ListItem extends View<ListItemController, ListItemModel>
{
  private StringProperty name = new SimpleStringProperty();
  private ObjectProperty<Panel> panel = new SimpleObjectProperty<>();

  /**
   * {@inheritDoc}
   */
  @Override
  protected void bindModelToExternalProperties(ListItemModel internalModel)
  {
    internalModel.nameProperty().bind(name);
    internalModel.panelProperty().bind(panel);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void load()
  {
    ListItemModel internalModel = new ListItemModel();
    bindModelToExternalProperties(internalModel);

    FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("ListItem.fxml"));
    loader.setRoot(this);
    loader.setControllerFactory(param ->
    {
      return new ListItemController(internalModel);
    });

    try
    {
      loader.load();
    }
    catch (IOException e)
    {
      this.getChildren().add(new Label("Failed to load ListItem"));
    }

  }
}
