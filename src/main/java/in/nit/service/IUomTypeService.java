package in.nit.service;

import java.util.List;

import in.nit.model.UomType;

public interface IUomTypeService {
	public Integer saveUomType(UomType ob);
	public List<UomType> getAllUomTypes();
	public void deletUomType(Integer id);
	public UomType getOneUomType(Integer id);
	public void updateUomType(UomType ob);
}
