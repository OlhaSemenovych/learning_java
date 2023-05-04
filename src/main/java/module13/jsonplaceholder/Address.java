package module13.jsonplaceholder;

public class Address {

    private final String street;
    private final String suite;
    private final String city;
    private final String zipcode;
    private final Geo geo;


    public Address(String street, String suite, String city,
                   String zipcode, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipcode=" + zipcode +
                ", geo=" + geo +
                '}';
    }
}
