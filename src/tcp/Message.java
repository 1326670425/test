/**
 * @Title Message.java
 * @Package tcp
 * @Description TODO
 * @author �����
 * @date 2018��6��7��
 * @version 1.0
 */
package tcp;

import java.io.Serializable;

/**
 * @ClassName Message
 * @Description ��Ϣ��װ
 * @author �����
 * @date 2018��6��7��
 * 
 */
public class Message implements Serializable{
	private String sendPort;
	private String receivePort;
	private String msg;
	public String getSendPort(){
		return this.sendPort;
	}
	public void setSendPort(String sendPort){
		this.sendPort = sendPort;
	}
	public String getReceivePort(){
		return this.receivePort;
	}
	public void setReceivePort(String receivePort){
		this.receivePort = receivePort;
	}
	public String getMsg(){
		return this.msg;
	}
	public void setMsg(String msg){
		this.msg = msg;
	}
}
