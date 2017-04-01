package cn.com.magicsoft.framework.core.utils;

import java.util.List;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public final class HSSFExportUtils {
	public static void commonExportData(String fileName, List<Map> ColumnsMapList, List<Map> dataMapList,
			HttpServletResponse response, Integer rowAccessWindowSize) throws Exception {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

		String fileName2 = new String(fileName.getBytes("gb2312"), "iso-8859-1");

		response.setHeader("Content-Disposition", "attachment;filename=" + fileName2 + ".xlsx");
		response.setHeader("Pragma", "no-cache");

		if (rowAccessWindowSize == null) {
			rowAccessWindowSize = Integer.valueOf(1);
		}

		SXSSFWorkbook wb = new SXSSFWorkbook(rowAccessWindowSize.intValue());
		Sheet sheet1 = wb.createSheet();
		wb.setSheetName(0, fileName);
		sheet1.setDefaultRowHeightInPoints(20.0F);
		sheet1.setDefaultColumnWidth(18);

		Footer footer = sheet1.getFooter();
		footer.setRight("Page " + HSSFFooter.page() + " of " + HSSFFooter.numPages());

		CellStyle style1 = wb.createCellStyle();
		style1.setAlignment((short) 2);
		Font font1 = wb.createFont();
		font1.setFontHeightInPoints((short) 13);
		font1.setBoldweight((short) 700);
		style1.setFont(font1);

		CellStyle style2 = wb.createCellStyle();
		style2.setAlignment((short) 1);
		style2.setWrapText(true);

		CellRangeAddress rg1 = new CellRangeAddress(0, 0, 0, (short) (ColumnsMapList.size() - 1));
		sheet1.addMergedRegion(rg1);

		CellStyle style3 = wb.createCellStyle();
		style3.setAlignment((short) 1);
		Font font3 = wb.createFont();
		font3.setFontHeightInPoints((short) 18);
		font3.setBoldweight((short) 700);
		style3.setFont(font3);
		style3.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style3.setFillPattern((short) 1);
		Row row0 = sheet1.createRow(0);
		row0.setHeightInPoints(35.0F);

		Cell cell0 = row0.createCell(0);
		cell0.setCellValue(fileName.toString());
		cell0.setCellStyle(style3);

		Row row1 = sheet1.createRow(1);
		row1.setHeightInPoints(20.0F);
		for (int i = 0; i < ColumnsMapList.size(); ++i) {
			Cell cell1 = row1.createCell(i);
			cell1.setCellType(1);
			cell1.setCellValue(((Map) ColumnsMapList.get(i)).get("title").toString());
			cell1.setCellStyle(style1);
		}

		for (int j = 0; j < dataMapList.size(); ++j) {
			Row row2 = sheet1.createRow(j + 2);
			Map cellDataMap = (Map) dataMapList.get(j);
			for (int i = 0; i < ColumnsMapList.size(); ++i) {
				Cell cell = row2.createCell(i);
				String cellValue = "";
				if (((Map) ColumnsMapList.get(i)).get("field") != null) {
					String fieldString = String.valueOf(((Map) ColumnsMapList.get(i)).get("field"));
					cellValue = String.valueOf(cellDataMap.get(fieldString));
				}
				cell.setCellValue(cellValue);
				cell.setCellStyle(style2);
			}

		}

		wb.write(response.getOutputStream());
		response.getOutputStream().flush();
		response.getOutputStream().close();
		wb.dispose();
	}

	public static void commonExportDataNoHeader(String fileName, List<Map> ColumnsMapList, List<Map> dataMapList,
			HttpServletResponse response, Integer rowAccessWindowSize) throws Exception {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

		String fileName2 = new String(fileName.getBytes("gb2312"), "iso-8859-1");

		response.setHeader("Content-Disposition", "attachment;filename=" + fileName2 + ".xlsx");
		response.setHeader("Pragma", "no-cache");

		if (rowAccessWindowSize == null) {
			rowAccessWindowSize = Integer.valueOf(1);
		}

		SXSSFWorkbook wb = new SXSSFWorkbook(rowAccessWindowSize.intValue());
		Sheet sheet1 = wb.createSheet();
		wb.setSheetName(0, "Sheet1");
		sheet1.setDefaultRowHeightInPoints(20.0F);
		sheet1.setDefaultColumnWidth(18);

		Footer footer = sheet1.getFooter();
		footer.setRight("Page " + HSSFFooter.page() + " of " + HSSFFooter.numPages());

		CellStyle style1 = wb.createCellStyle();
		style1.setAlignment((short) 2);
		Font font1 = wb.createFont();
		font1.setFontHeightInPoints((short) 13);
		font1.setBoldweight((short) 700);
		style1.setFont(font1);

		CellStyle style2 = wb.createCellStyle();
		style2.setAlignment((short) 1);
		style2.setWrapText(true);

		Row row1 = sheet1.createRow(0);
		row1.setHeightInPoints(20.0F);
		for (int i = 0; i < ColumnsMapList.size(); ++i) {
			Cell cell1 = row1.createCell(i);
			cell1.setCellType(1);
			cell1.setCellValue(((Map) ColumnsMapList.get(i)).get("title").toString());
			cell1.setCellStyle(style1);
		}

		for (int j = 0; j < dataMapList.size(); ++j) {
			Row row2 = sheet1.createRow(j + 1);
			Map cellDataMap = (Map) dataMapList.get(j);
			for (int i = 0; i < ColumnsMapList.size(); ++i) {
				Cell cell = row2.createCell(i);
				String cellValue = "";
				if (((Map) ColumnsMapList.get(i)).get("field") != null) {
					String fieldString = String.valueOf(((Map) ColumnsMapList.get(i)).get("field"));
					cellValue = String.valueOf(cellDataMap.get(fieldString));
				}
				cell.setCellValue(cellValue);
				cell.setCellStyle(style2);
			}

		}

		wb.write(response.getOutputStream());
		response.getOutputStream().flush();
		response.getOutputStream().close();
		wb.dispose();
	}
}