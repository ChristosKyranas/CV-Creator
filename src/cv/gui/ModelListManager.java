package cv.gui;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import cv.main.BulletList;
import cv.main.Item;
import cv.main.Section;

public class ModelListManager {
	
	public DefaultListModel addArrayModelList(DefaultListModel arrayModelList,Section section){
		
		if(section.getSectionName().equals("3. Skills And Experience")){
				arrayModelList.addElement(section.getBulletListInPosition(section.getSizeArrayBulletList()-1).getSkillAndExperienceOn());
				return arrayModelList;
		}
		else if(section.getSectionName().equals("4. Professional Experience")){
				arrayModelList.addElement(section.getBulletListInPosition(section.getSizeArrayBulletList()-1).getCompanyName() + " " +
						section.getBulletListInPosition(section.getSizeArrayBulletList()-1).getJobTitle() + " " +section.getBulletListInPosition(section.getSizeArrayBulletList()-1).getDate1() + " " +
						section.getBulletListInPosition(section.getSizeArrayBulletList()-1).getDate2());
			
				return arrayModelList;
		}
		return arrayModelList;
	}
	
	public DefaultListModel deleteArrayModelList(DefaultListModel arrayModelList,int index){
		arrayModelList.remove(index);
		return arrayModelList;
	}
	
	public static DefaultListModel setArrayModelList(DefaultListModel arrayModelList,Section section,int index){
		if(section.getSectionName().equals("3. Skills And Experience")){
			arrayModelList.setElementAt(section.getBulletListInPosition(index).getSkillAndExperienceOn(), index);
			return arrayModelList;
		}
		else if(section.getSectionName().equals("4. Professional Experience")){
			arrayModelList.setElementAt(section.getBulletListInPosition(index).getCompanyName() + " " +
					section.getBulletListInPosition(index).getJobTitle() + " " +section.getBulletListInPosition(index).getDate1() + " " +
					section.getBulletListInPosition(index).getDate2() , index);
			return arrayModelList;
		}
		return arrayModelList;
	}
	
	public void clearArrayModelList(DefaultListModel arrayModelList){
		arrayModelList.clear();
	}
	
	public DefaultListModel addModelList(DefaultListModel modelList,Section section){
		if(section.getSectionName().equals("3. Skills And Experience") || section.getSectionName().equals("4. Professional Experience")){
				modelList.addElement(section.getItem().getData());
			return modelList;	
		}
		else if(section.getSectionName().equals("4. Career Summary")){
			modelList.addElement(section.getItem().getCompanyName() + " " + section.getItem().getJobTitle() + " " + section.getItem().getDate1() + " " + section.getItem().getDate2());
			return modelList;	
		}
		else if(section.getSectionName().equals("5. Education And Training") || (section.getSectionName().equals("6. Further Courses"))){
			modelList.addElement(section.getItem().getQualOrCourse() + " " + section.getItem().getEstablishment() + " " + section.getItem().getLocation() + " " +  section.getItem().getDate1() + " " + section.getItem().getDate2());
			return modelList;	
		}
		return modelList;
	}

	public DefaultListModel deleteModelList(DefaultListModel modelList,int index){
		modelList.remove(index);
		return modelList;
	}
	
	public DefaultListModel setModelList(DefaultListModel modelList,Section section,int index){
		modelList.set(index,section.getItemInPosition(index).getData());
		return modelList;
	}
	
	public DefaultListModel setModelList(DefaultListModel modelList,Section section,int index,int i){	
		modelList.set(i, section.getBulletListInPosition(index).getItem(i).getData());
		return modelList;
	}
	
	public void clearModelList(DefaultListModel modelList){
		modelList.clear();
	}
	
	public DefaultListModel displayList(DefaultListModel modelList,Section section,int index){
		clearModelList(modelList);
		for(int i= 0; i<section.getBulletListInPosition(index).getSize(); i++){
			modelList.addElement(section.getBulletListInPosition(index).getItem(i).getData());
		}
		return modelList;
	}
	
