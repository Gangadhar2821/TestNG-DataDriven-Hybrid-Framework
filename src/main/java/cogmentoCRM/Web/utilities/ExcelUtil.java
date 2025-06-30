package cogmentoCRM.Web.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtil { // Single Excel file used throughout the framework
	private static final String EXCEL_FILE_PATH = "./testdata/Cogmento-crm-Web.xlsx";

	@DataProvider(name = "ExcelTestData", parallel = false)
	public Object[][] dynamicExcelData(Method method) {
		String sheetName = method.getName(); // Use test method name as sheet name
		return getExcelDataAsMap(EXCEL_FILE_PATH, sheetName);
	}

	public static Object[][] getExcelDataAsMap(String filePath, String sheetName) {

		List<Map<String, String>> dataList = new ArrayList<>();

		try {
			FileInputStream fis = new FileInputStream(new File(filePath));
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null)
				throw new RuntimeException("Sheet not found: " + sheetName);

			Row headerRow = sheet.getRow(0);
			if (headerRow == null)
				throw new RuntimeException("Header row missing in sheet: " + sheetName);

			int colCount = headerRow.getLastCellNum();
			int rowCount = sheet.getPhysicalNumberOfRows();

			for (int i = 1; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				if (row == null)
					continue;

				Map<String, String> rowMap = new LinkedHashMap<>();

				for (int j = 0; j < colCount; j++) {
					Cell headerCell = headerRow.getCell(j);
					Cell valueCell = row.getCell(j);

					String key = headerCell != null ? headerCell.getStringCellValue().trim() : "Column" + j;
					String value = valueCell != null ? getCellValueAsString(valueCell) : "";

					rowMap.put(key, value);
				}

				dataList.add(rowMap);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error reading Excel data: " + e.getMessage());
		}

		// Convert List<Map> to Object[][]
		Object[][] result = new Object[dataList.size()][1];
		for (int i = 0; i < dataList.size(); i++) {
			result[i][0] = dataList.get(i);
		}

		return result;
	}

	// Method that converts the data in cell into respective data type
	private static String getCellValueAsString(Cell cell) {

		if (cell == null)
			return "";

		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue().toString(); // You can format date if needed
			} else {
				double value = cell.getNumericCellValue();
				long longVal = (long) value;
				if (value == (double) longVal) {
					return String.valueOf(longVal); // exact integer representation
				} else {
					return String.valueOf(value); // fallback for decimals
				}
			}

		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());

		case BLANK:
			return "";

		default:
			return "";
		}
	}

}
