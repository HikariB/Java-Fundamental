package com.hbLib.Collection;

import java.util.*;

public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Widgt",4562));
        parts.add(new Item("Modem",9912));
        System.out.println(parts);

        NavigableSet<Item> sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);

    }


    private static class Item implements Comparable<Item> {
        private String description;
        private int partNumber;

        public Item(String description, int partNumber) {
            this.description = description;
            this.partNumber = partNumber;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if(getClass()!=obj.getClass())
                return false;
            Item other = (Item) obj;
            return Objects.equals(description,other.description) && partNumber == other.partNumber;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public int hashCode() {
            return Objects.hash(description, partNumber);
        }

        @Override
        public String toString() {
            return "description = " + description + ", partNumber = " + partNumber;
        }

        @Override
        public int compareTo(Item item) {
            int diff = Integer.compare(partNumber, item.partNumber);
            return diff != 0 ? diff : description.compareTo(item.description);
        }

//        @Override
//        public int compareTo(Object o) {
//            return 0;
//        }
    }

}