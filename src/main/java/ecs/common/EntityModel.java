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

package ecs.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import common.ServiceLocator;
import ecs.components.Transform;
import services.LoggingService;

public class EntityModel
{
  protected final LoggingService.Logger logger;
  protected ArrayList<Class<? extends Component>> components = new ArrayList<>();

  public EntityModel(Class<? extends Component> ... components)
  {
    logger = ServiceLocator.getInstance().resolve(LoggingService.class).newLogger(this.getClass());
    this.components.addAll(Arrays.asList(components));
  }

  public List<Class<? extends Component>> getComponents()
  {
    return this.components;
  }

  public Entity initialize()
  {
    Entity newEntity = new Entity();
    for(Class<? extends Component> componentType : components)
    {
      try
      {
        logger.log("Added " + componentType + " to new entity", null);
        newEntity.addComponent(componentType.newInstance());
      }
      catch (InstantiationException | IllegalAccessException | NullPointerException e)
      {
        logger.log("Failed to instantiate " + componentType.toString() + " component", e.getMessage());
      }
    }

    Transform transform = new Transform();
    transform.setName(newEntity.getClass().getSimpleName());
    transform.setEntity(newEntity);
    newEntity.addComponent(transform);
    return newEntity;
  }
}
