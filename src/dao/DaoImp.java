package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import entity.TrackDetail;
import Exception.serviceException.IdNotFoundException;
import Exception.daoexception.DaoException;
import utility.JdbcConnection;

public class DaoImp implements DaoInterface {
	@Override
	public void insertDb(int id, String name, String track, int mobile, String role) {
		try {
			String query = "insert into emp_detail values(?,?,?,?,?)";
			Connection con = JdbcConnection.connect();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, track);
			pst.setString(4, role);
			pst.setInt(5, mobile);
			int i = pst.executeUpdate();
			System.out.println(i + " rows affected");
		} catch (SQLException e) {
			System.out.println("Insertion failure");
		}
	}

	@Override
	public void deleteDb(int id) {
		String query = "delete from emp_detail where id=?";
		try {
			Connection con = JdbcConnection.connect();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			int i = pst.executeUpdate();
			if (i > 0) {
				System.out.println("id deleted ");
				JdbcConnection.close(con, pst);

			} else {
				JdbcConnection.close(con, pst);
				try {
					throw new DaoException("query not done");
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					System.out.println("query not done");
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void update(int id, int num) {
		String query = "update emp_detail set mobileNo=? where id=?";
		try {
			Connection con = JdbcConnection.connect();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, num);
			pst.setInt(2, id);
			int i = pst.executeUpdate();
			if (i > 0) {
				System.out.println("Phone number updated");
				JdbcConnection.close(con, pst);
			} else {
				JdbcConnection.close(con, pst);
				try {
					throw new DaoException("update not successfull ");
				} catch (DaoException e) {
					System.out.println(e.getLocalizedMessage());
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void insertTrack(String t, int n) {
		try {
			String query = "update track_detail set noOfMinds=? where track_name=?";
			Connection con = JdbcConnection.connect();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, n+1);
			pst.setString(2, t);
			int i = pst.executeUpdate();
			System.out.println(i + " rows affected");
		} catch (SQLException e) {
			System.out.println("Insertion failure"+e);
		}

	}

	@Override
	public void getTrack(String t, List<TrackDetail> list) {
		String query = "select * from emp_detail where track=?";
 	   Connection con = JdbcConnection.connect();
 	   try {
 		   PreparedStatement pst = con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
 		   pst.setString(1, t);
 		   ResultSet rs = pst.executeQuery();
 		   if(rs.next() == false) {
 			   System.out.println("No such records");
 		   }else {
 			   System.out.println("Login done ");
 			   rs.previous();
 			   while(rs.next()) {
 				   System.out.println(rs.getInt(1) +"   "+rs.getString(2)
 				   +"   "+rs.getString(3) + "  "+rs.getString(4) +"    "+rs.getInt(5));
 			   }
 				   System.out.println("\n");
 				   JdbcConnection.close(con, pst);
 			   }
 		   } 
 	   catch( SQLException e) {
 			   e.printStackTrace();
 		   }
	}

	@Override
	public int retrieveValue(String t) {
		String query = "select * from track_detail where track_name=?";
		try {
			Connection con = JdbcConnection.connect();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, t);
			ResultSet rs = pst.executeQuery();
			if (rs.next() == false) {
				JdbcConnection.close(con, pst);
				throw new DaoException("track not in the list");
			} else {
				rs.previous();
				rs.next();
				System.out.println("track present here");
				insertTrack(t, rs.getInt(2));
				if (rs.getInt(2) == 0) {
					JdbcConnection.close(con, pst);
					throw new DaoException("track not available");
				}
			}
			while (rs.next()) {
				return rs.getInt(2);
			}return rs.getInt(2);
		} catch (DaoException e) {
			System.out.println("track not avaliable " + e);

		} catch (SQLException e) {
			System.out.println("track not in the list " + e);
		}
		return 0;
	}
}
