package controler;

public class Hours {

	private String from_;
	private String to_;
	
	Hours(String from, String to){
		setFrom(from);
		setTo(to);
	}

	public String getFrom() {
		return from_;
	}

	public void setFrom(String from_) {
		this.from_ = from_;
	}

	public String getTo() {
		return to_;
	}

	public void setTo(String to_) {
		this.to_ = to_;
	}
}
