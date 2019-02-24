package ecs.common;

import java.util.ArrayList;
import java.util.List;

import common.ServiceLocator;
import services.EventManager;
import services.Ecs;
import services.LoggingService;
import events.SceneLoadedEvent;
import javafx.scene.layout.AnchorPane;

/**
 * A Scene object contains all the {@link Entity}s to be loaded. A Scene can be loaded at any time
 * during runtime or by being declared as the initial Scene in the {@link services.SceneManager}.
 *
 * When a Scene loads, all {@link Entity}s created while the Scene is active are destroyed.
 */
public abstract class Scene
{
  protected LoggingService.Logger logger;

  private EventManager eventManager;
  protected Ecs ecs;

  protected AnchorPane sceneRoot;

  protected List<Class<? extends EntityModel>> prefabs = new ArrayList<>();
  protected List<Class<? extends System>> systems = new ArrayList<>();

  /**
   * Constructor
   *
   * When Scene instance created, it will attempt to locate the {@link Ecs} and {@link EventManager}
   * services.
   */
  public Scene()
  {
    this.logger = ServiceLocator.getInstance().resolve(LoggingService.class).newLogger(getClass());
    this.eventManager = ServiceLocator.getInstance().resolve(EventManager.class);
    this.ecs = ServiceLocator.getInstance().resolve(Ecs.class);
  }

  /**
   * Loads the {@link Entity}s associated with the Scene. {@link Entity}s are attached to the
   * Scene using the Class of the {@link Entity} object.
   *
   * When loading the Scene, those Entity Class references are used to create new instances
   * which are then added to the {@link Ecs} service.
   *
   * Once all {@link Entity} instances are created, an {@link events.SceneLoadedEvent} is fired
   * off notifying the {@link services.SpriteService} of the new root;
   */
  public void load()
  {
    if(!systems.isEmpty())
    {
      loadSystems();
    }
    else
    {
      logger.log("Scene does not have any systems to load", null);
    }

    if(!this.prefabs.isEmpty())
    {
      loadEntities();
    }
    else
    {
      logger.log("Scene does not contain entities to load", null);
    }
  }

  private void loadSystems()
  {
    for(Class<? extends System> system : systems)
    {
      try
      {
        ecs.addSystem(system.newInstance());
      }
      catch (InstantiationException | IllegalAccessException e)
      {
        logger.log("Failed to load " + system.getSimpleName() + " system", e.getMessage());
      }
    }
  }

  private void loadEntities()
  {
    for(Class<? extends EntityModel> prefab : this.prefabs)
    {
      try
      {
        ecs.addEntity(prefab.newInstance().initialize());
      }
      catch (InstantiationException | IllegalAccessException e)
      {
        logger.log("Failed to load scene entity: " + prefab.getName(), e.getMessage());
      }
    }
    sceneRoot = new AnchorPane();
    eventManager.addEvent(new SceneLoadedEvent(this));
  }

  public AnchorPane getSceneRoot()
  {
    return sceneRoot;
  }
}
