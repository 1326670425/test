package chapter15;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Layout {
	public static void main(String[] args){
		JFrame frame = new JFrame("请假条");
		frame.setSize(400, 400);
		frame.setLocation(400, 400);

		JLabel labelNorth = new JLabel("北方",JLabel.CENTER);
		JTextField textWest = new JTextField("西方");
		JLabel labelEast = new JLabel("东方");
		JTextField textCenter = new JTextField("中部");
		JLabel labelSouth = new JLabel("南方",JLabel.CENTER);
/*		//区域布局管理器
 		BorderLayout bl =new BorderLayout(5,5);//实例化区域布局管理器
 		frame.setLayout(bl);
		frame.add(labelNorth,BorderLayout.NORTH);
		frame.add(textWest, BorderLayout.WEST);
		frame.add(labelEast, BorderLayout.EAST);
		frame.add(textCenter,BorderLayout.CENTER);
		frame.add(labelSouth, BorderLayout.SOUTH);
		frame.pack();
 		*/
/*		//流式布局管理器
  		FlowLayout fl = new FlowLayout(FlowLayout.CENTER,20,5);//实例化流式布局管理器
		frame.setLayout(fl);
		frame.add(labelNorth);
		frame.add(textWest);
		frame.add(labelEast);
		frame.add(textCenter);
		frame.add(labelSouth);
		frame.pack();
		*/
/*		//网络布局管理器
		GridLayout gl = new GridLayout(2,2,3,3);
		frame.setLayout(gl);
		frame.add(labelNorth);
		frame.add(textWest);
		frame.add(labelEast);
		frame.add(textCenter);
		frame.add(labelSouth);
		frame.pack();
		*/
		//卡片布局管理器
		Container cont = frame.getContentPane();//取得窗体容器的容器
		CardLayout cl = new CardLayout();
		frame.setLayout(cl);
		frame.add(labelNorth);
		frame.add(textWest);
		frame.add(labelEast);
		frame.add(textCenter);
		frame.add(labelSouth);
		frame.setVisible(true);
		cl.show(cont,"labelNorth");
		for(int i=0;i<10;i++){
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			cl.next(cont);
		}
	}
}
