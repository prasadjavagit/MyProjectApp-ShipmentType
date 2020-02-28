package in.nit.dao;

import in.nit.model.Document;

public interface IDocumentDao {
	Integer saveDocument(Document doc);
}
