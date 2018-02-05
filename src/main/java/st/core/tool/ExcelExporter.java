package st.core.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 涓�涓�氱敤鐨勫皢List<T>涓暟鎹鍑轰负Excel鏂囨。鐨勫伐鍏风�?
 * 
 * @author zhrb@cec.jmu
 */
public class ExcelExporter {
	/**
	 * 鏍规嵁ExcelEntity绛夊弬鏁扮敓鎴�?�orkbook
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public static <T> Workbook export2Excel(ExcelEntity<T> entity) throws Exception {
		Workbook workbook = export2Excel(entity.getHeader(), entity.getFooter(), entity.getSheetName(),
				entity.getColumnNames(), entity.getMethodNames(), entity.getEntities());
		return workbook;
	}

	/**
	 * 鏍规嵁缁欏畾鍙傛暟�?�煎嚭Excel鏂囨�?
	 *
	 * @param headerTitle
	 *            棰樺�?
	 * @param footer
	 *            鑴氭�?
	 * @param sheetName
	 * @param columnNames
	 *            琛ㄥご鍚嶇�?
	 * @param methodNames
	 * @param entities
	 * @return
	 * @throws Exception
	 */
	public static <T> Workbook export2Excel(String headerTitle, String footerTitle, String sheetName,
			String[] columnNames, String[] methodNames, List<T> entities) throws Exception {
		if (methodNames.length != columnNames.length)
			throw new IllegalArgumentException("methodNames.length should be equal to columnNames.length:"
					+ columnNames.length + " " + methodNames.length);
		Workbook newWorkBook2007 = new XSSFWorkbook();
		Sheet sheet = newWorkBook2007.createSheet(sheetName);
		// 璁剧疆棰樺ご
		Header header = sheet.getHeader();
		header.setCenter(headerTitle);
		// 璁剧疆鑴氭敞
		Footer footer = sheet.getFooter();
		footer.setCenter(footerTitle);
		int[] columnWidths = new int[columnNames.length];
		// 鍒涘缓琛ㄥご
		createTableHeader(sheet, 0, headerTitle, columnNames, columnWidths);
		// 濉厖琛ㄥ唴瀹�
		createTableContent(sheet, 1, methodNames, columnWidths, entities);
		return newWorkBook2007;
	}

