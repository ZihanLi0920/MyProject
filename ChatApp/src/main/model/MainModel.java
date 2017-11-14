package main.model;
import main.model.MainModel.ProxyUser;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;
import java.util.function.Consumer;

import common.DataPacketChatRoom;
import common.IAddReceiverType;
import common.IChatRoom;
import common.IReceiver;
import common.IRemoveReceiverType;
import common.IUser;
import main.model.cmds.AddReceiverType;
import main.model.cmds.RemoveReceiverData;
import mini.model.ChatRoom;
//import provided.compute.ICompute;
import provided.rmiUtils.IRMI_Defs;
import provided.rmiUtils.RMIUtils;

/**
 * Main model for Model-View-Controller structure 
 */
public class MainModel {
	/**
	 * model adapter object for communicating with the view
	 */
	MainModel2ViewAdapter model2viewAdpt;
	/**
	 * userstub
	 */
	IUser userStub;
	/**
	 * user
	 */
	User user;
	/**
	 * Registry
	 */
	Registry registry;
	//HashMap<UUID,IChatRoom> roomStubs=new HashMap<UUID,IChatRoom>();
	/**
	 * Hashmap to preserve the chatroom list
	 */
	HashMap<UUID,ChatRoom>  chatRooms=new HashMap<UUID,ChatRoom>();
	/**
	 * RMI system
	 */
	private RMIUtils rmiUtils;
	/**
	 * cmd for output info to view
	 */
	private Consumer<String> outputCmd = new Consumer<String>() {

		@Override
		public void accept(String t) {
			model2viewAdpt.appendInfo(t+"\n");
			//System.out.println(t + "\n");
		}
	};
	/**
	 * proxy user 
	 */
	public class ProxyUser implements IUser{
		/**
		 * User stub
		 */

