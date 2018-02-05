package st.core.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import st.core.model.TestModel;


public class ExcelUtils {

	public static void main(String[] args) throws Exception {
//		new ExcelUtils().showExcel("D:\\qq.xls");
		List<TestModel> list = new ExcelUtils().showExcel3("D:\\qq.xls","Sheet1");
		for(TestModel o:list) {
			System.out.print(o.getName()+"\t");
			System.out.print(o.getSco()+"\t\n");
		}
		
		String[] columnNames = { "濮撳�?", "鍒嗘�?"};
		String[] methodNames = { "getName", "getSco"};
		Workbook excel = ExcelExporter.export2Excel("棰樺�?","鑴氭�?", "sheet1", columnNames, methodNames,
				 list);
		 ExcelExporter.saveWorkBook2007(excel,"D:\\qqqqqqq.xls");
	}


	// 璇诲彇锛屽叏閮╯heet琛ㄥ強鏁版嵁
	public void showExcel(String filepath) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(filepath)));
		XSSFSheet sheet = null;
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {// 鑾峰彇姣忎釜Sheet琛�
			sheet = workbook.getSheetAt(i);
			for (int j = 0; j < sheet.getLastRowNum() + 1; j++) {// getLastRowNum锛岃幏鍙栨渶鍚庝竴琛�?殑琛屾爣
				XSSFRow row = sheet.getRow(j);
				if (row != null) {
					for (int k = 0; k < row.getLastCellNum(); k++) {// getLastCellNum锛屾槸鑾峰彇鏈�鍚庝竴涓笉涓虹┖鐨勫垪鏄鍑犱釜
						if (row.getCell(k) != null) { // getCell 鑾峰彇鍗曞厓鏍兼暟鎹�?
							System.out.print(row.getCell(k) + "\t");
						} else {
							System.out.print("\t");
						}
					}
				}
				System.out.println(""); // 璇诲畬涓�琛屽悗鎹㈣�?
			}
			System.out.println("璇诲彇sheet琛�?" + workbook.getSheetName(i) + " 瀹屾�?");
		}
	}

	public List<TestModel> showExcel3(String filepath, String sheetname) throws Exception {
		List<TestModel> list = new ArrayList<>();
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(filepath)));
		XSSFSheet sheet = null;
		int i = workbook.getSheetIndex(sheetname); // sheet琛ㄥ�?
		sheet = workbook.getSheetAt(i);
		for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {// getLastRowNum
			TestModel test = new TestModel();
			XSSFRow row = sheet.getRow(j);// 鑾峰彇鏈�鍚庝竴琛岀殑琛屾爣
			String[] temp = new String[row.getLastCellNum()];
			if (row != null) {
				for (int k = 0; k < row.getLastCellNum(); k++) {// getLastCellNum
					if (row.getCell(k) != null) { // getCell 鑾峰彇鍗曞厓鏍兼暟鎹�?
						// System.out.print(row.getCell(k) + "\t");
						temp[k] = row.getCell(k).toString();
					} else {
						// System.out.print("\t");
					}
				}
			}
			test.setName(temp[0]);
			test.setSco(Double.valueOf((temp[1])));
			list.add(test);
			// System.out.println("");
		}
		return list;
	}

	// 璇诲彇锛屾寚瀹歴heet琛ㄥ強鏁版嵁
	public void showExcel2(String filepath, String sheetname) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(filepath)));
		XSSFSheet sheet = null;
		int i = workbook.getSheetIndex(sheetname); // sheet琛ㄥ�?
//		sheet = workbook.getSheetAt(i);
		sheet=workbook.getSheet(sheetname);
		for (int j = 0; j < sheet.getLastRowNum() + 1; j++) {// getLastRowNum
																// 鑾峰彇鏈�鍚庝竴琛岀殑琛屾爣
			XSSFRow row = sheet.getRow(j);
			if (row != null) {
				for (int k = 0; k < row.getLastCellNum(); k++) {// getLastCellNum
																// 鏄幏鍙栨渶鍚庝竴涓笉涓虹┖鐨勫垪鏄鍑犱釜
					if (row.getCell(k) != null) { // getCell 鑾峰彇鍗曞厓鏍兼暟鎹�?
						System.out.print(row.getCell(k) + "\t");
					} else {
						System.out.print("\t");
					}
				}
			}
			System.out.println("");
		}
	}

	// 鍐欏叆锛屽線鎸囧畾sheet琛ㄧ殑鍗曞厓鏍�
	public void insertExcel3() throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File("E:/temp/t1.xls"))); // 璇诲彇鐨勬枃浠�
		XSSFSheet sheet = null;
		int i = workbook.getSheetIndex("xt"); // sheet琛ㄥ�?
		sheet = workbook.getSheetAt(i);

		XSSFRow row = sheet.getRow(0); // 鑾峰彇鎸囧畾鐨勮�?�硅薄锛屾棤鏁版嵁鍒欎负绌猴紝闇�瑕佸垱寤�
		if (row == null) {
			row = sheet.createRow(0); // 璇ヨ鏃犳暟鎹紝鍒涘缓琛屽璞�?
		}

		Cell cell = row.createCell(1); // 鍒涘缓鎸囧畾鍗曞厓鏍煎璞°�傚鏈韩鏈夋暟鎹細鏇挎崲鎺�
		cell.setCellValue("tt"); // 璁剧疆鍐呭

		FileOutputStream fo = new FileOutputStream("E:/temp/t1.xls"); // 杈撳嚭鍒版枃浠�
		workbook.write(fo);

	}

}
