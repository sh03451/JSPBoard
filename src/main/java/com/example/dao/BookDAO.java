package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.bean.BookVO;
import com.example.util.JDBCUtil;

public class BookDAO {

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    private final String BOOK_INSERT = "insert into BOOK (title, author, category, publisher, price, photo) values (?,?,?,?,?,?);";
    private final String BOOK_UPDATE = "update BOOK set title=?, author=?, category=?, publisher=?, price=?, photo=? where seq=?";
    private final String BOOK_DELETE = "delete from BOOK  where seq=?";
    private final String BOOK_GET = "select * from BOOK  where seq=?";
    private final String BOOK_LIST = "select * from BOOK order by seq desc";

    public int insertBook(BookVO vo) {
        System.out.println("===> JDBC로 insertBook() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOOK_INSERT);
            stmt.setString(1, vo.getTitle());
            stmt.setString(2, vo.getAuthor());
            stmt.setString(3, vo.getCategory());
            stmt.setString(4, vo.getPublisher());
            stmt.setString(5, vo.getPrice());
            stmt.setString(6, vo.getPhoto());
            stmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 글 삭제
    public void deleteBook(BookVO vo) {
        System.out.println("===> JDBC로 deleteBook() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOOK_DELETE);
            stmt.setInt(1, vo.getSeq());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int updateBook(BookVO vo) {
        System.out.println("===> JDBC로 updateBook() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOOK_UPDATE);
            stmt.setString(1, vo.getTitle());
            stmt.setString(2, vo.getAuthor());
            stmt.setString(3, vo.getCategory());
            stmt.setString(4, vo.getPublisher());
            stmt.setString(5, vo.getPrice());
            stmt.setString(6, vo.getPhoto());
            stmt.setInt(7, vo.getSeq());


            System.out.println(vo.getTitle() + "-" + vo.getAuthor() + "-" + vo.getCategory() + "-" + vo.getPublisher()+"-" + vo.getPrice() + "-" + vo.getSeq());
            stmt.executeUpdate();
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public BookVO getBook(int seq) {
        BookVO one = new BookVO();
        System.out.println("===> JDBC로 getBook() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOOK_GET);
            stmt.setInt(1, seq);
            rs = stmt.executeQuery();
            if(rs.next()) {
                one.setSeq(rs.getInt("seq"));
                one.setTitle(rs.getString("title"));
                one.setAuthor(rs.getString("author"));
                one.setCategory(rs.getString("category"));
                one.setPublisher(rs.getString("publisher"));
                one.setPrice(rs.getString("price"));
                one.setPhoto(rs.getString("photo"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return one;
    }

    public List<BookVO> getBookList(){
        List<BookVO> list = new ArrayList<BookVO>();
        System.out.println("===> JDBC로 getBookList() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOOK_LIST);
            rs = stmt.executeQuery();
            while(rs.next()) {
                BookVO one = new BookVO();
                one.setSeq(rs.getInt("seq"));
                one.setTitle(rs.getString("title"));
                one.setAuthor(rs.getString("author"));
                one.setCategory(rs.getString("category"));
                one.setPublisher(rs.getString("publisher"));
                one.setPrice(rs.getString("price"));
                one.setPhoto(rs.getString("photo"));
                list.add(one);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public String getPhotoFilename(int seq){
        String filename = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOOK_GET);
            stmt.setInt(1, seq);
            rs = stmt.executeQuery();
            if(rs.next()){
                filename = rs.getString("photo");
            }
            rs.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("===> JDBC로 getPhotoFilename() 기능 처리");
        return filename;
    }
}
