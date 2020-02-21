package cv.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import cv.main.Cv;
import cv.main.Section;

public interface IParser {
	public abstract void loadGeneralInformation(File file,Cv cv) throws FileNotFoundException;
	public abstract void loadParagraph(File file,Section section) throws FileNotFoundException;
	public abstract void loadSkillAndExperience(File file,Section section) throws FileNotFoundException;
	public abstract void loadProfessionalExperience(File file,Section section) throws FileNotFoundException;
	public abstract void loadCareerSummary(File file,Section section) throws FileNotFoundException;
	public abstract void loadEducationOrCourses(File file,Section section) throws FileNotFoundException;
}
