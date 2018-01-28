package GUI;

/*
 * panel of CourseList
 * @Authors: Bora Ecer, Alp Ege Basturk, Aziz Osman Kozhan, Emre Yigit Kuzhan
 * v1 26.04.2016
 * 
 */
import GUI.AssignmentListPanel;
import Person.*;
import XMLEditors.XMLCourseListEditor;
import Materials.Course;
import Materials.CourseList;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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


public class CourseListPanel extends JPanel
{
	// Properties
	private final JList list;
	private DefaultListModel model;
	private JPanel courseListPanel;
	private final JScrollPane pane;
	private final JButton addButton;
	private final JButton removeButton;
	private CourseList courseList;
	private XMLCourseListEditor editor;
	private JButton importFromXML;

	// Constructor
	public CourseListPanel() 
	{
		// Init
		courseList = new CourseList(new ArrayList<Course>());
		editor = new XMLCourseListEditor(courseList);

		courseListPanel = new JPanel();
		setLayout(new BorderLayout());
		model = new DefaultListModel();
		list = new JList<>(model);
		pane = new JScrollPane(list);
		pane.setPreferredSize(new Dimension(200, 200));
		addButton = new JButton("Add Course");
		removeButton = new JButton("Remove Course");
		importFromXML= new JButton("Import");

		// Lists ActionListener
		list.addListSelectionListener((ListSelectionEvent e) -> {
			if(e.getValueIsAdjusting())
			{
				JList source = (JList) e.getSource();
				Object values = source.getSelectedValue();

				Course currentCourse;
				currentCourse = (Course) values;
				System.out.println(currentCourse.getCourseName());
				SectionListPanel sectionListPanel = new SectionListPanel( new JFrame(), currentCourse);
				courseListPanel.setVisible(false);
				sectionListPanel.setVisible(true);
				add(sectionListPanel);
				repaint();
			}
		});

		// Adding actionListener to addButton.
		addButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JTextField criteriaField = new JTextField(5);


				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel("Enter Course Name:"));
				myPanel.add(criteriaField);
				myPanel.add(Box.createHorizontalStrut(15)); // a spacer

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						"COURSE", JOptionPane.OK_CANCEL_OPTION);

				String courseName = "";

				if (result == JOptionPane.OK_OPTION) 
				{
					courseName = criteriaField.getText();
				}
				// Creating new course with given name
				Course course = new Course(courseName);
				// Adding it to the courseList and model
				courseList.addCourse(course);
				model.addElement(course);
				// Updating the XML.
				editor.saveToXML();
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
						"REMOVE COURSE", JOptionPane.OK_CANCEL_OPTION);

				int index = 0;


				if (result == JOptionPane.OK_OPTION) 
				{
					index = Integer.parseInt(indexField.getText());
					if (model.getSize() > 0 && index >= 1)
					{
						// Removing given courseName from model
						String courseName;
						courseName = model.getElementAt(index -1).toString();
						model.removeElementAt(index - 1);
						// Removing the given course from CourseList
						courseList.removeCourse(courseName);
						// Updating the XML file
						editor.saveToXML();

					}
				}
			}
		});
		// Adding ActionListener to ImportFromXML button
		importFromXML.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// gets input from the XML file, and sets it to the current courseList
				courseList = editor.inputFromXML();
				// adds all the elements of the courseList to model
				for(int i = 0; i< courseList.getCourses().size(); i++)
				{
					model.addElement(courseList.getCourses().get(i));
					repaint();
				}
			}
		});
		// Adding buttons, label & pane to the CourseListPanel and setting the layout
		courseListPanel.add(pane, BorderLayout.NORTH);
		courseListPanel.add(addButton, BorderLayout.SOUTH);
		courseListPanel.add(removeButton, BorderLayout.SOUTH);
		courseListPanel.add(importFromXML, BorderLayout.SOUTH);
		// Sets visiblity.
		courseListPanel.setVisible(true);
		// Adding courseListPanel
		add(courseListPanel);
	}


}
