package main.model.cmds;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.ICmd2ModelAdapter;
import common.IFailureStatusType;


public class FailureStatusTypeCmd extends DataPacketAlgoCmd<IFailureStatusType>{
	/**
	 * ICmd2ModelAdapter
	 *
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ICmd2ModelAdapter cmd2ModelAdpt;
	/**
	 *add algorithm
	 *@param index
	 *@param host
	 *@param params
	 *@return null
	 */
	/**(non-Javadoc)
	 * @see provided.datapacket.ADataPacketAlgoCmd#apply(java.lang.Class, provided.datapacket.ADataPacket, java.lang.Object[])
	 */
	@Override
	public String apply(Class<?> index, DataPacketChatRoom<IFailureStatusType> host, String... params) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * set ICmd2ModelAdapter
	 *@param cmd2ModelAdpt
	 */
	/** (non-Javadoc)
	 * @see provided.datapacket.ADataPacketAlgoCmd#setCmd2ModelAdpt(java.lang.Object)
	 * set the adapter
	 */
	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		// TODO Auto-generated method stub
		this.cmd2ModelAdpt=cmd2ModelAdpt;
		
	}

}
