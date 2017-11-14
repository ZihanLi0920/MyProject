package main.model.cmds;


import java.awt.Component;
import java.awt.Container;
import java.rmi.RemoteException;

import javax.swing.JLabel;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.ICmd2ModelAdapter;
import common.IComponentFactory;
import common.IReceiver;
/**
 * StringCommand to process string
 *
 */
public class StringCommand extends DataPacketAlgoCmd<String> {

	/**
	 * String command to process string
	 */

	private static final long serialVersionUID = -6829927260727331813L;
	/**
	 * ICmd2ModelAdapter
	 */

	transient private ICmd2ModelAdapter cmd2ModelAdpt = null;
	/**
	 * set Cmd2ModelAdpt
	 * @param cmd2ModelAdpt
	 */

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		// TODO Auto-generated method stub
		this.cmd2ModelAdpt = cmd2ModelAdpt;
	}
	
	@Override
	/**
	 * add method
	 * @param index 
	 * @param host
	 * @param params
	 * @return null
	 */
	public String apply(Class<?> index, DataPacketChatRoom<String> host, String... params) {
		// TODO Auto-generated method stub
			
			/*cmd2ModelAdpt.buildScrollableComponent(new IComponentFactory() {

				@Override
				public Component makeComponent() {
					// TODO Auto-generated method stub
					try {
						JLabel label=new JLabel(host.getSender().getUserStub().getName() + ": " + host.getData().toString());
						return label;
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				}},"Scrolling Comps");*/
			 try {
				cmd2ModelAdpt.appendMsg(  host.getData().toString(),host.getSender().getUserStub().getName());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//chatroomViewadpt.append(host.getSender().getUser().getName(), host.getData().toString());
		
		return null;
	}

}
