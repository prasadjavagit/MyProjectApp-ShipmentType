package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IUomTypeDao;
import in.nit.model.UomType;
import in.nit.service.IUomTypeService;

@Service
public class UomTypeServiceImpl implements IUomTypeService, IUomTypeDao {
	@Autowired
	private IUomTypeDao dao;

	@Transactional
	public Integer saveUomType(UomType ob) {
		return dao.saveUomType(ob);
	}

	@Transactional(readOnly = true)
	public List<UomType> getAllUomTypes() {
		return dao.getAllUomTypes();
	}

	@Transactional
	public void deletUomType(Integer id) {
		dao.deletUomType(id);
	}
}
