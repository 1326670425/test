package chapter15;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class MyLabel{
	private JLabel aLabel;
	public MyLabel(JLabel aLabel){
		JFrame frame = new JFrame("标签案例");
		frame.setSize(400, 400);
		frame.setLocation(300, 400);
		this.aLabel = aLabel;
		frame.add(aLabel);
		frame.setVisible(true);
	}
	public void setText(String text){
		aLabel.setText(text);
	}
	public void setFont(Font font,Color fg,Color bg){
		aLabel.setFont(font);
		aLabel.setForeground(fg);
		aLabel.setBackground(bg);
	}
	public void setImage(String imageFile){
		Icon icon = new ImageIcon(imageFile);
		aLabel.setIcon(icon);
	}
}

public class Label {
	public static void main(String[] args){
		JLabel aLabel = new JLabel("标签测试",JLabel.CENTER);
		MyLabel myLabel = new MyLabel(aLabel);
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		myLabel.setText("设置文本");
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		Font font = new Font("华文行楷",Font.BOLD,20);
		myLabel.setFont(font, Color.RED, Color.YELLOW);
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		String image = "F://image.jpg";
		myLabel.setImage(image);
	}
}
