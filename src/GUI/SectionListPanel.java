package GUI;

/*
 * Panel for SectionList
 * @Authors: Bora Ecer, Alp Ege Basturk, Aziz Osman Kozhan, Emre Yigit Kuzhan
 * v1 30.04.2016
 * 
 */
import Person.*;
import Materials.Course;
import Materials.Section;

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



public class SectionListPanel extends JPanel
{
	// Properties
	private JPanel sectionListPanel;
	private final JFrame owner;
	private final Course oldPage;
	private final JLabel courseLabel;
	private final String courseName;
	private final JScrollPane pane;
	private final JButton addButton;
	private final JButton removeButton;
	private final JList list;
	private DefaultListModel model;
	// Default value

	public SectionListPanel(JFrame owner, Course oldPage) 
	{
		// Init
		this.owner = owner;
		this.oldPage = oldPage;

		courseName = oldPage.getCourseName();
		courseLabel = new JLabel(courseName + "'s sections."); 

		sectionListPanel = new JPanel();
		setLayout(new BorderLayout());
		model = new DefaultListModel();
		list = new JList<>(model);
		removeButton = new JButton("Remove Section");
		addButton = new JButton("Add Section");
		pane = new JScrollPane(list);
		pane.setPreferredSize(new Dimension(200, 200));

		// List's selectionListener
		list.addListSelectionListener((ListSelectionEvent e) -> {
			if(e.getValueIsAdjusting())
			{
				JList source = (JList) e.getSource();
				Object values = source.getSelectedValue();

				Section currentSection;
				currentSection = (Section) values;


				GUI.StudentListPanel studentListPanel = new StudentListPanel( new JFrame(), currentSection);
				System.out.println(currentSection.getSectionNumber());
				sectionListPanel.setVisible(false);
				studentListPanel.setVisible(true);
				add(studentListPanel);
				repaint();
			}
		});




		// Adding actionListener to addButton.
		addButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				JTextField sectionField = new JTextField(5);


				JPanel myPanel = new JPanel();
				myPanel.add(new JLabel("Section Number:"));
				myPanel.add(sectionField);
				myPanel.add(Box.createHorizontalStrut(15)); // a spacer

				int result = JOptionPane.showConfirmDialog(null, myPanel,
						"SECTION", JOptionPane.OK_CANCEL_OPTION);

				int sectionNumber = 0;

				if (result == JOptionPane.OK_OPTION) 
				{
					sectionNumber = Integer.parseInt(sectionField.getText());
				}
				model.addElement( new Section(new ArrayList<>(), sectionNumber));

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
		// Adding buttons, label & pane to the SectionListPanel and setting the layout
		sectionListPanel.add(pane, BorderLayout.NORTH);
		sectionListPanel.add(addButton, BorderLayout.WEST);
		sectionListPanel.add(removeButton, BorderLayout.EAST);
		sectionListPanel.add(courseLabel, new BorderLayout().SOUTH);
		// Setting panel visible.
		sectionListPanel.setVisible(true);
		// adding panel.
		add(sectionListPanel);

	}
}
