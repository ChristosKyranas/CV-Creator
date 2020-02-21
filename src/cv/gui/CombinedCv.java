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
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class CombinedCv extends JFrame {

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
	private JTextField txtInfo;
	private JTextField txtSkiAndExpOn;
	
	private JTextArea txtProProf;
	private JTextArea txtAddInfo;
	private JTextArea txtInter;
	
	private JList lstEduAndTrain;
	private JList lstFurCour;
	private JList lstInfo;
    private JList lstSkiAndExp;
    private JList lstAch;
    private JList lstProExp;
    private ModelListManager modelListManager;
    private DefaultListModel skillArrayModelList;
    private DefaultListModel skillModelList;
    private DefaultListModel experienceModelList;
	private DefaultListModel experienceArrayModelList;
    private DefaultListModel EducationModelList;
	private DefaultListModel FurtherModelList;
    
    private CvFactory cvFactory;
    private SectionFactory sectionFactory;
	private String type = "Combined";
	private Cv combined;
	private Section professionalProfile;
	private Section professionalExperience;
	private Section skillAndExperience;
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
	public CombinedCv() {
		setResizable(false);
		setTitle("Combined CV Template");
		setBounds(100, 100, 875, 961);
				
		contentPane = new JPanel();
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(null);
		
		contentPane.setPreferredSize(new Dimension(800, 1200));
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
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 111, 46, 14);
		contentPane.add(lblEmail);
		
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
		
		JLabel lblCareerSummary = new JLabel("4. Professional Experience");
		lblCareerSummary.setBounds(10, 422, 203, 14);
		contentPane.add(lblCareerSummary);
		
		JLabel lblCompanyName = new JLabel("Company Name:");
		lblCompanyName.setBounds(10, 450, 142, 14);
		contentPane.add(lblCompanyName);
		
		JLabel lblJobTitle = new JLabel("Job Title:");
		lblJobTitle.setBounds(10, 475, 142, 14);
		contentPane.add(lblJobTitle);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(10, 500, 142, 14);
		contentPane.add(lblDate);
		
		txtCmpNameProExp = new JTextField();
		txtCmpNameProExp.setColumns(10);
		txtCmpNameProExp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCmpNameProExp.setBounds(162, 447, 174, 20);
		contentPane.add(txtCmpNameProExp);
		
		txtJobTitleProExp = new JTextField();
		txtJobTitleProExp.setColumns(10);
		txtJobTitleProExp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtJobTitleProExp.setBounds(162, 472, 174, 20);
		contentPane.add(txtJobTitleProExp);
		
		JLabel lblEducationAnd = new JLabel("5. Education And Training");
		lblEducationAnd.setBounds(10, 663, 203, 14);
		contentPane.add(lblEducationAnd);
		
		JLabel lblQualification = new JLabel("Qualification:");
		lblQualification.setBounds(10, 691, 142, 14);
		contentPane.add(lblQualification);
		
		txtQualEduAndTrain = new JTextField();
		txtQualEduAndTrain.setColumns(10);
		txtQualEduAndTrain.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtQualEduAndTrain.setBounds(162, 688, 174, 20);
		contentPane.add(txtQualEduAndTrain);
		
		txtEstaEduAndTrain = new JTextField();
		txtEstaEduAndTrain.setColumns(10);
		txtEstaEduAndTrain.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEstaEduAndTrain.setBounds(162, 713, 174, 20);
		contentPane.add(txtEstaEduAndTrain);
		
		JLabel lblEstablishment = new JLabel("Establishment:");
		lblEstablishment.setBounds(10, 716, 142, 14);
		contentPane.add(lblEstablishment);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(10, 741, 142, 14);
		contentPane.add(lblLocation);
		
		txtLocEduAndTrain = new JTextField();
		txtLocEduAndTrain.setColumns(10);
		txtLocEduAndTrain.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtLocEduAndTrain.setBounds(162, 738, 174, 20);
		contentPane.add(txtLocEduAndTrain);
		
		JLabel label_3 = new JLabel("Date:");
		label_3.setBounds(10, 769, 142, 14);
		contentPane.add(label_3);
		
		JLabel lblFurtherCourses = new JLabel("6. Further Courses");
		lblFurtherCourses.setBounds(10, 794, 154, 14);
		contentPane.add(lblFurtherCourses);
		
		JLabel lblCourses = new JLabel("Courses:");
		lblCourses.setBounds(10, 822, 142, 14);
		contentPane.add(lblCourses);
		
		JLabel lblEstablishment_1 = new JLabel("Establishment");
		lblEstablishment_1.setBounds(10, 847, 142, 14);
		contentPane.add(lblEstablishment_1);
		
		txtEstaFurCour = new JTextField();
		txtEstaFurCour.setColumns(10);
		txtEstaFurCour.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtEstaFurCour.setBounds(162, 844, 174, 20);
		contentPane.add(txtEstaFurCour);
		
		txtCourFurCour = new JTextField();
		txtCourFurCour.setColumns(10);
		txtCourFurCour.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtCourFurCour.setBounds(162, 819, 174, 20);
		contentPane.add(txtCourFurCour);
		
		txtLocFurCour = new JTextField();
		txtLocFurCour.setColumns(10);
		txtLocFurCour.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtLocFurCour.setBounds(162, 869, 174, 20);
		contentPane.add(txtLocFurCour);
		
		JLabel lblLocation_1 = new JLabel("Location:");
		lblLocation_1.setBounds(10, 872, 142, 14);
		contentPane.add(lblLocation_1);
		
		JLabel label_4 = new JLabel("Date:");
		label_4.setBounds(10, 900, 142, 14);
		contentPane.add(label_4);
		
		JLabel lblAdditionalInformation = new JLabel("7. Additional Information");
		lblAdditionalInformation.setBounds(10, 925, 203, 14);
		contentPane.add(lblAdditionalInformation);
		
		txtAddInfo = new JTextArea();
		txtAddInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAddInfo.setBounds(11, 951, 483, 81);
		contentPane.add(txtAddInfo);
		
		JLabel lblInterest = new JLabel("8. Interests");
		lblInterest.setBounds(11, 1043, 203, 14);
		contentPane.add(lblInterest);
		
		txtInter = new JTextArea();
		txtInter.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtInter.setBounds(12, 1069, 483, 81);
		contentPane.add(txtInter);
		
		JLabel lblResponsibilities = new JLabel("Responsibilities:");
		lblResponsibilities.setBounds(10, 528, 142, 14);
		contentPane.add(lblResponsibilities);
		
		txtAch = new JTextField();
		txtAch.setColumns(10);
		txtAch.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtAch.setBounds(162, 554, 321, 20);
		contentPane.add(txtAch);
		
		txtRespProExp = new JTextField();
		txtRespProExp.setColumns(10);
		txtRespProExp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtRespProExp.setBounds(162, 525, 321, 20);
		contentPane.add(txtRespProExp);
		
		JLabel label = new JLabel("Skills And Experience On:");
		label.setBounds(13, 275, 151, 14);
		contentPane.add(label);
		
		txtInfo = new JTextField();
		txtInfo.setColumns(10);
		txtInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtInfo.setBounds(174, 301, 321, 20);
		contentPane.add(txtInfo);
		
		txtSkiAndExpOn = new JTextField();
		txtSkiAndExpOn.setColumns(10);
		txtSkiAndExpOn.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtSkiAndExpOn.setBounds(174, 272, 321, 20);
		contentPane.add(txtSkiAndExpOn);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(162, 585, 321, 72);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(173, 332, 322, 72);
		contentPane.add(scrollPane_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(617, 272, 373, 91);
		contentPane.add(scrollPane_3);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(615, 447, 375, 91);
		contentPane.add(scrollPane_4);
		
		MaskFormatter formatter = new TimeFormatter(); 
		formatter.setValueClass(java.util.Date.class);
		
		JFormattedTextField fmtTxtDateProExp1 = new JFormattedTextField(formatter);
		fmtTxtDateProExp1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fmtTxtDateProExp1.setBounds(162, 496, 75, 23);
		fmtTxtDateProExp1.setValue(new Date());
		contentPane.add(fmtTxtDateProExp1);
		
		JLabel label_1 = new JLabel("to");
		label_1.setBounds(247, 500, 15, 14);
		contentPane.add(label_1);
		
		JFormattedTextField fmtTxtDateProExp2 = new JFormattedTextField(formatter);
		fmtTxtDateProExp2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fmtTxtDateProExp2.setBounds(261, 496, 75, 23);
		fmtTxtDateProExp2.setValue(new Date());
		contentPane.add(fmtTxtDateProExp2);
		
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    getContentPane().add(jScrollPane);
	    setSize(1050, 800);
	    
	    JFormattedTextField fmtTxtDateEduAndTrain1 = new JFormattedTextField(formatter);
		fmtTxtDateEduAndTrain1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fmtTxtDateEduAndTrain1.setBounds(162, 760, 75, 23);
		fmtTxtDateEduAndTrain1.setValue(new Date());
		contentPane.add(fmtTxtDateEduAndTrain1);
		
		JLabel label_2 = new JLabel("to");
		label_2.setBounds(247, 764, 15, 14);
		contentPane.add(label_2);
		
		JFormattedTextField fmtTxtDateEduAndTrain2 = new JFormattedTextField(formatter);
		fmtTxtDateEduAndTrain2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fmtTxtDateEduAndTrain2.setBounds(261, 760, 75, 23);
		fmtTxtDateEduAndTrain2.setValue(new Date());
		contentPane.add(fmtTxtDateEduAndTrain2);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(617, 691, 373, 92);
		contentPane.add(scrollPane_5);
		
		lstEduAndTrain = new JList();
		lstEduAndTrain.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_5.setViewportView(lstEduAndTrain);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(617, 819, 373, 91);
		contentPane.add(scrollPane_6);
		
		lstFurCour = new JList();
		scrollPane_6.setViewportView(lstFurCour);
		
		JFormattedTextField fmtTxtDateFurCour1 = new JFormattedTextField(formatter);
		fmtTxtDateFurCour1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fmtTxtDateFurCour1.setBounds(162, 891, 75, 23);
		fmtTxtDateFurCour1.setValue(new Date());
		contentPane.add(fmtTxtDateFurCour1);
		
		JLabel label_5 = new JLabel("to");
		label_5.setBounds(247, 895, 15, 14);
		contentPane.add(label_5);
		
		JFormattedTextField fmtTxtDateFurCour2 = new JFormattedTextField(formatter);
		fmtTxtDateFurCour2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		fmtTxtDateFurCour2.setBounds(261, 891, 75, 23);
		fmtTxtDateFurCour2.setValue(new Date());
		contentPane.add(fmtTxtDateFurCour2);
	    
	    JMenuBar menuBar = new JMenuBar();
	    setJMenuBar(menuBar);
	    
	    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    /////////////1. General Information 2. Professional Profile 7. Additional Information 8. Interests/////////////////
	    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    
	    cvFactory = new CvFactory();
		combined = cvFactory.constructCv(type);
	    sectionFactory = new SectionFactory();
	    professionalProfile = sectionFactory.constructSection("2. Professional Profile");
	    combined.add(professionalProfile);
	    skillAndExperience = sectionFactory.constructSection("3. Skills And Experience");
	    combined.add(skillAndExperience);
		professionalExperience = sectionFactory.constructSection("4. Professional Experience");
		combined.add(professionalExperience);
		educationAndTraining = sectionFactory.constructSection("5. Education And Training");
		combined.add(educationAndTraining);
		furtherCourses = sectionFactory.constructSection("6. Further Courses");
		combined.add(furtherCourses);
		additionalInformation = sectionFactory.constructSection("7. Additional Information");
		combined.add(additionalInformation);
		interests = sectionFactory.constructSection("8. Interests");
		combined.add(interests);	
		
		
		modelListManager = new ModelListManager();
		
	    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////3. Skills And Experience///////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    
		skillModelList = new DefaultListModel();
		skillArrayModelList = new DefaultListModel();
		
	    lstInfo = new JList();
		lstInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					txtInfo.setText(lstInfo.getSelectedValue().toString());
				}catch(NullPointerException e){
					JOptionPane.showMessageDialog(null, "Not selected information to display!!!");
				}
			}
		});
		lstInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_2.setViewportView(lstInfo);
		
	    lstSkiAndExp = new JList();
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
		lstSkiAndExp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_3.setViewportView(lstSkiAndExp);
	    
		JButton btnAddInfo = new JButton("Add Information");
		btnAddInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnAddInfo.setBounds(10, 300, 154, 23);
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
		btnDltInfo.setBounds(10, 334, 154, 23);
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
		btnUpdInfo.setBounds(10, 368, 154, 23);
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
		btnAddSkiAndExp.setBounds(505, 272, 89, 23);
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
		btnDltSkiAndExp.setBounds(505, 306, 89, 23);
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
					JOptionPane.showMessageDialog(null, "Not selected skill and experience to display!!!");
				}
			}
		});
		btnUpdSkiAndExp.setBounds(505, 340, 89, 23);
		contentPane.add(btnUpdSkiAndExp);
		
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
		scrollPane_4.setViewportView(lstProExp);
		
	    JButton btnAddAchievement = new JButton("Add Achievement");
		btnAddAchievement.addActionListener(new ActionListener() {
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
		btnAddAchievement.setBounds(10, 553, 142, 23);
		contentPane.add(btnAddAchievement);
	    
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
		btnDltAch.setBounds(10, 587, 142, 23);
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
					JOptionPane.showMessageDialog(null, "Not selected achievement to update!!!");
				}
			}
		});
		btnUpdAch.setBounds(10, 621, 142, 23);
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
		btnAddProExp.setBounds(505, 447, 89, 23);
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
		btnDltProExp.setBounds(505, 481, 89, 23);
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
		btnUpdProExp.setBounds(505, 515, 89, 23);
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
						JOptionPane.showMessageDialog(null, "Not selected education and training to update!!!");
					}
				}
			});
	    
	    JButton btnAddEduAndTrain = new JButton("Add");
		btnAddEduAndTrain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnAddEduAndTrain.setBounds(505, 688, 89, 23);
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
		btnDltEduAndTrain.setBounds(505, 722, 89, 23);
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
		btnUpdEduAndTrain.setBounds(505, 756, 89, 23);
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
					JOptionPane.showMessageDialog(null, "Not selected further course to display!!!");
				}
			}
		});
		lstFurCour.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
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
		btnAddFurCour.setBounds(505, 819, 89, 23);
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
		btnDltFurCour.setBounds(505, 853, 89, 23);
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
		btnUpdFurCour.setBounds(505, 887, 89, 23);
		contentPane.add(btnUpdFurCour);
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////Save////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  
		JButton btnSave = new JButton("Save");
	    btnSave.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		combined.setName(txtName.getText());
	    		combined.setAddress(txtAddr.getText());
	    		combined.setTelHome(txtTelHome.getText());
	    		combined.setTelMobile(txtTelMob.getText());
	    		combined.setEmail(txtEmail.getText());
	    		professionalProfile.setParagraph(txtProProf.getText());
	    		additionalInformation.setParagraph(txtAddInfo.getText());
	    		interests.setParagraph(txtInter.getText());
	    		if(createDoc()){
	    			generatorFactory= new GeneratorFactory();
	    			if(generatorFormat.equals("txt")){
	    				generator = generatorFactory.constructGenerator(generatorFormat);
	    				generator.saveGeneralInformation(file, combined);
	    				generator.saveParagraph(file,professionalProfile);
	    				generator.saveSkillAndExperience(file,skillAndExperience);
	    				generator.saveProfessionalExperience(file, professionalExperience);
	    				generator.saveEducationOrCourses(file, educationAndTraining);
	    				generator.saveEducationOrCourses(file, furtherCourses);
	    				generator.saveParagraph(file, additionalInformation);
	    				generator.saveParagraph(file,interests);
	    			}else if(generatorFormat.equals("latex")){
	    				generator = generatorFactory.constructGenerator(generatorFormat);
	    				generator.saveGeneralInformation(file, combined);
	    				generator.saveParagraph(file, professionalProfile);
	    				generator.saveSkillAndExperience(file, skillAndExperience);
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
	
	
	public void loadCombined(File file,String generatorFormat){
		
		cvFactory = new CvFactory();
		combined = cvFactory.constructCv(type);
	    sectionFactory = new SectionFactory();
	    professionalProfile = sectionFactory.constructSection("2. Professional Profile");
	    combined.add(professionalProfile);
	    skillAndExperience = sectionFactory.constructSection("3. Skills And Experience");
	    combined.add(skillAndExperience);
		professionalExperience = sectionFactory.constructSection("4. Professional Experience");
		combined.add(professionalExperience);
		educationAndTraining = sectionFactory.constructSection("5. Education And Training");
		combined.add(educationAndTraining);
		furtherCourses = sectionFactory.constructSection("6. Further Courses");
		combined.add(furtherCourses);
		additionalInformation = sectionFactory.constructSection("7. Additional Information");
		combined.add(additionalInformation);
		interests = sectionFactory.constructSection("8. Interests");
		combined.add(interests);	
		parserFactory = new ParserFactory();
			if(generatorFormat.equals("txt")){
				try {
					parser = parserFactory.constructParser(generatorFormat);
					parser.loadGeneralInformation(file,combined);
					txtName.setText(combined.getName());
					txtAddr.setText(combined.getAddress());
					txtTelHome.setText(combined.getTelHome());
					txtTelMob.setText(combined.getTelMobile());
					txtEmail.setText(combined.getEmail());
					parser.loadParagraph(file, professionalProfile);
					txtProProf.setText(professionalProfile.getParagraph());
					parser.loadSkillAndExperience(file, skillAndExperience);
					lstSkiAndExp.setModel(modelListManager.displayList(skillArrayModelList,skillAndExperience));
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
					parser.loadGeneralInformation(file,combined);
					txtName.setText(combined.getName());
					txtAddr.setText(combined.getAddress());
					txtTelHome.setText(combined.getTelHome());
					txtTelMob.setText(combined.getTelMobile());
					txtEmail.setText(combined.getEmail());
					parser.loadParagraph(file, professionalProfile);
					txtProProf.setText(professionalProfile.getParagraph());
					parser.loadSkillAndExperience(file, skillAndExperience);
					lstSkiAndExp.setModel(modelListManager.displayList(skillArrayModelList,skillAndExperience));
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
					CombinedCv frame = new CombinedCv();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
