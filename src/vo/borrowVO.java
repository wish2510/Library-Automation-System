package vo;
public class borrowVO {
	private Long borrowID;
	private Long bookID;
	private Long readerID;
	private Long branchID;
	private String bDateTime;
	private String rDateTime;
	private Double fine;
	
	public Long getBorrowID() {
		return borrowID;
	}
	public void setBorrowID(Long borrowID) {
		this.borrowID = borrowID;
	}
	public Long getBookID() {
		return bookID;
	}
	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}
	public Long getReaderID() {
		return readerID;
	}
	public void setReaderID(Long readerID) {
		this.readerID = readerID;
	}
	public Long getBranchID() {
		return branchID;
	}
	public void setBranchID(Long branchID) {
		this.branchID = branchID;
	}
	public String getbDateTime() {
		return bDateTime;
	}
	public void setbDateTime(String bDateTime) {
		this.bDateTime = bDateTime;
	}
	public String getrDateTime() {
		return rDateTime;
	}
	public void setrDateTime(String rDateTime) {
		this.rDateTime = rDateTime;
	}
	public Double getFine() {
		return fine;
	}
	public void setFine(Double fine) {
		this.fine = fine;
	}
}
