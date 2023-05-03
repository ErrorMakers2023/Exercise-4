package de.uni_passau.aj.exercise3.streams;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Streams {
    // Bestimmen Sie, ausgehend von einer Liste von Namen, die Gesamtzahl der Buchstaben in allen Namen mit mehr als 5 Buchstaben.
    public static int calculateTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
        // int total = 0;
        // for (String s : names) {
        //     if (s.length() > 5) {
        //         total += s.length();
        //     }
        // }
        // return total;
        return 0;
    }

    // Transformieren Sie eine Liste von Liste von Strings in eine Liste von Strings.
    public static List<String> transform(List<List<String>> collection) {
        // List<String> newCollection = new ArrayList<>();
        // for (List<String> subCollection : collection) {
        //     newCollection.addAll(subCollection);
        // }
        // return newCollection;
        return null;
    }

    // Finden Sie die älteste Person aus der Liste
    public static Person findOldestPerson(List<Person> people) {
        // Person oldestPerson = new Person("", 0);
        // for (Person person : people) {
        //     if (person.getAge() > oldestPerson.getAge()) {
        //         oldestPerson = person;
        //     }
        // }
        // return oldestPerson;
        return null;
    }

    // Lassen Sie sich die Namen aller Kinder unter 18 Jahren geben.
    public static Set<String> getNamesOfKids(List<Person> people) {
        // Set<String> kids = new HashSet<>();
        // for (Person person : people) {
        //     if (person.getAge() < 18) {
        //         kids.add(person.getName());
        //     }
        // }
        // return kids;
        return null;
    }

    // Unterteilen Sie diese Liste von Personen in Erwachsene und Kinder, dafür brauchen Sie einen speziellen Collector!!!
    // Sehen Sie sich die Javadoc zur Collectors Companion Klasse an: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/Collectors.html
    // Dort werden Sie fündig!
    public static Map<Boolean, List<Person>> partitionAdultPeople(List<Person> people) {
        // Map<Boolean, List<Person>> map = new HashMap<>();
        // map.put(true, new ArrayList<>());
        // map.put(false, new ArrayList<>());
        // for (Person person : people) {
        //     map.get(person.getAge() >= 18).add(person);
        // }
        // return map;
        return null;
    }

    // Gruppieren Sie diese Personen nach Nationalität, wie bei der vorherigen Übung
    public static Map<String, List<Person>> partitionByNationality(List<Person> people) {
        //Map<String, List<Person>> map = new HashMap<>();
        //for (Person person : people) {
        //    if (!map.containsKey(person.getNationality())) {
        //        map.put(person.getNationality(), new ArrayList<>());
        //    }
        //    map.get(person.getNationality()).add(person);
        //}
        //return map;
        return null;
    }

    // Schreiben Sie eine Methode, die eine kommagetrennte Zeichenkette auf der Grundlage einer
    // gegebenen Liste von Ganzzahlen zurückgibt. Jedem Element sollte der Buchstabe "g" vorangestellt werden,
    // wenn die Zahl gerade ist, und der Buchstabe "u", wenn die Zahl ungerade ist.
    // Wenn die Eingabeliste zum Beispiel (3,44) lautet, sollte die Ausgabe 'u3,g44' sein.
    public static String commaSeparatedList(List<Integer> ints) {
        return null;
    }

    // Schreiben Sie die Methode um auf Streams.
    // Tip: es gibt eine mapToDouble() Funktion, die auf einen Stream von primitiven double mapped.
    public static double calculateAverage(List<Employee> employeeList) {
        //int sum = 0;
        //int count = 0;
        //for (Employee employee : employeeList) {
        //    sum += employee.getSalary();
        //    count++;
        //}
        //return count > 0 ? (double) sum / count : 0d;
        return 0;
    }

    //
    // Summieren Sie alle Elemente einer Collection.
    // Nutzen Sie den reduce Operator mit Identity Parameter!
    public static int sumUp(List<Integer> numbers) {
        // int total = 0;
        // for (int number : numbers) {
        //     total += number;
        // }
        // return total;
        return 0;
    }

    //
    // Multiplizieren Sie alle Elemente einer Collection.
    // Nutzen Sie den reduce Operator mit Identity Parameter!
    public static int multiplyUp(List<Integer> numbers) {
        // int total = 1;
        // for (int number : numbers) {
        //     total *= number;
        // }
        // return total;
        return 0;
    }

}
