package chapter15;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyMotion{
	private JLabel lbFile = new JLabel("Motion.txt");
	private JTextArea text = new JTextArea(100, 50);
	private JLabel lbInfo = new JLabel("AAAAA");
	private JFrame frame = new JFrame("鼠标拖拽测试");
	private boolean flag = false;
	public MyMotion(){
		frame.setLocation(300, 300);
		frame.setSize(400, 400);
		frame.setLayout(new BorderLayout());
		frame.add(lbFile, BorderLayout.NORTH);
		frame.add(text, BorderLayout.CENTER);
		frame.add(lbInfo, BorderLayout.SOUTH);
		lbFile.addMouseMotionListener(new MyMotionListener());

		text.addMouseListener(new MouseAdapter(){
			@SuppressWarnings("deprecation")
			public void mouseReleased(MouseEvent e){
				if(flag == true && e.getSource() == text){
					text.setText("准备发送离线文件:"+lbFile.getText());
					lbInfo.setText("正在发送离线文件");
					flag = false;
					frame.setCursor(Cursor.DEFAULT_CURSOR);
				}
				else{
					JOptionPane.showMessageDialog(null, "请选择发送文件", "警告信息", 2);
				}
			}
		});
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1);
			}
		});
		this.frame.setVisible(true);
	}
	class MyMotionListener implements MouseMotionListener{

		@SuppressWarnings("deprecation")
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			flag = true;
			text.setText("鼠标位置："+"("+e.getX()+","+e.getY()+")");
			frame.setCursor(Cursor.CROSSHAIR_CURSOR);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

public class _MouseMotion {
	public static void main(String[] args){
		new MyMotion();
	}
}
