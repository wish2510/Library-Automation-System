package vo;

public class reserveVO {
	private Long reserveID;
	private Long bookID;
	private Long readerID;
	private Long branchID;
	private String reserveDate;
	
	public Long getReserveID() {
		return reserveID;
	}
	public void setReserveID(Long reserveID) {
		this.reserveID = reserveID;
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
	public String getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}
	
}
