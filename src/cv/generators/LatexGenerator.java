package cv.generators;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import cv.main.*;

public class LatexGenerator implements IGenerator {
	
	public void saveGeneralInformation(File file,Cv cv){
		file.delete();
		BufferedWriter out = null;
		try {
			FileWriter fstream = new FileWriter(file,true); 
	    	out = new BufferedWriter(fstream);
			out.write("\\documentclass{article} \r\n \\title{" + cv.getType() +"} \r\n \\usepackage{amssymb} \r\n \\begin{document} \r\n");
			out.write("%" + "General Information" + "\r\n \\section{ " + "General Information" + "} \r\n {Name: " + cv.getName() +"} \\newline \r\n {Address: " + cv.getAddress() +"} \\newline \r\n {Telephone: (Home) " 
							+ cv.getTelHome() +"}  \t{(Mobile) "+ cv.getTelMobile() +"} \\newline \r\n {Email: " + cv.getEmail() +"}\r\n");
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
			if(section.getSectionName().equals("8. Interests")){
				out.write("%"+ "Interests" +"\r\n \\section{" +  "Interests" + "} \r\n {" + section.getParagraph() +"}\r\n\\end{document}");
			}else{
				String title = null;
				for(String temp : section.getSectionName().split(". ")){
					title = temp;
				}
				out.write("%"+ title +"\r\n \\section{" + title + "} \r\n {" + section.getParagraph() +"}\r\n");
			}
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
			out.write("%" + section.getSectionName() + "\r\n \\section{"+ section.getSectionName() +"} \r\n");
			for(int i=0; i<section.getSizeArrayBulletList(); i++){
				int temp=i+1;
				out.write("{3."+ temp + " Skills And Experience On " + section.getBulletListInPosition(i).getSkillAndExperienceOn()+ "}\r\n");
				out.write("\\begin{itemize} \r\n");
				if(section.getBulletListInPosition(i).getSize() == 0){
					out.write("\\item {}");
				}
				for(int j=0; j<section.getBulletListInPosition(i).getSize(); j++){
					out.write("\\item {" + section.getBulletListInPosition(i).getItem(j).getData() + "}\r\n");
				}
				out.write("\\end{itemize} \r\n");
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
			out.write("%" + section.getSectionName() + "\r\n \\section{"+ section.getSectionName() +"} \r\n");
			out.write("\\renewcommand{\\labelitemii}{$\\circ$} \r\n \\renewcommand{\\labelitemiii}{\\tiny$\\blacksquare$} \r\n");
			for(int i=0; i<section.getSizeArrayBulletList(); i++){
				out.write("%profExp\r\n");
				out.write("\\begin{itemize} \r\n");
				out.write("\\item {" + section.getBulletListInPosition(i).getCompanyName() + ", " + section.getBulletListInPosition(i).getJobTitle() + ", " + section.getBulletListInPosition(i).getDate1()+ ", " + section.getBulletListInPosition(i).getDate2()+ "}\r\n");
				out.write("%Responibilities\r\n");
				out.write("\\begin{itemize} \r\n");
				out.write("\\item {" + section.getBulletListInPosition(i).getResponsibilities() + "}\r\n \\item {List of achievements}\r\n");
				out.write("\\begin{itemize} \r\n");
				if(section.getBulletListInPosition(i).getSize() == 0){
					out.write("\\item {}");
				}
				for(int j=0; j<section.getBulletListInPosition(i).getSize(); j++){
					out.write("\\item {" + section.getBulletListInPosition(i).getItem(j).getData() + "}\r\n");
				}
				out.write("\\end{itemize} \r\n");
				out.write("\\end{itemize} \r\n");
				out.write("\\end{itemize} \r\n");
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
			out.write("%" + section.getSectionName() + "\r\n \\section{"+ section.getSectionName() +"} \r\n");
			out.write("\\begin{itemize} \r\n");
			if(section.getSizeBulletList() == 0){
				out.write("\\item {}");
			}
			for(int i=0; i<section.getSizeBulletList(); i++){
				out.write("\\item {" + section.getItemInPosition(i).getCompanyName() +", "+ section.getItemInPosition(i).getJobTitle() +", "+  
						section.getItemInPosition(i).getDate1() +" to "+ section.getItemInPosition(i).getDate2() + "}\r\n");
			}
			out.write("\\end{itemize} \r\n");
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
	    	out.write("%" + section.getSectionName() + "\r\n \\section{"+ section.getSectionName() +"} \r\n");
	    	out.write("\\begin{itemize} \r\n");
			if(section.getSizeBulletList()==0){
				out.write("\\item {}");
			}
			for(int i=0; i<section.getSizeBulletList(); i++){
				out.write("\\item {" +  section.getItemInPosition(i).getQualOrCourse() +", "+ section.getItemInPosition(i).getEstablishment() +", "+  
						section.getItemInPosition(i).getLocation() +", "+ section.getItemInPosition(i).getDate1() +" to "+ section.getItemInPosition(i).getDate2() + "}\r\n");
			}
			out.write("\\end{itemize} \r\n");
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
