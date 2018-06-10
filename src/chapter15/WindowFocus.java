package chapter15;

import javax.swing.*;
import java.awt.event.*;

public class WindowFocus {
	public JFrame frame;
	public JButton jb;
	int i = 0;
	public WindowFocus(){
		frame = new JFrame();
		frame.setTitle("���ڽ������");
		frame.setBounds(300, 250, 300, 200);
		jb = new JButton("����0��");
		jb.setMnemonic('a');
		frame.addWindowFocusListener(new WindowFocusListener(){
			public void windowGainedFocus(WindowEvent e){
				System.out.println("���ڻ�ý���");
			}
			public void windowLostFocus(WindowEvent e){
				System.out.println("����ʧȥ����");
			}
		});
		frame.addWindowListener(new WindowAdapter(){
			public void windowIconified(WindowEvent e){
				System.out.println("��С��");
			}
		});
		frame.add(jb);
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jb.setText("����"+(++i)+"��");
			}
		});
		frame.setVisible(true);
	}
	public static void main(String[] args){
		new WindowFocus();
	}
}
