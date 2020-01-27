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

    private static Map<String, Runnable> inProgressPrograms;
    private static Map<String, Runnable> completedPrograms;

    public static void main(String[] args) {
        populatePrograms();
        offerPrograms();
    }

    private static void populatePrograms() {
        inProgressPrograms = new HashMap<>();
        completedPrograms = new HashMap<>();

        Set<Class> potentialRunnables = new HashSet<>(getClasses(PACKAGE_PREFIX));

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
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
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
}
