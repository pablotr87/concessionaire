package com.ptirador.concessionaire.views;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.usermodel.*;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.ptirador.concessionaire.util.Constants.*;

/**
 * View to build a spreadsheet document.
 *
 * @author ptirador
 */
public class ExportListSpreadsheetView extends AbstractXlsxView {

    /**
     * Default spreadsheet file extension.
     */
    private static final String DEFAULT_SPREADSHEET_EXTENSION = ".xlsx";

    /**
     * Default spreadsheet file name.
     */
    private static final String DEFAULT_SPREADSHEET_NAME = "list";

    /**
     * Builds an spreadsheet document from model data.
     *
     * @param model    Model data.
     * @param workbook Workbook where the data will be inserted.
     * @param request  HTTP request.
     * @param response HTTP response.
     * @throws Exception If anything wrong happens.
     */
    @Override
    @SuppressWarnings("unchecked")
    protected void buildExcelDocument(Map<String, Object> model,
                                      Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        // Collect the data model
        List<?> list = (List<?>) model.get(MDL_BASE_LIST);
        List<String> cols = (List<String>) model.get(MDL_BASE_HEADER);
        List<String> ids = (List<String>) model.get(MDL_BASE_IDS);
        Object objFName = model.get(MDL_BASE_FILENAME);
        String fileName = (String) (objFName != null ? objFName : DEFAULT_SPREADSHEET_NAME);

        // Sheet where the list will be filled
        Sheet sheet = workbook.createSheet(fileName);
        // Document hedaer
        createHeader(workbook, cols, sheet);

        // Iterate every element from the list
        for (int i = 0; i < list.size(); i++) {
            // Create rows from 1 because 0 is the header
            Row row = sheet.createRow(i + 1);
            // For each header element, search for the bean value
            for (int j = 0; j < cols.size(); j++) {
                Object bean = list.get(i);
                String[] arrayProp = BeanUtils.getArrayProperty(bean, ids.get(j));
                // If the bean has a list property, it is formatted
                if (null != arrayProp && arrayProp.length > 1) {
                    String arrayPropStr = Arrays.toString(arrayProp);
                    String arrayPropWithoutBrackets = arrayPropStr.replace("[", "").replace("]", "");
                    addStringCell(row, j, arrayPropWithoutBrackets);
                } else {
                    addStringCell(row, j, BeanUtils.getProperty(bean, ids.get(j)));
                }
            }
        }

        // Add auto size for columns.
        setColumnsSize(cols, sheet);

        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName + DEFAULT_SPREADSHEET_EXTENSION);

    }

    /**
     * Sets autosize to every column.
     *
     * @param cols  Document columns.
     * @param sheet Document sheet.
     */
    private void setColumnsSize(List<String> cols, Sheet sheet) {
        for (int i = 0; i < cols.size(); i++) {
            sheet.autoSizeColumn(i);
        }
    }

    /**
     * Create the first row in the document (header).
     *
     * @param workbook Workbook where the row is created.
     * @param cols     Document columns.
     * @param sheet    Sheet where the row is created.
     */
    private void createHeader(Workbook workbook, List<String> cols, Sheet sheet) {
        Row header = sheet.createRow(0);
        header.setHeight((short) 500);

        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.DARK_TEAL.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        font.setBold(true);
        style.setFont(font);

        for (int x = 0; x < cols.size(); x++) {
            addHeadCell(header, x, cols.get(x), style);
        }
    }

    /**
     * Create a new cell for the header.
     *
     * @param row       Row where the cell will be added.
     * @param index     Column in row.
     * @param value     Value to insert in the cell.
     * @param headStyle Style for the header.
     */
    private void addHeadCell(Row row, int index, String value,
                             CellStyle headStyle) {
        Cell cell = row.createCell((short) index);

        if (value != null) {
            cell.setCellValue(value);
            cell.setCellStyle(headStyle);
        }
    }

    /**
     * Create a new cell that contains a string.
     *
     * @param row   Row where the cell will be added.
     * @param index Column in row.
     * @param value Value to insert in the cell.
     */
    private void addStringCell(Row row, int index, String value) {
        Cell cell = row.createCell(index);
        if (value != null) {
            cell.setCellValue(value);
        }
    }


}
