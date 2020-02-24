package model;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;


/**
 * 九九の表をエクセルファイルに出力
 * @author s-tsuchida
 *
 */
public class Pdfjava {

    public static void pdfJava() {
        //ファイルパス・ファイル名の指定
        String outPutFilePath = null;
        //System.out.print(outPutFilePath);
        String outPutFileName = null;
        String outFileName = null;
        try {

            // ドキュメントオブジェクトの作成
            PDDocument document = new PDDocument();

            // ページオブジェクトの作成
            PDPage page = new PDPage();
            document.addPage(page);
            //パスの取得
            String path = new File(".").getAbsoluteFile().getParent();
            // 現在の日付を取得
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddssss");
            //ファイルパス・ファイル名の指定
            outPutFilePath = path + "\\File\\pdf\\";
            //System.out.print(outPutFilePath);
            outPutFileName = dateFormat.format(date).toString() +  ".pdf";
            outFileName = outPutFilePath + outPutFileName;
            System.out.println(outFileName);
            // ドキュメントを保存します
            document.save(outFileName);
            document.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}