package chapter15;

import java.awt.event.*;
import javax.swing.*;

class MyMenu{
	private JFrame frame = new JFrame("菜单测试");
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
		menuFile = new JMenu("文件");
		menuNew = new JMenuItem("新建");
		menuOpen = new JMenuItem("打开");
		menuClose = new JMenuItem("关闭");
		menuStore = new JMenuItem("保存");
		menuFile.add(menuNew);
		menuFile.add(menuOpen);
		menuFile.add(menuClose);
		menuFile.addSeparator();
		menuFile.add(menuStore);
		
		menuEdit = new JMenu("编辑");
		menuCopy = new JMenuItem("复制");
		menuPaste = new JMenuItem("粘贴");
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
				text.setText("新建一个文件");
			else if(e.getSource() == menuOpen)
				text.setText("打开一个文件");
			else if(e.getSource() == menuClose)
				text.setText("关闭一个文件");
			else if(e.getSource() == menuStore)
				text.setText("保存一个文件");
			else if(e.getSource() == menuCopy){
				System.out.println("开始复制");
				copyInfo = text.getSelectedText();//复制选择的信息
				System.out.println("复制的信息为："+copyInfo);
			}
			else if(e.getSource() == menuPaste){
				System.out.println("粘贴的信息为："+copyInfo);
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
