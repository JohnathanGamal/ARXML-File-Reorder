package file_reorder;

public class Container implements Comparable<Container> {
	private String ID;
	private String shortName;
	private String longName;
	public static final String getEnd() {
		return end;
	}
	public static final void setEnd(String end) {
		Container.end = end;
	}


	private static String end;
	
	
	public Container(String iD, String shortName, String longName) {
		this.ID = iD;
		this.shortName = shortName;
		this.longName = longName;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	public int compareTo(Container x){
		return this.shortName.compareTo(x.shortName);
	}

	


}

