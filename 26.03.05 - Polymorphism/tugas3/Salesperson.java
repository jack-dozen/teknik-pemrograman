// *******************************************************
// Salesperson.java
//
// Represents a sales person who has a first name, last
// name, and total number of sales.
// *******************************************************
public class Salesperson implements Comparable<Salesperson>{
    private final String firstName, lastName;
    private final int totalSales;

    //------------------------------------------------------
    // Constructor: Sets up the sales person object with
    // the given data.
    //------------------------------------------------------
    public Salesperson (String first, String last, int sales){
        firstName = first;
        lastName = last;
        totalSales = sales;
    }

    //-------------------------------------------
    // Returns the sales person as a string.
    //-------------------------------------------
    @Override
    public String toString(){
        return lastName + ", " + firstName + ": \t" + totalSales;
    }

    //-------------------------------------------
    // Returns true if the sales people have
    // the same name.
    //-------------------------------------------
    @Override
    public boolean equals (Object other){
        if (!(other instanceof Salesperson)) {
            return false;
        }
        return (lastName.equals(((Salesperson)other).getLastName()) &&
        firstName.equals(((Salesperson)other).getFirstName()));
    }

    //-------------------------------------------
    // Returns hash code based on name.
    //-------------------------------------------
    @Override
    public int hashCode(){
        return (firstName + lastName).hashCode();
    }

    //--------------------------------------------------
    // Order is based on total sales with the name
    // (last, then first) breaking a tie.
    //--------------------------------------------------
    @Override
    public int compareTo(Salesperson other) {
        Salesperson otherPerson = other;

        if (this.totalSales < otherPerson.getSales()) {
            return -1;
        }else if (this.totalSales > otherPerson.getSales()) {
            return 1;
        }else{
            int result = this.lastName.compareTo(otherPerson.getLastName());
            if (result == 0) 
                result = this.firstName.compareTo(otherPerson.getFirstName());

            return result;
        }
    }

    //-------------------------
    // First name accessor.
    //-------------------------
    public String getFirstName(){
        return firstName;
    }

    //-------------------------
    // Last name accessor.
    //-------------------------
    public String getLastName(){
        return lastName;
    }

    //-------------------------
    // Total sales accessor.
    //-------------------------
    public int getSales(){
        return totalSales;
    }
}
