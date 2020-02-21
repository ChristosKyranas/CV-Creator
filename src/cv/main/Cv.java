package cv.main;

import java.util.ArrayList;

public class Cv {
	
	private String type;
	private String name;
	private String address;
	private String telHome;
	private String telMobile;
	private String email;
	private ArrayList<Section> sectionList;
	
	
	public Cv(String type){
		this.type = type;
		sectionList = new ArrayList<Section>();
	}
	
	public ArrayList<Section> getList(){
		return sectionList;
	}
	
	public boolean isEmpty(){
		return sectionList.isEmpty();
	}

	public void add(Section section){
		sectionList.add(section);	
	}
	
	public void pop(int index){
		sectionList.remove(index);
	}
	
	public int getSize(){
		return sectionList.size();
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public void setTelHome(String telHome){
		this.telHome = telHome;
	}
	
	public void setTelMobile(String telMobile){
		this.telMobile = telMobile;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getTelHome(){
		return telHome;
	}
	
	public String getTelMobile(){
		return telMobile;
	}
	
	public String getEmail(){
		return email;
	}

	public String getType(){
		return type;
	}	
}