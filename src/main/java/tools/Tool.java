package tools;

import javafx.scene.Parent;
import ui.Window;
import ui.mvc.View;

/**
 * A Tool is a window that is opened by the main engine.
 * <p>
 * Tools have a {@link View} which serves as the root of the
 * tool window.
 *
 * @param <T> the type of View to use as the root of the tool window
 */
public abstract class Tool<T extends View>
{
  private Window window;
  private T toolView;

  public Tool()
  {
    super();
    this.window = new Window();
  }

  /**
   * Returns the root view of the Tool window
   *
   * @return the root node of the window
   */
  public Parent getRoot()
  {
    return this.window.getScene().getRoot();
  }

  /**
   * Sets the root view of the Tool window
   *
   * @param toolView the tool view to set as the root of the window's UI object graph
   */
  public void setToolView(T toolView)
  {
    this.toolView = toolView;
    this.window.setRootControl(toolView);
  }

  /**
   * Loads the root view that is set as the root of the Tool's {@link Window}
   */
  public abstract void load();
}
