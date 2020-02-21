package cv.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import cv.main.Item;
import cv.main.Section;
import cv.main.SectionFactory;

public class SectionTesting {

	private SectionFactory sectionFactory;
	private String temp;
	@Test
	public void test() {
		testParagraph();
		testSkillAndExperience();
		testProfessionalExperience();
		testCareerSummary();
		testEducationOrCourses();
	}

	public void testParagraph(){
		temp = null;
		sectionFactory = new SectionFactory();
		Section section = sectionFactory.constructSection("2. Professional Profile");
		section.setParagraph("a String");
		temp = section.getParagraph();
		assertEquals("a String", temp);
	}
	
	public void testSkillAndExperience(){
		temp = null;
		sectionFactory = new SectionFactory();
		Section section = sectionFactory.constructSection("3. Skills And Experience");				
		section.setBulletList("Skill And Experience 1");
		section.setItem("data1");
		section.addItem();
		section.setItem("data2");
		section.addItem();
		section.addBulletList();
		section.setBulletList("Skill And Experience 2");
		section.setItem("data3");
		section.addItem();
		section.setItem("data4");
		section.addItem();
		section.addBulletList();	
		temp = section.getBulletListInPosition(0).getItem(0).getData();
		assertEquals("data1", temp);
		temp = section.getBulletListInPosition(0).getItem(1).getData();
		assertEquals("data2", temp);
		temp = section.getBulletListInPosition(1).getItem(0).getData();
		assertEquals("data3", temp);
		temp = section.getBulletListInPosition(1).getItem(1).getData();
		assertEquals("data4", temp);
		section.getBulletListInPosition(1).pop(0);
		temp = section.getBulletListInPosition(1).getItem(0).getData();
		assertEquals("data4", temp);
		Item item = new Item();
		item.setData("data5");
		section.getBulletListInPosition(0).setInPosition(item, 0);
		temp = section.getBulletListInPosition(0).getItem(0).getData();
		assertEquals("data5", temp);
		temp = section.getBulletListInPosition(0).getSkillAndExperienceOn();
		assertEquals("Skill And Experience 1", temp);
		temp = section.getBulletListInPosition(1).getSkillAndExperienceOn();
		assertEquals("Skill And Experience 2", temp);
		section.setBulletList(0, "123");
		temp = section.getBulletListInPosition(0).getSkillAndExperienceOn();
		assertEquals("123", temp);
	}
	
	public void testProfessionalExperience(){
		temp = null;
		sectionFactory = new SectionFactory();
		Section section = sectionFactory.constructSection("4. Professional Experience");
		section.setBulletList("company name","job title","date 1","date 2","responsibilities");
		section.setItem("data1");
		section.addItem();
		section.setItem("data2");
		section.addItem();
		section.addBulletList();
		section.setBulletList("apple", "software engineer", "22/5/2017", "03/8/2018", "programming");
		section.setItem("data3");
		section.addItem();
		section.setItem("data4");
		section.addItem();
		section.addBulletList();
		temp = section.getBulletListInPosition(0).getCompanyName();
		assertEquals("company name", temp);
		temp = section.getBulletListInPosition(0).getJobTitle();
		assertEquals("job title", temp);
		temp = section.getBulletListInPosition(0).getDate1();
		assertEquals("date 1", temp);
		temp = section.getBulletListInPosition(0).getDate2();
		assertEquals("date 2", temp);
		temp = section.getBulletListInPosition(0).getResponsibilities();
		assertEquals("responsibilities", temp);
		temp = section.getBulletListInPosition(1).getCompanyName();
		assertEquals("apple", temp);
		temp = section.getBulletListInPosition(1).getJobTitle();
		assertEquals("software engineer", temp);
		temp = section.getBulletListInPosition(1).getDate1();
		assertEquals("22/5/2017", temp);
		temp = section.getBulletListInPosition(1).getDate2();
		assertEquals("03/8/2018", temp);
		temp = section.getBulletListInPosition(1).getResponsibilities();
		assertEquals("programming", temp);
		temp = section.getBulletListInPosition(0).getItem(0).getData();
		assertEquals("data1", temp);
		temp = section.getBulletListInPosition(0).getItem(1).getData();
		assertEquals("data2", temp);
		temp = section.getBulletListInPosition(1).getItem(0).getData();
		assertEquals("data3", temp);
		temp = section.getBulletListInPosition(1).getItem(1).getData();
		assertEquals("data4", temp);
		section.getBulletListInPosition(1).pop(0);
		temp = section.getBulletListInPosition(1).getItem(0).getData();
		assertEquals("data4", temp);
		Item item = new Item();
		item.setData("data5");
		section.getBulletListInPosition(0).setInPosition(item, 0);
		temp = section.getBulletListInPosition(0).getItem(0).getData();
		assertEquals("data5", temp);
	}
	
