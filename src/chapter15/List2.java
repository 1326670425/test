package chapter15;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class List2 extends JFrame implements ListSelectionListener{
	private JList<String> jl = new JList<String>();
	private JPanel jp = new JPanel();
	private JScrollPane jspz = new JScrollPane(jl);
	private JScrollPane jspy = new JScrollPane(jp);
	JSplitPane jspw = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jspz,jspy);
	private String[] str = new String[5];
	private JCheckBox[] jcb = new JCheckBox[5];
	public List2(){
		jspw.setDividerLocation(100);
		jspw.setDividerSize(4);
		jl.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//设置模式：允许多选
		jl.setListData(str);
		jl.addListSelectionListener(this);
		jp.setLayout(new GridLayout(4,10));
		for(int i=0;i<str.length;i++){
			str[i] = "选择项"+(i+1);
			jcb[i] = new JCheckBox(""+(i+1));
			jcb[i].setBounds(120+(i%6)*45, 10+(i/6)*35, 40, 30);
			jcb[i].setEnabled(false);
			jp.add(jcb[i]);
		}
		this.add(jspw);
		this.setTitle("列表、复选测试");
		this.setBounds(100, 100, 360, 450);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void valueChanged(ListSelectionEvent e){
		for(int i=e.getFirstIndex();i<=e.getLastIndex();i++){
			System.out.println(i);
			jcb[i].setSelected(((JList<String>)e.getSource()).isSelectedIndex(i));
		}
	}
	public static void main(String[] args){
		new List2();
	}
}
