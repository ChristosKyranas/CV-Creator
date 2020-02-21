package cv.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import cv.main.Item;

public class ItemTesting {

	@Test
	public void test() {
		Item test = new Item();
		String temp=null;
		
		test.setData("start");
		temp = test.getData();
		assertEquals("start", temp);
		
		test.setQualOrCourse("hello");
		temp = test.getQualOrCourse();
		assertEquals("hello", temp);
		
		test.setEstablishment("hello1");
		temp = test.getEstablishment(); 
		assertEquals("hello1", temp );
		
		test.setLocation("Ioannina");
		temp = test.getLocation();
		assertEquals("Ioannina", temp);
		
		test.setCompanyName("tsi");
		temp = test.getCompanyName();
		assertEquals("tsi", temp);
		
		test.setJobTitle("manager");
		temp = test.getJobTitle();
		assertEquals("manager", temp);
	
		test.setDate1("20/12/2001");
		temp = test.getDate1();
		assertEquals("20/12/2001", temp);
		
		test.setDate2("20/12/2010");
		temp = test.getDate2();
		assertEquals("20/12/2010", temp);
		
		
	}

}
