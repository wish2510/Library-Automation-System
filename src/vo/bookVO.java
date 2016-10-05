package vo;

public class bookVO {

		private Long bookID;
		private String bookTitle;
		private String isbn;
		private Long publisherID;
		private Long authorID;
		private String pubDate;
		
		public Long getBookID() {
			return bookID;
		}
		public void setBookID(Long bookID) {
			this.bookID = bookID;
		}
		public String getBookTitle() {
			return bookTitle;
		}
		public void setBookTitle(String bookTitle) {
			this.bookTitle = bookTitle;
		}
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		public Long getPublisherID() {
			return publisherID;
		}
		public void setPublisherID(Long publisherID) {
			this.publisherID = publisherID;
		}
		public Long getAuthorID() {
			return authorID;
		}
		public void setAuthorID(Long authorID) {
			this.authorID = authorID;
		}
		public String getPubDate() {
			return pubDate;
		}
		public void setPubDate(String pubDate) {
			this.pubDate = pubDate;
		}
		
		
}


