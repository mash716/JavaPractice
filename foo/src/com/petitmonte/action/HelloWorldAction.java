package com.petitmonte.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



public class HelloWorldAction extends Action {
    //DB接続情報
    private static final String URL = "jdbc:mysql://localhost:3306/user";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
              throws Exception {
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
            for (int i = 1; i <= 6; i++) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
        }
		return mapping.findForward("success");
    }

}
