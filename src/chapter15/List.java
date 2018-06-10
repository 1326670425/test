package chapter15;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.event.*;

class SelectFontType{
	private JFrame frame = new JFrame("�б�����");
	private Container cont;
	private JLabel lb = new JLabel("����");
	private JTextField text = new JTextField("�ı�����");
	private JList<String> jList = null;
	public SelectFontType(){
		frame.setLocation(300, 300);
		frame.setSize(400, 400);
		cont = frame.getContentPane();
		cont.setLayout(new GridLayout(3,1));
		//List<String>list = new ArrayList<String>();
		Vector<String>list = new Vector<String>();
		list.add("����");
		list.add("��б");
		list.add("�Ӵ�");
		list.add("��б���Ӵ�");
		jList = new JList<String>(list);
		cont.add(lb);
		cont.add(text);
		cont.add(jList);
		jList.setBorder(BorderFactory.createLineBorder(Color.RED));
		jList.addListSelectionListener(new MyListSelectListener());
		this.frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1);
			}
		});
		this.frame.setVisible(true);
	}
	private class MyListSelectListener implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			String str = (String)jList.getSelectedValue();
			Font font = null;
			if(str.equals("����"))
				font = new Font("�����п�",Font.PLAIN,40);
			else if(str.equals("�Ӵ�"))
				font = new Font("�����п�",Font.BOLD,40);
			else if(str.equals("��б"))
				font = new Font("�����п�",Font.ITALIC,40);
			else if(str.equals("��б���Ӵ�"))
				font = new Font("�����п�",Font.TRUETYPE_FONT,40);
			text.setFont(font);
		}
		
	}
}
public class List {
	public static void main(String[] args){
		new SelectFontType();
	}
}
