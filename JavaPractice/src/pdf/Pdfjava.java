package pdf;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class Pdfjava {

    public static void main(String args[]) {
        // 出力ファイルパス・・・・・➀
        String outPutFilePath = null;
        // 出力ファイル名・・・・・➁
        String outPutFileName = null;
        //➀+➁
        String outFileName = null;
        try {

            // ドキュメントオブジェクトの作成
            PDDocument document = new PDDocument();

            // ページオブジェクトの作成
            PDPage page = new PDPage();
            document.addPage(page);

            // 現在の日付を取得
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddssss");

            //パスの取得
            String path = new File(".").getAbsoluteFile().getParent();

            //ファイルパス・ファイル名の指定
            outPutFilePath = path + "\\pdf\\";
            //System.out.print(outPutFilePath);
            outPutFileName = dateFormat.format(date).toString() +  ".pdf";
            outFileName = outPutFilePath + outPutFileName;

            // ドキュメントを保存します
            document.save(outFileName);
            document.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}