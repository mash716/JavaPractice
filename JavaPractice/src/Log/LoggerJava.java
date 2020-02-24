package Log;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerJava {
    public static void main(String[] args) {
        // Loggerクラスのインスタンスを生成
        Logger logger = Logger.getLogger(LoggerJava.class.getName());
        String path = new File(".").getAbsoluteFile().getParent();
        String PathLog = path + "\\Log\\" + "Sample.log";

        try {
            // Handlerを生成しloggerに登録
            FileHandler fHandler = new FileHandler(PathLog, true);
            fHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fHandler);

            // ログレベルの設定
            logger.setLevel(Level.INFO);

            // Loggerクラスのメソッドを使ってメッセージを出力
            logger.finest("FINEST");
            logger.finer("FINER");
            logger.fine("FINE");
            logger.config("CONFIG");
            logger.info("INFO");
            logger.warning("WARNING");
            logger.severe("SEVERE");

            // 例外をスロー
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            logger.log(Level.INFO, "例外のスローを捕捉", e);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}