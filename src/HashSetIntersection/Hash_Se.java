package HashSetIntersection;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Hash_Se {
    public static void main(String[] args){
        Set s1 = new HashSet();
        s1.add("Bill");
        s1.add("Larry");
        s1.add("Adolph");
        s1.add("Regina");
        s1.add("Susie");
        Set s1copy = new HashSet();
        s1copy.addAll(s1);
        Set s2 = new HashSet();
        s2.add("Larry");
        s2.add("Jack");
        s2.add("Alice");
        s2.add("June");
        s2.add("Benny");
        s2.add("Susie");
        //Intersection
        s1.retainAll(s2);
        Iterator i1 = s1.iterator();
        System.out.println("intersection results");
        while(i1.hasNext()){
            System.out.println(i1.next());
        }
        //Union
        s1copy.removeAll(s1);
        Iterator i1copy = s1copy.iterator();
        Iterator i2 = s2.iterator();
        System.out.println("Union Results");
        while(i1copy.hasNext()){
            System.out.println(i1copy.next());
        }
        while(i2.hasNext()){
            System.out.println(i2.next());
        }
    }
}
