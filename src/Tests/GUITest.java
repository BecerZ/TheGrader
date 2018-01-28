package Tests;

/*
 * GUI test for GUI classes
 * @Authors: Bora Ecer
 * v1 26.04.2016
 * 
 */

import javax.swing.JFrame;

import GUI.*;

public class GUITest
{
	public static void main(String s[])
	{
		JFrame frame = new JFrame("The Grader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new CourseListPanel());
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
