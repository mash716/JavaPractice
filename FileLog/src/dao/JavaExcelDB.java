package dao;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class JavaExcelDB {
    //DB接続情報
    private static final String URL = "jdbc:mysql://localhost:3306/user";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        String sql = "SELECT * FROM user_data;";

        try {
            //データ取得用
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            //取得結果をリストへ
            List records = new ArrayList<List>();
            List columns = new ArrayList<Object>();
            for (int i = 1; i <= 5; i++) {
                columns.add(rsmd.getColumnName(i));
            }
            records.add(columns);
            while (rs.next()) {
                List values = new ArrayList<Object>();
                values.add(rs.getString("userid"));
                values.add(rs.getString("name"));
                values.add(rs.getString("zipcode"));
                values.add(rs.getString("address"));
                values.add(rs.getString("tel"));
                values.add(rs.getString("mail"));
                records.add(values);
            }

            //エクセルに出力するデータをセット
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            int rowNum = 0;
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadSheet = workbook.createSheet("test1");
            XSSFRow row = spreadSheet.createRow(rowNum++);
            for (Object record : records) {
                int cellNum = 0;
                XSSFCell cell = row.createCell(cellNum++);
                for (int i = 0; i < ((List)record).size(); i++) {
                    if (!((List)record).get(0).equals("id")) {
                        if (i == 4 || i == 5) {
                            if (((List)record).get(i) != null) {
                                ((List)record).set(i, sdf.format(((List)record).get(i)));
                            } else {
                                ((List)record).set(i, "NULL");
                            }
                        }
                    }
                    cell.setCellValue(((List)record).get(i).toString());
                    if (i != ((List)record).size() -1) cell = row.createCell(cellNum++);
                }
                row = spreadSheet.createRow(rowNum++);
            }
            //パスの取得
            String path = new File(".").getAbsoluteFile().getParent();
            String filepath = path+"\\excel\\kuku_202002240022.xlsx";
            //出力
            FileOutputStream output = null;
            try {
                output = new FileOutputStream(new File(filepath));
                workbook.write(output);
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (output != null) output.close();
                    if (workbook != null) workbook.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
        }
    }

}
