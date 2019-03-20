package ui.controls.Logger;

import javafx.fxml.FXMLLoader;
import ui.controls.LoggerContent.LoggerContent;
import ui.mvc.View;

public class Logger extends View<LoggerController, LoggerModel>
{
	public Logger()
	{
		load();
	}

	@Override public void load()
	{
		internalModel = new LoggerModel();

		FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/LoggerView.fxml"));
		loader.setRoot(this);
		loader.setControllerFactory(param ->
		{
			return new LoggerController(internalModel);
		});
	}

	public void setContent(LoggerContent loggerContent)
	{
		internalModel.setContent(loggerContent);
	}
}
