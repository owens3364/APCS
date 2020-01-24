package com.owen.scott;

import com.owen.scott.annotations.Completed;
import com.owen.scott.annotations.InProgress;

import java.io.File;
import java.io.IOException;
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

    private static final String PACKAGE_PREFIX = "com.owen.scott";

    private static final String CLASS_EXTENSION = ".class";
    private static final byte CLASS_EXTENSION_LENGTH = 0x6;

    private static HashMap<String, Runnable> inProgressPrograms;
    private static HashMap<String, Runnable> completedPrograms;

    public static void main(String[] args) {
        populatePrograms();
        offerPrograms();
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
                        classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - CLASS_EXTENSION_LENGTH)));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return classes;
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
                    try {
                        inProgressPrograms.put(potentialRunnable.getName(), (Runnable) potentialRunnable.getConstructor().newInstance());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (isRunnable && potentialRunnable.isAnnotationPresent(Completed.class)) {
                    try {
                        completedPrograms.put(potentialRunnable.getName(), (Runnable) potentialRunnable.getConstructor().newInstance());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        });
    }

    private static void offerPrograms() {
        System.out.println(SELECT_PROGRAM);
        System.out.println(IN_PROGRESS);
        inProgressPrograms.forEach((String val, Runnable runnable) -> System.out.println(val));
        System.out.println(COMPLETED);
        completedPrograms.forEach((String val, Runnable runnable) -> System.out.println(val));
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
                    ran.set(true);
                }
            });
            if (!ran.get()) {
                completedPrograms.forEach((String val, Runnable runnable) -> {
                    if (programName.equalsIgnoreCase(val)) {
                        runnable.run();
                        ran.set(true);
                    }
                });
            }
            if (!ran.get()) {
                System.out.println(INVALID_INPUT);
            }
        }
    }
}
