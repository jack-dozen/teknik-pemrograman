// =======================
// === No. 1 Try First ===
// =======================
public class GenericsTypeOld {
    private Object t; // membuat object yang dapat menampung tipe data apa saja

    public Object get(){
        return t; // return type object
    }

    public void set(Object t) { // memiliki parameter input bertipe object sehingga bisa menerima tipe data apa saja
        this.t = t;
    }

    public static void main(String args[]) {
        GenericsTypeOld type = new GenericsTypeOld();
        type.set("Java"); // otomatis melakukan upcasting
        String str = (String) type.get(); // type casting, error prone and can cause ClassCastException
        // type casting dilakukan karena nilai return dari get adalah object
        System.out.println(type.get());
        System.out.println(str);

        // eksperimen
        type.set(67);
        Integer sixseven = (Integer) type.get();
        System.out.println(type.get());
        System.out.println(sixseven);
    }
}
