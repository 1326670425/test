package chapter15;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;

public class Slider extends JFrame{
	int width = 400;
	int height = 280;
	JLabel choosedLabel = new JLabel("choose age:");
	JLabel choiceLabel = new JLabel("Please choose age:");
	private JTextField myTextField;
	JPanel agePanel;
	public Slider(){
		this.setTitle("ª¨øÈ≤‚ ‘");
		this.setBounds(300, 300, 300, 300);
		Container contentPane = this.getContentPane();
		AgeListener myAgeListener = new AgeListener();
		agePanel = new JPanel();
		JSlider ageSlider = new JSlider();
		ageSlider.addChangeListener(myAgeListener);
		agePanel.add(choiceLabel);
		agePanel.add(ageSlider);
		ageSlider = new JSlider(SwingConstants.VERTICAL,0,100,20);
		ageSlider.addChangeListener(myAgeListener);
		agePanel.add(ageSlider);
		JPanel textPanel = new JPanel();
		myTextField = new JTextField("",15);
		textPanel.add(choosedLabel, BorderLayout.NORTH);
		textPanel.add(myTextField, BorderLayout.CENTER);
		contentPane.add(agePanel, BorderLayout.NORTH);
		contentPane.add(textPanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private class AgeListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			JSlider sourceSlider = (JSlider)e.getSource();
			myTextField.setText(""+sourceSlider.getValue());
		}
		
	}
	public static void main(String[] args){
		new Slider();
	}
}
