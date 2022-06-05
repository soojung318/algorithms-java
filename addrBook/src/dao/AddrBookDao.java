package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.AddrBookDto;

public class AddrBookDao {
	private static AddrBookDao instance = new AddrBookDao();
	
	private AddrBookDao() {}
	
	public static AddrBookDao getInstance() {
		return instance;
	}
	
	// AddrBean.insertDB()
	public int insertAddr(AddrBookDto dto) {
		int ri = 0;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		String query = "insert into addrbook values(?,?,?,?,?,?,?)";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1,  dto.getAb_id());
			pstmt.setString(2,  dto.getAb_name());
			pstmt.setString(3, dto.getAb_email());
			pstmt.setString(4, dto.getAb_birth());
			pstmt.setString(5, dto.getAb_tel());
			pstmt.setString(6, dto.getAb_comdept());
			pstmt.setString(7, dto.getAb_memo());
			pstmt.executeUpdate();
			ri = 1;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) pstmt.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
	}
	
	public ArrayList<AddrBookDto> addrBooksAll(){
		
		ArrayList<AddrBookDto> dtos = new ArrayList<AddrBookDto>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query ="select * from addrbook";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			System.out.println("=================");
			while(rs.next()) {
				AddrBookDto dto = new AddrBookDto();
				dto.setAb_id(rs.getInt("ab_id"));
				dto.setAb_name(rs.getString("ab_name"));
				dto.setAb_email(rs.getString("ab_email"));
				dto.setAb_birth(rs.getString("ab_birth"));
				dto.setAb_tel(rs.getString("ab_tel"));
				dto.setAb_comdept(rs.getString("ab_comdept"));
				dto.setAb_memo(rs.getString("ab_memo"));
				dtos.add(dto);
			}
			System.out.println("------------------------");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				connection.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	private Connection getConnection() {
		Context context = null;
		DataSource dataSource = null;
		Connection connection = null;
		
		try {
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/Oracle11g");
			connection = dataSource.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}


// db insert와 db select만 해놓은 상태
