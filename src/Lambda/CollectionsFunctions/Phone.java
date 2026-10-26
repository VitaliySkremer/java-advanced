package Lambda.CollectionsFunctions;

public class Phone {
    private String name;
    private int price;
    private String company;

    public Phone(String name, String company, int price) {
        this.name = name;
        this.price = price;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCompany() {
        return company;
    }

    public static void showPhone(Phone phone) {
        System.out.printf("%s (%s) - %d \n", phone.getName(), phone.getCompany(), phone.getPrice());
    }
}
