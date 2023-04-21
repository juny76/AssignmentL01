import java.time.LocalDate;

public class Person {
    public static int IdCounter=0;

    private int Id;
    private String name;
    private LocalDate DoB;
    private String address;
    private double height;
    private double weight;

    public Person() {}
    public Person(String name, LocalDate DoB, String address, double height, double weight) {
        this.Id = IdCounter++;
        this.name = name;
        this.DoB = DoB;
        this.address = address;
        this.height = height;
        this.weight = weight;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDoB() {
        return DoB;
    }

    public void setDoB(LocalDate DoB) {
        this.DoB = DoB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString(){
        return "Id : " + this.Id +"\n"
                + "Name : " + this.name +"\n"
                + "Date of Birthday : " + this.DoB + "\n"
                + "Address : " + this.address + "\n"
                + "Height : " + this.height + "\n"
                + "Weight : " + this.weight + "\n"
                ;
    }


}
