package http;

import com.sun.jndi.toolkit.url.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * http工具类
 */
public class HttpUtils {
    /**
     * get方式请求
     * @param path（请求路径）
     * @param param（参数）
     * @return（字符串）
     */
    public String httpGet(String path , String param) throws IOException {
        //服务器返回内容
        String msg = "";
        //创建url
        URL url = new URL(path + param);
        //新建http连接
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        //设置请求方式
        con.setRequestMethod("GET");
        //设置参数
//        con.setRequestProperty("Content-Type","text/html;charset=UTF-8");
        //设置连接超时时间3s
        con.setConnectTimeout(6000);
        //请求状态码
        int code = con.getResponseCode();

        if (code == 200){
            System.out.println("请求成功,状态码：" + code);

            BufferedReader br = null;

            br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String str = null;

            while ((str = br.readLine()) != null){
                msg = msg + str;

            }

            br.close();
        }else {
            System.out.println("请求失败,状态码：" + code);
        }

        return msg;
    }
}
