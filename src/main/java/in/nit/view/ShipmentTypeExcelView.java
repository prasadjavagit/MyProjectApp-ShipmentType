package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsxView {
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// file name
		response.addHeader("Content-Disposition", "attachment;filename=shipments.xlsx");
		Sheet s = workbook.createSheet("Shipment Types");
		// set Head-row-0
		setHeader(s);
		// read model data
		@SuppressWarnings("unchecked")
		List<ShipmentType> list = (List<ShipmentType>) model.get("list");
		// set Body-row-1
		setBody(s, list);
	}

	private void setHeader(Sheet s) {
		Row row = s.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("ENABLE");
		row.createCell(4).setCellValue("GRADE");
		row.createCell(5).setCellValue("NOTE");

	}

	private void setBody(Sheet s, List<ShipmentType> list) {
		int count = 1;
		for (ShipmentType st : list) {
			Row row = s.createRow(count++);
			row.createCell(0).setCellValue(st.getShipId());
			row.createCell(1).setCellValue(st.getShipMode());
			row.createCell(2).setCellValue(st.getShipCode());
			row.createCell(3).setCellValue(st.getEnbShip());
			row.createCell(4).setCellValue(st.getShipGrad());
			row.createCell(5).setCellValue(st.getShipDesc());
		}

	}
}
