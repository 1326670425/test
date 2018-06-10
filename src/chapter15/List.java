package chapter15;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.event.*;

class SelectFontType{
	private JFrame frame = new JFrame("列表框测试");
	private Container cont;
	private JLabel lb = new JLabel("字形");
	private JTextField text = new JTextField("改变字形");
	private JList<String> jList = null;
	public SelectFontType(){
		frame.setLocation(300, 300);
		frame.setSize(400, 400);
		cont = frame.getContentPane();
		cont.setLayout(new GridLayout(3,1));
		//List<String>list = new ArrayList<String>();
		Vector<String>list = new Vector<String>();
		list.add("常规");
		list.add("倾斜");
		list.add("加粗");
		list.add("倾斜，加粗");
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
			if(str.equals("常规"))
				font = new Font("华文行楷",Font.PLAIN,40);
			else if(str.equals("加粗"))
				font = new Font("华文行楷",Font.BOLD,40);
			else if(str.equals("倾斜"))
				font = new Font("华文行楷",Font.ITALIC,40);
			else if(str.equals("倾斜，加粗"))
				font = new Font("华文行楷",Font.TRUETYPE_FONT,40);
			text.setFont(font);
		}
		
	}
}
public class List {
	public static void main(String[] args){
		new SelectFontType();
	}
}