	public void testCareerSummary(){
		temp = null;
		sectionFactory = new SectionFactory();
		Section section = sectionFactory.constructSection("4. Career Summary");
		section.setItem("company name","job title","date 1","date 2");
		section.addItem();
		section.setItem("apple", "software engineer", "22/5/2017", "03/8/2018");
		section.addItem();
		temp = section.getItemInPosition(0).getCompanyName();
		assertEquals("company name", temp);
		temp = section.getItemInPosition(0).getJobTitle();
		assertEquals("job title", temp);
		temp = section.getItemInPosition(0).getDate1();
		assertEquals("date 1", temp);
		temp = section.getItemInPosition(0).getDate2();
		assertEquals("date 2", temp);
		temp = section.getItemInPosition(1).getCompanyName();
		assertEquals("apple", temp);
		temp = section.getItemInPosition(1).getJobTitle();
		assertEquals("software engineer", temp);
		temp = section.getItemInPosition(1).getDate1();
		assertEquals("22/5/2017", temp);
		temp = section.getItemInPosition(1).getDate2();
		assertEquals("03/8/2018", temp);
		section.deleteItem(0);
		temp = section.getItemInPosition(0).getCompanyName();
		assertEquals("apple", temp);
		temp = section.getItemInPosition(0).getJobTitle();
		assertEquals("software engineer", temp);
		temp = section.getItemInPosition(0).getDate1();
		assertEquals("22/5/2017", temp);
		temp = section.getItemInPosition(0).getDate2();
		assertEquals("03/8/2018", temp);
	}

	public void testEducationOrCourses(){
		temp = null;
		sectionFactory = new SectionFactory();
		Section section = sectionFactory.constructSection("5. Education And Training"); // Same with 6. Further Courses
		section.setItem("qualOrCourse", "establishment", "location", "date1", "date2");
		section.addItem();
		section.setItem("qual", "estab", "ioannina", "22/5/2017", "03/8/2018");
		section.addItem();
		temp = section.getItemInPosition(0).getQualOrCourse();
		assertEquals("qualOrCourse", temp);
		temp = section.getItemInPosition(0).getEstablishment();
		assertEquals("establishment", temp);
		temp = section.getItemInPosition(0).getLocation();
		assertEquals("location", temp);
		temp = section.getItemInPosition(0).getDate1();
		assertEquals("date1", temp);
		temp = section.getItemInPosition(0).getDate2();
		assertEquals("date2", temp);
		temp = section.getItemInPosition(1).getQualOrCourse();
		assertEquals("qual", temp);
		temp = section.getItemInPosition(1).getEstablishment();
		assertEquals("estab", temp);
		temp = section.getItemInPosition(1).getLocation();
		assertEquals("ioannina", temp);
		temp = section.getItemInPosition(1).getDate1();
		assertEquals("22/5/2017", temp);
		temp = section.getItemInPosition(1).getDate2();
		assertEquals("03/8/2018", temp);
		section.deleteItem(0);
		temp = section.getItemInPosition(0).getQualOrCourse();
		assertEquals("qual", temp);
		temp = section.getItemInPosition(0).getEstablishment();
		assertEquals("estab", temp);
		temp = section.getItemInPosition(0).getLocation();
		assertEquals("ioannina", temp);
		temp = section.getItemInPosition(0).getDate1();
		assertEquals("22/5/2017", temp);
		temp = section.getItemInPosition(0).getDate2();
		assertEquals("03/8/2018", temp);
	}
}

