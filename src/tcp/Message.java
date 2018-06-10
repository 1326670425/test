/**
 * @Title Message.java
 * @Package tcp
 * @Description TODO
 * @author 吴扬颉
 * @date 2018年6月7日
 * @version 1.0
 */
package tcp;

import java.io.Serializable;

/**
 * @ClassName Message
 * @Description 消息封装
 * @author 吴扬颉
 * @date 2018年6月7日
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
