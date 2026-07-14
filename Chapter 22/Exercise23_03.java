/*
Author: Dimercia`
Date: 07//14/2026

Description: The program implements the Quick Sort algorithm using Java generics
It provides two versions of the quickSort method: one that sorts
objects implementing the Comparable interface and another that sorts
objects using a Comparator, the program demonstrates the methods by
sorting an array of Integer objects and an array of Circle objects
*/
import java.util.Comparator;



public class Exercise23_03 {
  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    quickSort(list);
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }

    System.out.println();
    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                     new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                     new Circle(3), new Circle(14), new Circle(12)};
    quickSort(list1, new GeometricObjectComparator());
    for (int i = 0; i < list1.length; i++) {
      System.out.println(list1[i] + " ");
    }
  }

  
public static <E extends Comparable<E>> void quickSort(E[] list) {
    quickSort(list, 0, list.length - 1);
}

private static <E extends Comparable<E>> void quickSort(E[] list,
        int first, int last) {

    if (first < last) {
        int pivotIndex = partition(list, first, last);
        quickSort(list, first, pivotIndex - 1);
        quickSort(list, pivotIndex + 1, last);
    }
}

private static <E extends Comparable<E>> int partition(E[] list,
        int first, int last) {

    E pivot = list[first];
    int low = first + 1;
    int high = last;

    while (high > low) {

        while (low <= high && list[low].compareTo(pivot) <= 0)
            low++;

        while (low <= high && list[high].compareTo(pivot) > 0)
            high--;

        if (high > low) {
            E temp = list[low];
            list[low] = list[high];
            list[high] = temp;
        }
    }

    while (high > first && list[high].compareTo(pivot) >= 0)
        high--;

    if (pivot.compareTo(list[high]) > 0) {
        list[first] = list[high];
        list[high] = pivot;
        return high;
    }

    return first;
}

// Quick sort using Comparator
public static <E> void quickSort(E[] list,
        Comparator<? super E> comparator) {
    quickSort(list, 0, list.length - 1, comparator);
}

private static <E> void quickSort(E[] list,
        int first, int last,
        Comparator<? super E> comparator) {

    if (first < last) {
        int pivotIndex = partition(list, first, last, comparator);
        quickSort(list, first, pivotIndex - 1, comparator);
        quickSort(list, pivotIndex + 1, last, comparator);
    }
}

private static <E> int partition(E[] list,
        int first, int last,
        Comparator<? super E> comparator) {

    E pivot = list[first];
    int low = first + 1;
    int high = last;

    while (high > low) {

        while (low <= high &&
                comparator.compare(list[low], pivot) <= 0)
            low++;

        while (low <= high &&
                comparator.compare(list[high], pivot) > 0)
            high--;

        if (high > low) {
            E temp = list[low];
            list[low] = list[high];
            list[high] = temp;
        }
    }

    while (high > first &&
            comparator.compare(list[high], pivot) >= 0)
        high--;

    if (comparator.compare(pivot, list[high]) > 0) {
        list[first] = list[high];
        list[high] = pivot;
        return high;
    }

    return first;
}
}