	public DefaultListModel displayModelList(DefaultListModel modelList,Section section){
		if(section.getSectionName().equals("4. Career Summary")){
			for(int i= 0; i<section.getSizeBulletList(); i++){
				modelList.addElement(section.getItemInPosition(i).getCompanyName() + " " + section.getItemInPosition(i).getJobTitle() + " " + section.getItemInPosition(i).getDate1() + " " + section.getItemInPosition(i).getDate2());
			}
			return modelList;
		}
		if(section.getSectionName().equals("6. Further Courses") || section.getSectionName().equals("5. Education And Training")){
			for(int i= 0; i<section.getSizeBulletList(); i++){
				modelList.addElement(section.getItemInPosition(i).getQualOrCourse() + " " + section.getItemInPosition(i).getEstablishment() + " " + section.getItemInPosition(i).getLocation() + " " + section.getItemInPosition(i).getDate1() + " " + section.getItemInPosition(i).getDate2());
			}
			return modelList;
		}
		return modelList;
	}
	
	public DefaultListModel displayList(DefaultListModel arrayModelList,Section section){
		if(section.getSectionName().equals("3. Skills And Experience")){
			for(int i= 0; i<section.getSizeArrayBulletList(); i++){
				arrayModelList.addElement(section.getBulletListInPosition(i).getSkillAndExperienceOn());
			}
			return arrayModelList;
		}else if(section.getSectionName().equals("4. Professional Experience")){
			for(int i= 0; i<section.getSizeArrayBulletList(); i++){
				arrayModelList.addElement(section.getBulletListInPosition(i).getCompanyName() + " " +
						section.getBulletListInPosition(i).getJobTitle() + " " +section.getBulletListInPosition(i).getDate1() + " " +
						section.getBulletListInPosition(i).getDate2());
			}
			return arrayModelList;
		}
		return arrayModelList;
	}
	
	public void changeValues(int index,Section section){
		Item temp = new Item();
		temp = section.getItemInPosition(index);
		section.setItemInPosition(section.getItemInPosition(index-1), index);
		section.setItemInPosition(temp, index-1);	
	}
	
	public void changeValues(int index,int i,Section section){
		BulletList temp = new BulletList();
		temp = section.getBulletListInPosition(index);
		section.setBulletListInPosition(section.getBulletListInPosition(index-1),index);
		section.setBulletListInPosition(temp,index-1);
	}
	
	public void orderDates(DefaultListModel modelList,Section section){
		int i = 0,temp = 0;
		int x1=0,x2=0,day1=0,day2=0,month1=0,month2=0,year1=0,year2=0;
		Object temp1 ,temp2;
		
		for(temp=0; temp<modelList.getSize(); temp++){
			for(i=modelList.getSize()-1; i>0; i--){
				for(String count: section.getItemInPosition(i).getDate2().split("/")){
					if(x1==0){	
						day1=Integer.parseInt(count);
					}
					else if(x1==1){
						month1=Integer.parseInt(count);
					}
					else if(x1==2){
						year1=Integer.parseInt(count);
					}
					x1++;
				}
				for(String count: section.getItemInPosition(i-1).getDate2().split("/")){
					if(x2==0){
						day2=Integer.parseInt(count);
					}
					else if(x2==1){
						month2=Integer.parseInt(count);
					}
					else if(x2==2){
						year2=Integer.parseInt(count);
					}
					x2++;
				}
				x1=0;
				x2=0;
				if(year1>year2){
					changeValues(i,section);
					temp1 = modelList.getElementAt(i-1);
					temp2 = modelList.getElementAt(i);
					modelList.setElementAt(temp1, i);
					modelList.setElementAt(temp2, i-1);
				}
				if(year1==year2 && month1>month2){
					changeValues(i,section);
					temp1 = modelList.getElementAt(i-1);
					temp2 = modelList.getElementAt(i);
					modelList.setElementAt(temp1, i);
					modelList.setElementAt(temp2, i-1);
				}
				if(year1==year2 && month1==month2 && day1>day2){
					changeValues(i,section);
					temp1 = modelList.getElementAt(i-1);
					temp2 = modelList.getElementAt(i);
					modelList.setElementAt(temp1, i);
					modelList.setElementAt(temp2, i-1);
				}
				year1=0;
				month1=0;
				day1=0;
				year2=0;
				month2=0;
				day2=0;
			}
		}
	}

