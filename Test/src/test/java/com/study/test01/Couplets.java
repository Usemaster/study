package com.study.test01;/**
 * @author gongwj
 * @Date 2022/2/2
 */

/**
 * @author gongwj
 * @Date 2022/2/2
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Couplets {
    //设置输出文件夹路径，请按您的实际需要进行修改
    final static String resultDirPath = "D:\\图片\\";
    //设置背景图片文件位置，请按您的实际存放路径进行修改
    final static String backgroundPath = "D:\\图片\\1.jpg";
    //设置字体。注意：大部分毛笔字体都涉及版权，如果商用需要取得授权。此代码为学习测试之用，非商用没有盈利，不涉及侵权。
    static String fontName = "方正字迹-吕建德字体";

    static BufferedImage background;
    static int basicSize;
    private String title;
    private String coupletA;
    private String coupletB;

    //主方法便捷测试
    public static void main(String[] args) throws IOException {
        Couplets couplets = new Couplets();
        //横批
        couplets.setTitle("吃遍天下");
        //上联
        couplets.setCoupletA("火锅特辣十倍爽");
        //下联
        couplets.setCoupletB("奶茶少冰五分甜");
        couplets.writeCouplets();
    }

    //书写对联
    public void writeCouplets() throws IOException {
        background = ImageIO.read(new File(backgroundPath));
        basicSize = background.getWidth();
        int coupletLength = coupletA.length();
        int gapSize = 30;
        // 算式前半部分的乘法不可以更改顺序，因为int的除法会抹除小数位，累计后的误差较大。
        int imageHeight = basicSize * 3 / 2 * coupletLength + basicSize + gapSize * 2;
        BufferedImage image = new BufferedImage(basicSize * 4, imageHeight, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.createGraphics();
        //修改背景颜色为红色
        g.setColor(Color.RED);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        g.drawImage(writeCouplet(title, true), 0, 0, basicSize * title.length(), basicSize, null);
        g.drawImage(writeCouplet(coupletA, false), basicSize / 4, basicSize + gapSize, basicSize * 3 / 2, basicSize * 3 / 2 * coupletLength, null);
        g.drawImage(writeCouplet(coupletB, false), basicSize * 9 / 4, basicSize + gapSize, basicSize * 3 / 2, basicSize * 3 / 2 * coupletLength, null);
        try {
            ImageIO.write(image, "jpg", new File(resultDirPath + title + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //书写单句
    private BufferedImage writeCouplet(String text, boolean horizontal) {
        char[] ch = text.toCharArray();
        BufferedImage image;
        if (horizontal) {
            image = new BufferedImage(basicSize * ch.length, basicSize, BufferedImage.TYPE_INT_RGB);
        } else {
            image = new BufferedImage(basicSize * 3 / 2, basicSize * 3 / 2 * ch.length, BufferedImage.TYPE_INT_RGB);
        }
        Graphics graphics = image.createGraphics();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (horizontal) {
                graphics.drawImage(writeWord(String.valueOf(c), true), basicSize * i, 0, basicSize, basicSize, null);
            } else {
                graphics.drawImage(writeWord(String.valueOf(c), false), 0, basicSize * 3 / 2 * i, basicSize * 3 / 2, basicSize * 3 / 2, null);
            }
        }
        graphics.dispose();
        return image;
    }

    //书写单字
    private BufferedImage writeWord(String content, boolean plus) {
        BufferedImage bufImg = new BufferedImage(background.getWidth(), background.getHeight(), background.getType());
        bufImg.setData(background.getData());
        Font font = new Font(fontName, Font.PLAIN, plus ? basicSize : basicSize * 4 / 5);
        Graphics2D graphics = bufImg.createGraphics();
        graphics.setColor(Color.black);
        graphics.setFont(font);
        graphics.drawString(content, plus ? 0 : basicSize / 10, plus ? basicSize * 6 / 7 : basicSize * 4 / 5);
        graphics.dispose();
        return bufImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoupletA() {
        return coupletA;
    }

    public void setCoupletA(String coupletA) {
        this.coupletA = coupletA;
    }

    public String getCoupletB() {
        return coupletB;
    }

    public void setCoupletB(String coupletB) {
        this.coupletB = coupletB;
    }
}

