package chapter15;

import javax.swing.*;
import java.awt.event.*;

public class WindowFocus {
	public JFrame frame;
	public JButton jb;
	int i = 0;
	public WindowFocus(){
		frame = new JFrame();
		frame.setTitle("窗口焦点测试");
		frame.setBounds(300, 250, 300, 200);
		jb = new JButton("单击0次");
		jb.setMnemonic('a');
		frame.addWindowFocusListener(new WindowFocusListener(){
			public void windowGainedFocus(WindowEvent e){
				System.out.println("窗口获得焦点");
			}
			public void windowLostFocus(WindowEvent e){
				System.out.println("窗口失去焦点");
			}
		});
		frame.addWindowListener(new WindowAdapter(){
			public void windowIconified(WindowEvent e){
				System.out.println("最小化");
			}
		});
		frame.add(jb);
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jb.setText("单击"+(++i)+"次");
			}
		});
		frame.setVisible(true);
	}
	public static void main(String[] args){
		new WindowFocus();
	}
}
