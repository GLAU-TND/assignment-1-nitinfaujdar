package contactADT;

public interface ContactADT<Person> {
    boolean add(Person data);
    void view();
    Person delete();
}
