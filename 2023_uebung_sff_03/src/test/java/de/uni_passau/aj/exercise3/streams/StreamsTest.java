package de.uni_passau.aj.exercise3.streams;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class StreamsTest {
    @Test
    void testCalculateTotalNumberOfLettersOfNamesLongerThanFive() {
        log.info("Testing if [william, jones, aaron, seppe, frank, gilliam] returns 14");
        Assertions.assertEquals(14, Streams.calculateTotalNumberOfLettersOfNamesLongerThanFive("william", "jones", "aaron", "seppe", "frank", "gilliam"));
        log.info("Testing if [aaron] returns 0");
        assertEquals(0, Streams.calculateTotalNumberOfLettersOfNamesLongerThanFive("aaron"));
    }

    @Test
    public void testTransformToOneList() {
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third");
        assertThat(Streams.transform(collection)).hasSameElementsAs(expected);
    }

    @Test
    public void testFindOldestPerson() {
        Person sara = new Person("Sara", 4, "German");
        Person viktor = new Person("Viktor", 40, "German");
        Person eva = new Person("Eva", 42, "German");
        List<Person> collection = asList(sara, eva, viktor);
        assertThat(Streams.findOldestPerson(collection)).usingRecursiveComparison().isEqualTo(eva);
    }

    @Test
    public void testGetNamesOfKids() {
        Person sara = new Person("Sara", 4, "German");
        Person viktor = new Person("Viktor", 40, "German");
        Person eva = new Person("Eva", 42, "German");
        Person anna = new Person("Anna", 5, "German");
        List<Person> collection = asList(sara, eva, viktor, anna);
        assertThat(Streams.getNamesOfKids(collection))
            .contains("Sara", "Anna")
            .doesNotContain("Viktor", "Eva");
    }

    @Test
    public void testPartitionAdultPeople() {
        Person sara = new Person("Sara", 4, "German");
        Person viktor = new Person("Viktor", 40, "German");
        Person eva = new Person("Eva", 42, "German");
        List<Person> collection = asList(sara, eva, viktor);
        Map<Boolean, List<Person>> result = Streams.partitionAdultPeople(collection);
        assertThat(result.get(true)).hasSameElementsAs(asList(viktor, eva));
        assertThat(result.get(false)).hasSameElementsAs(singletonList(sara));
    }

    @Test
    public void testPartitionByNationality() {
        Person sara = new Person("Sara", 4, "Norwegian");
        Person viktor = new Person("Viktor", 40, "Serbian");
        Person eva = new Person("Eva", 42, "Norwegian");
        List<Person> collection = asList(sara, eva, viktor);
        Map<String, List<Person>> result = Streams.partitionByNationality(collection);
        assertThat(result.get("Norwegian")).hasSameElementsAs(asList(sara, eva));
        assertThat(result.get("Serbian")).hasSameElementsAs(singletonList(viktor));
    }

    @Test
    void testCommaSeparatedList() {
        assertThat(Streams.commaSeparatedList(asList(7, 66))).isEqualTo("u7,g66");
        assertThat(Streams.commaSeparatedList(singletonList(3))).isEqualTo("u3");
    }

    @Test
    void testCalculateAverage() {
        assertEquals(28.75d, Streams.calculateAverage(List.of(new Employee(10d), new Employee(70d), new Employee(20d), new Employee(15d))));
        assertEquals(0d, Streams.calculateAverage(List.of(new Employee(0d))));
        assertEquals(0d, Streams.calculateAverage(Collections.emptyList()));
    }

    @Test
    public void sumUp() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        assertThat(Streams.sumUp(numbers)).isEqualTo(1 + 2 + 3 + 4 + 5);
    }

    @Test
    public void multiplyUp() {
        List<Integer> numbers = asList(2, 3, 4, 5, 6);
        assertThat(Streams.multiplyUp(numbers)).isEqualTo(2 * 3 * 4 * 5 * 6);
    }
}
