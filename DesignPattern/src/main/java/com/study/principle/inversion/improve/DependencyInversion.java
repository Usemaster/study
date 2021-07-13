package com.study.principle.inversion.improve;

public class DependencyInversion {

    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new WeiXin());
    }

}

interface IReceiver {
    public String getInfo();
}

class Email implements IReceiver{
    public String getInfo(){
        return "电子邮件信息：hello,world";
    }
}

class WeiXin implements IReceiver {
    @Override
    public String getInfo() {
        return "微信信息：hello,world";
    }
}

//完成Person接收消息的功能
//方式2完成
class Person {
    //这里我们是对接口的依赖
    public void receive(IReceiver receiver){
        System.out.println(receiver.getInfo());
    }

}
