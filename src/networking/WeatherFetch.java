package networking;
/*
*24小时天气预报
url：http://tj.nineton.cn/Heart/index/future24h/
拼接参数：
  city：城市
  language：语言
  key：秘钥，固定值 78928e706123c1a8f1766f062bc8676b。可不填。也可省略该参数

作者：DROP_DATABASE
链接：https://www.jianshu.com/p/e3e04cf3fc0f
來源：简书
Exp: http://tj.nineton.cn/Heart/index/future24h/?city=CHSH000000
需要城市ID，但暂无城市ID接口。。。
*
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WeatherFetch {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        System.out.println("请输入要查询的城市编号");

        BufferedReader br = new BufferedReader(isr);
        String cityID = br.readLine();
        br.close();

        URL url = new URL("http://tj.nineton.cn/Heart/index/future24h/?city="+cityID);
        URLConnection hul = url.openConnection();
        InputStream is = hul.getInputStream();


    }
}
