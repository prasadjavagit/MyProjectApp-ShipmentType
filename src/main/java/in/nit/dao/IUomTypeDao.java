package in.nit.dao;

import java.util.List;

import in.nit.model.UomType;

public interface IUomTypeDao {
	public Integer saveUomType(UomType ob);
	public List<UomType> getAllUomTypes();
	public void deletUomType(Integer id);
}
