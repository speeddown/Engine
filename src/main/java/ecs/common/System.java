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
import java.util.List;

import common.ServiceLocator;
import services.LoggingService;
import events.EntityAddedEventListener;
import events.EntityRemovedEventListener;

public abstract class System implements EntityAddedEventListener, EntityRemovedEventListener
{
  protected final LoggingService.Logger logger;

  protected List<Entity> entities = new ArrayList<>();
  protected List<Class<? extends Component>> componentList = new ArrayList<>();

  public System()
  {
    logger = ServiceLocator.getInstance().resolve(LoggingService.class).newLogger(getClass());
  }

  public void processEntities(List<Entity> entities)
  {
    for(Entity entity : entities)
    {
      processEntity(entity);
    }
  }

  protected abstract void start();

  public void processEntity(Entity entity)
  {
    logger.log("Processing entity [" + entity.getClass().getName() + "]", null);
    for(Class<? extends Component> componentType : componentList)
    {
      if(!entity.hasComponent(componentType))
      {
        logger.log("Entity [" + entity.getClass().getName() + "] does not match System component key", null);
        return;
      }
    }
    logger.log("Entity [" + entity.getClass().getName() + "] matched System component key. Adding entity to system", null);
    addEntity(entity);
  }

  private void addEntity(Entity entity)
  {
    this.entities.add(entity);
  }

  private void removeEntity(Entity entity)
  {
    if(this.entities.contains(entity))
    {
      this.entities.remove(entity);
    }
  }

  public void OnEntityAdded(Entity entity)
  {
    if(!this.entities.contains(entity))
    {
      processEntity(entity);
    }
  }

  public void OnEntityRemoved(Entity entity)
  {
    if(this.entities.contains(entity))
    {
      this.entities.remove(entity);
    }
  }

  public abstract void update();
}
