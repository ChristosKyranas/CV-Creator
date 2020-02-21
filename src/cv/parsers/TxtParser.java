package cv.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import cv.main.*;


public class TxtParser implements IParser {
	
	private FileReader fReader;
	private BufferedReader bReader;
	private String line = null;
	
	public void loadGeneralInformation(File file,Cv cv) throws FileNotFoundException{
		fReader = new FileReader(file);
		bReader = new BufferedReader(fReader);
		
		try {
			line = bReader.readLine();
			line = bReader.readLine();
			if(line.contains("1. General Information")){
				while((line = bReader.readLine())!=null){
					if(line.contains("Name: ")){
						for(String temp : line.split("Name: ")){
							cv.setName(temp);
						}
					}
					else if(line.contains("Address: ")){
						for(String temp : line.split("Address: ")){
							cv.setAddress(temp);
						}
					}
					else if(line.contains("Telephone: (Home) ") == true){
						if(line.contains("(Mobile) ") == true){
							for(String temp : line.split("Telephone: \\(Home\\) ")){
								int i=0;
								for(String temp1 : temp.split("	\\(Mobile\\) ")){
									if(i==0){
										
										cv.setTelHome(temp1);
										i++;
									}
									else if(i==1){
										cv.setTelMobile(temp1);
									}
								}
							}
						}
					}
					else if(line.contains("Email: ")){
						for(String temp : line.split("Email: ")){
							cv.setEmail(temp);
						}
						line = bReader.readLine();
						break;
					}
					else{
						JOptionPane.showMessageDialog(null, "Error Opening File:Wrong CV Format");
						
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadParagraph(File file,Section section) throws FileNotFoundException{
		try {
			if(line.equals("2. Professional Profile")){
				line = bReader.readLine();
				for(String temp : line.split("\t")){
					line = temp;
				}
				section.setParagraph(line);
				line = bReader.readLine();
			}else if(line.equals("3. Core Strengths")){
				line = bReader.readLine();
				for(String temp : line.split("\t")){
					line = temp;
				}
				section.setParagraph(line);
				line = bReader.readLine();
			}
			else if((line = bReader.readLine()).equals("8. Interests")){
				line = bReader.readLine();
				for(String temp : line.split("\t")){
					line = temp;
				}
				section.setParagraph(line);
				bReader.close();
				fReader.close();
			}
			else{
				for(String temp : line.split("\t")){
					line = temp;
				}
				section.setParagraph(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadSkillAndExperience(File file,Section section) throws FileNotFoundException{
		int count=1, tempCount=0;
		
		try {
			if(line.equals("3. Skills And Experience")){
					line = bReader.readLine();
					if(line.contains("3." + count + " Skills And Experience On ")){
						for(String temp : line.split("3." + count + " Skills And Experience On ")){
							if(tempCount==0){
								tempCount++;
							}
							else if(tempCount==1){
								section.setBulletList(temp);
							}
						}
					}
					count++;
					tempCount=0;
					while((line = bReader.readLine())!=null){
						tempCount = 0;
						if(line.equals("4. Career Summary") || line.equals("4. Professional Experience")){
							section.addBulletList();
							break;
						}
						else if(line.contains("3." + count + " Skills And Experience On ")){
							section.addBulletList();
							for(String temp : line.split("3." + count + " Skills And Experience On ")){
								if(tempCount==0){
									tempCount++;
								}
								else if(tempCount==1){
									section.setBulletList(temp);
								}
							}
							count++;
						}
						else if(line.contains("*")){
							for(String temp : line.split("\\* ")){
								if(tempCount==0){
									tempCount++;
								}
								else if(tempCount==1){
									section.setItem(temp);
									section.addItem();
								}
							}
						}
					}
			}
			else if(line==null){
				JOptionPane.showMessageDialog(null, "Error Opening File:Wrong CV Format");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadProfessionalExperience(File file,Section section) throws FileNotFoundException{
		int count=0;
		boolean flag=false;
		String companyName = null,jobTitle = null,responsibilities = null,date1 = null,date2 = null;
		String date;
		try {
			if(line.equals("4. Professional Experience")){
				while((line = bReader.readLine())!=null){ 
					count=0;
					if(line.contains("5. Education And Training")){
						if(flag == true){
							section.setBulletList(companyName, jobTitle, date1, date2, responsibilities);
							section.addBulletList();
						}
						break;
					}
					if(line.contains("***")){
						if(flag==false){
							flag=true;
						}
						else{
							section.setBulletList(companyName, jobTitle, date1, date2, responsibilities);
							section.addBulletList();
						}
						for(String temp : line.split("\\*\\*\\* ")){
							if(count==0){
								count++;
							}
							else if(count==1){
								date=null;
								int i = 0;
								for(String temp1 : temp.split(", ")){
									if(i==0){
										companyName = temp1;
										i++;
									}
									else if(i==1){
										jobTitle = temp1;
										i++;
									}
									else{
										date = temp1;
									}
								}
								i=0;
								
								for(String temp2 : date.split(" to ")){
									if(i==0){
										date1 = temp2;
										i++;
									}
									else if(i==1){
										date2 = temp2;
									}
								}
							}
						}
					}
					else if(line.contains("** List of achievements")){
						continue;
					}
					else if(line.contains("**")){
						for(String temp : line.split("\\*\\* ")){
							if(count==0){
								count++;
							}
							else if(count==1){
								
								responsibilities = temp;
							}
						}
					}
					else if(line.contains("*")){
						for(String temp : line.split("\\* ")){
							if(count==0){
								count++;
							}
							else if(count==1){
								section.setItem(temp);
								section.addItem();
							}
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadCareerSummary(File file,Section section) throws FileNotFoundException{
		int count=0;
		String companyName = null,jobTitle = null,date1 = null,date2 = null, date;
		boolean flag=false;
		
		try {
			while((line = bReader.readLine())!=null ){
					count=0;
					if(line.equals("5. Education And Training")){
						
						if(flag==true){
							section.addItem();
						}
						break;
					}
					if(line.contains("*")){
						if(flag==false){
							flag=true;
						}
						else{
							section.addItem();
						}
						for(String temp : line.split("\\* ")){
							if(count==0){
								count++;
							}
							else if(count==1){
								date=null;
								int i = 0;
								for(String temp1 : temp.split(", ")){
									if(i==0){
										companyName = temp1;
										i++;
									}
									else if(i==1){
										jobTitle = temp1;
										i++;
									}
									else{
										date = temp1;
									}
								}
								i=0;
								for(String temp2 : date.split(" to ")){
									if(i==0){
										date1 = temp2;
										i++;
									}
									else if(i==1){
										date2 = temp2;
									}
								}
							}
						}
					}
					section.setItem(companyName, jobTitle, date1, date2);
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadEducationOrCourses(File file,Section section) throws FileNotFoundException{
		int count=0;
		String qualOrCourse = null,establishment = null,location = null,date1 = null,date2 = null, date;
		boolean flag=false;
		
		try {
			while((line = bReader.readLine())!=null ){
					count=0;
					if(line.equals("6. Further Courses")){
						
						if(flag==true){
							section.addItem();
						}
						break;
					}
					if(line.equals("7. Additional Information")){
						
						if(flag==true){
							section.addItem();
						}
						break;
					}
					if(line.contains("*")){
						if(flag==false){
							flag=true;
						}
						else{
							section.addItem();
						}
						for(String temp : line.split("\\* ")){
							if(count==0){
								count++;
							}
							else if(count==1){
								date=null;
								int i = 0;
								for(String temp1 : temp.split(", ")){
									if(i==0){
										qualOrCourse = temp1;
										i++;
									}
									else if(i==1){
										establishment = temp1;
										i++;
									}
									else if(i==2){
										location = temp1;
										i++;
									}
									else{
										date = temp1;
									}
								}
								i=0;
								for(String temp2 : date.split(" to ")){
									if(i==0){
										date1 = temp2;
										i++;
									}
									else if(i==1){
										date2 = temp2;
									}
								}
							}
						}
						
					}
					section.setItem(qualOrCourse, establishment, location, date1, date2);
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	