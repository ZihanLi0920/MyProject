package main.model.cmds;

import common.DataPacketAlgoCmd;
import common.IInstallCmdType;
/**
 * Install CmdType
 *
 */
/**
 * @author zihanli
 * the data type of installing cmd
 *
 */
public class InstallCmdType implements IInstallCmdType{
   /**
    * 
    */
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Class<?> id;
	/**
	 * 
	 */
	DataPacketAlgoCmd<?> cmd;

	public InstallCmdType(Class<?> id,DataPacketAlgoCmd<?> cmd)
	{
		this.id=id;
		this.cmd=cmd;
	}
	/** (non-Javadoc)
	 * @see common.IInstallCmdType#getCmd()
	 * return the cmd
	 */
	@Override
	/**
	 * get Cmd
	 * @return cmd
	 */
	public DataPacketAlgoCmd<?> getCmd() {
		// TODO Auto-generated method stub
		return cmd;
	}
    /**
     * get CmdId
     * @return id
     */
	/** (non-Javadoc)
	 * @see common.IInstallCmdType#getCmdId()
	 */
	@Override
	public Class<?> getCmdId() {
		// TODO Auto-generated method stub
		return id;
	}

}
