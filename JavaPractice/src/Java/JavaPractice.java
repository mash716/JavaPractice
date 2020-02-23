package Java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class JavaPractice {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//System.out.print("AAAA");
	       try {
	            //Fileクラスに読み込むファイルを指定する
	            File file = new File("C:\\Users\\masho\\Desktop\\bk\\BK退避\\pleiades\\workspaces\\Java\\JavaPractice.txt");

	            //ファイルが存在するか確認する
	            if(file.exists()) {

	                //FileReaderクラスのオブジェクトを生成する
	                FileReader filereader = new FileReader(file);

	                //filereaderクラスのreadメソッドでファイルを1文字ずつ読み込む
	                int data;
	                while((data = filereader.read()) != -1) {
	                    System.out.print((char) data);
	                }

	                //ファイルクローズ
	                filereader.close();

	            } else {
	                System.out.print("ファイルは存在しません");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }


}


