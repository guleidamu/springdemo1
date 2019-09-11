package com.example.businessdemo.util;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;

import java.util.*;
import java.util.Map.Entry;

import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ExcelUtil {
    private static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    public static void main(String[] args) {
        //public void getExcel() {
        Workbook wb = null;
        Sheet sheet = null;
        Row row = null;
        List<Map<String, String>> list = null;
        String cellData = null;
        String filePath = "D:\\test.xlsx";
        String columns[] = {"name", "age", "score"};
        String columnDt[] = null;
        List<String> columnLists = new ArrayList();
        wb = readExcel(filePath);
        if (null != wb) {
            //用来存放表的数据
            list = new ArrayList<Map<String, String>>();
            //获取第一个sheet
            sheet = wb.getSheetAt(0);
            //获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows();
            //获取第一行
            row = sheet.getRow(0);
            //获取最大列数
            int colnum = row.getPhysicalNumberOfCells();

            for(int k = 0;k<colnum;k++){
                columnLists.add((String) getCellFormatValue(row.getCell(k)));
            }

            for (int i = 1; i < rownum+1; i++) {
                Map<String, String> map = new LinkedHashMap<String, String>();
                row = sheet.getRow(i);
                if (null != row) {
                    for (int j = 0; j < colnum; j++) {
//                        if (1 == i) {
//                            Row row_1 = sheet.getRow(0);
//                            if (null != row_1) {
//                                String data = (String) getCellFormatValue(row_1.getCell(j));
//                                if(null!=data){
//                                    columnLists.add(data);
//                                }else{
//                                    columnLists.add("");
//                                }
//                            }
//                        }
                            String data = (String) getCellFormatValue(row.getCell(j));
                            map.put(columnLists.get(j), data);
                    }
                } else {
                    break;
                }
                list.add(map);
            }


//            for (int i = 1; i < rownum; i++) {
//                Map<String, String> map = new LinkedHashMap<String, String>();
//                row = sheet.getRow(i);
//                if (null != row){
//                    for(int j = 0; j<colnum;j++){
//                        cellData =  (String) getCellFormatValue(row.getCell(j));
//                        map.put(columns[j],cellData);
//                    }
//                }else {
//                    break;
//                }
//                list.add(map);
//            }
        }

        //遍历解析出来的list
        for (Map<String, String> map : list) {
            for (Entry<String, String> entry : map.entrySet()) {
                System.out.print(entry.getKey() + ":" + entry.getValue() + ",");
            }
            System.out.println();
        }

    }

    //读取excel
    public static Workbook readExcel(String filePath) {
        Workbook wb = null;
        if (null == filePath) {
            logger.info("查找不到相应的文件");
            return null;
        }

        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;

        try {
            is = new FileInputStream(filePath);
            if (".xls".equalsIgnoreCase(extString)) {
                return wb = new HSSFWorkbook(is);
            } else if (".xlsx".equalsIgnoreCase(extString)) {
                return wb = new XSSFWorkbook(is);
            } else {
                return wb = null;
            }
        } catch (FileNotFoundException e) {
            logger.info("找不到文件 " + filePath);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    public static Object getCellFormatValue(Cell cell) {
        Object cellValue = null;
        if (null != cell) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC: {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                }
                case Cell.CELL_TYPE_FORMULA: {
                    //判断cell是否为日期格式
                    if (DateUtil.isCellDateFormatted(cell)) {
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    } else {
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING: {
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        } else {
            cellValue = "";
        }
        return cellValue;
    }

}
