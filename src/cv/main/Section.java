package cv.main;

import java.util.ArrayList;

public class Section{
	
	private String sectionName;
	private String paragraph;
	private ArrayList<BulletList> arrayBulletList;
	private BulletList bulletList;
	private Item item;
	
	public Section(String sectionName){
		this.sectionName = sectionName;
		if(this.sectionName.equals("4. Career Summary") || this.sectionName.equals("5. Education And Training") 
				|| this.sectionName.equals("6. Further Courses")){
			bulletList = new BulletList();
		}
		if(this.sectionName.equals("3. Skills And Experience") || this.sectionName.equals("4. Professional Experience")){
			arrayBulletList = new ArrayList<BulletList>();
			bulletList = new BulletList();
		}
	}
	
	public String getSectionName(){
		return sectionName;
	}
	
	public void setParagraph(String paragraph){
		this.paragraph = paragraph;
	}
	
	public String getParagraph(){
		return paragraph;
	}
	
	public Item getItem(){
		return item;
	}
	
	public void addItem(){
		bulletList.add(item);
	}
	
	public void addItem(int index){
		arrayBulletList.get(index).add(item);
	}
	
	public void deleteItem(int index){
		bulletList.pop(index);
	}
	
	public void deleteItem(int index,int i){
		arrayBulletList.get(index).pop(i);
	}
	
	public void setItem(Item item, int index){
		bulletList.setInPosition(item, index);
	}
	
	public void setItem(String data){
		item = new Item();
		item.setData(data);
	}
	
	public void setItem(String data,int index){
		bulletList.getItem(index).setData(data);
	}
	
	public void setItem(String data,int index,int i){
		arrayBulletList.get(i).getItem(index).setData(data);
	}
	
	public void setItem(String companyName, String jobTitle ,String date1,String date2){
		 item = new Item();
		 item.setCompanyName(companyName);
		 item.setJobTitle(jobTitle);
		 item.setDate1(date1);
		 item.setDate2(date2);
	}
	
	public void setItem(String qualOrCourse,String establishment,String location,String date1,String date2){
		item = new Item();
		item.setQualOrCourse(qualOrCourse);
		item.setEstablishment(establishment);
		item.setLocation(location);
		item.setDate1(date1);
		item.setDate2(date2);
	}
	
	public Item getItemInPosition(int index){
		return bulletList.getItem(index);
	}
	
	public void setItemInPosition(Item item,int index){
		bulletList.setInPosition(item, index);
	}
	
	public int getSizeBulletList(){
		return bulletList.getSize();
	}
	
	public int getSizeArrayBulletList(){
		return arrayBulletList.size();
	}
	
	public void addBulletList(){
		arrayBulletList.add(bulletList);
		bulletList = new BulletList();
	}

	public void deleteBulletList(int index){
		arrayBulletList.remove(index);
	}
	
	public void setBulletList(String skillAndExperienceOn){
		bulletList.setSkillAndExperienceOn(skillAndExperienceOn);
	}
	
	public void setBulletList(String companyName, String jobTitle ,String date1,String date2, String responsibilities){
		bulletList.setCompanyName(companyName);
		bulletList.setJobTitle(jobTitle);
		bulletList.setDate1(date1);
		bulletList.setDate2(date2);
		bulletList.setResponsibilities(responsibilities);
	}
	
	public void setBulletList(int index , String skillAndExperienceOn){
		arrayBulletList.get(index).setSkillAndExperienceOn(skillAndExperienceOn);
	}
	
	public void setBulletList(int index,String companyName, String jobTitle ,String date1,String date2, String responsibilities){
		arrayBulletList.get(index).setCompanyName(companyName);
		arrayBulletList.get(index).setJobTitle(jobTitle);
		arrayBulletList.get(index).setDate1(date1);
		arrayBulletList.get(index).setDate2(date2);
		arrayBulletList.get(index).setResponsibilities(responsibilities);
	}
	
	public void setBulletListInPosition(BulletList bulletList,int index){
		arrayBulletList.set(index, bulletList);
	}
	
	public BulletList getBulletListInPosition(int index){
		return arrayBulletList.get(index);
	}
	

}
