package tcp;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * 
 * @ClassName StartServer
 * @Description 服务器线程，循环监听
 * @author 吴扬颉
 * @date 2018年6月6日
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
 * @Description 接收客户端发送的信息
 * @author 吴扬颉
 * @date 2018年6月6日
 *
 */
class ClientThread implements Runnable{

	private Socket client;
	private BufferedReader bf = null;
	private Map<String,Socket> map;
	
	public ClientThread(Socket client,Map<String,Socket> map){
		this.client = client;
		this.map = map;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		String str = null;
		while(!client.isClosed()){
			try {
				bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
				

				new Thread(new Online(client)).start();
				
				while((str=bf.readLine())!=null && client != null)
					server.content.setText(server.content.getText()+"\n"+client.getInetAddress()+":"+client.getPort()+"——:"+str);
				server.list.removeElement(""+client.getPort());
				server.jList.setListData(server.list);
				map.remove(""+client.getPort());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	class Online implements Runnable{
		private ObjectOutputStream oos;
		private Socket client;
		public Online(Socket client){
			this.client = client;
		}
		/** (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while(!client.isClosed()){
					
					oos = new ObjectOutputStream(client.getOutputStream());
					oos.writeObject(map.keySet().toArray());
					oos.flush();
					Thread.sleep(1000);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
	}
	
}
