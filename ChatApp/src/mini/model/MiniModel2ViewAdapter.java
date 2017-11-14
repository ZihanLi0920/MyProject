package mini.model;

import java.awt.Component;
import java.io.Serializable;
/**
 * 
 * MiniModel2ViewAdapter
 *
 */
public interface MiniModel2ViewAdapter extends Serializable {
	/**
	 * appendMsg to view
	 * @param msg
	 * @param name
	 */
	public void appendMsg(String msg,String name);
	/**
	 * addScrollableComponent
	 * @param c
	 * @param label
	 */
	public void addScrollableComponent(Component c, String label);
	/**
	 * addNonScrollableComponent
	 * @param c
	 * @param label
	 */
	public void addNonScrollableComponent(Component c,String label);
	/**
	 * refresh
	 */
	public void refresh();
	/**
	 * leave
	 */
	public void leave();

}
