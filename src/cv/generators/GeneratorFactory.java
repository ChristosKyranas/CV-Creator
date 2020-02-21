package cv.generators;

public class GeneratorFactory {
	
	public IGenerator constructGenerator(String generatorFormat){
		if(generatorFormat.equals("txt")){
			return new TxtGenerator();
		}else if(generatorFormat.equals("latex")){
			return new LatexGenerator();
		}
		
		System.out.println("If the code got up to here, you passed a wrong format to GeneratorFactory");
		return null;
	}
}
