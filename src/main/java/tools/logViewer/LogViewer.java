package tools.logViewer;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import ui.Window;
import ui.controls.splitToolView.SplitToolView;
import ui.mvc.View;

public class LogViewer extends Window
{
  @FXML
  private SplitToolView toolView;

  @Override
  public void load()
  {
    FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("LogViewer.fxml"));
    loader.setRoot(this.getScene().getRoot());
    loader.setController(this);
    this.show();

    try
    {
      View toolView = loader.load();
      this.setRootControl(toolView);
    }
    catch (IOException e)
    {
      AnchorPane root = (AnchorPane)getScene().getRoot();
      root.getChildren().add(new Label("Failed to load LogViewer"));
    }
  }
}
