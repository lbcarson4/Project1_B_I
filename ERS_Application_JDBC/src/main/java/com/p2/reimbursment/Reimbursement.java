package com.p2.reimbursment;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {

	int id, amount;
	Timestamp submitted, resolved;
	String description;
	Blob receipt;
	String author, resolver, status, type;
	
	public Reimbursement() {}
	
	public Reimbursement(int id, int amount, Timestamp submitted, Timestamp resolved, String description, Blob receipt,
			String author, String resolver, String status, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public int getAmount() {return amount;}
	public void setAmount(int amount) {this.amount = amount;}
	public Timestamp getSubmitted() {return submitted;}
	public void setSubmitted(Timestamp submitted) {this.submitted = submitted;}
	public Timestamp getResolved() {return resolved;}
	public void setResolved(Timestamp resolved) {this.resolved = resolved;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	public Blob getReceipt() {return receipt;}
	public void setReceipt(Blob receipt) {this.receipt = receipt;}
	public String getAuthor() {return author;}
	public void setAuthor(String author) {this.author = author;}
	public String getResolver() {return resolver;}
	public void setResolver(String resolver) {this.resolver = resolver;}
	public String getStatus() {return status;}
	public void setStatus(String status) {this.status = status;}
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}

	@Override
	public String toString() {
		return "Reimbursment [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", receipt=" + receipt + ", author=" + author + ", resolver="
				+ resolver + ", status=" + status + ", type=" + type + "]";
	}
}