package networking;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class PortScanner {

        private String address;
        private int upper;
        private int down;
        private int[] p;
        Socket ss = null;

        public PortScanner(String a,int u, int d) {
            this.address = a;
            this.upper = u;
            this.down = d;
        }

        public static void main(String[] args) {

            System.out.println("请输入要扫描的地址");
            Scanner sc = new Scanner(System.in);
            /*
             *此处需要检验ip地址正确性
             */
            String ipadd = sc.nextLine();

            System.out.println("请输入要扫描端口的上下界");
            /*
            此处需要检验端口上下界是否是对的顺序

             */
            int u = Integer.parseInt(sc.nextLine());
            int d = Integer.parseInt(sc.nextLine());

            //System.out.println("");


            PortScanner portScanner = new PortScanner(ipadd,u,d);
            portScanner.scan();


        }

        public void scan() {

            for(int i = down; i < upper; i++){
                try {
//                System.out.println(i);
                    ss = new Socket(address,i);
                    System.err.println("扫描到端口： " + i);

                } catch (IOException e) {
                    System.err.println("端口： " + i + "未打开");
                }
            }
        }




}
