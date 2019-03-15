package tools;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
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
public abstract class Tool<T extends View> implements Loadable
{
	protected ObjectProperty<T> toolView = new SimpleObjectProperty<>();
	protected ObjectProperty<Window> window = new SimpleObjectProperty<>();

	@Override
	public abstract void load();

	public void showTool()
	{
		this.window.get().show();
	}

	public void hideTool()
	{
		this.window.get().hide();
	}
}
