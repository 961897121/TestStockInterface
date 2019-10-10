package service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import service.inter.ParseInterface;

import java.util.ArrayList;
import java.util.List;

public class ParseService implements ParseInterface {

    List<JSONObject> list = new ArrayList<>();
    JSONObject jsonObject = new JSONObject();
    @Override
    public String getParseList(String json) {
        //解析json -->org.json.jar包
        try {
            JSONObject first = new JSONObject(json);

            String result = first.getString("result");
//            System.out.println("第一次解析:" + first.toString());

            JSONObject second = new JSONObject(result);
            String data = second.getString("data");
//            System.out.println("第二次解析:" + second);

            System.out.println(data);
            JSONArray third = new JSONArray(data);
//            System.out.println("第三次解析:" + third);

            for (int i = 0 ; i < third.length() ; i++){
//                System.out.println(third.get(i));
                JSONObject root = new JSONObject(third.get(i).toString());
//                System.out.println("第四次解析：" + root);

                String symbol = root.getString("symbol");
                String changepercent = root.getString("changepercent");
                String amount = root.getString("amount");
                String code = root.getString("code");
                String buy = root.getString("buy");
                String sell = root.getString("sell");
                String ticktime = root.getString("ticktime");
                String pricechange = root.getString("pricechange");
                String settlement = root.getString("settlement");
                String volume = root.getString("volume");
                String high = root.getString("high");
                String trade = root.getString("trade");
                String low = root.getString("low");
                String name = root.getString("name");
                String open = root.getString("open");


                JSONObject object = new JSONObject();
                object.put("symbol",symbol);
                object.put("changepercent",changepercent);
                object.put("amount",amount);
                object.put("code",code);
                object.put("buy",buy);
                object.put("sell",sell);
                object.put("ticktime",ticktime);
                object.put("pricechange",pricechange);
                object.put("settlement",settlement);
                object.put("volume",volume);
                object.put("high",high);
                object.put("trade",trade);
                object.put("low",low);
                object.put("name",name);
                object.put("open",open);

                list.add(object);
            }


            jsonObject.put("data",list);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject.toString();
    }
}
