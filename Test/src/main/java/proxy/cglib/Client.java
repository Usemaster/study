package proxy.cglib;

public class Client {

    public static void main(String[] args) {
        Host target = new Host();
        Host proxy =(Host)new ProxyFactory(target).getProxy();

        String rent = proxy.rent();
        System.out.println(rent);
    }

}
