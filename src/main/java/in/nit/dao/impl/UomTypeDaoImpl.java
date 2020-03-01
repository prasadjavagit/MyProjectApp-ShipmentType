package in.nit.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IUomTypeDao;
import in.nit.model.UomType;

@Repository
public class UomTypeDaoImpl implements IUomTypeDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveUomType(UomType ob) {
		Integer id = (Integer) ht.save(ob);
		return id;
	}

}
