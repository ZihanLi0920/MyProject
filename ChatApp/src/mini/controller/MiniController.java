package mini.controller;

import java.awt.Component;
import java.awt.Image;
import java.rmi.RemoteException;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.DataPacketChatRoom;
import main.model.cmds.ImageData;
import main.model.cmds.StringData;
import mini.model.ChatRoom;
import mini.model.MiniModel2ViewAdapter;
import mini.view.MiniView;
import mini.view.MiniView2ModelAdapter;
/**
 * 
 * MiniController
 *
 */
public class MiniController {
	/**
	 * Mini view
	 */
	MiniView view;
	/**
	 * model
	 */
	ChatRoom model;
	/**
	 * Mini2Main adpt
	 */
	Mini2MainAdapter adpt;
	/**
	 * constructor
	 * @param name
	 * @param adpt
	 */
	public MiniController(String name,Mini2MainAdapter adpt)
	{   
		/**
		 * view of the mini MVC structure
		 */
		view=new MiniView(new MiniView2ModelAdapter() {

			@Override
			public void SendMsg(String msg) {
				model.sendPacket(new StringData(String.class,msg,model.getRelated()));
			}

			@Override
			public void SendImg(String path) {
				// TODO Auto-generated method stub
				ImageIcon img=new ImageIcon(path);
				System.out.println(path);
				model.sendPacket(new ImageData(ImageIcon.class,img,model.getRelated()));
				
			}

			@Override
			public Collection<String> getMembers() {
				// TODO Auto-generated method stub
				return model.getMembers();
			}

			@Override
			public void leave() {
				// TODO Auto-generated method stub
				model.leave();
				
			}

			@Override
			public void SendFile(byte[][] data) {
				// TODO Auto-generated method stub
				model.sendPacket(new DataPacketChatRoom<byte[][]>(byte[][].class,data,model.getRelated()));
				
			}});
		/**
		 * model of the mini MVC structure
		 */
		model=new ChatRoom(name,new MiniModel2ViewAdapter() {

			@Override
			public void appendMsg(String msg,String name) {
				// TODO Auto-generated method stub
				view.appendMsg(msg,name);
				
			}

			@Override
			public void addScrollableComponent(Component c,String label) {
				// TODO Auto-generated method stub
				view.addScrollableComponent(c,label);
				
			}

			@Override
			public void addNonScrollableComponent(Component c,String label) {
				// TODO Auto-generated method stub
				view.addNonScrollableComponent(c,label);
				
			}

			@Override
			public void refresh() {
				// TODO Auto-generated method stub
				view.refresh();
				
			}

			@Override
			public void leave() {
				// TODO Auto-generated method stub
				adpt.leave(model.getUUID());
				
			}});
		this.adpt=adpt;
		
	}
	/**
	 * get model
	 * @return model
	 */
	public ChatRoom getModel()
	{
		return model;
	}
	/**
	 * get view
	 * @return view
	 */
	public MiniView getView()
	{
		return view;
	}

	

}
