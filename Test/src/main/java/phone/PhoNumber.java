package phone;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PhoNumber extends JFrame implements ActionListener{

    JPanel panel;
    JLabel label,label2;
    JButton loginButton,exitButton;
    JTextField jTextField;
    JPasswordField passwordField;

    public PhoNumber() {
        this.setTitle("用户登录界面");
        this.setSize(250,220);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());//设置为流式布局
        label = new JLabel("电话号码");
        label2 = new JLabel("密码");
        loginButton = new JButton("登录");
        loginButton.addActionListener(this);//监听事件
        exitButton = new JButton("退出");
        exitButton.addActionListener(this);//监听事件
        jTextField = new JTextField(16);//设置文本框的长度
        passwordField = new JPasswordField(16);//设置密码框

        panel.add(label);//把组件添加到面板panel
        panel.add(jTextField);
//        panel.add(label2);
//        panel.add(passwordField);
        panel.add(loginButton);
//        panel.add(exitButton);

        this.add(panel);//实现面板panel

        this.setVisible(true);//设置可见
    }

    @SuppressWarnings("deprecation")

    public void actionPerformed(ActionEvent e) {//处理事件
        // TODO Auto-generated method stub

        if (e.getSource()==loginButton) {
            String s = jTextField.getText();
            Boolean b = s.matches("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
            if (b) {//如果文本框包含abc并且密码框包含123则登录成功，否则登录失败
                JOptionPane.showMessageDialog(null,"电话号码有效！" );
            }else {
                JOptionPane.showMessageDialog(null, "电话号码无效！");
            }
//            if (e.getSource()==exitButton) {
//                System.exit(0);
//            }
        }
    }




}