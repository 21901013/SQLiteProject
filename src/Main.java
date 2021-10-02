import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			
			String dbFile = "myfirst.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			
			System.out.println("\n*** Search Data ***");
			Statement state1 = con.createStatement();
			String sql1 = "select * from g_artists";
			ResultSet rs1 = state1.executeQuery(sql1);
			while(rs1.next()) {
				String id = rs1.getString("id");
				String name = rs1.getString("name");
				String regdate = rs1.getString("regdate");
				System.out.println(id + " " + name + " " + regdate);
			}
			state1.close();
			
			
			System.out.println("\n*** Update New Data ***");
			Statement state2 = con.createStatement();
			String sql2 = "insert into g_artists (name, a_type, a_year, debut, regdate)"
					+ " values ('BTS', 'Male', '2010s, 2020s', 'year of 2013', datetime('now','localtime'));";
			int cnt2 = state2.executeUpdate(sql2);
			if (cnt2 > 0) System.out.println("New data have been updated");
			else System.out.println("[Error] Error have occured");
			state2.close();
			
			System.out.println("\n*** Update New Data ***");
			Statement state5 = con.createStatement();
			String sql5 = "insert into g_artists (name, a_type, a_year, debut, regdate)"
					+ " values ('SHINee', 'Male', '2000s, 2010s,2020s', 'year of 2008', datetime('now','localtime'));";
			int cnt5 = state5.executeUpdate(sql5);
			if (cnt5 > 0) System.out.println("New data have been updated");
			else System.out.println("[Error] Error have occured");
			state5.close();
			
			System.out.println("\n*** Update New Data ***");
			Statement state6 = con.createStatement();
			String sql6 = "insert into g_artists (name, a_type, a_year, debut, regdate)"
					+ " values ('SNSD', 'Female', '2000s, 2010s, 2020s', 'year of 2007', datetime('now','localtime'));";
			int cnt6 = state6.executeUpdate(sql6);
			if (cnt6 > 0) System.out.println("New data have been updated");
			else System.out.println("[Error] Error have occured");
			state6.close();
			
			System.out.println("\n*** Update New Data ***");
			Statement state8 = con.createStatement();
			String sql8 = "insert into g_artists (name, a_type, a_year, debut, regdate)"
					+ " values ('Tae Min (solo)', 'Male', '2010s, 2020s', 'year of 2014', datetime('now','localtime'));";
			int cnt8 = state6.executeUpdate(sql8);
			if (cnt8 > 0) System.out.println("New data have been updated");
			else System.out.println("[Error] Error have occured");
			state8.close();
			
			System.out.println("\n*** Update New Data ***");
			Statement state9 = con.createStatement();
			String sql9 = "insert into g_artists (name, a_type, a_year, debut, regdate)"
					+ " values ('Jong Hyun (solo)', 'Male', '2010s', 'year of 2015', datetime('now','localtime'));";
			int cnt9 = state6.executeUpdate(sql9);
			if (cnt9 > 0) System.out.println("New data have been updated");
			else System.out.println("[Error] Error have occured");
			state9.close();
			
			System.out.println("\n*** Update New Data ***");
			Statement state10 = con.createStatement();
			String sql10 = "insert into g_artists (name, a_type, a_year, debut, regdate)"
					+ " values ('Tae Yeon (solo)', 'Female', '2010s, 2020s', 'year of 2015', datetime('now','localtime'));";
			int cnt10 = state6.executeUpdate(sql10);
			if (cnt10 > 0) System.out.println("New data have been updated");
			else System.out.println("[Error] Error have occured");
			state10.close();
			
			
			System.out.println("\n*** Data Edit ***");
			Statement state3 = con.createStatement();
			String sql3 = "update g_artists set a_year = '2000s, 2010s, 2020s'"
					+ "where id=1 ;";
			int cnt3 = state3.executeUpdate(sql3);
			if(cnt3 > 0) System.out.println("Data has been edited");
			else System.out.println("[Error] Error have occured");
			state3.close();
			
			
			System.out.println("\n*** Delete Data***");
			Statement state4 = con.createStatement();
			String sql4 = "delete from g_artists where id=4 ;";
			int cnt4 = state4.executeUpdate(sql4);
			if(cnt4 > 0) System.out.println("Data have been deleted!");
			else System.out.println("[Error] Error have occured");
			state4.close();
			
			System.out.println("\n*** Delete Data***");
			Statement state7 = con.createStatement();
			String sql7 = "delete from g_artists where id=5 ;";
			int cnt7 = state4.executeUpdate(sql7);
			if(cnt7 > 0) System.out.println("Data have been deleted!");
			else System.out.println("[Error] Error have occured");
			state7.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (Exception e) {}
			}
		}
	}

}
