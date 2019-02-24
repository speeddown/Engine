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

import java.util.ArrayList;

public class Grid<T>
{
  private ArrayList<ArrayList<T>> gridArray = new ArrayList<>();
  private int columns;
  private int rows;

  public Grid(int width, int height)
  {
    columns = width;
    rows = height;

    for(int i = 0; i < rows; i++)
    {
      gridArray.add(new ArrayList<>(columns));
    }
  }

  public void set(int x, int y, T item)
  {
    if(x < columns && y < rows)
    {
      gridArray.get(y).set(x, item);
    }
  }

  public T get(int x, int y)
  {
    if(x < columns && y < rows)
    {
      return gridArray.get(y).get(x);
    }
    return null;
  }

  public void clear()
  {
    for(ArrayList row : gridArray)
    {
      row.clear();
    }
  }
}
