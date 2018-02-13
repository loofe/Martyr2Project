package networking;
/*
*24小时天气预报

 */

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class WeatherFetch {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        System.out.println("请输入要查询的城市");

        BufferedReader br = new BufferedReader(isr);
        String city = br.readLine();
        br.close();
        //CHSH000000
        URL url = new URL("https://free-api.heweather.com/v5/now?city= "+city +
                "&key=c3a5e12dc05648e4bfac00c0c3ce9a86");
        URLConnection hul = url.openConnection();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(hul.getInputStream()));
        String urlString = "";
        String current;

        while((current = in.readLine()) != null)
        {
            urlString += current;
        }

        System.out.println(urlString);
        //JSONObject json = JSONObject.fromObject(urlString);

        //涉及到json的多层解析，需要另外学习


     /*   Map<String, Object> map = new HashMap<String, Object>();
        // 最外层解析
        JSONObject object = JSONObject.fromObject(urlString);
        for (Object k : object.) {
            Object v = object.get(k);
            map.put(k.toString(), v);
        }

        //String text = JSONObject.fromObject(json.get("hourly")).get("text").toString();
        //String country = JSONObject.fromObject(json.get("data")).get("country").toString();

        System.out.println(" temperature : " +  " text: " + text);
    */
    }
}
