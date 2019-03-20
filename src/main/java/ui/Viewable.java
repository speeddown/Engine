package ui;

import ui.mvc.Controller;
import ui.mvc.Model;
import ui.mvc.View;

public interface Viewable<T extends Controller<V>, V extends Model>
{
	public View<T, V> getViewable();
}
