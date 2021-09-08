package proxy.staticproxy;

public class Client {


    public static void main(String[] args) {
        Rent rent = new Host();

        HouseProxy houseProxy = new HouseProxy(rent);

        houseProxy.rent();

    }


}
