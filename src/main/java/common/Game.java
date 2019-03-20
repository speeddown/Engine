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

package common;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import services.*;

/**
 * Entry point for the project.
 */
public abstract class Game extends Application
{
	protected ToolAccessService toolService = ToolAccessService.getInstance();
	protected LoggingService loggingService = LoggingService.getInstance();
	protected EventManager eventManager = EventManager.getInstance();
	protected ServiceLocator serviceLocator = ServiceLocator.getInstance();
	protected Ecs ecs = Ecs.getInstance();
	protected SceneManager sceneManager = SceneManager.getInstance();
	protected SpriteService spriteService = SpriteService.getInstance();

	@Override public void start(Stage primaryStage)
	{
		Font.loadFont(ClassLoader.getSystemResource("fonts/Roboto-Regular.ttf").toExternalForm(), 52);

		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.show();

		load();
		startRunning();
	}

	protected abstract void load();

	protected void startRunning()
	{
		ecs.start();
	}

	protected abstract void unload();

	protected void stopRunning()
	{
		ecs.stop();
	}

	@Override public void stop()
	{
		unload();
		stopRunning();
	}
}
