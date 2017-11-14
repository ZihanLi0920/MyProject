package main.model.cmds;

import common.DataPacketChatRoom;
import common.IReceiver;
import common.IRemoveReceiverType;
/**
 * Remove Receiver data
 * @author admin
 *
 */
public class RemoveReceiverData implements IRemoveReceiverType{
    /**
     * receiver stub
     */
	IReceiver stub;
	/**
	 * constructor for RemoveReceiverData
	 * @param stub
	 */
	public RemoveReceiverData(IReceiver stub)
	{
		this.stub=stub;
	}
    /**
     * get receiver stub
     * @return receiver stub
     */
	@Override
	public IReceiver getReceiverStub() {
		// TODO Auto-generated method stub
		return stub;
	}

	

}
