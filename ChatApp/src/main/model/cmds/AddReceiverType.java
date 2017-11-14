package main.model.cmds;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.IAddReceiverType;
import common.ICmd2ModelAdapter;
import common.IReceiver;
import provided.datapacket.ADataPacket;
import provided.extvisitor.IExtVisitorHost;
/**
 * 
 * Add receiver type
 *
 */
public class AddReceiverType implements IAddReceiverType {
	/**
	 * 
	 * receiver
	 *
	 */
	IReceiver receiver;
	/**
	 * constructor
	 * @param receiver
	 */
	public AddReceiverType(IReceiver receiver)
	{
		this.receiver=receiver;
	}
	/**
	 * get receiver stub
	 *@return IReceiver
	 */
	@Override
	public IReceiver getReceiverStub() {
		// TODO Auto-generated method stub
		return receiver;
	}



	

}
