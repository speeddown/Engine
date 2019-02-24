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

package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import common.ServiceLocator;
import ecs.common.Entity;
import common.Service;
import events.ComponentAddedEvent;
import events.ComponentRemovedEvent;
import events.EntityAddedEvent;
import events.EntityRemovedEvent;

public class Ecs extends Service
{
  private LoggingService.Logger logger;

  private static Ecs instance = null;

  private List<ecs.common.System> systems = new ArrayList<>();
  private List<Entity> entities = new ArrayList<>();

  private long updateInterval = 33;
  private int ticks = 0;
  private TimerTask updateTask;
  private Timer timer;

  private EventManager eventManager;

  private Ecs()
  {
    logger = ServiceLocator.getInstance().resolve(LoggingService.class).newLogger(getClass());
    this.eventManager = ServiceLocator.getInstance().resolve(EventManager.class);
  }

  public static Ecs getInstance()
  {
    if (instance == null)
    {
      instance = new Ecs();
    }
    return instance;
  }

  public void addSystem(ecs.common.System system)
  {
    if (!this.systems.contains(system))
    {
      this.eventManager.addListener(EntityAddedEvent.class, system);
      this.eventManager.addListener(EntityRemovedEvent.class, system);
      this.eventManager.addListener(ComponentAddedEvent.class, system);
      this.eventManager.addListener(ComponentRemovedEvent.class, system);

      system.processEntities(entities);
      this.systems.add(system);
    }
  }

  public void removeSystem(System system)
  {
    if (this.systems.contains(system))
    {
      systems.remove(system);
    }
  }

  public void addEntity(Entity entity)
  {
    if (!this.entities.contains(entity))
    {
      this.entities.add(entity);
      this.eventManager.addEvent(new EntityAddedEvent(entity));
    }
  }

  public void removeEntity(Entity entity)
  {
    if (this.entities.contains(entity))
    {
      this.entities.remove(entity);
      this.eventManager.addEvent(new EntityRemovedEvent(entity));
    }
  }

  public void start()
  {
    java.lang.System.out.println("Attempting to start Ecs update loop");

    updateTask = new UpdateTask();
    timer = new Timer();
    timer.scheduleAtFixedRate(updateTask, 0, updateInterval);
  }

  private class UpdateTask extends TimerTask
  {
    @Override
    public void run()
    {
      System.out.println("----- ECS Update ------");
      updateSystems();
    }

    private void updateSystems()
    {
      if(!systems.isEmpty())
      {
        for(ecs.common.System system : systems)
        {
          system.update();
        }
        tick();
      }
    }
  }

  private void tick()
  {
    ticks++;
    logger.log("Ticks: " + ticks, null);
  }

  public void stop()
  {
    timer.cancel();
  }
}
