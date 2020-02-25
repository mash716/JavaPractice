package com.petitmonte.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.petitmonte.form.HelloWorldForm;

public class HelloWorldAction2 extends Action {

  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response)
                                  throws Exception {

	    HelloWorldForm myForm = (HelloWorldForm) form;

	    String str = "";
	    Connection con = null;
	    Statement stmt = null;
	    ResultSet rs = null;

	    // JDBCの各設定
	    // ※jdbc:mysql://localhost:3306/データベース名
	    String url  = "jdbc:mysql://localhost:3306/user";
	    String user = "root";        // ユーザー名
	    String pass = "root";  // パスワード

	    try {

	        // データベースに接続
	        con = DriverManager.getConnection(url,user,pass);

	        // ステートメントオブジェクトを作成
	        stmt = con.createStatement();

	        // SQLの作成
	        String sql = "select * from user_data";

	        // SQLの実行
	        rs = stmt.executeQuery(sql);

	        str += "--------------------" + "<br>";
	        str += "no  title" + "<br>";
	        str += "--------------------" + "<br>";

	        // 結果セットからデータを取り出す
	        while(rs.next()) {
	          String userid = rs.getString("userid");
	          String name = rs.getString("name");

	          str += String.valueOf(userid) + " " + name + "<br>";
	        }


	      } catch (Exception e) {
	          System.out.println(e.getMessage()+"EEEE");
	      }finally {

	          // 各オブジェクトを解放する
	          if(rs != null) {
	              try {
	                  rs.close();
	              }catch (Exception e) {
	                  System.out.println(e.getMessage()+"AAAA");
	                  System.out.println("AAAA");
	            }
	          }

	          if(stmt != null) {
	              try {
	                  stmt.close();
	              }catch (Exception e) {
	                  System.out.println(e.getMessage()+"BBBB");
	                  System.out.println("BBBB");
	            }
	          }

	          if(con != null) {
	              try {
	                  con.close();
	              }catch (Exception e) {
	                  System.out.println(e.getMessage()+"CCCC");
	                  System.out.println("CCCC");
	            }
	          }
	      }

	    myForm.setMessage(str);

	    return mapping.findForward("success");
  }

}
