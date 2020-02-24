package control;

import java.io.IOException;

import model.ExcelJava;
import model.LoggerJava;
import model.Pdfjava;
import model.wordjava;

public class Control {

	public static void main(String[] args) {

		//excelファイルの生成
		try {
			ExcelJava.excelJava();
		} catch (SecurityException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		//Loggerファイルの生成
		LoggerJava.loggerJava();
		//pdfファイルの生成
		Pdfjava.pdfJava();
		//wordファイルの生成
		try {
			wordjava.wordJava();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}


}
