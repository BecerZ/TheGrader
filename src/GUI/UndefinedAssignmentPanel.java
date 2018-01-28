package GUI;

/*
 * Panel for UndefinedAssignment
 * @Authors: Bora Ecer, Alp Ege Basturk, Aziz Osman Kozhan, Emre Yigit Kuzhan
 * v1 26.04.2016
 * 
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
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
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Person.Student;
import Materials.ChecklistCriteria;
import Materials.UndefinedGradedAssignment;
import javax.swing.Box;
import javax.swing.JOptionPane;

public class UndefinedAssignmentPanel extends JPanel
{
	// Properties
	private int counter = 4; // Default value
	private JPanel checklistPanel;
	private String assignmentName;
	private JFrame owner;
	private UndefinedGradedAssignment clickedAssignment;
	private JLabel assignmentLabel;
	private JLabel assignmentGrade;
	private JTextField gradeInput;
	private JButton setGrade;
	private JPanel buttonsPanel;
	private JButton addCriteria;
	private JLabel textFieldLabel;

	// Constructor
	public UndefinedAssignmentPanel(JFrame owner, UndefinedGradedAssignment clickedAssignment) 
	{
		// Creating new panel
		checklistPanel = new JPanel();
		checklistPanel.setLayout(new GridLayout(3,3));
		assignmentGrade = new JLabel("Grade Of The Assignment");


		assignmentName = clickedAssignment.getName();
		assignmentLabel = new JLabel(assignmentName);

		buttonsPanel = new JPanel();
		// SetGrade button and it's actionListener
		buttonsPanel.add(assignmentLabel);
		buttonsPanel.add(assignmentGrade);
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

				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel("Enter Criteria:"));
				myPanel.add(criteriaField);
				myPanel.add(Box.createHorizontalStrut(15)); // a spacer

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						"Please Enter Criteria", JOptionPane.OK_CANCEL_OPTION);

				String criteria = "";

				if (result == JOptionPane.OK_OPTION) 
				{
					criteria = criteriaField.getText();
				}

				add(checklistPanel);
				checklistPanel.add(new JCheckBox(criteria));

				revalidate();
			}

		});



		textFieldLabel = new JLabel("Enter Grade");
		gradeInput = new JTextField(5);
		// Adding buttons & etc to the buttonsPanel
		buttonsPanel.add(textFieldLabel);
		buttonsPanel.add(gradeInput);
		buttonsPanel.add(setGrade);
		buttonsPanel.add(addCriteria);
		buttonsPanel.add(assignmentGrade);
		// Setting visibility 
		checklistPanel.setVisible(true);
		buttonsPanel.setVisible(true);
		// Adding panels
		add(buttonsPanel);
		add(checklistPanel);


	}
}



