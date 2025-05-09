package dto;

import java.io.Serializable;

public class Book implements Serializable {
// 직렬화 하기 위해 필요함 - 세션 관리나 네트워크 전송에 관여
		private static final long serialVersionUID = -4274700572038677000L; // 직렬화 버전 관리
		
		private String bookId; 	    // 책ID
		private String name; 	    // 책이름
		private int unitPrice; 	    // 가격
		private String author; 	    // 저자
		private String description; // 설명
		private String publisher; 	// 출판사
		private String category; 	// 분류
		private long unitsInStock; 	// 재고수량
		private String releaseDate; // 출판일 (월/년)
		private String condition; 	// 신제품,구제품,리퍼브제품
		private String filename;
		private int quantity;       // 수량
		
		
		
		
		

		public Book() {
			super();
		}

		
		
		public Book(String bookId, String name, Integer unitPrice) {
			super();
			this.bookId = bookId;
			this.name = name;
			this.unitPrice = unitPrice;
		}
		
		
		
		
		public String getBookId() {
			return bookId;
		}

		public void setBookId(String bookId) {
			this.bookId = bookId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getUnitPrice() {
			return unitPrice;
		}

		public void setUnitPrice(int unitPrice) {
			this.unitPrice = unitPrice;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getPublisher() {
			return publisher;
		}

		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public long getUnitsInStock() {
			return unitsInStock;
		}

		public void setUnitsInStock(long unitsInStock) {
			this.unitsInStock = unitsInStock;
		}

		public String getReleaseDate() {
			return releaseDate;
		}

		public void setReleaseDate(String releaseDate) {
			this.releaseDate = releaseDate;
		}

		public String getCondition() {
			return condition;
		}

		public void setCondition(String condition) {
			this.condition = condition;
		}
		public String getFilename() {
			return filename;
		}

		public void setFilename(String filename) {
			this.filename = filename;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}


		
}
