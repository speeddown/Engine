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

package ecs.components;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import common.Position;
import ecs.common.Component;
import ecs.common.Entity;

public class Transform extends Component
{
  private Position position = new Position(0,0);
  private String name = "NewEntity";
  private Entity entity;
  private ArrayList<Entity> children;

  public Position getPosition()
  {
    return position;
  }

  public void setPosition(Position position)
  {
    this.position = position;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Entity getEntity()
  {
    return entity;
  }

  public void setEntity(Entity entity)
  {
    this.entity = entity;
  }

  public ArrayList<Entity> getChildren()
  {
    return children;
  }

  public void addChild(Entity entity)
  {
    this.children.add(entity);
  }

  public void addChildren(List<Entity> children)
  {
    this.children.addAll(children);
  }
}
