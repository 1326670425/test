package tcp;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * 
 * @ClassName StartServer
 * @Description �������̣߳�ѭ������
 * @author �����
 * @date 2018��6��6��
 *
 */
public class StartServer implements Runnable{
	
	private ServerSocket ssocket;
	private Socket client;
	private Map<String,Socket> map;
	public StartServer(ServerSocket ssocket){
		this.ssocket = ssocket;
		map = new HashMap<String,Socket>();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				client = ssocket.accept();
				map.put(""+client.getPort(),client);
				server.list.addElement(""+client.getPort());
				server.jList.setListData(server.list);
				new Thread(new ClientThread(client,map)).start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
/**
 * 
 * @ClassName ClientThread
 * @Description ���տͻ��˷��͵���Ϣ
 * @author �����
 * @date 2018��6��6��
 *
 */
class ClientThread implements Runnable{

	private Socket client;
	private BufferedReader bf = null;
	private Map<String,Socket> map;
	private ObjectOutputStream oos;
	
	public ClientThread(Socket client,Map<String,Socket> map){
		this.client = client;
		this.map = map;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		String str = null;
		while(client!=null){
			try {
				bf = new BufferedReader(new InputStreamReader(client.getInputStream()));

/*				oos = new ObjectOutputStream(client.getOutputStream());
				oos.writeObject(map.keySet().toArray());
				oos.flush();*/
				
				while((str=bf.readLine())!=null)
					server.content.setText(server.content.getText()+"\n"+client.getInetAddress()+":"+client.getPort()+"����:"+str);
				server.list.removeElement(""+client.getPort());
				server.jList.setListData(server.list);
				map.remove(""+client.getPort());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
