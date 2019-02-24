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

import java.util.HashMap;

import ecs.common.System;
import common.Service;
import common.ServiceLocator;
import ecs.common.Scene;
import ecs.systems.MovementSystem;
import ecs.systems.RenderingSystem;
import ecs.systems.WorldSystem;

/**
 * Manages and loads all project {@link Scene}s.
 *
 * If a {@link Scene} is not specified, SceneManager will use the {@link Scene} located at index
 * 0 of the map which contains all the {@link Scene}s of the project.
 *
 * Scenes can be loaded at any time during runtime, all Ecs {@link System}s will reset upon
 * notification that a new {@link Scene} is being loaded.
 */
public class SceneManager extends Service
{
  private static SceneManager instance = null;

  private Ecs ecs;
  private LoggingService.Logger logger;

  private HashMap<String, Class<? extends Scene>> scenes = new HashMap<>();

  private SceneManager()
  {
    ecs = ServiceLocator.getInstance().resolve(Ecs.class);
    logger = ServiceLocator.getInstance().resolve(LoggingService.class).newLogger(getClass());
  }

  public static SceneManager getInstance()
  {
    if(instance == null)
    {
      instance = new SceneManager();
    }
    return instance;
  }

  /**
   * Adds a new {@link Scene} to the project.
   *
   * @param scene   the Scene
   */
  public void addScene(Class<? extends Scene> scene)
  {
    this.scenes.put(scene.getSimpleName(), scene);
  }

  /**
   * Loads a {@link Scene} by the given scene name
   *
   * @param sceneName the name identifier of the scene
   */
  public void loadScene(String sceneName)
  {
    if(ecs != null)
    {
      ecs.addSystem(new MovementSystem());
      ecs.addSystem(new RenderingSystem());
      ecs.addSystem(new WorldSystem());

      if(scenes.containsKey(sceneName))
      {
        try
        {
          Scene newScene = scenes.get(sceneName).newInstance();
          logger.log("Successfully created new scene instance", null);

          if (newScene != null)
          {
            newScene.load();
            logger.log("Scene loading failed", null);
          }
        }
        catch (InstantiationException | IllegalAccessException e)
        {
          logger.log("Failed to instantiate scene: " + sceneName, null);
        }
      }
    }
    else
    {
      logger.log("Scene loading failed: Ecs was null...", null);
    }
  }
}
