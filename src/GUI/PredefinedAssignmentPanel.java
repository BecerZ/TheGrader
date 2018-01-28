package GUI;

/*
 * Panel Of PredefinedAssignment
 * @Authors: Bora Ecer, Alp Ege Basturk, Aziz Osman Kozhan, Emre Yigit Kuzhan
 * v1 30.04.2016
 * 
 */

import Materials.PredefinedCriteria;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Materials.PredefinedGradedAssignment;
import Materials.UndefinedGradedAssignment;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JOptionPane;

public class PredefinedAssignmentPanel extends JPanel
{

	private JPanel percentagePanel;
	private String assignmentName;
	private JLabel assignmentNameLabel; 
	private JFrame owner;

	private JLabel assignmentLabel;
	private JLabel assignmentGrade;
	private JButton addCriteria;
	private JPanel buttonsPanel;
	private JTextField gradeInput;
	private JButton setGrade;


	public PredefinedAssignmentPanel(JFrame owner, PredefinedGradedAssignment clickedAssignment) 
	{
		percentagePanel = new JPanel();
		percentagePanel.setLayout(new GridLayout(3,3));
		assignmentGrade = new JLabel("Grade Of The Assignment");


		assignmentName = clickedAssignment.getName();
		assignmentLabel = new JLabel(assignmentName);

		buttonsPanel = new JPanel();
		buttonsPanel.add(assignmentLabel);
		buttonsPanel.add(assignmentGrade);
		
		// SetGrade button and it's actionListener		
		setGrade = new JButton("Set Grade");
		setGrade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				assignmentGrade.setText("Grade of the assignment: " + gradeInput.getText());
			}
		});

		// AddCriteria button and it's actionListener
		addCriteria = new JButton("Add Criteria");
		addCriteria.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{

				JTextField criteriaField = new JTextField(5);
				JTextField percentageField = new JTextField(5);

				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel("Enter Criteria:"));
				myPanel.add(criteriaField);
				myPanel.add(Box.createHorizontalStrut(15)); // a spacer
				myPanel.add(new JLabel("Enter its percentage:"));
				myPanel.add(percentageField);

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						"Please Criteria and Percentage", JOptionPane.OK_CANCEL_OPTION);

				String criteria = "";
				double per = 0.0;
				if (result == JOptionPane.OK_OPTION)
				{
					//clickedAssignment = new PredefinedCriteria(criteriaField.getText(),
					//Double.parseDouble(percentageField.getText()));
					criteria = criteriaField.getText();
					per = Double.parseDouble(percentageField.getText());
				}
				add(percentagePanel);
				percentagePanel.add(new JCheckBox(criteria + " X " + per));

				revalidate();

			}
		});

		assignmentNameLabel = new JLabel("Enter Grade");
		gradeInput = new JTextField(5);
		// Adding buttons and etc to the buttonsPanel
		buttonsPanel.add(assignmentNameLabel);
		buttonsPanel.add(gradeInput);
		buttonsPanel.add(setGrade);
		buttonsPanel.add(addCriteria);
		buttonsPanel.add(assignmentGrade);
		// Setting visibility
		percentagePanel.setVisible(true);
		buttonsPanel.setVisible(true);
		// Adding the panels.
		add(buttonsPanel);
		add(percentagePanel);


	}

}


