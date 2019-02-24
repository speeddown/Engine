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

package common;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Position
{
  private SimpleDoubleProperty x = new SimpleDoubleProperty();
  private SimpleDoubleProperty y = new SimpleDoubleProperty();

  public Position(float x, float y)
  {
    this.x.set(x);
    this.y.set(y);
  }

  public double getX()
  {
    return x.get();
  }

  public DoubleProperty xProperty()
  {
    return x;
  }

  public void setX(double x)
  {
    this.x.set(x);
  }

  public double getY()
  {
    return y.get();
  }

  public DoubleProperty yProperty()
  {
    return y;
  }

  public void setY(double y)
  {
    this.y.set(y);
  }
}
