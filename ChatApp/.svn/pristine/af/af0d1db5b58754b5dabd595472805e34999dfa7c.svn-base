package main.view;

import java.util.ArrayList;

import main.model.MainModel.ProxyUser;
import main.model.ProxyChatroom;
import mini.model.ChatRoom;
/**
 * Adapter for allowing communication from the view to the model
 *
 */
public interface MainView2ModelAdapter {
   /**
    * start the application
    * @param name
    * @param port
    */
	public void start(String name,int port);
	/**
	 * connect to user
	 * @param name
	 * @param IP
	 */
	public void connectTo(String name,String IP);
	/**
	 * create a room
	 * @param room
	 */
	public void createRoom(String room);
	/**
	 * join a room
	 * @param room
	 */
	public void joinRoom(ProxyChatroom room);
	/**
	 * get remote room
	 * @param friend
	 * @return list of remote room
	 */
	public ArrayList<ProxyChatroom> getRemoteRoom(ProxyUser friend);
	/**
	 * quit the room
	 */
	public void quit();
}
