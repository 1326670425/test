package chapter15;

import java.awt.event.*;
import javax.swing.*;

class MyMenu{
	private JFrame frame = new JFrame("�˵�����");
	private JTextArea text = new JTextArea();
	private JMenu menuFile = null;
	private JMenu menuEdit = null;
	private JMenuBar bar = null;
	private JMenuItem menuNew;
	private JMenuItem menuOpen;
	private JMenuItem menuClose;
	private JMenuItem menuStore;
	private JMenuItem menuCopy;
	private JMenuItem menuPaste;
	private String copyInfo;
	public MyMenu(){
		frame.setLocation(300, 300);
		frame.setSize(400, 400);
		menuFile = new JMenu("�ļ�");
		menuNew = new JMenuItem("�½�");
		menuOpen = new JMenuItem("��");
		menuClose = new JMenuItem("�ر�");
		menuStore = new JMenuItem("����");
		menuFile.add(menuNew);
		menuFile.add(menuOpen);
		menuFile.add(menuClose);
		menuFile.addSeparator();
		menuFile.add(menuStore);
		
		menuEdit = new JMenu("�༭");
		menuCopy = new JMenuItem("����");
		menuPaste = new JMenuItem("ճ��");
		menuEdit.add(menuCopy);
		menuEdit.add(menuPaste);
		
		MyMenuListener MyListener = new MyMenuListener();
		menuNew.addActionListener(MyListener);
		menuOpen.addActionListener(MyListener);
		menuClose.addActionListener(MyListener);
		menuStore.addActionListener(MyListener);
		menuCopy.addActionListener(MyListener);
		menuPaste.addActionListener(MyListener);
		
		frame.getContentPane().add(new JScrollPane(text));
		bar = new JMenuBar();
		frame.setJMenuBar(bar);
		bar.add(menuFile);
		bar.add(menuEdit);
		frame.add(text);
		this.frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1);;
			}
		});
		this.frame.setVisible(true);
	}
	private class MyMenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == menuNew)
				text.setText("�½�һ���ļ�");
			else if(e.getSource() == menuOpen)
				text.setText("��һ���ļ�");
			else if(e.getSource() == menuClose)
				text.setText("�ر�һ���ļ�");
			else if(e.getSource() == menuStore)
				text.setText("����һ���ļ�");
			else if(e.getSource() == menuCopy){
				System.out.println("��ʼ����");
				copyInfo = text.getSelectedText();//����ѡ�����Ϣ
				System.out.println("���Ƶ���ϢΪ��"+copyInfo);
			}
			else if(e.getSource() == menuPaste){
				System.out.println("ճ������ϢΪ��"+copyInfo);
				text.append(copyInfo);
		}
		
	}
	}
}

public class Menu {
	public static void main(String[] args){
		new MyMenu();
	}
}