		IUser stub;
		/**
		 * Constructor
		 * @param user stub
		 */
		ProxyUser(IUser _stub)
		{
			this.stub=_stub;
		}
		

		

		
		/**
		 * get user name
		 * @return the name of the user
		 */
		@Override
		public String getName() throws RemoteException {
			// TODO Auto-generated method stub
			return stub.getName();
		}

		
		/**
		 * converting the user name into a String 
		 * @return the name of the user
		 */
		@Override
		public String toString()
		{
			try {
				return this.getName();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "wrong";
		}

		/**
		 * get chat rooms 
		 * @return the list of chat rooms
		 */
		@Override
		public Collection<IChatRoom> getChatRooms() throws RemoteException {
			// TODO Auto-generated method stub
			return stub.getChatRooms();
		}

		/**
		 * get user's UUID  
		 * @return the UUID of the user
		 */
		@Override
		public UUID getUUID() throws RemoteException {
			// TODO Auto-generated method stub
			return stub.getUUID();
		}

		/**
		 * connnect to the user 
		 * @param userStub
		 */
		@Override
		public void connect(IUser userStub) throws RemoteException {
			// TODO Auto-generated method stub
			stub.connect(userStub);
			
		}
		
	}
	/**
	 * Constructor for main model 
	 * @param _model2viewAdpt
	 */
	public MainModel(MainModel2ViewAdapter _model2viewAdpt)
	{
		model2viewAdpt=_model2viewAdpt;
	}
	/**
	 * configure the application
	 * @param name
	 * @param port
	 */
	public void start(String name,int port)
	{
		rmiUtils = new RMIUtils(outputCmd);
		rmiUtils.startRMI(port-10);
		try {
			user=new User(name,port,new User2ModelAdapter() {

				@Override
				public void addfriend(IUser friend) {
					// TODO Auto-generated method stub
					model2viewAdpt.addFriend(new ProxyUser(friend));
				}
			});

				
			user.setIP(rmiUtils.getLocalAddress());
			model2viewAdpt.setIP(rmiUtils.getLocalAddress()+":"+port);
			
			userStub = (IUser) UnicastRemoteObject.exportObject(user,
					port);
			registry = rmiUtils.getLocalRegistry();
			registry.rebind(user.BOUND_NAME1, userStub);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * connect to user
	 * @param name
	 * @param IP
	 */
	public void connectTo(String name, String IP)
	{
		Registry registry = rmiUtils.getRemoteRegistry(IP);
		try {
			IUser friendStub = (IUser) registry.lookup(name);
			user.connect(friendStub);
			friendStub.connect(userStub);
		} catch (AccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return user;
		
	}
	/**
	 * add room to local
	 * @param newRoom
	 */
	public void addLocalRoom(ChatRoom newRoom)
	{
		//ChatRoom newRoom=new ChatRoom(name);
		IReceiver receiverStub;
		Receiver receiver=new Receiver(user,newRoom);
		try {
			receiverStub = (IReceiver) UnicastRemoteObject.exportObject(receiver,
					user.BOUND_PORT);
			//Registry registry = rmiUtils.getLocalRegistry();
			registry.rebind(newRoom.getName(), receiver);
			//roomStubs.put(newRoom.getId(), roomStub);
			newRoom.addIReceiverStubLocally(receiverStub);
			newRoom.setRelated(receiverStub);
			chatRooms.put(newRoom.getUUID(), newRoom);
			user.addRoom(newRoom);
			newRoom.refresh();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//model2viewAdpt.addLocalRoom(newRoom);
		
		
	}
	/**
	 * get remote room
	 * @param friend
	 * @return
	 */
	public ArrayList<ProxyChatroom> getRemoteRoom(ProxyUser friend)
	{
		ArrayList<ProxyChatroom> res=new ArrayList<ProxyChatroom>();
		try {
			Iterable<IChatRoom> rooms=friend.getChatRooms();
			for(IChatRoom room:rooms)
			{
				res.add(new ProxyChatroom(room));
			}
			return res;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * join room
	 * @param newRoom
	 * @param remoteRoom
	 */
	public void joinRoom(ChatRoom newRoom,ProxyChatroom remoteRoom) {
		// TODO Auto-generated method stub
		IReceiver receiverStub;
		Receiver receiver=new Receiver(user,newRoom);
		try {
			receiverStub = (IReceiver) UnicastRemoteObject.exportObject(receiver,
					user.BOUND_PORT);
			//Registry registry = rmiUtils.getLocalRegistry();
			registry.rebind(newRoom.getName(), receiverStub);
			//roomStubs.put(newRoom.getId(), roomStub);
			//newRoom.addIReceiverStub(receiverStub);
			DataPacketChatRoom<IAddReceiverType> data=new DataPacketChatRoom<IAddReceiverType>(IAddReceiverType.class,new AddReceiverType(receiverStub),receiverStub);
			for(IReceiver r:remoteRoom.getIReceiverStubs())
			{
				r.receive(data);
				newRoom.addIReceiverStubLocally(r);
			}
			newRoom.addIReceiverStubLocally(receiverStub);
			newRoom.setRelated(receiverStub);
			chatRooms.put(newRoom.getUUID(), newRoom);
			user.addRoom(newRoom);
			newRoom.refresh();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//model2viewAdpt.addLocalRoom(newRoom);
		
		
	}
	/**
	 * quit the room 
	 * 
	 */
	public void quit() {
		for(ChatRoom room:chatRooms.values())
		{
			IReceiver sender=room.getRelated();
			room.sendPacket(new DataPacketChatRoom(IRemoveReceiverType.class,new RemoveReceiverData(sender),sender) );
		}
		rmiUtils.stopRMI();
		System.exit(0);
	}
	/**
	 * leave the room
	 * @param id
	 */
	public void leave(UUID id)
	{
		//model2viewAdpt.leave(chatRooms.get(id).getName());
		chatRooms.remove(id);
		
	}
	

}
