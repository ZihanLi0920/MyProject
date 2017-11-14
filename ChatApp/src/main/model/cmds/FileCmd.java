package main.model.cmds;

import java.awt.Component;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JLabel;

import common.DataPacketAlgoCmd;
import common.DataPacketChatRoom;
import common.ICmd2ModelAdapter;
import common.IComponentFactory;


public class FileCmd extends DataPacketAlgoCmd<byte[][]> {
	/**
	 * ICmd2ModelAdapter
	 *
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ICmd2ModelAdapter cmd2ModelAdpt;

	@Override
	public String apply(Class<?> index, DataPacketChatRoom<byte[][]> host, String... params) {
		// TODO Auto-generated method stub
		File dir = new File("download/");
		dir.mkdirs();
		File temp = new File("download/"+new String(host.getData()[0]));
		if(!temp.exists()) {
			try {
				temp.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(temp);
			fos.write(host.getData()[1]);
			fos.flush();
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		cmd2ModelAdpt.buildScrollableComponent(new IComponentFactory() {
			@Override
			public Component makeComponent() {
				return new JLabel("File received:[download/"+temp.getName()+"]");
			}
			
		}, "Receive File Status");
		return null;
	}
	/**
	 * set Cmd2ModelAdpt
	 *@param cmd2ModelAdpt
	 */
	/** (non-Javadoc)
	 * @see provided.datapacket.ADataPacketAlgoCmd#setCmd2ModelAdpt(java.lang.Object)
	 * set the model2cmd adapter
	 */
	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		// TODO Auto-generated method stub
		this.cmd2ModelAdpt=cmd2ModelAdpt;
		
	}

}
