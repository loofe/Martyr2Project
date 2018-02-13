package networking;


import net.sf.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetAddressByIP {


    public static void getaddressinfo (String address) {

        try {
            URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=" + address);
            URLConnection connection = url.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String urlString = "";
            String current;

            while((current = in.readLine()) != null)
            {
                urlString += current;
            }
            //System.out.println(urlString);

            JSONObject json = JSONObject.fromObject(urlString);

            String country = JSONObject.fromObject(json.get("data")).get("country").toString();
            String region = JSONObject.fromObject(json.get("data")).get("region").toString();
            String city = JSONObject.fromObject(json.get("data")).get("city").toString();
            String county = JSONObject.fromObject(json.get("data")).get("county").toString();
            String isp = JSONObject.fromObject(json.get("data")).get("isp").toString();
            String area = JSONObject.fromObject(json.get("data")).get("area").toString();
            System.out.println("国家： " + country);
            System.out.println("地区： " + area);
            System.out.println("省份: " + region);
            System.out.println("城市： " + city);
            System.out.println("区/县： " + county);
            System.out.println("互联网服务提供商： " + isp);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        getaddressinfo("218.192.3.42");

    }

}
