package cv.main;

public class CvFactory {
	
	 public Cv constructCv(String type) {
	        return new Cv(type);
	    }
}
