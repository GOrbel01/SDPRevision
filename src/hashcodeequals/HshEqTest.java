package hashcodeequals;

import java.util.*;

/**
 * Created by Squall on 23/05/2015.
 */
public class HshEqTest {
    public static void main(String[] args) {
        Persona p1 = new PersonaImpl("Jack Frost", "Magician");
        Persona p2 = new PersonaImpl("Pyro Jack", "Magician");
        Persona p3 = new PersonaImpl("Jack Frost", "Magician");
        Persona p4 = new PersonaImpl("Isis", "Empress");
        Integer i1 = 7;
        List list = new ArrayList<Persona>();
        list.add(p2);
        list.add(p3);
        list.add(p4);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
        System.out.println(p1.equals(p1));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());
        Set<Persona> personaSet = new HashSet<Persona>();
        personaSet.add(p1);
        personaSet.add(p2);
        personaSet.add(p4);
    }
}
