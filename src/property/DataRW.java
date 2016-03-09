package property;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataRW {
	
	public static void main(String[] args) {
		connDatabase();
	}
	public static void connDatabase(){		
		// TODO Auto-generated method stub
		Connection conn = null;	
		String url = "jdbc:mysql://localhost/news_web?"
                + "user=root&password=haimeng&useUnicode=true&characterEncoding=UTF8";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载MySQL驱动程序");
			conn = DriverManager.getConnection(url);
			readData(conn);
			writeData(conn);
		}catch(Exception e){
			System.out.println("MySQL操作错误");
			e.printStackTrace();
		}
	}
	public static void readData(Connection conn){
		try{			
			Statement stmt = conn.createStatement();
			String sql="select origin_link,current_link from huanqiu_1_new ";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
//            	System.out.println(rs.getString(2)+"\t"+rs.getString(3));
            	System.out.println(rs.getString(1)+"\t"+rs.getString(2));
            }
		}catch(Exception e){
			System.out.println("MySQL操作错误");
			e.printStackTrace();
		}
	}
	public static void writeData(Connection conn){
		try{			
			conn.setAutoCommit(false);  
			Statement stmt = conn.createStatement();
			String sql="insert into huanqiu_1_new pageRank values 0.234";
			int result; 
			int i=0;
            while(i<100){
//            	System.out.println(rs.getString(2)+"\t"+rs.getString(3));
            	result=stmt.executeUpdate(sql);
            	i++;
            }
		}catch(Exception e){
			System.out.println("MySQL操作错误");
			e.printStackTrace();
		}
	}
}
