package com.p2.reimbursment;

import java.util.List;

public interface ReimbursementDAO {

	public void insertReimbursment(Reimbursement r);
	public List<Reimbursement> selectAllReimbursments();
	public Reimbursement selectReimbursmentById(int id);
	public List<Reimbursement> selectReimbursmentByAuthor(String author);
	public void updateReimbursmentByStatus(Reimbursement r);
}