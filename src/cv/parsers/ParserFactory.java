package cv.parsers;

import cv.generators.IGenerator;
import cv.generators.LatexGenerator;
import cv.generators.TxtGenerator;

public class ParserFactory {
	public IParser constructParser(String generatorFormat){
		if(generatorFormat.equals("txt")){
			return new TxtParser();
		}else if(generatorFormat.equals("latex")){
			return new LatexParser();
		}
		
		System.out.println("If the code got up to here, you passed a wrong format to ParserFactory");
		return null;
	}
}
