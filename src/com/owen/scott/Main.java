package com.owen.scott;

import com.owen.scott.annotations.Completed;
import com.owen.scott.annotations.InProgress;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    private static final String SELECT_PROGRAM = "Please select a program to run from the following options.";
    private static final String IN_PROGRESS = "In Progress:";
    private static final String COMPLETED = "Completed:";
    private static final String EXIT = "Exit";
    private static final String PROGRAM_NAME_OR_EXIT = "Type a program name and hit the enter / return key, or type '" + EXIT + "' to exit.";
    private static final String INVALID_INPUT = "Invalid Input.";
    private static final String CURRENCY_NOTE = "Note: Any programs requesting currency related input are requesting the currency in USD and only require integers or decimals. Do not enter a $ or ¢ sign.";
    private static final String PROGRAM_COMPLETED = " completed.";

    private static final String PACKAGE_PREFIX = "com.owen.scott";

    private static final String CLASS_EXTENSION = ".class";

    private static final String PROGRAMS = "programs";
    private static final String CHAPTER = "chapter";

    private static final String FRIDAY_BUILDS = "friday.builds";
    private static final String BUILD = ".build";

    private static Map<String, Runnable> inProgressPrograms;
    private static Map<String, Runnable> completedPrograms;

    public static void main(String[] args) {
        populatePrograms();
        offerPrograms();
    }

    private static void populatePrograms() {
        inProgressPrograms = new HashMap<>();
        completedPrograms = new HashMap<>();

        Set<Class> potentialRunnables = new HashSet<>(classesFromRegistrar(getRegistrar()));

        potentialRunnables.forEach((Class potentialRunnable) -> {
            boolean isRunnable = false;
            for (Class anInterface : potentialRunnable.getInterfaces()) {
                if (anInterface == Runnable.class) {
                    isRunnable = true;
                }
            }
            if (isRunnable && potentialRunnable.isAnnotationPresent(InProgress.class)) {
                addPotentialRunnableToMap(inProgressPrograms, potentialRunnable);
            }
            if (isRunnable && potentialRunnable.isAnnotationPresent(Completed.class)) {
                addPotentialRunnableToMap(completedPrograms, potentialRunnable);
            }
        });
    }

    private static void addPotentialRunnableToMap(Map<String, Runnable> map, Class potentialRunnable) {
        map.put(potentialRunnable.getName(), () -> {
            try {
                potentialRunnable.getConstructor().setAccessible(true);
                ((Runnable) potentialRunnable.getConstructor().newInstance()).run();
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException ignored) {
                System.out.println("Execution failed.");
            }
        });
    }


    private static List<Class> getClasses(String packageName) {
        //ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        List<Class> classes = new LinkedList<>();
        if (classLoader != null) {
            Enumeration<URL> resources;
            try {
                resources = classLoader.getResources(packageName.replace('.', '/'));
            } catch (IOException e) {
                e.printStackTrace();
                return classes;
            }
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                classes.addAll(findClasses(new File(resource.getFile()), packageName));
            }
        }
        return classes;
    }

    private static List<Class> findClasses(File directory, String packageName) {
        List<Class> classes = new LinkedList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (!file.getName().contains(".")){
                        classes.addAll(findClasses(file, packageName + "." + file.getName()));
                    }
                } else if (file.getName().endsWith(CLASS_EXTENSION)) {
                    try {
                        classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - CLASS_EXTENSION.length())));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return classes;
    }

    private static void offerPrograms() {
        System.out.println(SELECT_PROGRAM);
        System.out.println(IN_PROGRESS);
        printAlphabetizedEntries(inProgressPrograms);
        System.out.println(COMPLETED);
        printAlphabetizedEntries(completedPrograms);
        System.out.println(CURRENCY_NOTE);
        System.out.println(PROGRAM_NAME_OR_EXIT);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String programName = sc.nextLine();
            if (programName.equalsIgnoreCase(EXIT)) {
                break;
            }
            AtomicBoolean ran = new AtomicBoolean(false);
            inProgressPrograms.forEach((String val, Runnable runnable) -> {
                if (programName.equalsIgnoreCase(val)) {
                    runnable.run();
                    System.out.println(val + PROGRAM_COMPLETED);
                    ran.set(true);
                }
            });
            if (!ran.get()) {
                completedPrograms.forEach((String val, Runnable runnable) -> {
                    if (programName.equalsIgnoreCase(val)) {
                        runnable.run();
                        System.out.println(val + PROGRAM_COMPLETED);
                        ran.set(true);
                    }
                });
            }
            if (!ran.get()) {
                System.out.println(INVALID_INPUT);
            }
        }
    }

    private static void printAlphabetizedEntries(Map<String, Runnable> map) {
        List<String> entries = new LinkedList<>();
        map.forEach((String str, Object obj) -> entries.add(str));
        Collections.sort(entries);
        entries.forEach(System.out::println);
    }

    private static Set<Class> classesFromRegistrar(List<String> registrar) {
        Set<Class> classes = new HashSet<>();
        registrar.forEach((String className) -> {
            try {
                classes.add(Class.forName(className));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        return classes;
    }

    private static List<String> getRegistrar() {
        List<String> registrar = new LinkedList<>();
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "2" + ".BMICalc");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "2" + ".Checkerboard");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "2" + ".CircleProperties");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "2" + ".Multiples");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "2" + ".NegativePositiveZeroValues");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "2" + ".OddOrEven");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "2" + ".SquaresAndCubesTable");

        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "3" + ".AccountTest");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "3" + ".EmployeeTest");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "3" + ".HeartRatesTest");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "3" + ".InvoiceTest");

        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "4" + ".CreditLimitCalculator");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "4" + ".GasMileage");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "4" + ".SalaryCalculator");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "4" + ".SalesCommissionCalculator");

        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "5" + ".Factorial");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "5" + ".ModifiedCompoundInterest");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "5" + ".ProductOfOddIntegers");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "5" + ".SmallestValue");

        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "6" + ".ComputerAssistedInstruction");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "6" + ".Exponentiation");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "6" + ".ParkingCharges");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "6" + ".TemperatureConversions");

        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "7" + ".AirlineReservationSystem");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "7" + ".DiceRolling");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "7" + ".TortoiseAndHare");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "7" + ".TotalSales");

        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "8" + ".EmployeeTest");

        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "14" + ".PigLatin");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "14" + ".RandomSentences");

        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "18" + ".Palindromes");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "18" + ".PrintAnArrayBackward");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "18" + ".MinimumValueInArray");

        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "19" + ".BubbleSort");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + CHAPTER + "19" + ".RecursiveBinSearch");

        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + FRIDAY_BUILDS + BUILD + "1" + ".LeapYearPaperBuild");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + FRIDAY_BUILDS + BUILD + "2" + ".Executor");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + FRIDAY_BUILDS + BUILD + "3" + ".ShapeExecutor");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + FRIDAY_BUILDS + BUILD + "4" + ".FizzBuzz");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + FRIDAY_BUILDS + BUILD + "5" + ".PartI");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + FRIDAY_BUILDS + BUILD + "5" + ".PartII");
        registrar.add(PACKAGE_PREFIX + "." + PROGRAMS + "." + FRIDAY_BUILDS + BUILD + "6" + ".PrimeNumberFinder");
        return registrar;
    }
}
