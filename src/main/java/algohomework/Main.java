package algohomework;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Person[] people = new Person[12];
        people[0] = new Person(180, 45, 23);
        people[1] = new Person(156, 50, 30);
        people[2] = new Person(170, 70, 54);
        people[3] = new Person(182, 70, 44);
        people[4] = new Person(156, 55, 30);
        people[5] = new Person(165, 55, 30);
        people[6] = new Person(165, 55, 48);
        people[7] = new Person(170, 70, 51);
        people[8] = new Person(185, 78, 67);
        people[9] = new Person(164, 60, 56);
        people[10] = new Person(185, 80, 67);
        people[11] = new Person(185, 80, 36);

        PersonSort personSort = new QuickSort();
        Comparator<Person> ageComparator = Comparator.comparingInt(Person::getAge);
        Comparator<Person> weightComparator = Comparator.comparingInt(Person::getWeight);
        Comparator<Person> heightComparator = Comparator.comparingInt(Person::getHeight);

        Comparator<Person> weightAndHeightComparator = (p1, p2) -> {
            if (p1.getWeight() - p2.getWeight() == 0){
                return p1.getHeight() - p2.getHeight();
            }
            else {
                return p1.getWeight() - p2.getWeight();
            }
        };

        // 1. Sort by age. Time complexity - O(nlog(n)) and cannot be improved to O(n).
        System.out.println("Sort by age");
        Person[] sortByAgeResult = sortPeople(people, personSort, ageComparator);
        for (Person person : sortByAgeResult) {
            System.out.println(person);
        }

        // 2. Sort by weight
        System.out.println("\nSort by weight");
        Person[] sortByWeightResult = sortPeople(people, personSort, weightComparator);
        for (Person person : sortByWeightResult) {
            System.out.println(person);
        }

        // 2. Sort by height
        System.out.println("\nSort by height");
        Person[] sortByHeightResult = sortPeople(people, personSort, heightComparator);
        for (Person person : sortByHeightResult) {
            System.out.println(person);
        }

        // 3. Find amount of people with the same weight but different height(without set usage).
        // Time complexity - O(n^2)
        int uniquePeopleCount = countWeightHeightUniquePeople(people, weightAndHeightComparator, weightComparator, heightComparator);
        System.out.println("\nAmount of people with the same weight but different height: " + uniquePeopleCount);
    }

    public static Person[] sortPeople(Person[] people, PersonSort personSort, Comparator<Person>personComparator) {
        return personSort.sort(people, personComparator);
    }

    public static int countWeightHeightUniquePeople(Person[] people,
                                                    Comparator<Person>weightAndHeightComparator,
                                                    Comparator<Person>weightComparator,
                                                    Comparator<Person>heightComparator) {

        Arrays.sort(people, weightAndHeightComparator);
        System.out.println("\nSorted by weight and height");
        for (Person person : people) {
            System.out.println(person);
        }

        System.out.println("\nUnique values");
        int count = 0;
        for(int i = 0; i < people.length; i++){
            //skip the index until there are duplicates ahead
            while (i < people.length - 1 &&
                    weightComparator.compare(people[i], people[i+1])==0 &&
                    heightComparator.compare(people[i], people[i+1])==0) {
                i++;
            }

            System.out.println(people[i]);
            count++;
        }
        return count;
    }
}
