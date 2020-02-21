package cv.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JRadioButton;



public class MainCvGui {

	private JFrame frmCvCreator;

	private File file;
	private String generatorFormat;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainCvGui window = new MainCvGui();
					window.frmCvCreator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainCvGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCvCreator = new JFrame();
		frmCvCreator.setResizable(false);
		frmCvCreator.setIconImage(Toolkit.getDefaultToolkit().getImage(MainCvGui.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		frmCvCreator.setTitle("CV Creator");
		frmCvCreator.setBounds(100, 100, 458, 271);
		frmCvCreator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JRadioButton rdFunCV = new JRadioButton("");
		rdFunCV.setEnabled(false);
		
		JRadioButton rdChrCV = new JRadioButton("");
		rdChrCV.setEnabled(false);
		
		JRadioButton rdComCV = new JRadioButton("");
		rdComCV.setEnabled(false);
		
		
		
		JLabel lblCvCreatorVersion = DefaultComponentFactory.getInstance().createTitle("CV Creator Version 1.0");
		lblCvCreatorVersion.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCvCreatorVersion.setIcon(new ImageIcon(MainCvGui.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		
		JLabel label = new JLabel("Choose the format of the CV");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnFunctionalCv = new JButton("Functional CV");
		btnFunctionalCv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdFunCV.setSelected(true);
				rdChrCV.setSelected(false);
				rdComCV.setSelected(false);
			}
		});
		
		JButton btnChronologicalCv = new JButton("Chronological CV");
		btnChronologicalCv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdFunCV.setSelected(false);
				rdChrCV.setSelected(true);
				rdComCV.setSelected(false);
			}
		});
		
		JButton btnCombinedCv = new JButton("Combined CV");
		btnCombinedCv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdFunCV.setSelected(false);
				rdChrCV.setSelected(false);
				rdComCV.setSelected(true);
			}
		});
		
		JButton btnCreateACv = new JButton("Create a CV");
		btnCreateACv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCreateACv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdFunCV.isSelected()==false && rdChrCV.isSelected()==false && rdComCV.isSelected()==false){
					JOptionPane.showMessageDialog(null, "Please choose one of the defined templates");
				}
				else if(rdFunCV.isSelected()==true){
					FunctionalCv functionalTemplates = new FunctionalCv();
					functionalTemplates.setVisible(true);
				}
				else if(rdChrCV.isSelected()==true){
					ChronologicalCv chronologicalTemplates = new ChronologicalCv();
					chronologicalTemplates.setVisible(true);
				}
				else if(rdComCV.isSelected()==true){
					CombinedCv combinedTemplates = new CombinedCv();
					combinedTemplates.setVisible(true);
				}
			}
		});
		
		JButton btnNewButton = new JButton("Open a CV");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(openFile()){
					try {
						if( recogniseTemplate()==1 ){
							FunctionalCv functionalTemplates = new FunctionalCv();
							functionalTemplates.setVisible(true);
							functionalTemplates.loadFunctional(file, generatorFormat);
						}
						else if( recogniseTemplate()==2 ){
							ChronologicalCv chronologicalTemplates = new ChronologicalCv();
							chronologicalTemplates.setVisible(true);
							chronologicalTemplates.loadChronological(file, generatorFormat);
						}
						else if( recogniseTemplate()==3 ){
							CombinedCv combinedTemplates = new CombinedCv();
							combinedTemplates.setVisible(true);
							combinedTemplates.loadCombined(file, generatorFormat);
						}
						else{
							JOptionPane.showMessageDialog(null, "Error Opening File:Wrong Format");
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		GroupLayout groupLayout = new GroupLayout(frmCvCreator.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(116)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCvCreatorVersion))
					.addContainerGap(109, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnFunctionalCv, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(42)
							.addComponent(btnChronologicalCv))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(rdFunCV)
							.addGap(131)
							.addComponent(rdChrCV)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addComponent(rdComCV))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCreateACv, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
								.addComponent(btnCombinedCv, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))))
					.addGap(40))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(lblCvCreatorVersion, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCombinedCv)
						.addComponent(btnChronologicalCv)
						.addComponent(btnFunctionalCv))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rdComCV)
									.addGap(18)
									.addComponent(btnCreateACv))
								.addComponent(rdFunCV))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton))
						.addComponent(rdChrCV))
					.addGap(15))
		);
		frmCvCreator.getContentPane().setLayout(groupLayout);
	}
	
	public boolean openFile(){
		JFileChooser filechooser = new JFileChooser();
		 
		filechooser.setCurrentDirectory(new File("."));
		int retval = filechooser.showOpenDialog(null);
		boolean open = false;
		generatorFormat = null;
		
		if(retval == JFileChooser.APPROVE_OPTION){ 
			file= filechooser.getSelectedFile();
			System.out.println(file);
			String str = file.toString();
			int i=0;
			
			for(String formatFile: str.split("\\.")){
				if(i==1){
					if(!((!(formatFile.equals("txt")) && (formatFile.equals("tex"))) || ((formatFile.equals("txt")) && !(formatFile.equals("tex"))))){
						JOptionPane.showMessageDialog(null, "Please choose the correct format, .txt or .tex");
					}
					else{
						if(formatFile.equals("txt")){
							generatorFormat = "txt";
						}
						else{
							generatorFormat = "latex";
						}
						return open = true;
					}
					System.out.println(formatFile);
				}
				i++;
			}
			if(i ==1){
				JOptionPane.showMessageDialog(null, "Error Opening File:Wrong Format \r\n Please choose the correct format, .txt or .tex");
			}
		}
		return open;
	}
	
	public int recogniseTemplate() throws FileNotFoundException{
		
		BufferedReader bReader = new BufferedReader(new FileReader(file));
		try {
			String temp = bReader.readLine();
			if(temp.equals("Functional")) {
				bReader.close();
				return 1;
			}
			else if(temp.equals("Chronological")) {
				bReader.close();
				return 2;
			}
			else if(temp.equals("Combined")) {
				bReader.close();
				return 3;
			}
			else{
				temp = bReader.readLine();
				if(temp.equals(" \\title{Functional} ")){
					bReader.close();
					return 1;
				}
				else if(temp.contains(" \\title{Chronological} ")){
					bReader.close();
					return 2;
				}
				else if(temp.contains(" \\title{Combined} ")){
					bReader.close();
					return 3;
				}
				else{
					bReader.close();
					return -1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
