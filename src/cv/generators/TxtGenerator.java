package cv.generators;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import cv.main.*;

public class TxtGenerator implements IGenerator {
	
	public void saveGeneralInformation(File file,Cv cv){
		file.delete();
		BufferedWriter out = null;
		try {
	    	FileWriter fstream = new FileWriter(file,true);
	    	out = new BufferedWriter(fstream);
	    	out.write(cv.getType() + "\r\n" + "1. General Information "+ "\r\n" + "\tName: " + cv.getName() +"\r\n"+"\tAddress: " + cv.getAddress() +"\r\n"+ "\tTelephone: (Home) " 
	    			+ cv.getTelHome() +"\t"+ "(Mobile) "+ cv.getTelMobile() +"\r\n"+ "\tEmail: " + cv.getEmail() +"\r\n");
		}
		catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void saveParagraph(File file,Section section){
		BufferedWriter out = null;
		try {
			FileWriter fstream = new FileWriter(file,true);
			out = new BufferedWriter(fstream);
			out.write(section.getSectionName() + "\r\n\t" + section.getParagraph() +"\r\n");
		}catch (IOException e){
			System.err.println("Error: " + e.getMessage());
		}
		finally {
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}
	}
	
	public void saveSkillAndExperience(File file,Section section){
		BufferedWriter out = null;
		try {
			FileWriter fstream = new FileWriter(file,true);
			out = new BufferedWriter(fstream);
			out.write(section.getSectionName() + "\r\n");
			for(int i=0; i<section.getSizeArrayBulletList(); i++){
				int temp=i+1;
				out.write("\t3."+ temp + " Skills And Experience On " + section.getBulletListInPosition(i).getSkillAndExperienceOn() + "\r\n");
				for(int j=0; j<section.getBulletListInPosition(i).getSize(); j++){
					out.write("\t\t* " + section.getBulletListInPosition(i).getItem(j).getData() + "\r\n");
				}
			}
		} catch (IOException e){
		    System.err.println("Error: " + e.getMessage());
		}
		finally {
		    if(out != null){
		    	try {
		    		out.close();
		    	} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		}
	}
	
	public void saveProfessionalExperience(File file,Section section){
		BufferedWriter out = null;
		try {	
			FileWriter fstream = new FileWriter(file,true);
			out = new BufferedWriter(fstream);
			out.write(section.getSectionName() + "\r\n");
			for(int i=0; i<section.getSizeArrayBulletList(); i++){
				out.write("\t*** " + section.getBulletListInPosition(i).getCompanyName() + ", " + section.getBulletListInPosition(i).getJobTitle() + ", " + section.getBulletListInPosition(i).getDate1() + " to " + section.getBulletListInPosition(i).getDate2() + "\r\n");					
				out.write("\t\t** " + section.getBulletListInPosition(i).getResponsibilities() + "\r\n");
				out.write("\t\t** List of achievements \r\n");
				for(int j=0; j<section.getBulletListInPosition(i).getSize(); j++){
					out.write("\t\t\t* " + section.getBulletListInPosition(i).getItem(j).getData() + "\r\n");
				}
			}
		}
		catch (IOException e){
			System.err.println("Error: " + e.getMessage());
		}
		finally {
		    if(out != null) {
		        try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		}
	}
	
	public void saveCareerSummary(File file,Section section){
		BufferedWriter out = null;
		try {
			FileWriter fstream = new FileWriter(file,true);
			out = new BufferedWriter(fstream);
			out.write(section.getSectionName() + "\r\n");
			for(int i=0; i<section.getSizeBulletList(); i++){
				out.write("\t* " + section.getItemInPosition(i).getCompanyName() +", "+ section.getItemInPosition(i).getJobTitle() +", "+  
						section.getItemInPosition(i).getDate1() +" to "+ section.getItemInPosition(i).getDate2() + "\r\n");
			}	
		}
		catch (IOException e){
		    System.err.println("Error: " + e.getMessage());
		}
		finally {
		    if(out != null) {
		        try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		}
	}
	
	public void saveEducationOrCourses(File file,Section section){
		BufferedWriter out = null;
		try {
		    	FileWriter fstream = new FileWriter(file,true);
		    	out = new BufferedWriter(fstream);
		    	out.write(section.getSectionName() + "\r\n");
		    	for(int i=0; i<section.getSizeBulletList(); i++){
		    		out.write("\t* " + section.getItemInPosition(i).getQualOrCourse() +", "+ section.getItemInPosition(i).getEstablishment() +", "+  
		    				section.getItemInPosition(i).getLocation() +", "+ section.getItemInPosition(i).getDate1() +" to "+ section.getItemInPosition(i).getDate2() + "\r\n");
		    	}
		}	
		catch (IOException e){
			System.err.println("Error: " + e.getMessage());
		}
		finally {
		    if(out != null) {
		        try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    }
		}
	}
	
	
}
