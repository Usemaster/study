package proxy.dynamic;

public class Client {

    public static void main(String[] args) {
        Rent host = new Host();
        Rent proxyHandler = (Rent) new ProxyHandler(host).getProxy();

        proxyHandler.rent();
    }

}
