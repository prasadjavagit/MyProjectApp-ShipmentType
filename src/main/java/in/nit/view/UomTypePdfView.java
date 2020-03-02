package in.nit.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.UomType;

public class UomTypePdfView extends AbstractPdfView {
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest requeut, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=uoms.pdf");
		Paragraph p = new Paragraph("Welcome to UomType");
		document.add(p);
		@SuppressWarnings("unchecked")
		List<UomType> list = (List<UomType>) model.get("li");
		PdfPTable t = new PdfPTable(4);
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("MODEL");
		t.addCell("NOTE");
		for (UomType ut : list) {
			t.addCell(ut.getUomId().toString());
			t.addCell(ut.getUomType());
			t.addCell(ut.getUomModel());
			t.addCell(ut.getUomDesc());
		}
		document.add(t);
		document.add(new Paragraph(new Date().toString()));
	}
}
