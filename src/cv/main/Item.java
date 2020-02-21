package cv.main;

public class Item {
	
	private String companyName;
	private String jobTitle;
	private String date1;
	private String date2;
	private String qualOrCourse;
	private String establishment;
	private String location;
	private String data;
	
	
	public Item(){
		this.companyName = null;
		this.jobTitle = null;
		this.date1= null;
		this.date2= null;
		this.qualOrCourse =null;
		this.establishment = null;
		this.location = null;
		this.data = null;
	}
	
	public void setData(String data){
		this.data = data;
	}
	
	public void setQualOrCourse(String qualOrCourse){
		this.qualOrCourse = qualOrCourse;
	}
	
	public void setEstablishment(String establishment){
		this.establishment = establishment;
	}
	
	public void setLocation(String location){
		this.location = location;
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
	
	public String getQualOrCourse(){
		return qualOrCourse;
	}
	
	public String getEstablishment(){
		return establishment;
	}
	
	public String getLocation(){
		return location;
	}
	
	public String getData(){
		return data;
	}
}