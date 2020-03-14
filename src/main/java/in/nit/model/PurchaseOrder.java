package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "potab")
public class PurchaseOrder {
	@Id
	@GeneratedValue
	@Column(name = "pid")
	private Integer pId;
	@Column(name = "ordode")
	private String orderCode;
	@Column(name = "refnum")
	private Integer refNum;
	@Column(name = "qchk")
	private String qltyChk;
	@Column(name = "status")
	private String status;
	@Column(name = "note")
	private String note;
	@ManyToOne
	@JoinColumn(name="shipIdFk")
	private ShipmentType shipOb;//HAS-A

	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(Integer pId) {
		super();
		this.pId = pId;
	}

	public ShipmentType getShipOb() {
		return shipOb;
	}

	public void setShipOb(ShipmentType shipOb) {
		this.shipOb = shipOb;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Integer getRefNum() {
		return refNum;
	}

	public void setRefNum(Integer refNum) {
		this.refNum = refNum;
	}

	public String getQltyChk() {
		return qltyChk;
	}

	public void setQltyChk(String qltyChk) {
		this.qltyChk = qltyChk;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [pId=" + pId + ", orderCode=" + orderCode + ", refNum=" + refNum + ", qltyChk=" + qltyChk
				+ ", status=" + status + ", note=" + note + ", shipOb=" + shipOb + "]";
	}

}
