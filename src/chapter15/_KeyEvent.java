package chapter15;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

class SerialNumber{
	private JRadioButton rb = new JRadioButton("单选按钮");
	private JTextField txt1 = new JTextField(4);
	private JTextField txt2 = new JTextField(4);
	private JTextField txt3 = new JTextField(4);
	private JLabel label = new JLabel("输入序列号");
	private JFrame frame = new JFrame("测试键盘事件");
	JPanel pan = new JPanel(new FlowLayout());
	public SerialNumber(){
		frame.setSize(400, 400);
		frame.setLocation(300, 300);
		frame.setLayout(new BorderLayout());
		Document doc1 = new MyDocument(4);
		Document doc2 = new MyDocument(4);
		Document doc3 = new MyDocument(4);
		txt1.setDocument(doc1);
		txt2.setDocument(doc2);
		txt3.setDocument(doc3);
		pan.add(txt1);
		pan.add(txt2);
		pan.add(txt3);
		frame.add(pan, BorderLayout.CENTER);
		frame.add(label, BorderLayout.SOUTH);
		frame.add(rb, BorderLayout.NORTH);
		rb.setSelected(true);
		MyKeyListener MyListener = new MyKeyListener();
		txt1.addKeyListener(MyListener);
		txt2.addKeyListener(MyListener);
		txt3.addKeyListener(MyListener);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				JOptionPane.showConfirmDialog(null, "系统被关闭", "警告信息",2);
				System.exit(1);
			}
		});
		frame.setVisible(true);
	}
	class MyDocument extends PlainDocument{
		int maxLength = 10;
		public MyDocument(int newMaxLength){
			super();
			maxLength = newMaxLength;
		}
		public MyDocument(){
			this(10);
		}
		//重载父类的insertString函数
		public void insertString(int offset, String str, AttributeSet a)throws BadLocationException{
			if(getLength()+str.length() > maxLength){
				return;
			}
			else{
				super.insertString(offset, str, a);
			}
		}
	}
	class MyKeyListener implements KeyListener{
		public void keyPressed(KeyEvent e){
			
		}
		public void keyReleased(KeyEvent e){
			if(e.getKeyChar() >= 58 || e.getKeyChar() <= 47){
				JOptionPane.showMessageDialog(null, "请输入数字", "警告信息", 2);
				if(e.getSource() == txt1)
					txt1.setText("");
				else if(e.getSource() == txt2)
					txt2.setText("");
				else if(e.getSource() == txt3)
					txt3.setText("");
			}
		}
		public void keyTyped(KeyEvent e){
			
		}
	}
}

public class _KeyEvent {
	public static void main(String[] args){
		new SerialNumber();
	}
}
