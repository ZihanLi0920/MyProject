package mini.view;

import java.util.Collection;

public interface MiniView2ModelAdapter {

	/**
	 * @param msg the message
	 * send the message
	 */
	public void SendMsg(String msg);
	/**
	 * @param path
	 * send the image
	 */
	public void SendImg(String path);
	/**
	 * @return the list of the receivers' name
	 * 
	 */
	public Collection<String> getMembers();
	/**
	 * leave a room
	 */
	public void leave();
	/**
	 * @param data
	 * send file
	 */
	public void SendFile(byte[][] data);
}
