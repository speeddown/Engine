package tools.logViewer;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import tools.Tool;
import ui.controls.listItem.ListItem;
import ui.controls.splitToolView.SplitToolView;

public class LogViewer extends Tool<SplitToolView>
{
  private ListProperty<ListItem> loggers = new SimpleListProperty<>();

  @Override
  public void load()
  {
    setToolView(new SplitToolView());
  }

  public ObservableList<ListItem> getLoggers()
  {
    return loggers.get();
  }

  public ListProperty<ListItem> loggersProperty()
  {
    return loggers;
  }

  public void setLoggers(ObservableList<ListItem> loggers)
  {
    this.loggers.set(loggers);
  }

  public void addLogger()
  {

  }
}
