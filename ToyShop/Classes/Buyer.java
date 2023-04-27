package ToyShop.Classes;

public class Buyer {
    private int id;
    private String Name;
    private String checkNumber;

    private String phone;

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Buyer(int id, String Name, String checkNumber, String phone) {
        this.id = id;
        this.Name = Name;
        this.checkNumber = checkNumber;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", fullName=" + Name + ", checkNumber=" +
                checkNumber + ", phone=" + phone + "]";
    }

    public String toSavePrize() {
        return id + ";" + Name + ";" + checkNumber + ";" + phone;
    }
}
