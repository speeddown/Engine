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

import javafx.scene.layout.AnchorPane;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ui.Viewable;

/**
 * The View class loads the FXML file and binds outward-facing properties to an internal {@link Model}
 * object that it shares with an associated {@link Controller} object.
 *
 * All View objects extend {@link AnchorPane} since they are used in FXML to arrange the UI.
 *
 * @param <T> the {@link Controller} subclass type
 * @param <V> the {@link Model} subclass type
 */
public class View<T extends Controller, V extends Model> extends AnchorPane implements Viewable
{
  /**
   * Default constructor. Calls the private load() method to begin loading the FXML for the
   * control
   */
  public View()
  {
    load();
  }

  /**
   * Responsible for binding the internal model to the outward facing properties of the
   * custom control.
   *
   * @param internalModel the internal model to bind to
   */
  protected void bindModelToExternalProperties(V internalModel)
  {
    throw new NotImplementedException();
  }

  /**
   * Creates and initializes a new instance of the associated {@link Model}.
   * Loads the FXML file associated with the {@link Controller}.
   */
  public void load()
  {
    throw new NotImplementedException();
  }
}
