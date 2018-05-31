package cn.hhm.worktest;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Ming
 * @create 2018-05-24 11:34
 */
public class Test {

    public static void main(String[] s){

        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() -> {
                try {
                    URL url = new URL("http://localhost:8080/test2");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(10000);
                    conn.connect();
                    System.out.println(conn.getResponseCode());
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            });
            thread.setName("thread_name【"+i+"】");
            thread.start();
        }
    }

}
