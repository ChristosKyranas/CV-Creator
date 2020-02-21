package cv.testing;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import cv.generators.GeneratorFactory;
import cv.generators.IGenerator;
import cv.main.Cv;
import cv.main.Section;

public class LatexGeneratorTesting {
	private GeneratorFactory generatorFactory;
	private IGenerator generator;
	private FileReader fReader;
	private BufferedReader bReader;
	private String line = null;
	@Test
	public void test() throws IOException {
		File file = new File("10.tex");
		generatorFactory= new GeneratorFactory();
		generator = generatorFactory.constructGenerator("latex");
		generalInformation(file);
		
		saveSkillsAndExperience(file);
		
		saveProfessionalExperience(file);
		saveCareerSummary(file);
		saveFurtherOrEducation(file);
		saveParagraph(file);
	}

	
	public void generalInformation(File file) throws IOException{
		fReader = new FileReader(file);
		bReader = new BufferedReader(fReader);
		Cv cv = new Cv("Functional");
		
		cv.setName("tsi");
		cv.setAddress("N.Zerva");
		cv.setTelHome("123");
		cv.setTelMobile("321");
		cv.setEmail("hello@hotmail.com");
		
		generator.saveGeneralInformation(file, cv);
		
		line = bReader.readLine();
		assertEquals("\\documentclass{article} ", line);
		line = bReader.readLine();
		assertEquals(" \\title{Functional} ", line);
		line = bReader.readLine();
		assertEquals(" \\usepackage{amssymb} ", line);
		line = bReader.readLine();
		assertEquals(" \\begin{document} ", line);
		line = bReader.readLine();
		assertEquals("%General Information", line);
		line = bReader.readLine();
		assertEquals(" \\section{ General Information} ", line);
		line = bReader.readLine();
		assertEquals(" {Name: tsi} \\newline ", line);
		line = bReader.readLine();
		assertEquals(" {Address: N.Zerva} \\newline ", line);
		line = bReader.readLine();
		assertEquals(" {Telephone: (Home) 123}  	{(Mobile) 321} \\newline ", line);
		line = bReader.readLine();
		assertEquals(" {Email: hello@hotmail.com}", line);
	}
	
	public void saveParagraph(File file) throws IOException{
		Section professionalProfile = new Section("2. Professional Profile");
		professionalProfile.setParagraph("Billios sings beautiful");
		generator.saveParagraph(file, professionalProfile);
		
		line = bReader.readLine();
		assertEquals("%Profile", line);
		line = bReader.readLine();
		assertEquals(" \\section{Profile} ", line);
		line = bReader.readLine();
		assertEquals(" {Billios sings beautiful}", line);
		
		
		Section coreStrengths = new Section("3. Core Strengths");
		coreStrengths.setParagraph("Billios sings bad");
		generator.saveParagraph(file, coreStrengths);
		
		line = bReader.readLine();
		assertEquals("%Strengths", line);
		line = bReader.readLine();
		assertEquals(" \\section{Strengths} ", line);
		line = bReader.readLine();
		assertEquals(" {Billios sings bad}", line);
		
		Section additionalInformation = new Section("7. Additional Information");
		additionalInformation.setParagraph("Billios sings too loud");
		generator.saveParagraph(file, additionalInformation);
		
		line = bReader.readLine();
		assertEquals("%Information", line);
		line = bReader.readLine();
		assertEquals(" \\section{Information} ", line);
		line = bReader.readLine();
		assertEquals(" {Billios sings too loud}", line);
		
		Section interests = new Section("8. Interests");
		interests.setParagraph("Billios is too tires to sing");
		generator.saveParagraph(file, interests);
		
		line = bReader.readLine();
		assertEquals("%Interests", line);
		line = bReader.readLine();
		assertEquals(" \\section{Interests} ", line);
		line = bReader.readLine();
		assertEquals(" {Billios is too tires to sing}", line);
		
	}

	public void saveSkillsAndExperience(File file) throws IOException{
		Section skillsAndExperience = new Section("3. Skills And Experience");
		skillsAndExperience.setBulletList("samsung");
		skillsAndExperience.setItem("texnikos");
		skillsAndExperience.addItem();
		skillsAndExperience.setItem("seller");
		skillsAndExperience.addItem();
		skillsAndExperience.addBulletList();
		skillsAndExperience.setBulletList("apple");
		skillsAndExperience.setItem("manager");
		skillsAndExperience.addItem();
		skillsAndExperience.addBulletList();
		generator.saveSkillAndExperience(file, skillsAndExperience);
		
		line = bReader.readLine();
		assertEquals("%3. Skills And Experience", line);
		line = bReader.readLine();
		assertEquals(" \\section{3. Skills And Experience} ", line);
		line = bReader.readLine();
		assertEquals("{3.1 Skills And Experience On samsung}", line);
		line = bReader.readLine();
		assertEquals("\\begin{itemize} ", line);
		line = bReader.readLine();
		assertEquals("\\item {texnikos}", line);
		line = bReader.readLine();
		assertEquals("\\item {seller}", line);
		line = bReader.readLine();
		assertEquals("\\end{itemize} ", line);
		line = bReader.readLine();
		assertEquals("{3.2 Skills And Experience On apple}", line);
		line = bReader.readLine();
		assertEquals("\\begin{itemize} ", line);
		line = bReader.readLine();
		assertEquals("\\item {manager}", line);
		line = bReader.readLine();
		assertEquals("\\end{itemize} ", line);
	}
	
