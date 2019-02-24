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

package ui.testMvc;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.Initializable;

public abstract class Controller<V extends Model> implements Initializable
{
  private ObjectProperty<V> model = new SimpleObjectProperty<>();

  public Controller(Class<? extends V> modelType)
  {
    try
    {
      this.model.set(modelType.newInstance());
    }
    catch (InstantiationException | IllegalAccessException e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public abstract void initialize(URL location, ResourceBundle resources);

  public V getTool()
  {
    return model.get();
  }

  public ObjectProperty<V> modelProperty()
  {
    return model;
  }

  public void setTool(V model)
  {
    this.model.set(model);
  }
}
