package hashcodeequals;

/**
 * Created by Squall on 23/05/2015.
 */
public class PersonaImpl implements Persona, Comparable<Persona> {
    private String name;
    private String arcana;

    public PersonaImpl(String name, String arcana) {
        this.name = name;
        this.arcana = arcana;
    }

    public String getName() {
        return name;
    }

    public String getArcana() {
        return arcana;
    }

    public int compareTo(Persona pers) {
        if (this.name.charAt(0) < pers.getName().charAt(0)) return -1;
        else if (this.name.charAt(0) > pers.getName().charAt(0)) return 1;
        else return 0;
    }

        @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PersonaImpl)) {
            return false;
        }
        else {
            Persona pers = (Persona) obj;
            return (this.name.equals(pers.getName()) && this.arcana.equals(pers.getArcana()));
        }
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 1;
        if (name != null) {
            result = result + name.hashCode();
        }
        if (arcana != null) {
            result = result + arcana.hashCode();
        }
        result = result * prime;
        result = result * prime;
        return result;
    }

    public String toString() {
        return "Name: " + name + ", Arcana: " + arcana;
    }
}
