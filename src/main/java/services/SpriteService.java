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

import common.Position;
import common.Service;
import common.ServiceLocator;
import ecs.common.Scene;
import events.SceneLoadedEvent;
import events.SceneLoadedEventListener;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * The SpriteService's role is to add Sprites to the {@link Scene} root for rendering as well as
 * updating the position of existing Sprites
 */
public class SpriteService extends Service implements SceneLoadedEventListener
{
  private static SpriteService instance;

  private AnchorPane sceneRoot;

  private SpriteService()
  {
    ServiceLocator.getInstance().resolve(EventManager.class).addListener(SceneLoadedEvent.class, this);
  }

  /**
   * Initializes the singleton instance of the SpriteService if it is already not initialized
   * and returns the instance
   *
   * @return the SpriteService singleton instance
   */
  public static SpriteService getInstance()
  {
    if(instance == null)
    {
      instance = new SpriteService();
    }
    return instance;
  }

  /**
   * Adds a Sprite to the {@link Scene} root
   *
   * @param sprite    the sprite to add
   * @param position  the position of the sprite in the {@link Scene}
   */
  public void addSprite(ImageView sprite, Position position)
  {
    sprite.setX(position.getX());
    sprite.setY(position.getY());
    this.sceneRoot.getChildren().add(sprite);
  }

  /**
   * Changes the {@link Position} of the sprite in the {@link Scene}
   *
   * @param sprite        the sprite to reposition
   * @param newPosition   the new {@link Position}
   */
  public void updateSpritePosition(ImageView sprite, Position newPosition)
  {
    sprite.setX(newPosition.getX());
    sprite.setY(newPosition.getY());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void OnSceneLoaded(Scene scene)
  {
    this.sceneRoot = scene.getSceneRoot();
  }
}
