package pl.coderstrust.newinjava;

import pl.coderstrust.multithreading.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntroducedInJava8 {

    public IntroducedInJava8() {
        String interfaceStaticMethodResult = IntroducedInJava8.interfaceStaticMethod();
        IntroducedInJava8 introducedInJava8 = new IntroducedInJava8();
        String result = introducedInJava8.interfaceDefaultMethod();
    }

    public static String interfaceStaticMethod() {
        //if this was an Interface man can call this method only through and inside interface
        //this method cant be overridden by implementing class
        return "this is some interface Static Method result";
    }

    public static String interfaceDefaultMethod() {
        //default methods are accessible through the instance of the implementing class and can be overridden
        //so if it was a default method of some interface implemented by eg. IntroducedInJava8 class man
        //would have to create new instance of Tomato class
        return "this is some interface Default Method result";
    }

    public static void functionalInterfacesAndLambdaExpressions() {
        //Functional interface is interface with exactly one abstract method
        //man can use lambda expression to easily implement such method
        Runnable r1 = () -> System.out.println("My Runnable");
    }

    public static void referencesToMethods() {
        //Reference to:
        //- static method
        boolean isReal = list.stream().anyMatch(User::isRealUser);
        //- an instance method of a particular object
        User user = new User();
        boolean isLegalName = list.stream().anyMatch(user::isLegalName);
        //- an instance method of an arbitrary object of a particular type
        long count = list.stream().filter(String::isEmpty).count();
        //- a constructor
        Stream<User> stream = list.stream().map(User::new);
    }

    public static void streams() {
        //The Stream interface represents a sequence of objects, supports a different type of iteration
        // where man can simply define the set of items to be processed,
        // the operation(s) to be performed on each item, and where the output of those operations is to be stored
        List<String> items = new ArrayList<>();
        String prefix = "prefix";
        List<String> filteredList = items.stream().filter(e -> (!e.startsWith(prefix))).collect(Collectors.toList());
    }
}
