package in.nit.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
