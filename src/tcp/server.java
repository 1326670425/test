package tcp;
import javax.swing.*;

import java.net.*;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
/**
 * 
 * @ClassName server
 * @Description 服务端UI
 * @author 吴扬颉
 * @date 2018年6月6日
 *
 */
public class server extends JFrame{
	private ServerSocket serverSocket;
	private JPanel panelUp;
	private JPanel panelDown;
	private JScrollPane panell;
	private JScrollPane panelr;
	private int port;
	private JTextField tport;
	public static JList<String> jList = new JList<String>();
	public static JTextArea content = new JTextArea();
	public static  Vector<String> list = new Vector<String>();
	private JButton bind;
	private JButton open;
	private JButton close;
	
	public server(){
		this.setTitle("服务器");
		this.setSize(600, 400);
		this.setLocation(400, 200);
		
		panelUp = new JPanel();
		panelUp.setLayout(new GridLayout());
		panelDown = new JPanel();
		panell = new JScrollPane(jList);
		panelDown.setLayout(new GridLayout());
		panell.setBorder(BorderFactory.createTitledBorder("在线列表"));

		panelr = new JScrollPane(content);
		panelr.setBorder(BorderFactory.createTitledBorder("消息框"));

		
		tport = new JTextField();
		
		
		bind = new JButton("绑定端口");
		open = new JButton("开启服务器");
		close = new JButton("关闭服务器");
		
		panelUp.add(tport);
		panelUp.add(bind);
		panelUp.add(open);
		panelUp.add(close);
		
		panelDown.add(panell);
		panelDown.add(panelr);
		
		MyListener listener = new MyListener();
		bind.addActionListener(listener);
		open.addActionListener(listener);
		close.addActionListener(listener);
		this.add(panelUp,BorderLayout.NORTH);
		this.add(panelDown,BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
	class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==bind){
				port = Integer.parseInt(tport.getText());
				try {
					serverSocket = new ServerSocket(port);
					JOptionPane.showMessageDialog(null, "已绑定端口");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(e.getSource()==open){
				
				new Thread(new StartServer(serverSocket)).start();;
				JOptionPane.showMessageDialog(null, "服务器已开启");
			}
			if(e.getSource()==close)
				System.exit(0);
		}
		
	}
	
	public static void main(String[] args){
		new server();
	}

}
