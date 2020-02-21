package cv.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import cv.generators.GeneratorFactory;
import cv.generators.IGenerator;
import cv.generators.LatexGenerator;
import cv.generators.TxtGenerator;
import cv.gui.FunctionalCv.TimeFormatter;
import cv.main.Cv;
import cv.main.CvFactory;
import cv.main.Section;
import cv.main.SectionFactory;
import cv.parsers.IParser;
import cv.parsers.ParserFactory;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.Window.Type;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class ChronologicalCv extends JFrame {

	private static JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddr;
	private JTextField txtTelHome;
	private JTextField txtTelMob;
	private JTextField txtEmail;
	private JTextField txtCmpNameProExp;
	private JTextField txtJobTitleProExp;
	private JTextField txtQualEduAndTrain;
	private JTextField txtEstaEduAndTrain;
	private JTextField txtLocEduAndTrain;
	private JTextField txtEstaFurCour;
	private JTextField txtCourFurCour;
	private JTextField txtLocFurCour;
	private JTextField txtAch;
	private JTextField txtRespProExp;
	
	private JTextArea txtProProf;
	private JTextArea txtAddInfo;
	private JTextArea txtInter;
	private JTextArea txtCorStr;
	
	private JList lstAch;
	private JList lstProExp;
	private JList lstEduAndTrain;
	private JList lstFurCour;
	private ModelListManager modelListManager;
	private DefaultListModel experienceModelList;
	private DefaultListModel experienceArrayModelList;
	private DefaultListModel EducationModelList;
	private DefaultListModel FurtherModelList;
	
	private CvFactory cvFactory;
	private SectionFactory sectionFactory;
	private String type = "Chronological";
	private Cv chronological;
	private Section professionalProfile;
	private Section coreStrengths;
	private Section professionalExperience;
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
	public ChronologicalCv() {
		setResizable(false);
		setTitle("Chronological CV Template");
		setBounds(100, 100, 875, 961);
		
		contentPane = new JPanel();
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(null);
		
		contentPane.setPreferredSize(new Dimension(800, 1150));
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
		
		JLabel lblSkillsAnd = new JLabel("3. Core Strengths");
		lblSkillsAnd.setBounds(10, 255, 203, 14);
		contentPane.add(lblSkillsAnd);
		
		JLabel lblCareerSummary = new JLabel("4. Professional Experience");
		lblCareerSummary.setBounds(10, 372, 203, 14);
		contentPane.add(lblCareerSummary);
		
		JLabel lblCompanyName = new JLabel("Company Name:");
		lblCompanyName.setBounds(10, 400, 142, 14);
		contentPane.add(lblCompanyName);
		
		JLabel lblJobTitle = new JLabel("Job Title:");
		lblJobTitle.setBounds(10, 425, 142, 14);
		contentPane.add(lblJobTitle);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(10, 450, 142, 14);
		contentPane.add(lblDate);
		
		txtCmpNameProExp = new JTextField();
		txtCmpNameProExp.setColumns(10);
		txtCmpNameProExp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCmpNameProExp.setBounds(162, 397, 174, 20);
		contentPane.add(txtCmpNameProExp);
		
		txtJobTitleProExp = new JTextField();
		txtJobTitleProExp.setColumns(10);
		txtJobTitleProExp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtJobTitleProExp.setBounds(162, 422, 174, 20);
		contentPane.add(txtJobTitleProExp);
		
		JLabel lblEducationAnd = new JLabel("5. Education And Training");
		lblEducationAnd.setBounds(10, 613, 203, 14);
		contentPane.add(lblEducationAnd);
		
		lstEduAndTrain = new JList();
		lstEduAndTrain.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lstEduAndTrain.setBounds(622, 638, 368, 91);
		contentPane.add(lstEduAndTrain);
		
		JLabel lblQualification = new JLabel("Qualification:");
		lblQualification.setBounds(10, 641, 142, 14);
		contentPane.add(lblQualification);
		
		txtQualEduAndTrain = new JTextField();
		txtQualEduAndTrain.setColumns(10);
		txtQualEduAndTrain.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtQualEduAndTrain.setBounds(162, 638, 174, 20);
		contentPane.add(txtQualEduAndTrain);
		
		txtEstaEduAndTrain = new JTextField();
		txtEstaEduAndTrain.setColumns(10);
		txtEstaEduAndTrain.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEstaEduAndTrain.setBounds(162, 663, 174, 20);
		contentPane.add(txtEstaEduAndTrain);
		
		JLabel lblEstablishment = new JLabel("Establishment:");
		lblEstablishment.setBounds(10, 666, 142, 14);
		contentPane.add(lblEstablishment);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(10, 691, 142, 14);
		contentPane.add(lblLocation);
		
		txtLocEduAndTrain = new JTextField();
		txtLocEduAndTrain.setColumns(10);
		txtLocEduAndTrain.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtLocEduAndTrain.setBounds(162, 688, 174, 20);
		contentPane.add(txtLocEduAndTrain);
		
		JLabel label_3 = new JLabel("Date:");
		label_3.setBounds(10, 719, 142, 14);
		contentPane.add(label_3);
		
		JLabel lblFurtherCourses = new JLabel("6. Further Courses");
		lblFurtherCourses.setBounds(10, 744, 154, 14);
		contentPane.add(lblFurtherCourses);
		
		JLabel lblCourses = new JLabel("Courses:");
		lblCourses.setBounds(10, 772, 142, 14);
		contentPane.add(lblCourses);
		
		JLabel lblEstablishment_1 = new JLabel("Establishment");
		lblEstablishment_1.setBounds(10, 797, 142, 14);
		contentPane.add(lblEstablishment_1);
		
		txtEstaFurCour = new JTextField();
		txtEstaFurCour.setColumns(10);
		txtEstaFurCour.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEstaFurCour.setBounds(162, 794, 174, 20);
		contentPane.add(txtEstaFurCour);
		
		txtCourFurCour = new JTextField();
		txtCourFurCour.setColumns(10);
		txtCourFurCour.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCourFurCour.setBounds(162, 769, 174, 20);
		contentPane.add(txtCourFurCour);
		
		txtLocFurCour = new JTextField();
		txtLocFurCour.setColumns(10);
		txtLocFurCour.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtLocFurCour.setBounds(162, 819, 174, 20);
		contentPane.add(txtLocFurCour);
		
		JLabel lblLocation_1 = new JLabel("Location:");
		lblLocation_1.setBounds(10, 822, 142, 14);
		contentPane.add(lblLocation_1);
		
		lstFurCour = new JList();
		
		JLabel label_4 = new JLabel("Date:");
		label_4.setBounds(10, 850, 142, 14);
		contentPane.add(label_4);
		
		JLabel lblAdditionalInformation = new JLabel("7. Additional Information");
		lblAdditionalInformation.setBounds(10, 875, 203, 14);
		contentPane.add(lblAdditionalInformation);
		
		txtAddInfo = new JTextArea();
		txtAddInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAddInfo.setBounds(11, 901, 483, 81);
		contentPane.add(txtAddInfo);
		
		JLabel lblInterest = new JLabel("8. Interests");
		lblInterest.setBounds(11, 993, 203, 14);
		contentPane.add(lblInterest);
		
		txtInter = new JTextArea();
		txtInter.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtInter.setBounds(12, 1019, 483, 81);
		contentPane.add(txtInter);
		
		txtCorStr = new JTextArea();
		txtCorStr.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCorStr.setBounds(10, 280, 483, 81);
		contentPane.add(txtCorStr);
		
		JLabel lblResponsibilities = new JLabel("Responsibilities:");
		lblResponsibilities.setBounds(10, 478, 142, 14);
		contentPane.add(lblResponsibilities);
		
		txtAch = new JTextField();
		txtAch.setColumns(10);
		txtAch.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAch.setBounds(162, 504, 321, 20);
		contentPane.add(txtAch);
		
		txtRespProExp = new JTextField();
		txtRespProExp.setColumns(10);
		txtRespProExp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtRespProExp.setBounds(162, 475, 321, 20);
		contentPane.add(txtRespProExp);
		
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    getContentPane().add(jScrollPane);
	    setSize(1050, 800);
	    
	    JMenuBar menuBar = new JMenuBar();
	    setJMenuBar(menuBar);
	    
	    MaskFormatter formatter = new TimeFormatter(); 
	    formatter.setValueClass(java.util.Date.class);
		    
		JFormattedTextField fmtTxtDateEduAndTrain1 = new JFormattedTextField(formatter);
		fmtTxtDateEduAndTrain1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fmtTxtDateEduAndTrain1.setBounds(162, 710, 75, 23);
		fmtTxtDateEduAndTrain1.setValue(new Date());
		contentPane.add(fmtTxtDateEduAndTrain1);
		
		JLabel label_1 = new JLabel("to");
		label_1.setBounds(247, 713, 15, 14);
		contentPane.add(label_1);
		
		JFormattedTextField fmtTxtDateEduAndTrain2 = new JFormattedTextField(formatter);
		fmtTxtDateEduAndTrain2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fmtTxtDateEduAndTrain2.setBounds(261, 710, 75, 23);
		fmtTxtDateEduAndTrain2.setValue(new Date());
		contentPane.add(fmtTxtDateEduAndTrain2);
		
		JFormattedTextField fmtTxtDateFurCour1 = new JFormattedTextField(formatter);
		fmtTxtDateFurCour1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fmtTxtDateFurCour1.setBounds(162, 841, 75, 23);
		fmtTxtDateFurCour1.setValue(new Date());
		contentPane.add(fmtTxtDateFurCour1);
		
		JLabel label_2 = new JLabel("to");
		label_2.setBounds(247, 844, 15, 14);
		contentPane.add(label_2);
		
		JFormattedTextField fmtTxtDateFurCour2 = new JFormattedTextField(formatter);
		fmtTxtDateFurCour2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fmtTxtDateFurCour2.setBounds(261, 841, 75, 23);
		fmtTxtDateFurCour2.setValue(new Date());
		contentPane.add(fmtTxtDateFurCour2);
		
		JFormattedTextField fmtTxtDateProExp1 = new JFormattedTextField(formatter);
		fmtTxtDateProExp1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fmtTxtDateProExp1.setBounds(162, 446, 75, 23);
		fmtTxtDateProExp1.setValue(new Date());
		contentPane.add(fmtTxtDateProExp1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(162, 535, 321, 75);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(622, 397, 374, 91);
		contentPane.add(scrollPane_2);
		
		JLabel label = new JLabel("to");
		label.setBounds(247, 450, 15, 14);
		contentPane.add(label);
		
		JFormattedTextField fmtTxtDateProExp2 = new JFormattedTextField(formatter);
		fmtTxtDateProExp2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fmtTxtDateProExp2.setBounds(261, 446, 75, 23);
		fmtTxtDateProExp2.setValue(new Date());
		contentPane.add(fmtTxtDateProExp2);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////1. General Information 2. Professional Profile 7. Additional Information 8. Interests/////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		cvFactory = new CvFactory();
		chronological = cvFactory.constructCv(type);
		sectionFactory = new SectionFactory();
		professionalProfile = sectionFactory.constructSection("2. Professional Profile");
		chronological.add(professionalProfile);
		coreStrengths = sectionFactory.constructSection("3. Core Strengths");
		chronological.add(coreStrengths);
		professionalExperience = sectionFactory.constructSection("4. Professional Experience");
		chronological.add(professionalExperience);
		educationAndTraining = sectionFactory.constructSection("5. Education And Training");
		chronological.add(educationAndTraining);
		furtherCourses = sectionFactory.constructSection("6. Further Courses");
		chronological.add(furtherCourses);
		additionalInformation = sectionFactory.constructSection("7. Additional Information");
		chronological.add(additionalInformation);
		interests = sectionFactory.constructSection("8. Interests");
		chronological.add(interests);	
		
		modelListManager = new ModelListManager();
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////4. Professional Experience/////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////
	
		experienceModelList = new DefaultListModel();
		experienceArrayModelList = new DefaultListModel();
		
		lstAch = new JList();
		lstAch.addMouseListener(new MouseAdapter() {
			@Override	
			public void mouseClicked(MouseEvent arg0) {
				try{
					txtAch.setText(lstAch.getSelectedValue().toString());
				}catch(NullPointerException e){
					JOptionPane.showMessageDialog(null, "Not selected achievement to display!!!");
				}
			}
		});
		lstAch.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_1.setViewportView(lstAch);
		
		lstProExp = new JList();
		lstProExp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					int index = lstProExp.getSelectedIndex();
					txtCmpNameProExp.setText(professionalExperience.getBulletListInPosition(index).getCompanyName());
					txtJobTitleProExp.setText(professionalExperience.getBulletListInPosition(index).getJobTitle());
					fmtTxtDateProExp1.setValue(new Date(fixDate(professionalExperience.getBulletListInPosition(index).getDate1())));
					fmtTxtDateProExp2.setValue(new Date(fixDate(professionalExperience.getBulletListInPosition(index).getDate2())));
					txtRespProExp.setText(professionalExperience.getBulletListInPosition(index).getResponsibilities());
					lstAch.setModel(modelListManager.displayList(experienceModelList, professionalExperience, index));
				}catch(ArrayIndexOutOfBoundsException e){
					JOptionPane.showMessageDialog(null, "Not selected professional experience to display!!!");
				}
			}
		});
		lstProExp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_2.setViewportView(lstProExp);
		
		JButton btnAddAch = new JButton("Add Achievement");
		btnAddAch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(professionalExperience.getSizeArrayBulletList() == 0){
					professionalExperience.setItem(txtAch.getText());
					professionalExperience.addItem();
					txtAch.setText("");
					lstAch.setModel(modelListManager.addModelList(experienceModelList, professionalExperience));
				}else if(lstProExp.getSelectedIndex()<0){
					professionalExperience.setItem(txtAch.getText());
					professionalExperience.addItem();
					txtAch.setText("");
					lstAch.setModel(modelListManager.addModelList(experienceModelList, professionalExperience));
				}else{
					professionalExperience.setItem(txtAch.getText());
					professionalExperience.addItem(lstProExp.getSelectedIndex());
					txtAch.setText("");
					lstAch.setModel(modelListManager.addModelList(experienceModelList, professionalExperience));
				}
			}
		});
		btnAddAch.setBounds(10, 503, 142, 23);
		contentPane.add(btnAddAch);
		
		JButton btnDltAch = new JButton("Delete Achievement");
		btnDltAch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{	
					if(lstProExp.getModel().getSize() == 0){
						professionalExperience.deleteItem(lstAch.getSelectedIndex());
						modelListManager.deleteModelList(experienceModelList,lstAch.getSelectedIndex());
						txtAch.setText("");
					}else{
						professionalExperience.deleteItem(lstProExp.getSelectedIndex(), lstAch.getSelectedIndex());
						modelListManager.deleteModelList(experienceModelList,lstAch.getSelectedIndex());
						txtAch.setText("");
					}
				}catch(NullPointerException e){
					JOptionPane.showMessageDialog(null, "Not selected achievement to delete!!!");
				}
			}
		});
		btnDltAch.setBounds(10, 535, 142, 23);
		contentPane.add(btnDltAch);
		
		JButton btnUpdAch = new JButton("Update Achievement");
		btnUpdAch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(lstProExp.getModel().getSize() == 0){
						professionalExperience.setItem(txtAch.getText(),lstAch.getSelectedIndex());
						txtAch.setText("");
						lstAch.setModel(modelListManager.setModelList(experienceModelList, professionalExperience,lstAch.getSelectedIndex()));
					}else{
						professionalExperience.setItem(txtAch.getText(),lstAch.getSelectedIndex(),lstProExp.getSelectedIndex());
						txtAch.setText("");
						lstAch.setModel(modelListManager.setModelList(experienceModelList, professionalExperience,lstProExp.getSelectedIndex(),lstAch.getSelectedIndex()));
					}
				}catch(NullPointerException e){
					JOptionPane.showMessageDialog(null, "Not selected achievement to display!!!");
				}
			}
		});
		btnUpdAch.setBounds(10, 569, 142, 23);
		contentPane.add(btnUpdAch);
		
		JButton btnAddProExp = new JButton("Add");
		btnAddProExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modelListManager.checkDates(fmtTxtDateProExp1.getText(),fmtTxtDateProExp2.getText())){
					professionalExperience.setBulletList(txtCmpNameProExp.getText(),txtJobTitleProExp.getText(),
						fmtTxtDateProExp1.getText(),fmtTxtDateProExp2.getText(), txtRespProExp.getText());
					professionalExperience.addBulletList();
					txtCmpNameProExp.setText("");
					txtJobTitleProExp.setText("");
					fmtTxtDateProExp1.setValue(new Date());
					fmtTxtDateProExp2.setValue(new Date());
					txtRespProExp.setText("");
					txtAch.setText("");
					lstProExp.setModel(modelListManager.addArrayModelList(experienceArrayModelList, professionalExperience));
					modelListManager.orderDates(0, experienceArrayModelList, professionalExperience);
					modelListManager.clearModelList(experienceModelList);
				}
			}
		});
		btnAddProExp.setBounds(505, 397, 89, 23);
		contentPane.add(btnAddProExp);
		
		JButton btnDltProExp = new JButton("Delete");
		btnDltProExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					professionalExperience.deleteBulletList(lstProExp.getSelectedIndex());
					modelListManager.deleteArrayModelList(experienceArrayModelList,lstProExp.getSelectedIndex());
					txtCmpNameProExp.setText("");
					txtJobTitleProExp.setText("");
					fmtTxtDateProExp1.setValue(new Date());
					fmtTxtDateProExp2.setValue(new Date());
					modelListManager.clearModelList(experienceModelList);
				}catch(ArrayIndexOutOfBoundsException e){
					JOptionPane.showMessageDialog(null, "Not selected professional experience to delete!!!");
				}
			}
		});
		btnDltProExp.setBounds(505, 431, 89, 23);
		contentPane.add(btnDltProExp);
		
		JButton btnUpdProExp = new JButton("Update");
		btnUpdProExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{			
					if(modelListManager.checkDates(fmtTxtDateProExp1.getText(),fmtTxtDateProExp2.getText())){
							professionalExperience.setBulletList(lstProExp.getSelectedIndex(),txtCmpNameProExp.getText(),txtJobTitleProExp.getText(),
									fmtTxtDateProExp1.getText(),fmtTxtDateProExp2.getText(), txtRespProExp.getText());
							txtCmpNameProExp.setText("");
							txtJobTitleProExp.setText("");
							fmtTxtDateProExp1.setValue(new Date());
							fmtTxtDateProExp2.setValue(new Date());
							txtRespProExp.setText("");
							txtAch.setText("");
							lstProExp.setModel(modelListManager.setArrayModelList(experienceArrayModelList, professionalExperience,lstProExp.getSelectedIndex()));
							modelListManager.orderDates(0, experienceArrayModelList, professionalExperience);
							modelListManager.clearModelList(experienceModelList);
					}
				}catch(ArrayIndexOutOfBoundsException e){
					JOptionPane.showMessageDialog(null, "Not selected professional experience to update!!!");
				}
			}
		});
		btnUpdProExp.setBounds(505, 465, 89, 23);
		contentPane.add(btnUpdProExp);
		
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
		btnAddEduAndTrain.setBounds(505, 638, 89, 23);
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
				modelListManager.orderDates(EducationModelList, educationAndTraining);;
			}
		});
		btnDltEduAndTrain.setBounds(505, 672, 89, 23);
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
		btnUpdEduAndTrain.setBounds(505, 706, 89, 23);
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
		lstFurCour.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lstFurCour.setBounds(622, 769, 368, 91);
		contentPane.add(lstFurCour);
		
		JButton btnAddFurCour = new JButton("Add");
		btnAddFurCour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnAddFurCour.setBounds(505, 769, 89, 23);
		contentPane.add(btnAddFurCour);
		
		JButton btnDltFurCour = new JButton("Delete");
		btnDltFurCour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnDltFurCour.setBounds(505, 803, 89, 23);
		contentPane.add(btnDltFurCour);
		
		JButton btnUpdFurCour = new JButton("Update");
		btnUpdFurCour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnUpdFurCour.setBounds(505, 837, 89, 23);
		contentPane.add(btnUpdFurCour);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////Save/////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		 JButton btnSave = new JButton("Save");
		    btnSave.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		chronological.setName(txtName.getText());
		    		chronological.setAddress(txtAddr.getText());
		    		chronological.setTelHome(txtTelHome.getText());
		    		chronological.setTelMobile(txtTelMob.getText());
		    		chronological.setEmail(txtEmail.getText());
		    		professionalProfile.setParagraph(txtProProf.getText());
		    		coreStrengths.setParagraph(txtCorStr.getText());
		    		additionalInformation.setParagraph(txtAddInfo.getText());
		    		interests.setParagraph(txtInter.getText());
		    		if(createDoc()){
		    			generatorFactory= new GeneratorFactory();
		    			if(generatorFormat.equals("txt")){
		    				generator = generatorFactory.constructGenerator(generatorFormat);
		    				generator.saveGeneralInformation(file, chronological);
		    				generator.saveParagraph(file,professionalProfile);
		    				generator.saveParagraph(file, coreStrengths);
		    				generator.saveProfessionalExperience(file, professionalExperience);
		    				generator.saveEducationOrCourses(file, educationAndTraining);
		    				generator.saveEducationOrCourses(file, furtherCourses);
		    				generator.saveParagraph(file, additionalInformation);
		    				generator.saveParagraph(file,interests);
		    			}else if(generatorFormat.equals("latex")){
		    				generator = generatorFactory.constructGenerator(generatorFormat);
		    				generator.saveGeneralInformation(file, chronological);
		    				generator.saveParagraph(file, professionalProfile);
		    				generator.saveParagraph(file, coreStrengths);
		    				generator.saveProfessionalExperience(file, professionalExperience);
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

	public void loadChronological(File file,String generatorFormat){
			
		cvFactory = new CvFactory();
		chronological = cvFactory.constructCv(type);
		sectionFactory = new SectionFactory();
		professionalProfile = sectionFactory.constructSection("2. Professional Profile");
		chronological.add(professionalProfile);
		coreStrengths = sectionFactory.constructSection("3. Core Strengths");
		chronological.add(coreStrengths);
		professionalExperience = sectionFactory.constructSection("4. Professional Experience");
		chronological.add(professionalExperience);
		educationAndTraining = sectionFactory.constructSection("5. Education And Training");
		chronological.add(educationAndTraining);
		furtherCourses = sectionFactory.constructSection("6. Further Courses");
		chronological.add(furtherCourses);
		additionalInformation = sectionFactory.constructSection("7. Additional Information");
		chronological.add(additionalInformation);
		interests = sectionFactory.constructSection("8. Interests");
		chronological.add(interests);	
		parserFactory = new ParserFactory();
			if(generatorFormat.equals("txt")){
				try {
					parser = parserFactory.constructParser(generatorFormat);
					parser.loadGeneralInformation(file,chronological);
					txtName.setText(chronological.getName());
					txtAddr.setText(chronological.getAddress());
					txtTelHome.setText(chronological.getTelHome());
					txtTelMob.setText(chronological.getTelMobile());
					txtEmail.setText(chronological.getEmail());
					parser.loadParagraph(file, professionalProfile);
					txtProProf.setText(professionalProfile.getParagraph());
					parser.loadParagraph(file, coreStrengths);
					txtCorStr.setText(coreStrengths.getParagraph());
					parser.loadProfessionalExperience(file, professionalExperience);
					lstProExp.setModel(modelListManager.displayList(experienceArrayModelList,professionalExperience));
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
					parser.loadGeneralInformation(file,chronological);
					txtName.setText(chronological.getName());
					txtAddr.setText(chronological.getAddress());
					txtTelHome.setText(chronological.getTelHome());
					txtTelMob.setText(chronological.getTelMobile());
					txtEmail.setText(chronological.getEmail());
					parser.loadParagraph(file, professionalProfile);
					txtProProf.setText(professionalProfile.getParagraph());
					parser.loadParagraph(file, coreStrengths);
					txtCorStr.setText(coreStrengths.getParagraph());
					parser.loadProfessionalExperience(file, professionalExperience);
					lstProExp.setModel(modelListManager.displayList(experienceArrayModelList,professionalExperience));
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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChronologicalCv frame = new ChronologicalCv();
					
			
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

