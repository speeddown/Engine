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

package ui.mvc;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Controller class is responsible for binding the internal model of the custom
 * control to the UI element properties. Prepares data from the model to be displayed
 * on the UI.
 *
 * @param <V> the {@link Model} subclass type
 */
public class Controller<V extends Model> implements Initializable
{
  @FXML
  protected AnchorPane root;

  /**
   * The Internal model.
   */
  protected V internalModel;

  /**
   * Instantiates a new Controller.
   *
   * @param model the internal {@link Model}
   */
  public Controller(V model)
  {
    if (model != null)
    {
      this.internalModel = model;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void initialize(URL location, ResourceBundle resources)
  {
    throw new NotImplementedException();
  }
}
