package proxy.staticproxy;

public class HouseProxy implements Rent{

    Rent target;

    public HouseProxy(Rent target) {
        this.target = target;
    }

    public void rent() {
        System.out.println("help host rent house");
        target.rent();
        System.out.println("proxy has finished work");
    }
}
