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
		JFrame frame = new JFrame("�����");
		frame.setSize(400, 400);
		frame.setLocation(400, 400);

		JLabel labelNorth = new JLabel("����",JLabel.CENTER);
		JTextField textWest = new JTextField("����");
		JLabel labelEast = new JLabel("����");
		JTextField textCenter = new JTextField("�в�");
		JLabel labelSouth = new JLabel("�Ϸ�",JLabel.CENTER);
/*		//���򲼾ֹ�����
 		BorderLayout bl =new BorderLayout(5,5);//ʵ�������򲼾ֹ�����
 		frame.setLayout(bl);
		frame.add(labelNorth,BorderLayout.NORTH);
		frame.add(textWest, BorderLayout.WEST);
		frame.add(labelEast, BorderLayout.EAST);
		frame.add(textCenter,BorderLayout.CENTER);
		frame.add(labelSouth, BorderLayout.SOUTH);
		frame.pack();
 		*/
/*		//��ʽ���ֹ�����
  		FlowLayout fl = new FlowLayout(FlowLayout.CENTER,20,5);//ʵ������ʽ���ֹ�����
		frame.setLayout(fl);
		frame.add(labelNorth);
		frame.add(textWest);
		frame.add(labelEast);
		frame.add(textCenter);
		frame.add(labelSouth);
		frame.pack();
		*/
/*		//���粼�ֹ�����
		GridLayout gl = new GridLayout(2,2,3,3);
		frame.setLayout(gl);
		frame.add(labelNorth);
		frame.add(textWest);
		frame.add(labelEast);
		frame.add(textCenter);
		frame.add(labelSouth);
		frame.pack();
		*/
		//��Ƭ���ֹ�����
		Container cont = frame.getContentPane();//ȡ�ô�������������
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
