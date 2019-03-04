package ui;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import ui.mvc.View;

/**
 * Window extends a {@link Stage} and obfuscates and simplifies the process of opening
 * a new Stage window in JavaFx.
 */
public class Window extends Stage implements Viewable
{
  /**
   * Instantiates a new Window.
   */
  public Window()
  {
    this.setScene(new Scene(new AnchorPane()));
  }

  /**
   * Instantiates a new Window given the root control
   *
   * @param control the control
   */
  public Window(View control)
  {
    this.setScene(new Scene(control));
    this.show();
  }

  /**
   * Instantiates a new Window given the root control and the desired size of the window
   *
   * @param control the control
   * @param width   the width
   * @param height  the height
   */
  public Window(View control, int width, int height)
  {
    this.setScene(new Scene(control));
    this.setWidth(width);
    this.setHeight(height);
    this.show();
  }

  /**
   * Sets root control.
   *
   * @param rootControl the root control
   */
  public void setRootControl(View rootControl)
  {
    this.hide();
    this.setScene(new Scene(rootControl));
    this.show();
  }

  @Override
  public void load()
  {
    throw new NotImplementedException();
  }
}
