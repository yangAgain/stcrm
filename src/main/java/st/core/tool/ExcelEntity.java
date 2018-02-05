package st.core.tool;

import java.util.List;

public class ExcelEntity<T> {
	private String sheetName = "Sheet1";// 榛樿鐢熸垚鐨剆heet鍚嶇О
	private String header = "";// 棰樺�?
	private String footer = "";// 鑴氭�?
	// 搴曚笅鏄繀椤诲叿澶囩殑灞炴��
	private String fileName;
	private String[] columnNames;// 鍒楀�?
	private String[] methodNames;// 涓庡垪鍚嶅搴旂殑鏂规硶鍚�
	private List<T> entities;// 鏁版嵁�?�炰�?

	public ExcelEntity(String fileName, String[] columnNames, String[] methodNames, List<T> entities) {
		this("sheet1", "", "", fileName, columnNames, methodNames, entities);
	}

	public ExcelEntity(String sheetName, String header, String footer, String fileName, String[] columnNames,
			String[] methodNames, List<T> entities) {
		this.sheetName = sheetName;
		this.header = header;
		this.footer = footer;
		this.fileName = fileName;
		this.columnNames = columnNames;
		this.methodNames = methodNames;
		this.entities = entities;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public List<T> getEntities() {
		return entities;
	}

	/**
	 *
	 * @param entities
	 *            鐢ㄤ簬�?�煎嚭Excel鐨勫疄浣撻泦鍚�
	 */
	public void setEntities(List<T> entities) {
		this.entities = entities;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String[] getMethodNames() {
		return methodNames;
	}

	public void setMethodNames(String[] methodNames) {
		this.methodNames = methodNames;
	}
}
