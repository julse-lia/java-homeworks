package algohomework;

import java.util.Comparator;

public class QuickSort implements PersonSort{

    @Override
    public Person[] sort(Person[] people, Comparator<Person> personComparator) {
        quickSort(people, personComparator, 0, people.length-1);
        return people;
    }

    private void quickSort(Person[] people, Comparator<Person> personComparator, int begin, int end) {
        if (begin<end) {
            int p = partition(begin, end, people, personComparator);
            quickSort(people, personComparator, begin, p-1);
            quickSort(people, personComparator, p+1, end);
        }
    }

    private static int partition(int begin, int end, Person[] people, Comparator<Person> personComparator) {
        Person pivot = people[end];

        int i = begin;
        for (int j = i; j<end; j++) {
            if (personComparator.compare(people[j], pivot) < 0) {
                swap(people, i, j);
                i++;
            }
        }
        swap(people, i, end);
        return i;
    }

    private static void swap(Person[] people, int i, int j) {
        Person temp = people[i];
        people[i] = people[j];
        people[j] = temp;
    }

}
