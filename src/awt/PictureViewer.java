package awt;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


class ImageViewerFrame extends JFrame {
    private JLabel label;
    private JFileChooser chooser;
    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 700;

    public ImageViewerFrame() {
        super();
        setTitle("图片浏览-lihm");
        setSize(this.DEFAULT_WIDTH,this.DEFAULT_HEIGHT);

        label = new JLabel();
        add(label);

        this.chooser = new JFileChooser();//java提供的文件选择器
        chooser.setCurrentDirectory(new File("."));//设置当前浏览路径

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("文件");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("打开图片");
        menu.add(openItem);

        openItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int result = chooser.showOpenDialog(null);//弹出文件选择对话框
                if(result==JFileChooser.APPROVE_OPTION){
                    String name = chooser.getSelectedFile().getPath();
                    label.setIcon(new ImageIcon(name));

                }

            }


        });

        JMenuItem exitItem = new JMenuItem("退出");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }

        });
    }


}

public class PictureViewer {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //EventQueue 是一个与平台无关的类，它将来自于基础同位体类和受信任的应用程序类的事件列入队列
        //invokeLater导致 runnable 的 run 方法在 EventQueue 的指派线程上被调用
        EventQueue.invokeLater(new Runnable(){//此处使用Runnable的一个匿名对象
            @Override
            public void run() {
                // TODO Auto-generated method stub
                JFrame frame = new ImageViewerFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

            }

        });

    }


}
