package networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Whois {

    private static final int DEFAULT_PORT = 43;

    public String query(String domain) throws Exception {
        String server = "";
        String tld = getTLD(domain);
        if ("com".equals(tld)) {
            server = "whois.verisign-grs.com";
        } else if ("net".equals(tld)) {
            server = "whois.verisign-grs.com";
        } else if ("org".equals(tld)) {
            server = "whois.pir.org";
        } else if ("cn".equals(tld)) {
            server = "whois.cnnic.cn";
        } else if ("jp".equals(tld)) {
            server = "whois.jprs.jp";
        } else if ("kr".equals(tld)) {
            server = "whois.kr";
        }
        return query(domain, server);
    }

    public String query(String domain, String server) throws Exception {
        Socket socket = new Socket(server, DEFAULT_PORT);
        String lineSeparator = "\r\n";

        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println(domain);
        out.flush();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        StringBuilder ret = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            ret.append(line + lineSeparator);
        }
        socket.close();
        return ret.toString();
    }

    private String getTLD(String domain) {
        final int index;
        return (domain == null || (index = domain.lastIndexOf('.') + 1) < 1) ? domain
                : (index < (domain.length())) ? domain.substring(index) : "";
    }

    public static void main(String[] args) throws Exception {
        Whois w = new Whois();
        System.out.println(w.query("baidu.com"));
        System.out.println(w.query("csdn.net"));
        System.out.println(w.query("apache.org"));
        System.out.println(w.query("360.cn"));          //china
        System.out.println(w.query("mixi.jp"));         //japan
        System.out.println(w.query("laneige.co.kr"));   //korea
    }

}

