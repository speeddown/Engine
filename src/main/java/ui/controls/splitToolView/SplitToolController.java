package ui.controls.splitToolView;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import ui.controls.itemList.ItemList;
import ui.mvc.Controller;

public class SplitToolController extends Controller<SplitToolModel>
{
  @FXML
  private MenuBar menu;
  @FXML
  private ToolBar toolBar;
  @FXML
  private ItemList itemList;
  @FXML
  private AnchorPane panel;

  public SplitToolController(SplitToolModel model)
  {
    super(model);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void initialize(URL location, ResourceBundle resources)
  {
    itemList.listItemsProperty().bind(internalModel.listItemsProperty());
  }
}
