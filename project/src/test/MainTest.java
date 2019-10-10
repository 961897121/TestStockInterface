package test;

import http.HttpUtils;
import service.ParseService;

import java.io.IOException;

public class MainTest {
    private static final String path = "http://web.juhe.cn:8080/finance/stock/szall";
    private static final String param = "?key=704283239dd829ffd38f1cc4538465d0&page=5&type=2";

    public static void main(String[] args){

        try {
            HttpUtils utils = new HttpUtils();
            String json = utils.httpGet(path , param);

            ParseService service = new ParseService();
            String data = service.getParseList(json);

            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
