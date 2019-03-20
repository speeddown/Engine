package ui;

import ui.mvc.View;

public abstract class Link<T extends View>
{
	protected T content;

	public abstract T getContent();
	public abstract void setContent(T link);
}
