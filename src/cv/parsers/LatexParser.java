package cv.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import cv.main.Cv;
import cv.main.Section;

public class LatexParser implements IParser {

	private FileReader fReader;
	private BufferedReader bReader;
	private String line = null;
	
	public void loadGeneralInformation(File file,Cv cv) throws FileNotFoundException{
		fReader = new FileReader(file);
		bReader = new BufferedReader(fReader);
		
		try {
			line = bReader.readLine();
			line = bReader.readLine();
			line = bReader.readLine();
			line = bReader.readLine();
			line = bReader.readLine();
			if(line.contains("%General Information")){
				line = bReader.readLine();
				while((line = bReader.readLine())!=null){
					if(line.contains("Name:")){
						for(String temp : line.split(" \\{Name: ")){
							line = temp;
						}
						for(String temp : line.split("\\} ")){
							cv.setName(temp);
							break;
						}
					}
					else if(line.contains("Address: ")){
						for(String temp : line.split(" \\{Address: ")){
							line = temp;
						}
						for(String temp : line.split("\\} ")){
							cv.setAddress(temp);
							break;
						}
					}
					else if(line.contains("Telephone: (Home) ") == true){
						if(line.contains("(Mobile) ") == true){
							for(String temp : line.split("\\{Telephone: \\(Home\\) ")){
								int i=0;
								for(String temp1 : temp.split("\\(Mobile\\) ")){
									if(i==0){
										line  = temp1;
										i++;
										for(String temp2 : line.split("\\} ")){
											cv.setTelHome(temp2);
											break;
										}
									}
									else if(i==1){
										line = temp1;
										for(String temp2 : line.split("\\}")){
											cv.setTelMobile(temp2);
											break;
										}
									}
								}
							}
						}
					}
					else if(line.contains("Email: ")){
						for(String temp : line.split(" \\{Email: ")){
							line = temp;
						}
						for(String temp : line.split("\\}")){
							cv.setEmail(temp);
							break;	
						}
						break;
					}
					else{
						JOptionPane.showMessageDialog(null, "Error Opening File:Wrong CV Format232332");
						
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadParagraph(File file,Section section) throws FileNotFoundException{
		try {
			line = bReader.readLine();
			if(line.equals("%Profile")){
				line = bReader.readLine();
				line = bReader.readLine();
				for(String temp : line.split("\\{")){
					line = temp;
				}
				for(String temp : line.split("\\}")){
					section.setParagraph(temp);
					break;
				}
			}
			else if(line.equals("%Strengths")){
				line = bReader.readLine();
				line = bReader.readLine();
				for(String temp : line.split("\\{")){
					line = temp;
				}
				for(String temp : line.split("\\}")){
					section.setParagraph(temp);
					break;
				}
				line = bReader.readLine();
			}
			else if(line.equals("%Interests")){
				line = bReader.readLine();
				line = bReader.readLine();
				for(String temp : line.split("\\{")){
					line = temp;
				}
				for(String temp : line.split("\\}")){
					section.setParagraph(temp);
					break;
				}
				bReader.close();
				fReader.close();
			}
			else{
				line = bReader.readLine();
				for(String temp : line.split("\\{")){
					line = temp;
				}
				for(String temp : line.split("\\}")){
					section.setParagraph(temp);
					break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void loadSkillAndExperience(File file,Section section) throws FileNotFoundException{
		int count=1, tempCount=0;
		
		try {
			line = bReader.readLine();
			if(line.equals("%3. Skills And Experience")){
					line = bReader.readLine();
					line = bReader.readLine();
					if(line.contains("3." + count + " Skills And Experience On ")){
						for(String temp : line.split("\\{3." + count + " \\Skills And Experience On ")){
							if(tempCount==0){
								tempCount++;
							}
							else if(tempCount==1){
								line = temp;
								for(String temp1 : line.split("\\}")){
									section.setBulletList(temp1);
									break;
								}
							}
						}
					}
					count++;
					tempCount=0;
					line = bReader.readLine();
					while((line = bReader.readLine())!=null){
						tempCount = 0;
						if(line.equals("%4. Career Summary") || line.equals("%4. Professional Experience")){
							section.addBulletList();
							break;
						}
						else if(line.contains("3." + count + " Skills And Experience On ")){
							section.addBulletList();
							for(String temp : line.split("\\{3." + count + " \\Skills And Experience On ")){
								if(tempCount==0){
									tempCount++;
								}
								else if(tempCount==1){
									line = temp;
									for(String temp1 : line.split("\\}")){
										section.setBulletList(temp1);
										break;
									}
								}
							}
							count++;
						}
						else if(line.contains("\\item {")){
							for(String temp : line.split("\\\\item \\{")){
								if(tempCount==0){
									tempCount++;
								}
								else if(tempCount==1){
									line = temp;
									for(String temp1 : line.split("\\}")){
										section.setItem(temp1);
										section.addItem();
										break;
									}
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
			if(line.equals("%4. Professional Experience")){
				while((line = bReader.readLine())!=null){ 
					count=0;
					if(line.contains("%5. Education And Training")){
						if(flag == true){
							section.setBulletList(companyName, jobTitle, date1, date2, responsibilities);
							section.addBulletList();
						}
						break;
					}
					if(line.contains("%profExp")){ // Mpainei Gia Kainourgio ADD
						line = bReader.readLine();
						line = bReader.readLine();
						if(flag==false){
							flag=true;
						}
						else{
							section.setBulletList(companyName, jobTitle, date1, date2, responsibilities);
							section.addBulletList();
						}
						for(String temp : line.split("\\\\item \\{")){ 
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
									else if(i==2){
										date1 = temp1;
										i++;
									}
									else{
										date2 = temp1;
										for(String temp2 : date2.split("\\}")){
											date2 = temp2;
											break;
										}
									}
								}
							}
						}
						
					}
					else if(line.contains("\\\\item {List of achievements}")){
						continue;
					}
					else if(line.contains("%Responibilities")){ // Mpainei gia ta RESPONSIBILITIES
						line = bReader.readLine();
						line = bReader.readLine();
						for(String temp : line.split("\\\\item \\{")){
							if(count==0){
								count++;
							}
							else if(count==1){
								line = temp;
								for(String temp2 : line.split("\\}")){
									responsibilities = temp2;
									break;
								}
							}
						}
					}
					else if(line.contains("\\item {") && !(line.contains("\\item {List of achievements}"))){/// Mpanei gia ta DATA
						for(String temp : line.split("\\\\item \\{")){
							if(count==0){
								count++;
							}
							else if(count==1){
								line = temp;
								for(String temp2 : line.split("\\}")){
									section.setItem(temp2);
									section.addItem();
									break;
								}
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
					if(line.equals("%5. Education And Training")){
						if(flag==true){
							section.addItem();
						}
						break;
					}
					if(line.contains("\\item {")){
						if(flag==false){
							flag=true;
						}
						else{
							section.addItem();
						}
						for(String temp : line.split("\\\\item \\{")){
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
										for(String temp3 : date2.split("\\}")){
											date2 = temp3;
											break;
										}
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
					if(line.equals("%6. Further Courses")){
						if(flag==true){
							section.addItem();
						}
						break;
					}
					if(line.equals("%Information")){
						if(flag==true){
							section.addItem();
						}
						break;
					}
					if(line.contains("\\item {")){
						if(flag==false){
							flag=true;
						}
						else{
							section.addItem();
						}
						for(String temp : line.split("\\\\item \\{")){
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
										for(String temp3 : date2.split("\\}")){
											date2 = temp3;
											break;
										}
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
