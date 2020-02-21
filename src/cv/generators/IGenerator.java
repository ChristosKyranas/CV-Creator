package cv.generators;

import java.io.File;

import cv.main.Cv;
import cv.main.Section;

public interface IGenerator {
	public abstract void saveGeneralInformation(File file,Cv cv);
	public abstract void saveParagraph(File file,Section section);
	public abstract void saveSkillAndExperience(File file,Section section);
	public abstract  void saveProfessionalExperience(File file,Section section);
	public abstract void saveCareerSummary(File file,Section section);
	public abstract  void saveEducationOrCourses(File file,Section section);
}
