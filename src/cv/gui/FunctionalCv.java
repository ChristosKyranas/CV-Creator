package cv.gui;

import cv.generators.GeneratorFactory;
import cv.generators.IGenerator;
import cv.main.Cv;
import cv.main.CvFactory;
import cv.main.Section;
import cv.main.SectionFactory;
import cv.parsers.IParser;
import cv.parsers.ParserFactory;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FunctionalCv extends JFrame {

	private static JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddr;
	private JTextField txtTelHome;
	private JTextField txtTelMob;
	private JTextField txtEmail;
	private JTextField txtSkiAndExpOn;
	private JTextField txtInfo;
	private JTextField txtCmpNameCarSum;
	private JTextField txtJobTitlCarSum;
	private JTextField txtQualEduAndTrain;
	private JTextField txtEstaEduAndTrain;
	private JTextField txtLocEduAndTrain;
	private JTextField txtEstaFurCour;
	private JTextField txtCourFurCour;
	private JTextField txtLocFurCour;
	
	private JOptionPane fmtTxtDateFurCour1;
	private JOptionPane fmtTxtDateFurCour2;
	
	private JTextArea txtProProf;
	private JTextArea txtAddInfo;
	private JTextArea txtInter;
	
	private JList lstSkiAndExp;
	private JList lstInfo;
	private JList lstCarSum;
	private JList lstEduAndTrain;
	private JList lstFurCour;
	private ModelListManager modelListManager;
	private DefaultListModel skillArrayModelList;
	private DefaultListModel skillModelList;
	private DefaultListModel careerModelList;
	private DefaultListModel EducationModelList;
	private DefaultListModel FurtherModelList;
	
	private CvFactory cvFactory;
	private SectionFactory sectionFactory;
	private String type = "Functional";
	private Cv functional;
	private Section professionalProfile;
	private Section skillAndExperience;
	private Section careerSummary;
	private Section educationAndTraining;
	private Section furtherCourses;
	private Section additionalInformation;
	private Section interests;
	
	private GeneratorFactory generatorFactory;
	private IGenerator generator;
	private ParserFactory parserFactory;
	private IParser parser;
	private File file;
	private String generatorFormat;
	
	
	/**
	 * Create the frame.
	 */
	public FunctionalCv() {
		setResizable(false);
		setTitle("Functional CV Template");
		setBounds(100, 100, 875, 961);
		
		contentPane = new JPanel();
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(null);
		
		contentPane.setPreferredSize(new Dimension(800, 1100));
		JScrollPane jScrollPane = new JScrollPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("1. General Information");
		lblNewLabel.setBounds(10, 11, 203, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(10, 36, 107, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 61, 107, 14);
		contentPane.add(lblAddress);
		
		JLabel lblTelephonehome = new JLabel("Telephone:(Home)");
		lblTelephonehome.setBounds(10, 86, 107, 14);
		contentPane.add(lblTelephonehome);
		
		txtName = new JTextField();
		txtName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtName.setBounds(127, 33, 142, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAddr = new JTextField();
		txtAddr.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAddr.setBounds(127, 58, 142, 20);
		contentPane.add(txtAddr);
		txtAddr.setColumns(10);
		
		txtTelHome = new JTextField();
		txtTelHome.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtTelHome.setBounds(127, 83, 142, 20);
		contentPane.add(txtTelHome);
		txtTelHome.setColumns(10);
		
		JLabel lblmobile = new JLabel("(Mobile)");
		lblmobile.setBounds(305, 86, 46, 14);
		contentPane.add(lblmobile);
		
		txtTelMob = new JTextField();
		txtTelMob.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtTelMob.setBounds(361, 83, 134, 20);
		contentPane.add(txtTelMob);
		txtTelMob.setColumns(10);
		
		txtTelHome.addKeyListener(new KeyAdapter() {			
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)){
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		
		txtTelMob.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)){
					getToolkit().beep();
					arg0.consume();
				}
			}
		});		
				
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 111, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEmail.setBounds(127, 108, 142, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblProfessionalProfile = new JLabel("2. Professional Profile");
		lblProfessionalProfile.setBounds(10, 136, 203, 14);
		contentPane.add(lblProfessionalProfile);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 161, 485, 83);
		contentPane.add(scrollPane);
		
		txtProProf = new JTextArea();
		txtProProf.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(txtProProf);
		
		JLabel lblSkillsAnd = new JLabel("3. Skills And Experience");
		lblSkillsAnd.setBounds(10, 255, 203, 14);
		contentPane.add(lblSkillsAnd);
		
		JLabel lblSkillsAndExperience = new JLabel("Skills And Experience On:");
		lblSkillsAndExperience.setBounds(13, 284, 151, 14);
		contentPane.add(lblSkillsAndExperience);
		
		txtSkiAndExpOn = new JTextField();
		txtSkiAndExpOn.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtSkiAndExpOn.setBounds(174, 281, 321, 20);
		contentPane.add(txtSkiAndExpOn);
		txtSkiAndExpOn.setColumns(10);
		
		txtInfo = new JTextField();
		txtInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtInfo.setBounds(174, 310, 321, 20);
		contentPane.add(txtInfo);
		txtInfo.setColumns(10);
		
		JLabel lblCareerSummary = new JLabel("4. Career Summary");
		lblCareerSummary.setBounds(10, 431, 203, 14);
		contentPane.add(lblCareerSummary);
		
		JLabel lblCompanyName = new JLabel("Company Name:");
		lblCompanyName.setBounds(10, 459, 142, 14);
		contentPane.add(lblCompanyName);
		
		JLabel lblJobTitle = new JLabel("Job Title:");
		lblJobTitle.setBounds(10, 484, 142, 14);
		contentPane.add(lblJobTitle);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(10, 509, 142, 14);
		contentPane.add(lblDate);
		
		txtCmpNameCarSum = new JTextField();
		txtCmpNameCarSum.setColumns(10);
		txtCmpNameCarSum.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCmpNameCarSum.setBounds(162, 456, 174, 20);
		contentPane.add(txtCmpNameCarSum);
		
		txtJobTitlCarSum = new JTextField();
		txtJobTitlCarSum.setColumns(10);
		txtJobTitlCarSum.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtJobTitlCarSum.setBounds(162, 481, 174, 20);
		contentPane.add(txtJobTitlCarSum);
		
		JLabel lblEducationAnd = new JLabel("5. Education And Training");
		lblEducationAnd.setBounds(10, 571, 203, 14);
		contentPane.add(lblEducationAnd);
		
		JLabel lblQualification = new JLabel("Qualification:");
		lblQualification.setBounds(10, 599, 142, 14);
		contentPane.add(lblQualification);
		
		txtQualEduAndTrain = new JTextField();
		txtQualEduAndTrain.setColumns(10);
		txtQualEduAndTrain.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtQualEduAndTrain.setBounds(162, 596, 174, 20);
		contentPane.add(txtQualEduAndTrain);
		
		txtEstaEduAndTrain = new JTextField();
		txtEstaEduAndTrain.setColumns(10);
		txtEstaEduAndTrain.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEstaEduAndTrain.setBounds(162, 621, 174, 20);
		contentPane.add(txtEstaEduAndTrain);
		
		JLabel lblEstablishment = new JLabel("Establishment:");
		lblEstablishment.setBounds(10, 624, 142, 14);
		contentPane.add(lblEstablishment);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(10, 649, 142, 14);
		contentPane.add(lblLocation);
		
		txtLocEduAndTrain = new JTextField();
		txtLocEduAndTrain.setColumns(10);
		txtLocEduAndTrain.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtLocEduAndTrain.setBounds(162, 646, 174, 20);
		contentPane.add(txtLocEduAndTrain);
		
		JLabel label_3 = new JLabel("Date:");
		label_3.setBounds(10, 677, 142, 14);
		contentPane.add(label_3);
		
		JLabel lblFurtherCourses = new JLabel("6. Further Courses");
		lblFurtherCourses.setBounds(10, 702, 154, 14);
		contentPane.add(lblFurtherCourses);
		
		JLabel lblCourses = new JLabel("Courses:");
		lblCourses.setBounds(10, 730, 142, 14);
		contentPane.add(lblCourses);
		
		JLabel lblEstablishment_1 = new JLabel("Establishment");
		lblEstablishment_1.setBounds(10, 755, 142, 14);
		contentPane.add(lblEstablishment_1);
		
		txtEstaFurCour = new JTextField();
		txtEstaFurCour.setColumns(10);
		txtEstaFurCour.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEstaFurCour.setBounds(162, 752, 174, 20);
		contentPane.add(txtEstaFurCour);
		
		txtCourFurCour = new JTextField();
		txtCourFurCour.setColumns(10);
		txtCourFurCour.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCourFurCour.setBounds(162, 727, 174, 20);
		contentPane.add(txtCourFurCour);
		
		txtLocFurCour = new JTextField();
		txtLocFurCour.setColumns(10);
		txtLocFurCour.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtLocFurCour.setBounds(162, 777, 174, 20);
		contentPane.add(txtLocFurCour);
		
		JLabel lblLocation_1 = new JLabel("Location:");
		lblLocation_1.setBounds(10, 780, 142, 14);
		contentPane.add(lblLocation_1);

		JLabel label_4 = new JLabel("Date:");
		label_4.setBounds(10, 808, 142, 14);
		contentPane.add(label_4);
		
		JLabel lblAdditionalInformation = new JLabel("7. Additional Information");
		lblAdditionalInformation.setBounds(10, 833, 203, 14);
		contentPane.add(lblAdditionalInformation);
		
		txtAddInfo = new JTextArea();
		txtAddInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAddInfo.setBounds(11, 859, 483, 81);
		contentPane.add(txtAddInfo);
		
		JLabel lblInterest = new JLabel("8. Interests");
		lblInterest.setBounds(11, 951, 203, 14);
		contentPane.add(lblInterest);
		
		txtInter = new JTextArea();
		txtInter.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtInter.setBounds(12, 977, 483, 81);
		contentPane.add(txtInter);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(622, 456, 367, 91);
		contentPane.add(scrollPane_1);
		
		lstCarSum = new JList();
		lstCarSum.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_1.setViewportView(lstCarSum);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(174, 341, 321, 83);
		contentPane.add(scrollPane_2);
		
		lstInfo = new JList();
		lstInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_2.setViewportView(lstInfo);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(622, 281, 368, 91);
		contentPane.add(scrollPane_3);
		
		lstSkiAndExp = new JList();
		lstSkiAndExp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_3.setViewportView(lstSkiAndExp);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(622, 596, 368, 91);
		contentPane.add(scrollPane_4);
		
		lstEduAndTrain = new JList();
		lstEduAndTrain.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_4.setViewportView(lstEduAndTrain);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(622, 730, 367, 91);
		contentPane.add(scrollPane_5);
		
		lstFurCour = new JList();
		lstFurCour.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_5.setViewportView(lstFurCour);
		
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    getContentPane().add(jScrollPane);
	    setSize(1050, 800);
	    
	    JMenuBar menuBar = new JMenuBar();
	    setJMenuBar(menuBar);
	    
	    MaskFormatter formatter = new TimeFormatter(); 
	    formatter.setValueClass(java.util.Date.class);
	    
		JFormattedTextField fmtTxtDateCarSum1 = new JFormattedTextField(formatter);
		fmtTxtDateCarSum1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fmtTxtDateCarSum1.setValue(new Date()); 
		fmtTxtDateCarSum1.setBounds(162, 506, 75, 23);
		contentPane.add(fmtTxtDateCarSum1);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setBounds(247, 509, 15, 14);
		contentPane.add(lblTo);
		
		JFormattedTextField fmtTxtDateCarSum2 = new JFormattedTextField(formatter);
		fmtTxtDateCarSum2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fmtTxtDateCarSum2.setValue(new Date()); 
		fmtTxtDateCarSum2.setBounds(261, 506, 75, 23);
		contentPane.add(fmtTxtDateCarSum2);
	
		JFormattedTextField fmtTxtDateEduAndTrain1 = new JFormattedTextField(formatter);
		fmtTxtDateEduAndTrain1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fmtTxtDateEduAndTrain1.setValue(new Date());
		fmtTxtDateEduAndTrain1.setBounds(162, 668, 75, 23);
		contentPane.add(fmtTxtDateEduAndTrain1);
		
		JLabel label = new JLabel("to");
		label.setBounds(247, 671, 15, 14);
		contentPane.add(label);
		
		JFormattedTextField fmtTxtDateEduAndTrain2 = new JFormattedTextField(formatter);
		fmtTxtDateEduAndTrain2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fmtTxtDateEduAndTrain2.setValue(new Date());
		fmtTxtDateEduAndTrain2.setBounds(261, 668, 75, 23);
		contentPane.add(fmtTxtDateEduAndTrain2);
		
		JFormattedTextField fmtTxtDateFurCour1 = new JFormattedTextField(formatter);
		fmtTxtDateFurCour1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fmtTxtDateFurCour1.setValue(new Date());
		fmtTxtDateFurCour1.setBounds(162, 799, 75, 23);
		contentPane.add(fmtTxtDateFurCour1);
		
		JLabel label_1 = new JLabel("to");
		label_1.setBounds(247, 802, 15, 14);
		contentPane.add(label_1);
		
		JFormattedTextField fmtTxtDateFurCour2 = new JFormattedTextField(formatter);
		fmtTxtDateFurCour2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fmtTxtDateFurCour2.setValue(new Date());
		fmtTxtDateFurCour2.setBounds(261, 799, 75, 23);
		contentPane.add(fmtTxtDateFurCour2);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////1. General Information 2. Professional Profile 7. Additional Information 8. Interests/////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		cvFactory = new CvFactory();
		functional = cvFactory.constructCv(type);
		sectionFactory = new SectionFactory();
	    professionalProfile = sectionFactory.constructSection("2. Professional Profile");
	    functional.add(professionalProfile);
	    skillAndExperience = sectionFactory.constructSection("3. Skills And Experience");
	    functional.add(skillAndExperience);
		careerSummary = sectionFactory.constructSection("4. Career Summary");
		functional.add(careerSummary);
		educationAndTraining = sectionFactory.constructSection("5. Education And Training");
		functional.add(educationAndTraining);
		furtherCourses = sectionFactory.constructSection("6. Further Courses");
		functional.add(furtherCourses);
		additionalInformation = sectionFactory.constructSection("7. Additional Information");
		functional.add(additionalInformation);
		interests = sectionFactory.constructSection("8. Interests");
		functional.add(interests);	
		
		modelListManager = new ModelListManager();
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////3. Skills And Experience///////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		skillModelList = new DefaultListModel();
		skillArrayModelList = new DefaultListModel();
		
		lstInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					txtInfo.setText(lstInfo.getSelectedValue().toString());
				}catch(NullPointerException e){
					JOptionPane.showMessageDialog(null, "Not selected infomation to display!!!");
				}
			}
		});
		
		lstSkiAndExp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					int index = lstSkiAndExp.getSelectedIndex();
					txtSkiAndExpOn.setText(skillAndExperience.getBulletListInPosition(index).getSkillAndExperienceOn());
					lstInfo.setModel(modelListManager.displayList(skillModelList, skillAndExperience, index));
				}catch(ArrayIndexOutOfBoundsException e){
					JOptionPane.showMessageDialog(null, "Not selected skill and experience to display!!!");
				}
			}
		});
	 
		JButton btnAddInfo = new JButton("Add Information");
		btnAddInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(skillAndExperience.getSizeArrayBulletList() == 0){
					skillAndExperience.setItem(txtInfo.getText());
					skillAndExperience.addItem();
					txtInfo.setText("");
					lstInfo.setModel(modelListManager.addModelList(skillModelList, skillAndExperience));
				}else if(lstSkiAndExp.getSelectedIndex()<0){
					skillAndExperience.setItem(txtInfo.getText());
					skillAndExperience.addItem();
					txtInfo.setText("");
					lstInfo.setModel(modelListManager.addModelList(skillModelList, skillAndExperience));
				}else{
					skillAndExperience.setItem(txtInfo.getText());
					skillAndExperience.addItem(lstSkiAndExp.getSelectedIndex());
					txtInfo.setText("");
					lstInfo.setModel(modelListManager.addModelList(skillModelList, skillAndExperience));
				}
			}
		});

		btnAddInfo.setBounds(10, 309, 154, 23);
		contentPane.add(btnAddInfo);
		
		JButton btnDltInfo = new JButton("Delete Information");
		btnDltInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{	
					if(lstSkiAndExp.getModel().getSize() == 0){
						skillAndExperience.deleteItem(lstInfo.getSelectedIndex());
						modelListManager.deleteModelList(skillModelList,lstInfo.getSelectedIndex());
						txtInfo.setText("");
					}else{
						skillAndExperience.deleteItem(lstSkiAndExp.getSelectedIndex(), lstInfo.getSelectedIndex());
						modelListManager.deleteModelList(skillModelList,lstInfo.getSelectedIndex());
						txtInfo.setText("");
					}
				}catch(NullPointerException e){
					JOptionPane.showMessageDialog(null, "Not selected information to delete!!!");
				}
			}
		});
		btnDltInfo.setBounds(10, 340, 154, 23);
		contentPane.add(btnDltInfo);
		
		JButton btnUpdInfo = new JButton("Update Information");
		btnUpdInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(lstSkiAndExp.getModel().getSize() == 0){
						skillAndExperience.setItem(txtInfo.getText(),lstInfo.getSelectedIndex());
						txtInfo.setText("");
						lstInfo.setModel(modelListManager.setModelList(skillModelList, skillAndExperience, lstInfo.getSelectedIndex()));
					}else{
						skillAndExperience.setItem(txtInfo.getText(),lstInfo.getSelectedIndex(),lstSkiAndExp.getSelectedIndex());
						txtInfo.setText("");
						lstInfo.setModel(modelListManager.setModelList(skillModelList,skillAndExperience,lstSkiAndExp.getSelectedIndex(),lstInfo.getSelectedIndex()));
					}
				}catch(NullPointerException e){
					JOptionPane.showMessageDialog(null, "Not selected information to update!!!");
				}
			}
		});
		btnUpdInfo.setBounds(10, 374, 154, 23);
		contentPane.add(btnUpdInfo);
		
		JButton btnAddSkiAndExp = new JButton("Add");
		btnAddSkiAndExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				skillAndExperience.setBulletList(txtSkiAndExpOn.getText());
				skillAndExperience.addBulletList();
				txtSkiAndExpOn.setText("");
				txtInfo.setText("");
				lstSkiAndExp.setModel(modelListManager.addArrayModelList(skillArrayModelList,skillAndExperience));
				modelListManager.clearModelList(skillModelList);
			}
		});
		btnAddSkiAndExp.setBounds(505, 281, 89, 23);
		contentPane.add(btnAddSkiAndExp);
		
		JButton btnDltSkiAndExp = new JButton("Delete");
		btnDltSkiAndExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					skillAndExperience.deleteBulletList(lstSkiAndExp.getSelectedIndex());
					modelListManager.deleteArrayModelList(skillArrayModelList,lstSkiAndExp.getSelectedIndex());
					txtSkiAndExpOn.setText("");
					txtInfo.setText("");
					modelListManager.clearModelList(skillModelList);
				}catch(ArrayIndexOutOfBoundsException e){
					JOptionPane.showMessageDialog(null, "Not selected skill and experience to delete!!!");
				}
			}
		});
			
		btnDltSkiAndExp.setBounds(505, 315, 89, 23);
		contentPane.add(btnDltSkiAndExp);
		
		JButton btnUpdSkiAndExp = new JButton("Update");
		btnUpdSkiAndExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{			
					skillAndExperience.setBulletList(lstSkiAndExp.getSelectedIndex(), txtSkiAndExpOn.getText());
					txtSkiAndExpOn.setText("");
					txtInfo.setText("");
					lstSkiAndExp.setModel(modelListManager.setArrayModelList(skillArrayModelList, skillAndExperience, lstSkiAndExp.getSelectedIndex()));
					modelListManager.clearModelList(skillModelList);
				}catch(ArrayIndexOutOfBoundsException e){
					JOptionPane.showMessageDialog(null, "Not selected skill and experience to update!!!");
				}
			}
		});
		btnUpdSkiAndExp.setBounds(505, 349, 89, 23);
		contentPane.add(btnUpdSkiAndExp);
		
	    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    ///////////////////////////////////////////4. Career Summary///////////////////////////////////////////////////////////
	    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		careerModelList = new DefaultListModel();
		
		lstCarSum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					int index = lstCarSum.getSelectedIndex();
					txtCmpNameCarSum.setText(careerSummary.getItemInPosition(index).getCompanyName());
					txtJobTitlCarSum.setText(careerSummary.getItemInPosition(index).getJobTitle());
					fmtTxtDateCarSum1.setValue(new Date(fixDate(careerSummary.getItemInPosition(index).getDate1())));
					fmtTxtDateCarSum2.setValue(new Date(fixDate(careerSummary.getItemInPosition(index).getDate2())));
				}catch(ArrayIndexOutOfBoundsException e){
					JOptionPane.showMessageDialog(null, "Not selected career summary to display!!!");
				}
			}
		});
	    
		JButton btnAddCarSum = new JButton("Add");
		btnAddCarSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modelListManager.checkDates(fmtTxtDateCarSum1.getText(), fmtTxtDateCarSum2.getText())){
					careerSummary.setItem(txtCmpNameCarSum.getText(), txtJobTitlCarSum.getText(), fmtTxtDateCarSum1.getText(),fmtTxtDateCarSum2.getText());
					careerSummary.addItem();
					lstCarSum.setModel(modelListManager.addModelList(careerModelList,careerSummary));
					txtCmpNameCarSum.setText("");
					txtJobTitlCarSum.setText("");
					fmtTxtDateCarSum1.setValue(new Date());
					fmtTxtDateCarSum2.setValue(new Date());
					modelListManager.orderDates(careerModelList, careerSummary);
				}
			}
		});
		btnAddCarSum.setBounds(505, 456, 89, 23);
		contentPane.add(btnAddCarSum);
	    
		JButton btnDltCarSum = new JButton("Delete");
		btnDltCarSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				careerSummary.deleteItem(lstCarSum.getSelectedIndex());
				modelListManager.deleteModelList(careerModelList,lstCarSum.getSelectedIndex());
				txtCmpNameCarSum.setText("");
				txtJobTitlCarSum.setText("");
				fmtTxtDateCarSum1.setValue(new Date());
				fmtTxtDateCarSum2.setValue(new Date());
				modelListManager.orderDates(careerModelList, careerSummary);
			}
		});
		btnDltCarSum.setBounds(505, 490, 89, 23);
		contentPane.add(btnDltCarSum);
		
		JButton btnUpdCarSum = new JButton("Update");
		btnUpdCarSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modelListManager.checkDates(fmtTxtDateCarSum1.getText(), fmtTxtDateCarSum2.getText())){
					careerSummary.deleteItem(lstCarSum.getSelectedIndex());
					modelListManager.deleteModelList(careerModelList,lstCarSum.getSelectedIndex());
					careerSummary.setItem(txtCmpNameCarSum.getText(), txtJobTitlCarSum.getText(), fmtTxtDateCarSum1.getText(),fmtTxtDateCarSum2.getText());
					careerSummary.addItem();
					lstCarSum.setModel(modelListManager.addModelList(careerModelList,careerSummary));
					txtCmpNameCarSum.setText("");
					txtJobTitlCarSum.setText("");
					fmtTxtDateCarSum1.setValue(new Date());
					fmtTxtDateCarSum2.setValue(new Date());
					modelListManager.orderDates(careerModelList, careerSummary);
				}
			}
		});
		btnUpdCarSum.setBounds(505, 524, 89, 23);
		contentPane.add(btnUpdCarSum);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    ///////////////////////////////////////////5. Education And Training///////////////////////////////////////////////////
	    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		EducationModelList = new DefaultListModel();
		
		lstEduAndTrain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					int index = lstEduAndTrain.getSelectedIndex();
					txtQualEduAndTrain.setText(educationAndTraining.getItemInPosition(index).getQualOrCourse());
					txtEstaEduAndTrain.setText(educationAndTraining.getItemInPosition(index).getEstablishment());
					txtLocEduAndTrain.setText(educationAndTraining.getItemInPosition(index).getLocation());
					fmtTxtDateEduAndTrain1.setValue(new Date(fixDate(educationAndTraining.getItemInPosition(index).getDate1())));
					fmtTxtDateEduAndTrain2.setValue(new Date(fixDate(educationAndTraining.getItemInPosition(index).getDate2())));
					
				}catch(ArrayIndexOutOfBoundsException e){
					JOptionPane.showMessageDialog(null, "Not selected education and training to display!!!");
				}
			}
		});
		
		JButton btnAddEduAndTrain = new JButton("Add");
		btnAddEduAndTrain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modelListManager.checkDates(fmtTxtDateEduAndTrain1.getText(), fmtTxtDateEduAndTrain2.getText())){
					educationAndTraining.setItem(txtQualEduAndTrain.getText(), txtEstaEduAndTrain.getText(),txtLocEduAndTrain.getText(), fmtTxtDateEduAndTrain1.getText(),fmtTxtDateEduAndTrain2.getText());
					educationAndTraining.addItem();
					lstEduAndTrain.setModel(modelListManager.addModelList(EducationModelList, educationAndTraining));
					txtQualEduAndTrain.setText("");
					txtEstaEduAndTrain.setText("");
					txtLocEduAndTrain.setText("");
					fmtTxtDateEduAndTrain1.setValue(new Date());
					fmtTxtDateEduAndTrain2.setValue(new Date());
					modelListManager.orderDates(EducationModelList, educationAndTraining);
				}
			}
		});
		btnAddEduAndTrain.setBounds(505, 596, 89, 23);
		contentPane.add(btnAddEduAndTrain);
		
		JButton btnDltEduAndTrain = new JButton("Delete");
		btnDltEduAndTrain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				educationAndTraining.deleteItem(lstEduAndTrain.getSelectedIndex());
				modelListManager.deleteModelList(EducationModelList,lstEduAndTrain.getSelectedIndex());
				txtQualEduAndTrain.setText("");
				txtEstaEduAndTrain.setText("");
				txtLocEduAndTrain.setText("");
				fmtTxtDateEduAndTrain1.setValue(new Date());
				fmtTxtDateEduAndTrain2.setValue(new Date());
				modelListManager.orderDates(EducationModelList, educationAndTraining);
			}
		});
		btnDltEduAndTrain.setBounds(505, 630, 89, 23);
		contentPane.add(btnDltEduAndTrain);
		
		JButton btnUpdEduAndTrain = new JButton("Update");
		btnUpdEduAndTrain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modelListManager.checkDates(fmtTxtDateEduAndTrain1.getText(), fmtTxtDateEduAndTrain2.getText())){
					educationAndTraining.deleteItem(lstEduAndTrain.getSelectedIndex());
					modelListManager.deleteModelList(EducationModelList,lstEduAndTrain.getSelectedIndex());
					educationAndTraining.setItem(txtQualEduAndTrain.getText(), txtEstaEduAndTrain.getText(),txtLocEduAndTrain.getText(), fmtTxtDateEduAndTrain1.getText(),fmtTxtDateEduAndTrain2.getText());
					educationAndTraining.addItem();
					lstEduAndTrain.setModel(modelListManager.addModelList(EducationModelList, educationAndTraining));
					txtQualEduAndTrain.setText("");
					txtEstaEduAndTrain.setText("");
					txtLocEduAndTrain.setText("");
					fmtTxtDateEduAndTrain1.setValue(new Date());
					fmtTxtDateEduAndTrain2.setValue(new Date());
					modelListManager.orderDates(EducationModelList, educationAndTraining);
				}
			}
		});
		btnUpdEduAndTrain.setBounds(505, 664, 89, 23);
		contentPane.add(btnUpdEduAndTrain);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////6. Further Courses//////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		FurtherModelList = new DefaultListModel();
		
		lstFurCour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					int index = lstFurCour.getSelectedIndex();
					txtCourFurCour.setText(furtherCourses.getItemInPosition(index).getQualOrCourse());
					txtEstaFurCour.setText(furtherCourses.getItemInPosition(index).getEstablishment());
					txtLocFurCour.setText(furtherCourses.getItemInPosition(index).getLocation());
					fmtTxtDateFurCour1.setValue(new Date(fixDate(furtherCourses.getItemInPosition(index).getDate1())));
					fmtTxtDateFurCour2.setValue(new Date(fixDate(furtherCourses.getItemInPosition(index).getDate2())));
				}catch(ArrayIndexOutOfBoundsException e){
					JOptionPane.showMessageDialog(null, "Not selected further courses to display!!!");
				}
			}
		});
		
		JButton btnAddFurCour = new JButton("Add");
		btnAddFurCour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modelListManager.checkDates(fmtTxtDateEduAndTrain1.getText(), fmtTxtDateEduAndTrain2.getText())){
					furtherCourses.setItem(txtCourFurCour.getText(), txtEstaFurCour.getText(),txtLocFurCour.getText(), fmtTxtDateFurCour1.getText(),fmtTxtDateFurCour2.getText());
					furtherCourses.addItem();
					lstFurCour.setModel(modelListManager.addModelList(FurtherModelList, furtherCourses));
					txtCourFurCour.setText("");
					txtEstaFurCour.setText("");
					txtLocFurCour.setText("");
					fmtTxtDateFurCour1.setValue(new Date());
					fmtTxtDateFurCour2.setValue(new Date());
					modelListManager.orderDates(FurtherModelList, furtherCourses);
				}
			}
		});
		btnAddFurCour.setBounds(505, 727, 89, 23);
		contentPane.add(btnAddFurCour);
		
		JButton btnDltFurCour = new JButton("Delete");
		btnDltFurCour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				furtherCourses.deleteItem(lstFurCour.getSelectedIndex());
				modelListManager.deleteModelList(FurtherModelList,lstFurCour.getSelectedIndex());
				txtCourFurCour.setText("");
				txtEstaFurCour.setText("");
				txtLocFurCour.setText("");
				fmtTxtDateFurCour1.setValue(new Date());
				fmtTxtDateFurCour2.setValue(new Date());
				modelListManager.orderDates(FurtherModelList, furtherCourses);
			}
		});
		btnDltFurCour.setBounds(505, 761, 89, 23);
		contentPane.add(btnDltFurCour);
		
		JButton btnUpdFurCour = new JButton("Update");
		btnUpdFurCour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modelListManager.checkDates(fmtTxtDateEduAndTrain1.getText(), fmtTxtDateEduAndTrain2.getText())){
					furtherCourses.deleteItem(lstFurCour.getSelectedIndex());
					modelListManager.deleteModelList(FurtherModelList,lstFurCour.getSelectedIndex());
					furtherCourses.setItem(txtCourFurCour.getText(), txtEstaFurCour.getText(),txtLocFurCour.getText(), fmtTxtDateFurCour1.getText(),fmtTxtDateFurCour2.getText());
					furtherCourses.addItem();
					lstFurCour.setModel(modelListManager.addModelList(FurtherModelList, furtherCourses));
					txtCourFurCour.setText("");
					txtEstaFurCour.setText("");
					txtLocFurCour.setText("");
					fmtTxtDateFurCour1.setValue(new Date());
					fmtTxtDateFurCour2.setValue(new Date());
					modelListManager.orderDates(FurtherModelList, furtherCourses);
				}
			}
		});
		btnUpdFurCour.setBounds(505, 795, 89, 23);
		contentPane.add(btnUpdFurCour);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////Save////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JButton btnSave = new JButton("Save");
	    btnSave.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		functional.setName(txtName.getText());
	    		functional.setAddress(txtAddr.getText());
	    		functional.setTelHome(txtTelHome.getText());
	    		functional.setTelMobile(txtTelMob.getText());
	    		functional.setEmail(txtEmail.getText());
	    		professionalProfile.setParagraph(txtProProf.getText());
	    		additionalInformation.setParagraph(txtAddInfo.getText());
	    		interests.setParagraph(txtInter.getText());
	    		if(createDoc()){
	    			generatorFactory= new GeneratorFactory();
	    			if(generatorFormat.equals("txt")){
	    				generator = generatorFactory.constructGenerator(generatorFormat);
	    				generator.saveGeneralInformation(file, functional);
	    				generator.saveParagraph(file,professionalProfile);
	    				generator.saveSkillAndExperience(file,skillAndExperience);
	    				generator.saveCareerSummary(file, careerSummary);
	    				generator.saveEducationOrCourses(file, educationAndTraining);
	    				generator.saveEducationOrCourses(file, furtherCourses);
	    				generator.saveParagraph(file, additionalInformation);
	    				generator.saveParagraph(file,interests);
	    			}else if(generatorFormat.equals("latex")){
	    				generator = generatorFactory.constructGenerator(generatorFormat);
	    				generator.saveGeneralInformation(file, functional);
	    				generator.saveParagraph(file, professionalProfile);
	    				generator.saveSkillAndExperience(file, skillAndExperience);
	    				generator.saveCareerSummary(file, careerSummary);
	    				generator.saveEducationOrCourses(file, educationAndTraining);
	    				generator.saveEducationOrCourses(file, furtherCourses);
	    				generator.saveParagraph(file, additionalInformation);
	    				generator.saveParagraph(file, interests);
	    			}else{
	    				JOptionPane.showMessageDialog(null, "Error!!");
	    			}
	    		}
	    	}
	    });
	    menuBar.add(btnSave);
	}
	
	public class TimeFormatter extends MaskFormatter {
		  public TimeFormatter() {
		    try {
		      setMask("##/##/####");
		      setPlaceholderCharacter('0');
		      setAllowsInvalid(false);
		      setOverwriteMode(true);
		    } catch (ParseException e) {
		      e.printStackTrace();
		    }
		  }
		  @Override
		  public Object stringToValue(String string) throws ParseException {
		    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		    if (string == null) {
		      string = "00/00/0000";
		    }
		    return df.parse(string);
		  }
		  @Override
		  public String valueToString(Object value) throws ParseException {
		    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		    if (value == null) {
		      value = new Date(0);
		    }
		    return df.format((Date) value);
		  }
	}
	
	public void loadFunctional(File file,String generatorFormat){
		
		cvFactory = new CvFactory();
		functional = cvFactory.constructCv(type);
		sectionFactory = new SectionFactory();
	    professionalProfile = sectionFactory.constructSection("2. Professional Profile");
	    functional.add(professionalProfile);
	    skillAndExperience = sectionFactory.constructSection("3. Skills And Experience");
	    functional.add(skillAndExperience);
		careerSummary = sectionFactory.constructSection("4. Career Summary");
		functional.add(careerSummary);
		educationAndTraining = sectionFactory.constructSection("5. Education And Training");
		functional.add(educationAndTraining);
		furtherCourses = sectionFactory.constructSection("6. Further Courses");
		functional.add(furtherCourses);
		additionalInformation = sectionFactory.constructSection("7. Additional Information");
		functional.add(additionalInformation);
		interests = sectionFactory.constructSection("8. Interests");
		functional.add(interests);	
		parserFactory = new ParserFactory();
		if(generatorFormat.equals("txt")){
			try {
				parser = parserFactory.constructParser(generatorFormat);
				parser.loadGeneralInformation(file,functional);
				txtName.setText(functional.getName());
				txtAddr.setText(functional.getAddress());
				txtTelHome.setText(functional.getTelHome());
				txtTelMob.setText(functional.getTelMobile());
				txtEmail.setText(functional.getEmail());
				parser.loadParagraph(file, professionalProfile);
				txtProProf.setText(professionalProfile.getParagraph());
				parser.loadSkillAndExperience(file, skillAndExperience);
				lstSkiAndExp.setModel(modelListManager.displayList(skillArrayModelList,skillAndExperience));
				parser.loadCareerSummary(file, careerSummary);
				lstCarSum.setModel(modelListManager.displayModelList(careerModelList, careerSummary));
				parser.loadEducationOrCourses(file, educationAndTraining);
				lstEduAndTrain.setModel(modelListManager.displayModelList(EducationModelList, educationAndTraining));
				parser.loadEducationOrCourses(file, furtherCourses);
				lstFurCour.setModel(modelListManager.displayModelList(FurtherModelList, furtherCourses));
				parser.loadParagraph(file, additionalInformation);
				txtAddInfo.setText(additionalInformation.getParagraph());
				parser.loadParagraph(file, interests);
				txtInter.setText(interests.getParagraph());
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}else if(generatorFormat.equals("latex")){
			try {
				parser = parserFactory.constructParser(generatorFormat);
				parser.loadGeneralInformation(file,functional);
				txtName.setText(functional.getName());
				txtAddr.setText(functional.getAddress());
				txtTelHome.setText(functional.getTelHome());
				txtTelMob.setText(functional.getTelMobile());
				txtEmail.setText(functional.getEmail());
				parser.loadParagraph(file, professionalProfile);
				txtProProf.setText(professionalProfile.getParagraph());
				parser.loadSkillAndExperience(file, skillAndExperience);
				lstSkiAndExp.setModel(modelListManager.displayList(skillArrayModelList,skillAndExperience));
				parser.loadCareerSummary(file, careerSummary);
				lstCarSum.setModel(modelListManager.displayModelList(careerModelList, careerSummary));
				parser.loadEducationOrCourses(file, educationAndTraining);
				lstEduAndTrain.setModel(modelListManager.displayModelList(EducationModelList, educationAndTraining));
				parser.loadEducationOrCourses(file, furtherCourses);
				lstFurCour.setModel(modelListManager.displayModelList(FurtherModelList, furtherCourses));
				parser.loadParagraph(file, additionalInformation);
				txtAddInfo.setText(additionalInformation.getParagraph());
				parser.loadParagraph(file, interests);
				txtInter.setText(interests.getParagraph());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			JOptionPane.showMessageDialog(null, "Error!!");
		}
	}

	public String fixDate(String date){
		int i=0;
		String month=null;
		String day=null;
		String year=null;
		
		for(String date1: date.split("/")){
			if(i==0){	
				day=date1;
			}
			else if(i==1){
				month=date1;
			}
			else if(i==2){
				year=date1;
			}
			i++;
		}
		return (month+"/"+day+"/"+year);
	}
	
	public boolean createDoc(){
		JFileChooser filechooser = new JFileChooser();
		filechooser.setCurrentDirectory(new File("."));
		int retval = filechooser.showSaveDialog(null);
		boolean save = false;
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
						return save = true;
					}
					System.out.println(formatFile);
				}
				i++;
			}
				if(i ==1){
					JOptionPane.showMessageDialog(null, "Please choose the correct format, .txt or .tex");
				}
		}
		return save;
	}
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FunctionalCv frame = new FunctionalCv();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
}
