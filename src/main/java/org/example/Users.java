package org.example;

import java.util.*;

public class Users {
    private List<Person> users = new ArrayList<>();

    public void addUser(Person user) {
        users.add(user);
    }

    public void sortUsersByAge() {
        Collections.sort(users, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
    }

    public void sortUsersByAgeAndGender() {
        Collections.sort(users, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getAge() < o2.getAge()) {
                    return -1;
                } else if (o1.getAge() > o2.getAge()) {
                    return 1;
                } else {
                    if (o1.getGender() < o2.getGender()) {
                        return -1;
                    } else if (o1.getGender() > o2.getGender()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        });
    }

    public void printUsers() {
        for (Person user : users) {
            System.out.println(user.toString());
        }
    }

    public static void main(String[] args) {
        Users users = new Users();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите информацию о пользователях в формате Фамилия Имя Отчество, Возраст, Пол: Для остановки введите (stop)" );
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("stop")) {
                break;
            }
            String[] parts = input.split(", ");
            String name = parts[0];
            int age = Integer.parseInt(parts[1]);
            char gender = parts[2].charAt(0);

            String[] nameParts = name.split(" ");
            String surname = nameParts[0];
            String firstName = nameParts[1];
            String patronymic = nameParts[2];

            users.addUser(new Person(surname, firstName, patronymic, age, gender));
        }

        System.out.println("Список пользователей:");
        users.printUsers();

        System.out.println("\nСписок пользователей, отсортированных по возрасту:");
        users.sortUsersByAge();
        users.printUsers();

        System.out.println("\nСписок пользователей, отсортированных по возрасту и полу:");
        users.sortUsersByAgeAndGender();
        users.printUsers();
    }
}