	public void orderDates(int index,DefaultListModel arrayModelList,Section section){
		int i = 0,temp = 0;
		int x1=0,x2=0,day1=0,day2=0,month1=0,month2=0,year1=0,year2=0;
		Object temp1 ,temp2;
		for(temp=0; temp<arrayModelList.getSize(); temp++){
			for(i=arrayModelList.getSize()-1; i>0; i--){
				for(String count:section.getBulletListInPosition(i).getDate2().split("/")){
					if(x1==0){	
						day1=Integer.parseInt(count);
						
					}
					else if(x1==1){
						month1=Integer.parseInt(count);
					}
					else if(x1==2){
						year1=Integer.parseInt(count);
					}
					x1++;
				}
				for(String count: section.getBulletListInPosition(i-1).getDate2().split("/")){
					if(x2==0){
						day2=Integer.parseInt(count);
					}
					else if(x2==1){
						month2=Integer.parseInt(count);
					}
					else if(x2==2){
						year2=Integer.parseInt(count);
					}
					x2++;
				}
				x1=0;
				x2=0;
				if(year1>year2){
					changeValues(i,0,section);
					temp1 = arrayModelList.getElementAt(i-1);
					temp2 = arrayModelList.getElementAt(i);
					arrayModelList.setElementAt(temp1, i);
					arrayModelList.setElementAt(temp2, i-1);
				}
				if(year1==year2 && month1>month2){
					changeValues(i,0,section);
					temp1 = arrayModelList.getElementAt(i-1);
					temp2 = arrayModelList.getElementAt(i);
					arrayModelList.setElementAt(temp1, i);
					arrayModelList.setElementAt(temp2, i-1);
				}
				if(year1==year2 && month1==month2 && day1>day2){
					changeValues(i,0,section);
					temp1 = arrayModelList.getElementAt(i-1);
					temp2 = arrayModelList.getElementAt(i);
					arrayModelList.setElementAt(temp1, i);
					arrayModelList.setElementAt(temp2, i-1);
				}
				year1=0;
				month1=0;
				day1=0;
				year2=0;
				month2=0;
				day2=0;
			}
		}
	}	
	
	public boolean checkDates(String date1,String date2){
		int x1=0;
		int day1=0;
		int month1=0;
		int year1=0;
		int x2=0;
		int day2=0;
		int month2=0;
		int year2=0;
		
		for(String count: date1.split("/")){
			if(x1==0){
				day1=Integer.parseInt(count);
			}
			else if(x1==1){
				month1=Integer.parseInt(count);
			}
			else if(x1==2){
				year1=Integer.parseInt(count);
			}
			x1++;
		}
		for(String count: date2.split("/")){
			if(x2==0){
				day2=Integer.parseInt(count);
			}
			else if(x2==1){
				month2=Integer.parseInt(count);
			}
			else if(x2==2){
				year2=Integer.parseInt(count);
			}
			x2++;
		}
		
		if(year1>year2){
			JOptionPane.showMessageDialog(null, "Change the date (date1>date2)!!!");
			return false;
		}
		else if(year1==year2 && month1>month2){
			JOptionPane.showMessageDialog(null, "Change the date (date1>date2)!!!");
			return false;
		}
		else if(year1==year2 && month1==month2 && day1>day2){
			JOptionPane.showMessageDialog(null, "Change the date (date1>date2)!!!");
			return false;
		}
		return true;
	}
}