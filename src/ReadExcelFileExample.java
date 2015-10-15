import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ZNE45571 on 2/25/2015.
 */
public class ReadExcelFileExample {
    private static final String FILE_PATH = "contacts1.xlsx";

    public static void main(String args[]) {

        List studentList = getUserListFromExcel2();
//        final Random random = new Random();
//        final int seed = 300*1000;
//
//        //System.out.println(studentList);
//        for(int i=0;i<20;i++) {
//            Double milli = Math.random()*10000*60;
//            int intVal = milli.intValue();
//            //int intValue = ((Double)Math.random()*10000*60);
//            //System.out.println(intVal);
//
//            int time = random.nextInt(seed);
//            System.out.println(time);
//        }
    }



    public static List getUserListFromExcel() {
        List userList = new ArrayList();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(FILE_PATH);

            // Using XSSF for xlsx format, for xls use HSSF
            Workbook workbook = new XSSFWorkbook(fis);

            int numberOfSheets = workbook.getNumberOfSheets();

            //looping over each workbook sheet
            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                Iterator rowIterator = sheet.iterator();

                //iterating over each row
                while (rowIterator.hasNext()) {

                    User user = new User();
                    Row row = (Row)rowIterator.next();
                    Iterator cellIterator = row.cellIterator();

                    //Iterating over each cell (column wise)  in a particular row.
                    while (cellIterator.hasNext()) {

                        Cell cell = (Cell)cellIterator.next();
                        //The Cell Containing String will is name.
                        //if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
                        //    user.setFirstName(cell.getStringCellValue());

                            //The Cell Containing numeric value will contain marks
                        //} else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {

                            //Cell with index 1 contains marks in Maths
                            if (cell.getColumnIndex() == 0) {
                                user.setFirstName(cell.getStringCellValue());
                            }
                            //Cell with index 2 contains marks in Science
                            else if (cell.getColumnIndex() == 1) {
                                user.setLastName(cell.getStringCellValue());
                            }
                            //Cell with index 3 contains marks in English
                            else if (cell.getColumnIndex() == 2) {
                                user.setEmail(cell.getStringCellValue());
                            }
                            else if (cell.getColumnIndex() == 3) {
                                user.setPassword(cell.getStringCellValue());
                            }
                            else if (cell.getColumnIndex() == 4) {
                                user.setZipCode(String.valueOf((int)cell.getNumericCellValue()));
                            }
                            else if (cell.getColumnIndex() == 5) {
                                user.setBirthMonth(cell.getStringCellValue());
                            }
                            else if (cell.getColumnIndex() == 6) {
                                user.setBirthDay(String.valueOf((int)cell.getNumericCellValue()));
                            }
                            else if (cell.getColumnIndex() == 7) {
                                user.setBirthYear(String.valueOf((int)cell.getNumericCellValue()));
                            }
                        //}
                    }
                    //end iterating a row, add all the elements of a row in list
                    userList.add(user);
                }
            }

            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static List getUserListFromExcel2() {
        List userList = new ArrayList();
        FileInputStream fis = null;
        HashMap months = new HashMap();
        months.put("01","January");
        months.put("02","February");
        months.put("03","March");
        months.put("04","April");
        months.put("05","May");
        months.put("06","June");
        months.put("07","July");
        months.put("08","August");
        months.put("09","September");
        months.put("10","October");
        months.put("11","November");
        months.put("12","December");
        try {
            fis = new FileInputStream(FILE_PATH);

            // Using XSSF for xlsx format, for xls use HSSF
            Workbook workbook = new XSSFWorkbook(fis);

            int numberOfSheets = workbook.getNumberOfSheets();

            //looping over each workbook sheet
            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                Iterator rowIterator = sheet.iterator();

                int j = 0;
                    //iterating over each row
                    while (rowIterator.hasNext() && j<23) {
                        j++;
                        User user = new User();
                        Row row = (Row)rowIterator.next();
                        Iterator cellIterator = row.cellIterator();
                        //Iterating over each cell (column wise)  in a particular row.
                        while (cellIterator.hasNext()) {

                            Cell cell = (Cell)cellIterator.next();
                            //The Cell Containing String will is name.
                            //if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
                            //    user.setFirstName(cell.getStringCellValue());

                            //The Cell Containing numeric value will contain marks
                            //} else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {

                            //Cell with index 1 contains marks in Maths
                            if (cell.getColumnIndex() == 0) {
                                user.setFirstName(cell.getStringCellValue());
                            }
                            //Cell with index 2 contains marks in Science
                            else if (cell.getColumnIndex() == 1) {
                                user.setLastName(cell.getStringCellValue());
                            }
                            //Cell with index 3 contains marks in English
                            else if (cell.getColumnIndex() == 2) {
                                user.setEmail(cell.getStringCellValue());
                            }
                            else if (cell.getColumnIndex() == 3) {
                                user.setPassword(cell.getStringCellValue());
                            }
                            else if (cell.getColumnIndex() == 4) {
                                user.setZipCode(String.valueOf((int)cell.getNumericCellValue()));
                            }
                            else if (cell.getColumnIndex() == 5) {
                                Date date = cell.getDateCellValue();
                                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                                String dateStr = sdf.format(date);
                                //System.out.println(dateStr);
                                String[] birthDetail = dateStr.split("/");
                                user.setBirthMonth((String)months.get(birthDetail[0]));
                                user.setBirthDay(String.valueOf(Integer.valueOf(birthDetail[1])));
                                //user.setBirthDay(birthDetail[1]);
                                user.setBirthYear(birthDetail[2]);
                            }
                            else if (cell.getColumnIndex() == 6) {
                                user.setGender(cell.getStringCellValue());
                            }
                            //}
                        }
                        //end iterating a row, add all the elements of a row in list
                        userList.add(user);
                    }
                }


            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }

}
