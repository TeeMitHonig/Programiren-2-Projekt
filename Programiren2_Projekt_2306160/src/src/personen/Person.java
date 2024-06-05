package src.personen;

public class Person {
    private String name;
    private String nachname;
    private int id;
    boolean istregisur;


    public Person(String name, String nachname, int id, boolean istregisur) {
        this.name = name;
        this.nachname = nachname;
        this.id = id;
        this.istregisur = istregisur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIstregisur() {
        return istregisur;
    }
}