	/**
	 * 鍒涘缓琛ㄥご
	 *
	 * @param sheet
	 * @param index
	 *            琛ㄥご寮�濮嬬殑琛屾�?
	 * @param headerTitle
	 *            棰樺�?
	 * @param columnNames
	 * @param columnWidths
	 */
	private static void createTableHeader(Sheet sheet, int index, String headerTitle, String[] columnNames,
			int[] columnWidths) {
		Row headerRow = sheet.createRow(index);
		/* 鏍煎紡璁剧疆 */
		// 璁剧疆�?�椾�?
		Font font = sheet.getWorkbook().createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);// 绮椾綋鏄剧ず
		// 璁剧疆鑳屾櫙鑹�
		CellStyle style = sheet.getWorkbook().createCellStyle();
		style.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setFont(font);
		for (int i = 0; i < columnNames.length; i++) {
			Cell headerCell = headerRow.createCell(i);
			headerCell.setCellStyle(style);
			headerCell.setCellValue(columnNames[i]);
		}
		for (int i = 0; i < columnNames.length; i++) {
			columnWidths[i] = (columnNames[i].getBytes().length + 2) * 256;
			sheet.setColumnWidth(i, columnWidths[i]);
		}
	}

	/**
	 * 鍒涘缓琛ㄦ牸鍐呭�?
	 *
	 * @param sheet
	 * @param rowIndexBegin
	 *            琛ㄥ唴�?�瑰紑濮嬬殑琛屾�?
	 * @param methodNames
	 *            T瀵硅薄鐨勬柟娉曞�?
	 * @param columnWidths
	 * @param entities
	 * @throws Exception
	 */
	private static <T> void createTableContent(Sheet sheet, int rowIndexBegin, String[] methodNames, int[] columnWidths,
			List<T> entities) throws Exception {
		Class<? extends Object> clazz = null;
		if (entities.size() > 0)
			clazz = entities.get(0).getClass();
		String content = null;
		for (T t : entities) {
			Row row = sheet.createRow(rowIndexBegin++);
			for (int i = 0; i < methodNames.length; i++) {
				Cell cell = row.createCell(i);
				Method method = clazz.getMethod(methodNames[i], null);
				Object object = method.invoke(t, null);
				object = object == null ? "" : object;
				if (object.getClass().equals(Date.class)) {// 瀵规棩鏈熸牸寮忚繘琛�?壒娈婂鐞�
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					content = sdf.format((Date) object);
					cell.setCellValue(content);
				} else {
					content = object.toString();
					cell.setCellValue(content);
				}
				int columnWidth = (content.getBytes().length + 2) * 256;
				if (columnWidth > columnWidths[i]) {// 濡傛灉�?�為檯鍐呭瀹藉害澶т簬�?�瑰簲鐨勮�?�澶村搴︼紝鍒欒缃负�?�為檯鍐呭瀹藉�?
					columnWidths[i] = columnWidth;
					sheet.setColumnWidth(i, columnWidths[i]);
				}
			}
		}
	}

	public static <T> void testPOI(String[] columnNames, String[] methodNames, List<T> entities) throws Exception {
		String sheetName = "Test";
		String title = "鏍囬鏍�?";
		String dstFile = "d:/temp/test.xlsx";
		Workbook newWorkBook2007 = new XSSFWorkbook();
		Sheet sheet = newWorkBook2007.createSheet(sheetName);
		int[] columnWidths = new int[columnNames.length];
		// 鍒涘缓琛ㄥご
		createTableHeader(sheet, 0, title, columnNames, columnWidths);
		// 濉厖琛ㄥ唴瀹�
		createTableContent(sheet, 1, methodNames, columnWidths, entities);
		// 淇濆瓨涓烘枃浠�
		saveWorkBook2007(newWorkBook2007, dstFile);
		System.out.println("end");
	}

	/**
	 * 灏唚orkbook2007鏉戝鏂囦欢
	 *
	 * @param workbook2007
	 * @param dstFile
	 */
	public static void saveWorkBook2007(Workbook workbook2007, String dstFile) {
		File file = new File(dstFile);
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			workbook2007.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}

	/**
	 * 娴嬭瘯鏂规硶
	 * 
	 * @param args
	 * @throws Exception
	 */
//	public static void main(String[] args) throws Exception {
//		// 鍑嗗鏁版嵁
//		List<Wind> winds = new ArrayList<>();// Wind鏈変笁涓柟娉�:getLocation銆乬etSpeed銆乬etTimestamp
//		for (int i = 0; i < 10; i++) {
//			Wind wind = new Wind();
//			wind.setLocation(i);
//			wind.setSpeed(i * 10);
//			wind.setTimestamp("2016/3/2" + i);
//			winds.add(wind);
//		}
//		String[] columnNames = { "鍦扮�?", "閫熷�?", "鏃堕�?" };
//		String[] methodNames = { "getLocation", "getSpeed", "getTimestamp" };
//		// String fileName = "d:/temp/excel1.xlsx";
//		String fileName = "d:/excel1.xlsx";
//		// 鐢熸垚ExcelEntity瀹炰綋锛屽寘鍚�4涓�?澶囧弬鏁�?
//		ExcelEntity<Wind> excelEntity = new ExcelEntity<>(fileName, columnNames, methodNames, winds);
//		// excelEntity.setHeader("棰樺�?");
//		// excelEntity.setFooter("鑴氭�?");
//		Workbook excel = ExcelExporter.export2Excel(excelEntity);
//		// ExcelExporter.export2Excel("棰樺�?","鑴氭�?", "sheet1", columnNames, methodNames,
//		// winds);//涔熷彲浠ヨ繖鏍疯皟鐢�?,鏃犻渶鏂板缓ExcelEntity瀵硅�?
//		// 灏哤orkbook瀛樹负鏂囦欢
//		ExcelExporter.saveWorkBook2007(excel, excelEntity.getFileName());
//		System.out.println("瀵煎嚭�?�屾垚锛�?");
//	}
}