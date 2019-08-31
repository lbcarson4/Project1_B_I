package com.p2.reimbursment;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.p2.highlander.HighConn;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	@Override
	public void insertReimbursment(Reimbursement r) {

		try {
			PreparedStatement ps = HighConn.conn
					.prepareStatement("INSERT INTO ERS_REIMBURSEMENT VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, r.getId());
			ps.setInt(2, r.getAmount());
			ps.setTimestamp(3, r.getSubmitted());
			ps.setTimestamp(4, r.getResolved());
			ps.setString(5, r.getDescription());
			ps.setBlob(6, r.getReceipt());
			ps.setString(7, r.getAuthor());
			ps.setString(8, r.getResolver());
			ps.setString(9, r.getStatus());
			ps.setString(10, r.getType());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Reimbursement> selectAllReimbursments() {

		List<Reimbursement> reims = new ArrayList<Reimbursement>();
		try {
			PreparedStatement ps = HighConn.conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT ORDER BY REIR_ID");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reims.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
				rs.getString(5), rs.getBlob(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reims;
	}

	@Override
	public Reimbursement selectReimbursmentById(int id) {

		Reimbursement r = null;
		try {
			PreparedStatement ps = HighConn.conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIR_ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				r = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
				rs.getString(5), rs.getBlob(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public List<Reimbursement> selectReimbursmentByAuthor(String author) {

		List<Reimbursement> reims = new ArrayList<Reimbursement>();
		try {
			PreparedStatement ps = HighConn.conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIR_AUTHOR = ?");
			ps.setString(1, author);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reims.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), rs.getBlob(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reims;
	}

	@Override
	public void updateReimbursmentByStatus(Reimbursement r) {

		try {
			CallableStatement cs = HighConn.conn.prepareCall("{call update_status(?,?,?,?)}");
			cs.setInt(1, r.getId());
			cs.setString(2, r.getStatus());
			cs.setTimestamp(3, r.getResolved());
			cs.setString(4, r.getResolver());
			cs.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}