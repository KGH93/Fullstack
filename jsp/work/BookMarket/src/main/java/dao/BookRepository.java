package dao;

import dto.Book;

import java.sql.*;
import java.util.ArrayList;

public class BookRepository {

    private static BookRepository instance = new BookRepository();  // Singleton pattern
    public static BookRepository getInstance() {
        return instance;
    }

    // DB 연결을 위한 메서드 (중복 제거)
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/BookMarketDB?serverTimezone=UTC";
        String user = "root";
        String password = "1234";
        return DriverManager.getConnection(url, user, password);
    }

    // 책 정보 가져오기 (전체 책 목록)
    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM book"; // SQL 쿼리

        try (Connection conn = getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Book book = new Book(rs.getString("b_id"), rs.getString("b_name"), rs.getInt("b_unitPrice"));
                book.setAuthor(rs.getString("b_author"));
                book.setDescription(rs.getString("b_description"));
                book.setPublisher(rs.getString("b_publisher"));
                book.setCategory(rs.getString("b_category"));
                book.setUnitsInStock(rs.getInt("b_unitsInStock"));
                book.setReleaseDate(rs.getString("b_releaseDate"));
                book.setFilename(rs.getString("b_filename"));
                books.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return books;
    }

    // 책 ID로 책 정보 가져오기
    public Book getBookById(String bookId) {
        Book book = null;
        String sql = "SELECT * FROM book WHERE b_id = ?";  // SQL 쿼리

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, bookId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                book = new Book(rs.getString("b_id"), rs.getString("b_name"), rs.getInt("b_unitPrice"));
                book.setAuthor(rs.getString("b_author"));
                book.setDescription(rs.getString("b_description"));
                book.setPublisher(rs.getString("b_publisher"));
                book.setCategory(rs.getString("b_category"));
                book.setUnitsInStock(rs.getInt("b_unitsInStock"));
                book.setReleaseDate(rs.getString("b_releaseDate"));
                book.setFilename(rs.getString("b_filename"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return book;
    }

    // 책 추가
    public void addBook(Book book) {
        String sql = "INSERT INTO book (b_id, b_name, b_unitPrice, b_author, b_description, b_publisher, b_category, b_unitsInStock, b_releaseDate, b_filename) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, book.getBookId());
            pstmt.setString(2, book.getName());
            pstmt.setInt(3, book.getUnitPrice());
            pstmt.setString(4, book.getAuthor());
            pstmt.setString(5, book.getDescription());
            pstmt.setString(6, book.getPublisher());
            pstmt.setString(7, book.getCategory());
            pstmt.setLong(8, book.getUnitsInStock());
            pstmt.setString(9, book.getReleaseDate());
            pstmt.setString(10, book.getFilename());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
