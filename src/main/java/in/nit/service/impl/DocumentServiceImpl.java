package in.nit.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.dao.IDocumentDao;
import in.nit.model.Document;
import in.nit.service.IDocumentService;

@Service
public class DocumentServiceImpl implements IDocumentService {
	@Autowired
	private IDocumentDao dao;

	@Transactional
	public Integer saveDocument(Document doc) {
		return dao.saveDocument(doc);
	}

}
