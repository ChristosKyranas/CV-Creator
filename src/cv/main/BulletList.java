package cv.main;

import java.util.ArrayList;

public class BulletList{
	
	private ArrayList<Item> list;
	private String companyName;
	private String jobTitle;
	private String date1;
	private String date2;
	private String responsibilities;
	private String skillAndExperienceOn;
	
	
	public BulletList(){
		list = new ArrayList<Item>();
	}
	
	public ArrayList<Item> getList(){
		return list;
	}
	
	public Item getItem(int index){
		return list.get(index);
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}

	public void add(Item item){
		list.add(item);	
	}
	
	public void setInPosition(Item item, int index){
		list.set(index, item);
	}
	
	public void pop(int index){
		list.remove(index);
	}
	
	public int getSize(){
		return list.size();
	}
	
	public void setResponsibilities(String responsibilities){
		this.responsibilities = responsibilities;
	}
	
	public void setSkillAndExperienceOn(String skillAndExperienceOn){
		this.skillAndExperienceOn = skillAndExperienceOn;
	}
	
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
	
	public void setJobTitle(String jobTitle){
		this.jobTitle = jobTitle;
	}
	
	public void setDate1(String date1){
		this.date1 = date1;
	}
	
	public void setDate2(String date2){
		this.date2 = date2;
	}
	
	public String getCompanyName(){
		return companyName;
	}
	
	public String getJobTitle(){
		return jobTitle;
	}
	
	public String getDate1(){
		return date1;
	}
	
	public String getDate2(){
		return date2;
	}
	
	public String getSkillAndExperienceOn(){
		return skillAndExperienceOn;
	}
	
	public String getResponsibilities(){
		return responsibilities;
	}	
}