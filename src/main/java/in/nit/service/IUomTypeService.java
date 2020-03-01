package in.nit.service;

import java.util.List;

import in.nit.model.UomType;

public interface IUomTypeService {
	public Integer saveUomType(UomType ob);
	public List<UomType> getAllUomTypes();
	public void deletUomType(Integer id);
}
