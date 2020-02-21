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

public class TxtGeneratorTesting {
	private GeneratorFactory generatorFactory;
	private IGenerator generator;
	private FileReader fReader;
	private BufferedReader bReader;
	private String line = null;
	@Test
	public void test() throws IOException {
		File file = new File("10.txt");
		generatorFactory= new GeneratorFactory();
		generator = generatorFactory.constructGenerator("txt");
		generalInformation(file);
		saveParagraph(file);
		saveSkillsAndExperience(file);
		saveProfessionalExperience(file);
		saveCareerSummary(file);
		saveFurtherOrEducation(file);
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
		assertEquals("Functional", line);
		line = bReader.readLine();
		assertEquals("1. General Information ", line);
		line = bReader.readLine();
		assertEquals("	Name: tsi", line);
		line = bReader.readLine();
		assertEquals("	Address: N.Zerva", line);
		line = bReader.readLine();
		assertEquals("	Telephone: (Home) 123	(Mobile) 321", line);
		line = bReader.readLine();
		assertEquals("	Email: hello@hotmail.com", line);
	}
	
	public void saveParagraph(File file) throws IOException{
		Section professionalProfile = new Section("2. Professional Profile");
		professionalProfile.setParagraph("Billios sings beautiful");
		generator.saveParagraph(file, professionalProfile);
		
		line = bReader.readLine();
		assertEquals("2. Professional Profile", line);
		line = bReader.readLine();
		assertEquals("	Billios sings beautiful", line);
		
		Section coreStrengths = new Section("3. Core Strengths");
		coreStrengths.setParagraph("Billios sings bad");
		generator.saveParagraph(file, coreStrengths);
		
		line = bReader.readLine();
		assertEquals("3. Core Strengths", line);
		line = bReader.readLine();
		assertEquals("	Billios sings bad", line);
		
		Section additionalInformation = new Section("7. Additional Information");
		additionalInformation.setParagraph("Billios sings too loud");
		generator.saveParagraph(file, additionalInformation);
		
		line = bReader.readLine();
		assertEquals("7. Additional Information", line);
		line = bReader.readLine();
		assertEquals("	Billios sings too loud", line);
		
		Section interests = new Section("8. Interests");
		interests.setParagraph("Billios is too tires to sing");
		generator.saveParagraph(file, interests);
		
		line = bReader.readLine();
		assertEquals("8. Interests", line);
		line = bReader.readLine();
		assertEquals("	Billios is too tires to sing", line);
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
		assertEquals("3. Skills And Experience", line);
		line = bReader.readLine();
		assertEquals("	3.1 Skills And Experience On samsung", line);
		line = bReader.readLine();
		assertEquals("		* texnikos", line);
		line = bReader.readLine();
		assertEquals("		* seller", line);
		line = bReader.readLine();
		assertEquals("	3.2 Skills And Experience On apple", line);
		line = bReader.readLine();
		assertEquals("		* manager", line);
		
	}
	
	public void saveCareerSummary(File file) throws IOException{
		Section careerSummary = new Section("4. Career Summary");
		careerSummary.setItem("apple", "texnikos", "13/05/2016", "15/05/2017");
		careerSummary.addItem();
		generator.saveCareerSummary(file, careerSummary);
		
		line = bReader.readLine();
		assertEquals("4. Career Summary", line);
		line = bReader.readLine();
		assertEquals("	* apple, texnikos, 13/05/2016 to 15/05/2017", line);
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
		assertEquals("4. Professional Experience", line);
		line = bReader.readLine();
		assertEquals("	*** moto, searcher, 13/05/2017 to 30/05/2017", line);
		line = bReader.readLine();
		assertEquals("		** motoria", line);
		line = bReader.readLine();
		assertEquals("		** List of achievements ", line);
		line = bReader.readLine();
		assertEquals("			* na briskw motoria", line);
		line = bReader.readLine();
		assertEquals("			* service", line);
	}
	
	public void saveFurtherOrEducation(File file) throws IOException{
		Section educationAndTraining = new Section("5. Education And Training");
		educationAndTraining.setItem("qual", "esta", "ioannina" , "12/05/2017", "22/05/2017");
		educationAndTraining.addItem();
		generator.saveEducationOrCourses(file, educationAndTraining);
		
		line = bReader.readLine();
		assertEquals("5. Education And Training", line);
		line = bReader.readLine();
		assertEquals("	* qual, esta, ioannina, 12/05/2017 to 22/05/2017", line);
		
		Section furtherCourses = new Section("6. Further Courses");
		furtherCourses.setItem("fix", "esta", "ioannina" , "12/05/2017", "13/05/2017");
		furtherCourses.addItem();
		generator.saveEducationOrCourses(file, furtherCourses);
		
		line = bReader.readLine();
		assertEquals("6. Further Courses", line);
		line = bReader.readLine();
		assertEquals("	* fix, esta, ioannina, 12/05/2017 to 13/05/2017", line);
	}
	
	
}
