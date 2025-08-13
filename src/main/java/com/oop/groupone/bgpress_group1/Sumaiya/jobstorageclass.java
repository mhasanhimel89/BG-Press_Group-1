package com.oop.groupone.bgpress_group1.Sumaiya;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class jobstorageclass {
    private static final String FILE_NAME = "jobs.dat";

    public static void saveJob(assignjobClass job) {
        List<assignjobClass> jobs = loadJobs(); // load old jobs
        jobs.add(job); // add the new one
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(jobs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<assignjobClass> loadJobs() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<assignjobClass>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }


    private static final String FILE_PATH = "jobrequests.dat";

    public static List<assignjobClass> loadRequests() {
        List<assignjobClass> requests = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            requests = (List<assignjobClass>) ois.readObject();
        } catch (FileNotFoundException e) {
            // File not found, return empty list
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requests;
    }

    public static void saveRequests(List<assignjobClass> requests) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(requests);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
