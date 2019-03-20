package tools;

import javafx.collections.ObservableList;
import ui.Viewable;
import ui.Window;
import ui.controls.SplitTool.SplitTool;

public class LogViewer extends Tool<SplitTool>
{
	@Override public void load()
	{
		toolView.setValue(new SplitTool());
		window.setValue(new Window(toolView.get()));
	}

	public void setLoggers(ObservableList<Viewable> loggers)
	{
		toolView.get().setItems(loggers);
	}
}
