package GUI;

/*
 * 
 * Panel for StudentList
 * @Authors: Bora Ecer, Alp Ege Basturk, Aziz Osman Kozhan, Emre Yigit Kuzhan
 * v1 25.04.2016
 * 
 */
 
import GUI.AssignmentListPanel;
import Person.*;
import Materials.Section;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class StudentListPanel extends JPanel 
{

	// Properties
	private JList list;
	private DefaultListModel model;
	private JPanel studentPanel;
	private AssignmentListPanel assignmentListPanel;
	private JFrame owner;
	private Section oldPage;
	private JScrollPane pane;
	private JButton addButton;
	private JButton removeButton;
	private JLabel sectionLabel;
	private String sectionName;

	public StudentListPanel(JFrame owner, Section oldPage)
	{
		// Init
		this.owner = owner;
		this.oldPage = oldPage;
		studentPanel = new JPanel();
		setLayout(new BorderLayout());
		model = new DefaultListModel();
		list = new JList<Student>(model);
		pane = new JScrollPane(list);
		pane.setPreferredSize(new Dimension(200, 200));
		addButton = new JButton("Add Student");
		removeButton = new JButton("Remove Student");
		sectionName = " Section " + oldPage.getSectionNumber();
		sectionLabel = new JLabel("Student List of " + sectionName);
		
		// Lists selectionListener
		list.addListSelectionListener(new ListSelectionListener() 
		{
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				if(e.getValueIsAdjusting())
				{
					JList source = (JList) e.getSource();
					Object values = source.getSelectedValue();

					Student currentStudent;
					currentStudent = (Student) values;

					assignmentListPanel = new AssignmentListPanel( new JFrame(), currentStudent);
					studentPanel.setVisible(false);
					assignmentListPanel.setVisible(true);
					add(assignmentListPanel);
					repaint();
				}
			}
		});

		
		// Adding actionListener to addButton.
		addButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
                            JTextField studentNameField = new JTextField(5);
                            JTextField studentSurnameField = new JTextField(5);
                            JTextField idField = new JTextField(5);
                        
                            JPanel myPanel = new JPanel();
                            myPanel.add(new JLabel("Name:"));
                            myPanel.add(studentNameField);
                         
                            myPanel.add(new JLabel("Surname:"));
                            myPanel.add(studentSurnameField);
                           
                            myPanel.add(new JLabel("ID:"));
                            myPanel.add(idField);
                            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                           
                            int result = JOptionPane.showConfirmDialog(null, myPanel,
                                "STUDENT", JOptionPane.OK_CANCEL_OPTION);
                            
                            String studentName = "";
                            String studentSurname = "";
                            int id = 0;
                            
                            if (result == JOptionPane.OK_OPTION) 
                            {
                                studentName = studentNameField.getText();
                                studentSurname = studentSurnameField.getText();
                                id = Integer.parseInt(idField.getText());
                            }
                        
                            model.addElement(new Student(studentName, studentSurname, id));
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
                                "REMOVE STUDENT", JOptionPane.OK_CANCEL_OPTION);
                            
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
		// Adding buttons, label & pane to the StudentPanel and setting the layout
		studentPanel.add(pane, BorderLayout.NORTH);
		studentPanel.add(addButton, BorderLayout.WEST);
		studentPanel.add(removeButton, BorderLayout.EAST);
		studentPanel.add(sectionLabel, new BorderLayout().SOUTH);
		// Setting visiblity
		studentPanel.setVisible(true);
		// Adding the panel.
		add(studentPanel);
	}

}