	public void saveCareerSummary(File file) throws IOException{
		Section careerSummary = new Section("4. Career Summary");
		careerSummary.setItem("apple", "texnikos", "13/05/2016", "15/05/2017");
		careerSummary.addItem();
		generator.saveCareerSummary(file, careerSummary);
		
		line = bReader.readLine();
		assertEquals("%4. Career Summary", line);
		line = bReader.readLine();
		assertEquals(" \\section{4. Career Summary} ", line);
		line = bReader.readLine();
		assertEquals("\\begin{itemize} ", line);
		line = bReader.readLine();
		assertEquals("\\item {apple, texnikos, 13/05/2016 to 15/05/2017}", line);
		line = bReader.readLine();
		assertEquals("\\end{itemize} ", line);
		
	}
	
	public void saveProfessionalExperience(File file) throws IOException{
		Section professionalExperience = new Section("4. Professional Experience");
		professionalExperience.setBulletList("moto", "searcher", "13/05/2017", "30/05/2017", "motoria");
		professionalExperience.setItem("na briskw motoria");
		professionalExperience.addItem();
		professionalExperience.setItem("service");
		professionalExperience.addItem();
		professionalExperience.addBulletList();
		
		generator.saveProfessionalExperience(file, professionalExperience);
		
		line = bReader.readLine();
		assertEquals("%4. Professional Experience", line);
		line = bReader.readLine();
		assertEquals(" \\section{4. Professional Experience} ", line);
		line = bReader.readLine();
		assertEquals("\\renewcommand{\\labelitemii}{$\\circ$} ", line);
		line = bReader.readLine();
		assertEquals(" \\renewcommand{\\labelitemiii}{\\tiny$\\blacksquare$} ", line);
		line = bReader.readLine();
		assertEquals("%profExp", line);
		line = bReader.readLine();
		assertEquals("\\begin{itemize} ", line);
		line = bReader.readLine();
		assertEquals("\\item {moto, searcher, 13/05/2017, 30/05/2017}", line);
		line = bReader.readLine();
		assertEquals("%Responibilities", line);
		line = bReader.readLine();
		assertEquals("\\begin{itemize} ", line);
		line = bReader.readLine();
		assertEquals("\\item {motoria}", line);
		line = bReader.readLine();
		assertEquals(" \\item {List of achievements}", line);
		line = bReader.readLine();
		assertEquals("\\begin{itemize} ", line);
		line = bReader.readLine();
		assertEquals("\\item {na briskw motoria}", line);
		line = bReader.readLine();
		assertEquals("\\item {service}", line);
		line = bReader.readLine();
		assertEquals("\\end{itemize} ", line);
		line = bReader.readLine();
		assertEquals("\\end{itemize} ", line);
		line = bReader.readLine();
		assertEquals("\\end{itemize} ", line);
		line = bReader.readLine();
		
		
	}
	
	public void saveFurtherOrEducation(File file) throws IOException{
		Section educationAndTraining = new Section("5. Education And Training");
		educationAndTraining.setItem("qual", "esta", "ioannina" , "12/05/2017", "22/05/2017");
		educationAndTraining.addItem();
		generator.saveEducationOrCourses(file, educationAndTraining);
		
		line = bReader.readLine();
		assertEquals("%5. Education And Training", line);
		line = bReader.readLine();
		assertEquals(" \\section{5. Education And Training} ", line);
		line = bReader.readLine();
		assertEquals("\\begin{itemize} ", line);
		line = bReader.readLine();
		assertEquals("\\item {qual, esta, ioannina, 12/05/2017 to 22/05/2017}", line);
		line = bReader.readLine();
		assertEquals("\\end{itemize} ", line);
		
		Section furtherCourses = new Section("6. Further Courses");
		furtherCourses.setItem("fix", "esta", "ioannina" , "12/05/2017", "13/05/2017");
		furtherCourses.addItem();
		generator.saveEducationOrCourses(file, furtherCourses);
		
		line = bReader.readLine();
		assertEquals("%6. Further Courses", line);
		line = bReader.readLine();
		assertEquals(" \\section{6. Further Courses} ", line);
		line = bReader.readLine();
		assertEquals("\\begin{itemize} ", line);
		line = bReader.readLine();
		assertEquals("\\item {fix, esta, ioannina, 12/05/2017 to 13/05/2017}", line);
		line = bReader.readLine();
		assertEquals("\\end{itemize} ", line);
	}
	
	
}
