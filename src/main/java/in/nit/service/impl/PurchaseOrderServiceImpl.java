package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IPurchaseOrderDao;
import in.nit.model.PurchaseOrder;
import in.nit.service.IPurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {

	@Autowired
	private IPurchaseOrderDao dao;
	
	@Override
	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder ob) {
		return dao.savePurchaseOrder(ob);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PurchaseOrder> getAllPurchaseOrders() {
		List<PurchaseOrder> list = dao.getAllPurchaseOrders();
		Collections.sort(list, (o1, o2) -> o1.getpId() - o2.getpId());
		return list;
	}

	@Override
	@Transactional
	public void deletePurchaseOrder(Integer id) {
		dao.deletePurchaseOrder(id);
	}

	@Override
	@Transactional(readOnly = true)
	public PurchaseOrder getOnePurchaseOrder(Integer id) {
		return dao.getOnePurchaseOrder(id);
	}

	@Override
	@Transactional
	public void updatePurchaseOrder(PurchaseOrder ob) {
		dao.updatePurchaseOrder(ob);
	}

}
