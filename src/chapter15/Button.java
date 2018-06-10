package chapter15;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

class MyButton{
	private JButton aButton = null;
	private JFrame aFrame = null;
	public MyButton(JButton aButton,JFrame aFrame){
		this.aButton = aButton;
		this.aFrame = aFrame;
		aFrame.add(aButton);
		aFrame.setVisible(true);
	}
	public void setText(String text){
		aButton.setText(text);
	}
	public void setFont(Font font,Color fg,Color bg){
		aButton.setFont(font);
		aButton.setBackground(bg);
		aButton.setForeground(fg);
	}
}

public class Button {
	public static void main(String[] args){
		JFrame frame = new JFrame("按钮案例");
		frame.setSize(400, 400);
		frame.setLocation(400, 400);
		JButton aButton = new JButton("按钮测试");
		MyButton myButton = new MyButton(aButton,frame);
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		myButton.setText("修改文字");
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		Font font = new Font("华文行楷",Font.BOLD,20);
		myButton.setFont(font, Color.BLUE, Color.YELLOW);

	}
}
