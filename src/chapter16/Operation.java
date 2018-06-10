package chapter16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class MyConnection{
	private String DBDriver;
	private String DBURL;
	private String DBUser;
	private String DBPass;
	private Connection conn = null;
	private Statement stmt = null;
	
	public MyConnection(String driver, String dburl, String user, String pass){
		DBDriver = driver;
		DBURL = dburl;
		DBUser = user;
		DBPass = pass;
		try{
			Class.forName(DBDriver);		//�������ݿ���������
			System.out.println("���ݿ�����������سɹ�");
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			conn = DriverManager.getConnection(DBURL, DBUser, DBPass);
			stmt = conn.createStatement();
			System.out.println("����MySQL���ݿ�ɹ�");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public Connection getMyConnection(){
		return conn;
	}
	public Statement getMyStatement(){
		return stmt;
	}
	public void closeMyConnection(){
		try{
			conn.close();
			stmt.close();
			System.out.println("�ر����ݿ�����");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public String toString(){
		return "���ݿ���������"+DBDriver+"�� ���ӵ�ַ��"+DBURL+"�� �û�����"+DBUser+"�����룺"+DBPass;
	}
}

class DBOperation{
	private MyConnection myDB = null;
	private Connection conn = null;
	private Statement stmt = null;
	public DBOperation(MyConnection myDB){
		conn = myDB.getMyConnection();
		stmt = myDB.getMyStatement();
	}
	public void insertData(String type, int amount){
		try{
			String newType = new String(type.getBytes(),"GBK");
			String sql = "INSERT INTO data(type,amount)VALUES('"+newType+"',"+amount+")";
			stmt.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void deleteData(String delType){
		String sql = "DELETE FROM data WHERE type='"+delType+"'";
		System.out.println(sql);
		try{
			stmt.executeUpdate(sql);
			System.out.println("һ����¼��ɾ��");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void updateData(String srcType, String detType, int amount){
		String sql = "UPDATE data SET type='"+detType+"',amount="+amount+" where type='"+srcType+"'";
		System.out.println(sql);
		try{
			stmt.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void selectAllData(){
		String sql = "SELECT type,amount FROM data";
		try{
			ResultSet rs = stmt.executeQuery(sql);//ִ�в�ѯ���������ؽ������
			System.out.println("�����������£�");
			while(rs.next()){
				String type = rs.getString("type");
				int amount = rs.getInt("amount");
				System.out.println("���ͣ�"+type+"������"+amount);
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void selectWhere(int amount){
		String sql = "SELECT type,amount FROM data where amount>="+amount;
		System.out.println("����"+amount+"����");
		try{
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String type = rs.getString("type");
				int thisAmount = rs.getInt("amount");
				System.out.println("���ͣ�"+type+"������"+thisAmount);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
public class Operation {
	public static void main(String[] agrs){
		String DBDriver = "com.mysql.jdbc.Driver";
		String DBURL = "jdbc:mysql://localhost:3306/javatest?useSSL=true";
		String DBUser = "root";
		String DBPass = "www";
		MyConnection myDB = new MyConnection(DBDriver,DBURL,DBUser,DBPass);
		DBOperation myOpr = new DBOperation(myDB);
/*		//��������
		myOpr.insertData("A", 1);
		myOpr.insertData("B", 2);
		myOpr.insertData("C", 3);
		myOpr.insertData("D", 4);
 		*/
/*		//�޸�����
		myOpr.updateData("A", "AA", 5);
		*/
/*		//ɾ������
		myOpr.deleteData("AA");
		*/
/*		//���Բ�ѯ����
		myOpr.selectWhere(3);
		*/
		
		myOpr.selectAllData();
		myDB.closeMyConnection();
	}
}
