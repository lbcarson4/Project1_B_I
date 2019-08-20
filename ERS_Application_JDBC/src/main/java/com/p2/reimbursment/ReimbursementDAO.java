package com.p2.reimbursment;

public interface ReimbursementDAO {

	public void insertReimbursment(Reimbursement r);
	public Reimbursement selectAllReimbursments();
	public Reimbursement selectReimbursmentById(int id);
	public Reimbursement selectReimbursmentByAuthor(String author);
	public Reimbursement selectReimbursmentByType(String type);
	public Reimbursement selectReimbursmentByStatus(String status);
	public void updateReimbursmentByStatus(Reimbursement r);
}