import java.io.IOException;

import common.Game;
import common.ServiceLocator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.ToolAccessService;
import tools.logViewer.LogViewer;

public class Main extends Game
{
  @Override
  public void start(Stage primaryStage)
  {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("MainTest.fxml"));
    Parent parent = null;

    try
    {
      parent = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    Scene scene = new Scene(parent);
    primaryStage.setScene(scene);
    primaryStage.show();

    ToolAccessService toolAccessService = ServiceLocator.getInstance().resolve(ToolAccessService.class);
    toolAccessService.startTool(LogViewer.class);

    startRunning();
  }

  @Override
  protected void load()
  {

  }

  @Override
  protected void unload()
  {

  }
}
