package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LambdaExample {

    public static void main(final String[] args) {

        final UsersRepository repository = new UsersRepository();

        banner("Listing all users");
        // SOLVED all users
        repository.select(null, null);

        banner("Listing all active users");
        // SOLVED With functional interfaces declared
        Predicate<User> activeUserPredicate = new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.active;
            }
        };
        repository.select(activeUserPredicate, null);

        banner("Listing all active users - lambda");
        // SOLVED With functional interfaces used directly
        repository.select(user -> user.active, null);

        banner("Listing users with age > 5 sorted by name");
        Predicate<User> ageGreaterThan5Predicate = new Predicate<User>() {

            @Override
            public boolean test(User user) {
                return user.age > 5;
            }
        };

        Comparator<User> nameComparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        };

        repository.select(ageGreaterThan5Predicate, nameComparator);

        banner("___________age > 5 sorted by name___________");


        banner("Listing users with age > 5 sorted by name - lambda");

        Predicate<User> ageGreaterThan5PredicateLambda = user -> user.age > 5;
        Comparator<User> nameComparatorLambda = (o1, o2) -> o1.name.compareTo(o2.name);


        repository.select(user -> user.age > 5, (o1, o2) -> o1.name.compareTo(o2.name));
        banner("___________age > 5 sorted by name - lambda___________");


        banner("Listing users with age < 10 sorted by age");
        Predicate<User> ageGreaterThanPredicate = new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.age < 10;
            }
        };
        Comparator<User> ageGreaterThanCompartor = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.age, o2.age);
            }
        };
        repository.select(ageGreaterThanPredicate, ageGreaterThanCompartor);

        banner("___________age < 10 sorted by age___________");

        banner("Listing users with age < 10 sorted by age - lambda");
        // TODO With functional interfaces used directly
        repository.select(user -> user.age < 10, (o1, o2) -> {
            return Integer.compare(o1.age, o2.age);
        });
        banner("Listing active users sorted by name");
        // TODO With functional interfaces declared
        Predicate<User> usersSortedByNamePredicate = new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.active;
            }
        };


        Comparator<User> usersSortedByNameComprator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        };

        repository.select(ageGreaterThanPredicate, usersSortedByNameComprator);

        banner("Listing active users sorted by name - lambda");
        repository.select(user -> user.active, (o1, o2) -> o1.name.compareTo(o2.name));

        banner("Listing active users with age > 8 sorted by name");
        // SOLVED With functional interfaces declared
        Predicate<User> activeAndAgeGreaterThan8Predicate = new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.active && user.age > 8;
            }
        };
        Comparator<User> nameComparator3 = new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.name.compareTo(u2.name);
            }
        };
        repository.select(activeAndAgeGreaterThan8Predicate, nameComparator3);

        banner("Listing active users with age > 8 sorted by name - lambda");
        // SOLVED With functional interfaces used directly
        repository.select(user -> user.active && user.age > 8, (u1, u2) -> u1.name.compareTo(u2.name));

    }

    private static void banner(final String m) {
        System.out.println("#### " + m + " ####");
    }

}

class UsersRepository {
    List<User> users;

    UsersRepository() {
        users = Arrays.asList(
                new User("Seven", 7, true),
                new User("Four", 4, false),
                new User("Eleven", 11, true),
                new User("Three", 3, true),
                new User("Nine", 9, false),
                new User("One", 1, true),
                new User("Twelve", 12, true));
    }

    void select(final Predicate<User> filter, final Comparator<User> order) {
        Stream<User> usersStream = users.stream();

        if (filter != null) {
            usersStream = usersStream.filter(filter);
        }
        if (order != null) {
            usersStream = usersStream.sorted(order);
        }
        usersStream.forEach(System.out::println);
    }
}

class User {
    String name;
    int age;
    boolean active;

    User(final String name, final int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
    }

    @Override
    public String toString() {
        return name + "\t| " + age;
    }
}