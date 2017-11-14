package main.model;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.IChatRoom;
import common.IReceiver;
//import common.IVoidLambdaDP;
import provided.datapacket.ADataPacket;

/**
 * ProxyChatroom
 */
public class ProxyChatroom implements IChatRoom {
	/**
	 * chat room stub
	 */
	IChatRoom stub;
	/**
	 * constructor
	 * @param _stub
	 */
	public ProxyChatroom(IChatRoom _stub)
	{
		stub=_stub;
	}


	/**
	 * convert name to string
	 */
	@Override
	public String toString()
	{
		return this.getName();
	}
	/**
	 * get chatroom's name
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return stub.getName();
	}
	/**
	 * get receiverStubs
	 * @return collection of receiverStubs
	 */

	@Override
	public Collection<IReceiver> getIReceiverStubs() {
		// TODO Auto-generated method stub
		return stub.getIReceiverStubs();
	}
	/**
	 *add receiver stub to local
	 *@param receiver
	 *@return boolean
	 */
	@Override
	public boolean addIReceiverStubLocally(IReceiver receiver) {
		// TODO Auto-generated method stub
		return stub.addIReceiverStubLocally(receiver);
	}
	/**
	 *remove receiver stub to local
	 *@param receiver
	 *@return boolean
	 */
	@Override
	public boolean removeIReceiverStubLocally(IReceiver receiver) {
		// TODO Auto-generated method stub
		return stub.removeIReceiverStubLocally(receiver);
	}
	/**
	 *send DataPacket
	 *@param data
	 */
	@Override
	public <T> void sendPacket(DataPacketChatRoom<T> data) {
		// TODO Auto-generated method stub
		stub.sendPacket(data);
		
	}
	/**
	 *get UUID
	 *@return UUID
	 */
	@Override
	public UUID getUUID() {
		// TODO Auto-generated method stub
		return stub.getUUID();
	}

	



	

}
