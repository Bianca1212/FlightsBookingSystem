package ro.itschool.curs.enums;

public enum CustomerCategory {
	SENIOR("65+ years"), ADULT(">18 years"), TEENAGER("12-18 years"), CHILDREN("2-11 years");
	
	public final String category;

    private CustomerCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
    	return category;
}}

