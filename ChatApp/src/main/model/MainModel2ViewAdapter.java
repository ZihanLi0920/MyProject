package main.model;

import common.IUser;
import main.model.MainModel.ProxyUser;
import mini.model.ChatRoom;

/**
 * The adapter to allow communication from the model to the view.
 * Lets the model say what functionality it wants from the view.
 */
public interface MainModel2ViewAdapter {
	
	/**
	 * set IP
	 * @param IP
	 */
	public void setIP(String IP);
	/**
	 * add friend
	 * @param ProxyUser
	 */
	public void addFriend(ProxyUser friend);
	//public void createRoom(String room);
	/**
	 * append info to view
	 * @param info
	 */
	public void appendInfo(String info);
	
}
