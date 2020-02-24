package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;

/**
 *
 * @author tool-taro.com
 */
public class wordjava {

    public static void wordJava() throws FileNotFoundException, IOException {

        XWPFDocument document = null;
        XWPFTable table;
        XWPFParagraph paragraph;
        XWPFRun run;
        FileOutputStream fout = null;
        //ファイルパス・ファイル名の指定
        String outPutFilePath = null;
        String outPutFileName = null;
        String outFileName = null;

        try {
            document = new XWPFDocument();

            //普通の段落を2つ作る
            for (int i = 0; i < 2; i++) {
                paragraph = document.createParagraph();

                //それぞれの段落の中に色の異なるテキストを2種配置する
                //setText内で\nを指定しても改行されないので注意、改行するには必ず段落を作る
                run = paragraph.createRun();
                run.setFontFamily("ＭＳ ゴシック");
                run.setText("黒のテキスト");

                run = paragraph.createRun();
                run.setFontFamily("ＭＳ ゴシック");
                run.setColor("ff0000");
                run.setText("赤のテキスト");
            }
            //2x2の表を作る
            table = document.createTable(2, 2);
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    //それぞれのセルの中に段落を2つ作る
                    for (int k = 0; k < 2; k++) {
                        //セルには初期状態で1つの段落がある(実装が変わるかもしれないので念のため存在数を確認して適切に処理)
                        if (table.getRow(i).getCell(j).getParagraphs().size() > k) {
                            paragraph = table.getRow(i).getCell(j).getParagraphs().get(k);
                        }
                        else {
                            paragraph = table.getRow(i).getCell(j).addParagraph();
                        }

                        //それぞれの段落の中に色の異なるテキストを2種配置する
                        run = paragraph.createRun();
                        run.setFontFamily("ＭＳ ゴシック");
                        run.setText("黒のテキスト");

                        run = paragraph.createRun();
                        run.setFontFamily("ＭＳ ゴシック");
                        run.setColor("ff0000");
                        run.setText("赤のテキスト");
                    }
                }
            }
            //パスの取得
            String path = new File(".").getAbsoluteFile().getParent();

            // 現在の日付を取得
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddssss");

            //ファイルパス・ファイル名の指定
            outPutFilePath = path + "\\File\\word\\";
            //System.out.print(outPutFilePath);
            outPutFileName = dateFormat.format(date).toString() +  ".doc";
            outFileName = outPutFilePath + outPutFileName;
            System.out.println(outFileName);
            //ファイル出力
            fout = new FileOutputStream(outFileName);
            document.write(fout);
        }
        finally {
            if (fout != null) {
                try {
                    fout.close();
                }
                catch (IOException e) {
                }
            }
            if (document != null) {
                try {
                    document.close();
                }
                catch (IOException e) {
                }
            }
        }
    }
}