package cv.main;

import cv.main.Section;

public class SectionFactory {
	
	    public Section constructSection(String sectionName) {
	        return new Section(sectionName);
	    }
}
