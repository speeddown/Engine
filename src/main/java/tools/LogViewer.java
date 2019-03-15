package tools;

import ui.Window;
import ui.controls.SplitTool.SplitTool;

public class LogViewer extends Tool<SplitTool>
{
	@Override
	public void load()
	{
		toolView.setValue(new SplitTool());
		window.setValue(new Window(toolView.get()));
	}
}
