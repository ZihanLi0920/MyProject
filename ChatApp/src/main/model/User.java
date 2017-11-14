package main.model;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

import common.IChatRoom;
import common.IUser;
/**
 * 
 * User implement IUser interface
 *
 */
/**
 * @author zihanli
 * the User
 */
public class User implements IUser {
	/**
	 * chatrooms
	 */
	HashSet<IChatRoom> chatRooms=new HashSet<IChatRoom>();
	/**
	 * list of friends
	 */
	ArrayList<IUser> friends=new ArrayList<IUser>();
	/**
	 * BOUND_NAME
	 */
	final String BOUND_NAME1;
	/**
	 * IP
	 */
	String IP;
	/**
	 * BOUND_PORT;
	 */
	final int BOUND_PORT;
	/**
	 * User2ModelAdapter
	 */
	User2ModelAdapter modelAdpt;
	/**
	 * UUID
	 */
	UUID id;
	
	/**
	 * constructor
	 * @param name
	 * @param port
	 * @param _modelAdpt
	 */
	User(String name,int port,User2ModelAdapter _modelAdpt)
	{
		modelAdpt=_modelAdpt;
		BOUND_NAME1=name;
		BOUND_PORT=port;
		id=UUID.randomUUID();
	}
	
    /**
     * add room
     * @param room
     */
	/**
	 * @param room 
	 * add a room to the nao
	 */
	public void addRoom(IChatRoom room)
	{
		chatRooms.add(room);
	}

	public void setIP(String _IP)
	{
		IP=_IP;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return BOUND_NAME1;
	}
    /**
     * join room
     * @param room
     * @return
     * @throws RemoteException
     */
	
    /**
     * quit room
     * @param room
     * @return
     * @throws RemoteException
     */
	
    /**
     * get name
     * @return BOUND_NAME1
     */
	/** (non-Javadoc)
	 * @see common.IUser#getName()
	 * get the name of the user
	 */
	@Override
	public String getName() throws RemoteException {
		// TODO Auto-generated method stub
		return BOUND_NAME1;
	}




    /**
     * get chat room
     * @return chat rooms
     * @throws RemoteException
     */
	/** (non-Javadoc)
	 * @see common.IUser#getChatRooms()
	 * get the chatrooms of the user
	 */
	@Override
	public Collection<IChatRoom> getChatRooms() throws RemoteException {
		// TODO Auto-generated method stub
		return this.chatRooms;
	}

    /**
     * get UUID
     * @return UUID
     * @throws RemoteException
     */
	/** (non-Javadoc)
	 * @see common.IUser#getUUID()
	 * get the id of the suer
	 */
	@Override
	public UUID getUUID() throws RemoteException {
		// TODO Auto-generated method stub
		return id;
	}

    /**
     * connect to user
     * @param userstub
     * @throws RemoteException
     */
	/** (non-Javadoc)
	 * @see common.IUser#connect(common.IUser)
	 * connect to a user
	 */
	@Override
	public void connect(IUser userStub) throws RemoteException {
		// TODO Auto-generated method stub
		friends.add(userStub);
		modelAdpt.addfriend(userStub);
		
	}

}
