package GUI;
/*
 * panel of AssignmentList 
 * @Authors: Bora Ecer, Alp Ege Basturk, Aziz Osman Kozhan, Emre Yigit Kuzhan
 * v1 26.04.2016
 * 
 */
import Person.Student;
import Materials.Assignment;
import Materials.PredefinedGradedAssignment;
import Materials.UndefinedGradedAssignment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class AssignmentListPanel extends JPanel
{
	// Properties
	private JFrame owner;
	private Student x;
	private JList list;
	private DefaultListModel model;
	private JPanel assignmentPanel;
	private String studentName;
	private JLabel studentNameLabel; 
	private JButton addPredefinedButton;
	private JButton addUndefinedButton;
	private JButton removeButton;
	private JButton back;
	private JScrollPane pane;
	private int count = 1; // Default value


	// Constructor
	public AssignmentListPanel( JFrame owner, Student x)
	{
		// Init
		this.x = x;
		this.owner = owner;
	
		assignmentPanel = new JPanel();
		studentName = x.getName();
		studentNameLabel= new JLabel(studentName + " 's assignments");
		setLayout(new BorderLayout());

		model = new DefaultListModel();
		list = new JList<UndefinedGradedAssignment>(model);

		pane = new JScrollPane(list);
		pane.setPreferredSize(new Dimension(200, 200));
		addUndefinedButton = new JButton("Add Undefined");
		addPredefinedButton = new JButton("Add Predefined");
		removeButton = new JButton("Remove Assignment");
		back = new JButton("Back to the StudentList");

		// Adding ListSelectionListener, if any element on list clicked
		list.addListSelectionListener(new ListSelectionListener()
		{
			@Override
			public void valueChanged(ListSelectionEvent e) 
			{
				if(e.getValueIsAdjusting())
				{
					JList source = (JList) e.getSource();
					Object values = source.getSelectedValue();
					
					// If clicked assignment is instance of UndefinedGradedAssignment class
					if(values instanceof UndefinedGradedAssignment)
					{
				
						UndefinedGradedAssignment currentAssignment;
						currentAssignment = (UndefinedGradedAssignment) values;
						GUI.UndefinedAssignmentPanel undefinedAssignmentPanel = new UndefinedAssignmentPanel(new JFrame(), currentAssignment);
						assignmentPanel.setVisible(false);
						undefinedAssignmentPanel.setVisible(true);
						add(undefinedAssignmentPanel);
						repaint();

					}
					// If clicked assignment is instance of PredefinedGradedAssignment class
					else if (values instanceof PredefinedGradedAssignment)
					{
						
						PredefinedGradedAssignment currentAssignment;
						currentAssignment = (PredefinedGradedAssignment) values;
						GUI.PredefinedAssignmentPanel predefinedAssignmentPanel = new PredefinedAssignmentPanel(new JFrame(), currentAssignment);
						assignmentPanel.setVisible(false);
						predefinedAssignmentPanel.setVisible(true);
						add(predefinedAssignmentPanel);
						repaint();
					}

				}
			}
		});

		// Adding actionListener to addPredefinedButton.
		addPredefinedButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				model.addElement(new PredefinedGradedAssignment("Assignment " + count
                                        +" (Predefined)", 100));
				count++;
			}
		});
		// Adding actionListener to addUndefinedButton
		addUndefinedButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.addElement(new UndefinedGradedAssignment("Assignment " + count
                                        + " (Undefined)", 100));
				count++;
			}
		});

		// Adding actionListener to removeButton
		removeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
                                JTextField indexField = new JTextField(5);
                            
                        
                            JPanel myPanel = new JPanel();
                            myPanel.add(new JLabel("Enter Index to Delete:"));
                            myPanel.add(indexField);
                            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                           
                            int result = JOptionPane.showConfirmDialog(null, myPanel,
                                "REMOVE ASSIGNMENT", JOptionPane.OK_CANCEL_OPTION);
                            
                            int index = 0;
                            
                            if (result == JOptionPane.OK_OPTION) 
                            {
                                index = Integer.parseInt(indexField.getText());
                                if (model.getSize() > 0 && index >= 1)
                                {
					model.removeElementAt(index - 1);
                                }
                            }
				
			}
		});
		// Adding buttons, label and pane to the AssignmentPanel and setting layout.
		assignmentPanel.add(pane, BorderLayout.NORTH);
		assignmentPanel.add(addPredefinedButton);
		assignmentPanel.add(addUndefinedButton, BorderLayout.WEST);
		assignmentPanel.add(removeButton, BorderLayout.EAST);
		assignmentPanel.add(studentNameLabel, new BorderLayout().SOUTH);
		// Setting visibility
		assignmentPanel.setVisible(true);
		// Adding the assignmentPanel
		add(assignmentPanel);
	}

}
