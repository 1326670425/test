package tcp;

import java.net.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
/**
 * 
 * @ClassName client
 * @Description 客户端UI
 * @author 吴扬颉
 * @date 2018年6月6日
 *
 */
public class client extends JFrame{
	private Socket socket;
	private JPanel panelUp;
	private JPanel panelCenter;
	private JScrollPane panelr;
	private JScrollPane panell;
	private JList<Object> jList;
	private JPanel panelDown;
	private int port;
	private String addr;
	private JTextField tport;
	private JTextField taddr;
	private JTextArea msg;
	private JButton conn;
	private JButton send;
	private JButton exit;
	private PrintWriter out;
	
	public client(){
		this.setTitle("客户端");
		this.setSize(400, 400);
		this.setLocation(400, 200);
		
		panelUp = new JPanel();
		panelUp.setLayout(new GridLayout(1,3));

		tport = new JTextField();
		taddr = new JTextField("127.0.0.1");
		msg = new JTextArea();
		conn = new JButton("连接");
		send = new JButton("发送");
		exit = new JButton("退出");
		
		MyListener listener = new MyListener();
		conn.addActionListener(listener);
		send.addActionListener(listener);
		exit.addActionListener(listener);
		
		panelDown = new JPanel();
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout());
		
		jList =  new JList<Object>();
		panell = new JScrollPane(jList);
		panelr = new JScrollPane(msg);
		panell.setBorder(BorderFactory.createTitledBorder("在线列表"));
		panelr.setBorder(BorderFactory.createTitledBorder("消息框"));
		
		panelUp.add(taddr);
		panelUp.add(tport);
		panelUp.add(conn);
		this.add(panelUp,BorderLayout.NORTH);
		
		panelCenter.add(panell);
		panelCenter.add(panelr);

		panelDown.add(send);
		panelDown.add(exit);
		this.add(panelCenter,BorderLayout.CENTER);
		this.add(panelDown,BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==conn){
				port = Integer.parseInt(tport.getText());
				addr = taddr.getText();
				try {
					socket = new Socket(addr,port);
					new Thread(new ListThread(socket,jList)).start();
					JOptionPane.showMessageDialog(null, "连接成功");
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "连接失败");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "连接失败");
				}
			}
			if(e.getSource()==send){
				try {
					out = new PrintWriter(socket.getOutputStream());
					out.write(msg.getText()+"\n");
					msg.setText("");
					out.flush();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(e.getSource()==exit){
				try {

					out.close();socket.getInputStream().close();socket.getOutputStream().close();
					socket.close();
					
					System.exit(0);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
		
	}
	
	public static void main(String[] args){
		new client();
	}
}

class ListThread implements Runnable{
	
	private Socket socket;
	private ObjectInputStream ois;
	private JList<Object> jList;
	
	public ListThread(Socket socket,JList<Object> jList){
		this.socket = socket;
		this.jList = jList;
	}
	/** (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			while(!socket.isClosed()){
				ois = new ObjectInputStream(socket.getInputStream());
				Object[] o = (Object[])ois.readObject();
				
				Vector<Object> list = new Vector<Object>();
				for(int i=0;i<o.length;i++)
					list.add(o[i]);
				jList.setListData(list);
				Thread.sleep(1000);
			}
		} catch (IOException | ClassNotFoundException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}
