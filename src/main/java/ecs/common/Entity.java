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

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import services.LoggingService;
import events.ComponentAddedEvent;
import events.ComponentRemovedEvent;
import services.EventManager;
import common.ServiceLocator;

public class Entity implements Serializable
{
  protected LoggingService.Logger logger;

  private EventManager eventManager;
  private Map<String, Component> components = new HashMap<>();

  public Entity()
  {
    logger = ServiceLocator.getInstance().resolve(LoggingService.class).newLogger(getClass());
    eventManager = ServiceLocator.getInstance().resolve(EventManager.class);
  }

  public Collection<Component> getComponents()
  {
    return this.components.values();
  }

  public <T extends Component> T getComponent(Class<? extends T> type)
  {
    logger.log("Added " + type.getSimpleName() + " component added to entity", null);
    return (T)components.get(type.getSimpleName());
  }

  public boolean hasComponent(Class<? extends Component> type)
  {
    return components.keySet().contains(type.getSimpleName());
  }

  public void addComponent(Component component)
  {
    logger.log("Added " + component.getClass().getSimpleName(), null);
    this.components.put(component.getClass().getSimpleName(), component);
    eventManager.addEvent(new ComponentAddedEvent(this, component));
  }

  public void removeComponent(Component component)
  {
    if(this.components.values().contains(component))
    {
      this.components.remove(component.getClass().getSimpleName());
      eventManager.addEvent(new ComponentRemovedEvent(this, component));
    }
    else
    {
      logger.log(component.getClass().getSimpleName() + " component not found in Entity. Unable to remove component", null);
    }
  }
}
