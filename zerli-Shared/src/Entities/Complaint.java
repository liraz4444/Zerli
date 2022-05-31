package Entities;

import java.io.Serializable;

public class Complaint implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id,complaintTime,status,reason,refund;
	private int orderNum;
	
	public Complaint(int orderNum, String id, String complaintTime,String status, String reason,String refund) {
		this.orderNum = orderNum;
		this.id = id;
		this.complaintTime = complaintTime;
		this.status = status;
		this.reason = reason;
		this.refund = refund;
	
	}
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComplaintTime() {
		return complaintTime;
	}
	public void setComplaintTime(String complaintTime) {
		this.complaintTime = complaintTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRefund() {
		return refund;
	}
	public void setRefund(String refund) {
		this.refund = refund;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
}
