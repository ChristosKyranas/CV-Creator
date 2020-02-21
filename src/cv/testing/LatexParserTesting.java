package cv.testing;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

import cv.main.Cv;
import cv.main.CvFactory;
import cv.main.Section;
import cv.main.SectionFactory;
import cv.parsers.IParser;
import cv.parsers.ParserFactory;

public class LatexParserTesting {
	
	private File file;
	private ParserFactory parserFactory = new ParserFactory();
	private IParser parser;
	
		
	@Test
	public void test() {
		loadFunctional();
		loadChronological();
		loadCombined();
	}


	public void loadFunctional(){
		
		Cv functional = new Cv("Functional");
		SectionFactory sectionFactory = new SectionFactory();
	    Section professionalProfile = sectionFactory.constructSection("2. Professional Profile");
	    functional.add(professionalProfile);
	    Section skillAndExperience = sectionFactory.constructSection("3. Skills And Experience");
	    functional.add(skillAndExperience);
	    Section careerSummary = sectionFactory.constructSection("4. Career Summary");
		functional.add(careerSummary);
		Section educationAndTraining = sectionFactory.constructSection("5. Education And Training");
		functional.add(educationAndTraining);
		Section furtherCourses = sectionFactory.constructSection("6. Further Courses");
		functional.add(furtherCourses);
		Section additionalInformation = sectionFactory.constructSection("7. Additional Information");
		functional.add(additionalInformation);
		Section interests = sectionFactory.constructSection("8. Interests");
		functional.add(interests);	
		parserFactory = new ParserFactory();
		
		file =  new File("1.tex");
			try {
				parser = parserFactory.constructParser("latex");
				parser.loadGeneralInformation(file,functional);
				assertEquals("Vasilis", functional.getName());
				assertEquals("N.Zerva", functional.getAddress());
				assertEquals("23213", functional.getTelHome());
				assertEquals("312312", functional.getTelMobile());
				assertEquals("papaki@hotmail.com", functional.getEmail());
				
				parser.loadParagraph(file, professionalProfile);
				assertEquals("Hello World!!!", professionalProfile.getParagraph());
				
				parser.loadSkillAndExperience(file, skillAndExperience);
				assertEquals("apple", skillAndExperience.getBulletListInPosition(0).getSkillAndExperienceOn());
				assertEquals("texnikos", skillAndExperience.getBulletListInPosition(0).getItem(0).getData());
				assertEquals("samsung", skillAndExperience.getBulletListInPosition(1).getSkillAndExperienceOn());
				assertEquals("huawei", skillAndExperience.getBulletListInPosition(2).getSkillAndExperienceOn());
				assertEquals("pwlhths", skillAndExperience.getBulletListInPosition(2).getItem(0).getData());
				assertEquals("texnikos", skillAndExperience.getBulletListInPosition(2).getItem(1).getData());
				
				parser.loadCareerSummary(file, careerSummary);
				assertEquals("apple", careerSummary.getItemInPosition(0).getCompanyName());
				assertEquals("texnikos", careerSummary.getItemInPosition(0).getJobTitle());
				assertEquals("13/05/2016", careerSummary.getItemInPosition(0).getDate1());
				assertEquals("15/05/2017", careerSummary.getItemInPosition(0).getDate2());
				assertEquals("samsung", careerSummary.getItemInPosition(1).getCompanyName());
				assertEquals("", careerSummary.getItemInPosition(1).getJobTitle());
				assertEquals("12/05/2015", careerSummary.getItemInPosition(1).getDate1());
				assertEquals("13/05/2016", careerSummary.getItemInPosition(1).getDate2());
				
				parser.loadEducationOrCourses(file, educationAndTraining);
				assertEquals("qual", educationAndTraining.getItemInPosition(0).getQualOrCourse());
				assertEquals("esta", educationAndTraining.getItemInPosition(0).getEstablishment());
				assertEquals("ioannina", educationAndTraining.getItemInPosition(0).getLocation());
				assertEquals("12/05/2017", educationAndTraining.getItemInPosition(0).getDate1());
				assertEquals("22/05/2017", educationAndTraining.getItemInPosition(0).getDate2());
				
				parser.loadEducationOrCourses(file, furtherCourses);
				assertEquals("fix", furtherCourses.getItemInPosition(0).getQualOrCourse());
				assertEquals("esta", furtherCourses.getItemInPosition(0).getEstablishment());
				assertEquals("ioannina", furtherCourses.getItemInPosition(0).getLocation());
				assertEquals("12/05/2017", furtherCourses.getItemInPosition(0).getDate1());
				assertEquals("13/05/2017", furtherCourses.getItemInPosition(0).getDate2());
				
				parser.loadParagraph(file, additionalInformation);
				assertEquals("i am pro now", additionalInformation.getParagraph());
				
				parser.loadParagraph(file, interests);
				assertEquals("fix code", interests.getParagraph());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	
	public void loadChronological(){

		
		Cv chronological = new Cv("Chronological");
		SectionFactory sectionFactory = new SectionFactory();
	    Section professionalProfile = sectionFactory.constructSection("2. Professional Profile");
	    chronological.add(professionalProfile);
	    Section coreStrengths = sectionFactory.constructSection("3. Core Strengths");
		chronological.add(coreStrengths);
		Section professionalExperience = sectionFactory.constructSection("4. Professional Experience");
		chronological.add(professionalExperience);
		Section educationAndTraining = sectionFactory.constructSection("5. Education And Training");
		chronological.add(educationAndTraining);
		Section furtherCourses = sectionFactory.constructSection("6. Further Courses");
		chronological.add(furtherCourses);
		Section additionalInformation = sectionFactory.constructSection("7. Additional Information");
		chronological.add(additionalInformation);
		Section interests = sectionFactory.constructSection("8. Interests");
		chronological.add(interests);	
		parserFactory = new ParserFactory();
		
		file =  new File("2.tex");
			try {
				parser = parserFactory.constructParser("latex");
				parser.loadGeneralInformation(file,chronological);
				assertEquals("Christos", chronological.getName());
				assertEquals("N.Zerva1", chronological.getAddress());
				assertEquals("12423", chronological.getTelHome());
				assertEquals("423324423", chronological.getTelMobile());
				assertEquals("gazakias@hotmail.gr", chronological.getEmail());
				
				parser.loadParagraph(file, professionalProfile);
				assertEquals("moto gazakias", professionalProfile.getParagraph());
				
				parser.loadParagraph(file, coreStrengths);
				assertEquals("power, durasel", coreStrengths.getParagraph());
				
				parser.loadProfessionalExperience(file, professionalExperience);
				assertEquals("moto search", professionalExperience.getBulletListInPosition(0).getCompanyName());
				assertEquals("search", professionalExperience.getBulletListInPosition(0).getJobTitle());
				assertEquals("13/05/2017", professionalExperience.getBulletListInPosition(0).getDate1());
				assertEquals("30/05/2017", professionalExperience.getBulletListInPosition(0).getDate2());
				assertEquals("motoria", professionalExperience.getBulletListInPosition(0).getResponsibilities());
				assertEquals("na briskw motoria", professionalExperience.getBulletListInPosition(0).getItem(0).getData());
				assertEquals("moto fix", professionalExperience.getBulletListInPosition(1).getCompanyName());
				assertEquals("fix", professionalExperience.getBulletListInPosition(1).getJobTitle());
				assertEquals("13/05/2017", professionalExperience.getBulletListInPosition(1).getDate1());
				assertEquals("29/05/2017", professionalExperience.getBulletListInPosition(1).getDate2());
				assertEquals("fix motoria", professionalExperience.getBulletListInPosition(1).getResponsibilities());
				assertEquals("fix fanaria", professionalExperience.getBulletListInPosition(1).getItem(0).getData());
				assertEquals("service", professionalExperience.getBulletListInPosition(1).getItem(1).getData());
				
				
				parser.loadEducationOrCourses(file, educationAndTraining);
				assertEquals("qual", educationAndTraining.getItemInPosition(0).getQualOrCourse());
				assertEquals("esta", educationAndTraining.getItemInPosition(0).getEstablishment());
				assertEquals("ioannina", educationAndTraining.getItemInPosition(0).getLocation());
				assertEquals("12/05/2017", educationAndTraining.getItemInPosition(0).getDate1());
				assertEquals("22/05/2017", educationAndTraining.getItemInPosition(0).getDate2());
				
				parser.loadEducationOrCourses(file, furtherCourses);
				assertEquals("fix", furtherCourses.getItemInPosition(0).getQualOrCourse());
				assertEquals("esta", furtherCourses.getItemInPosition(0).getEstablishment());
				assertEquals("ioannina", furtherCourses.getItemInPosition(0).getLocation());
				assertEquals("12/05/2017", furtherCourses.getItemInPosition(0).getDate1());
				assertEquals("13/05/2017", furtherCourses.getItemInPosition(0).getDate2());
				
				parser.loadParagraph(file, additionalInformation);
				assertEquals("i am good boy", additionalInformation.getParagraph());
				
				parser.loadParagraph(file, interests);
				assertEquals("make souzes", interests.getParagraph());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	}

	public void loadCombined(){
		Cv combined = new Cv("Combined");
		SectionFactory sectionFactory = new SectionFactory();
	    Section professionalProfile = sectionFactory.constructSection("2. Professional Profile");
	    combined.add(professionalProfile);
	    Section skillAndExperience = sectionFactory.constructSection("3. Skills And Experience");
	    combined.add(skillAndExperience);
	    Section professionalExperience = sectionFactory.constructSection("4. Professional Experience");
		combined.add(professionalExperience);
		Section educationAndTraining = sectionFactory.constructSection("5. Education And Training");
		combined.add(educationAndTraining);
		Section furtherCourses = sectionFactory.constructSection("6. Further Courses");
		combined.add(furtherCourses);
		Section additionalInformation = sectionFactory.constructSection("7. Additional Information");
		combined.add(additionalInformation);
		Section interests = sectionFactory.constructSection("8. Interests");
		combined.add(interests);	
		
		
		file =  new File("3.tex");
		try {
			parser = parserFactory.constructParser("latex");
			parser.loadGeneralInformation(file,combined);
			assertEquals("ChristosVasilis", combined.getName());
			assertEquals("N.Zerva1", combined.getAddress());
			assertEquals("12423", combined.getTelHome());
			assertEquals("423324423", combined.getTelMobile());
			assertEquals("gazakias@hotmail.gr", combined.getEmail());
			
			parser.loadParagraph(file, professionalProfile);
			assertEquals("moto gazakias", professionalProfile.getParagraph());
			
			parser.loadSkillAndExperience(file, skillAndExperience);
			assertEquals("apple", skillAndExperience.getBulletListInPosition(0).getSkillAndExperienceOn());
			assertEquals("texnikos", skillAndExperience.getBulletListInPosition(0).getItem(0).getData());
			assertEquals("samsung", skillAndExperience.getBulletListInPosition(1).getSkillAndExperienceOn());
			assertEquals("huawei", skillAndExperience.getBulletListInPosition(2).getSkillAndExperienceOn());
			assertEquals("pwlhths", skillAndExperience.getBulletListInPosition(2).getItem(0).getData());
			assertEquals("texnikos", skillAndExperience.getBulletListInPosition(2).getItem(1).getData());
			
			parser.loadProfessionalExperience(file, professionalExperience);
			assertEquals("moto search", professionalExperience.getBulletListInPosition(0).getCompanyName());
			assertEquals("search", professionalExperience.getBulletListInPosition(0).getJobTitle());
			assertEquals("13/05/2017", professionalExperience.getBulletListInPosition(0).getDate1());
			assertEquals("30/05/2017", professionalExperience.getBulletListInPosition(0).getDate2());
			assertEquals("motoria", professionalExperience.getBulletListInPosition(0).getResponsibilities());
			assertEquals("na briskw motoria", professionalExperience.getBulletListInPosition(0).getItem(0).getData());
			assertEquals("moto fix", professionalExperience.getBulletListInPosition(1).getCompanyName());
			assertEquals("fix", professionalExperience.getBulletListInPosition(1).getJobTitle());
			assertEquals("13/05/2017", professionalExperience.getBulletListInPosition(1).getDate1());
			assertEquals("29/05/2017", professionalExperience.getBulletListInPosition(1).getDate2());
			assertEquals("fix motoria", professionalExperience.getBulletListInPosition(1).getResponsibilities());
			assertEquals("fix fanaria", professionalExperience.getBulletListInPosition(1).getItem(0).getData());
			assertEquals("service", professionalExperience.getBulletListInPosition(1).getItem(1).getData());
			
			
			parser.loadEducationOrCourses(file, educationAndTraining);
			assertEquals("qual", educationAndTraining.getItemInPosition(0).getQualOrCourse());
			assertEquals("esta", educationAndTraining.getItemInPosition(0).getEstablishment());
			assertEquals("ioannina", educationAndTraining.getItemInPosition(0).getLocation());
			assertEquals("12/05/2017", educationAndTraining.getItemInPosition(0).getDate1());
			assertEquals("22/05/2017", educationAndTraining.getItemInPosition(0).getDate2());
			
			parser.loadEducationOrCourses(file, furtherCourses);
			assertEquals("fix", furtherCourses.getItemInPosition(0).getQualOrCourse());
			assertEquals("esta", furtherCourses.getItemInPosition(0).getEstablishment());
			assertEquals("ioannina", furtherCourses.getItemInPosition(0).getLocation());
			assertEquals("12/05/2017", furtherCourses.getItemInPosition(0).getDate1());
			assertEquals("13/05/2017", furtherCourses.getItemInPosition(0).getDate2());
			
			parser.loadParagraph(file, additionalInformation);
			assertEquals("i am good boy", additionalInformation.getParagraph());
			
			parser.loadParagraph(file, interests);
			assertEquals("make souzes", interests.getParagraph());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
