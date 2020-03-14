package in.nit.service;

import java.util.List;

import in.nit.model.PurchaseOrder;

public interface IPurchaseOrderService {

	Integer PurchaseOrder(PurchaseOrder ob);

	List<PurchaseOrder> getAllPurchaseOrders();

	public void deletePurchaseOrder(Integer id);

	PurchaseOrder getOnePurchaseOrder(Integer id);

	void updatePurchaseOrder(PurchaseOrder ob);
}