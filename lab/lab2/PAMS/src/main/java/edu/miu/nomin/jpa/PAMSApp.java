package edu.miu.nomin.jpa;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.miu.nomin.jpa.model.Patient;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PAMSApp {
    public static int calcAge(String dob) {
        String[] parts = dob.split("-");
        int year = Integer.parseInt(parts[0]);
        int currentYear = java.time.LocalDate.now().getYear();
        return currentYear - year;
    }
    public static void printPatients(List<Patient> patients) {
        for (Patient p : patients) {
            int age = calcAge(p.getDateOfBirth());
        //add age field into patient json response
            p.setAge(age);
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(patients);
        System.out.println(prettyJson);
    }
    public static void saveToFile(List<Patient> patients, String filePath) {
        //sort by age descending
        patients = patients.stream()
                .sorted((p1, p2) -> Integer.compare(calcAge(p2.getDateOfBirth()), calcAge(p1.getDateOfBirth())))
                .toList();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer = new FileWriter(filePath)){
            writer.write(gson.toJson(patients));
            System.out.println("Data saved to " + new File(filePath).getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Patient p1 = new Patient("Daniel", "Agar", "dagar@m.as", "(641) 123-0009", "1 N Street", "1987-1-19");
        Patient p2 = new Patient("Ana", "Smith", "amsith@te.edu", "", "","1948-12-5");
        Patient p3 = new Patient("Marcus", "Garvey", "", "(123) 292-0018", "4 East Ave", "2001-9-18");
        Patient p4 = new Patient("Jeff", "Goldbloom", "(999) 165-1192", "jgold@es.co.za", "", "1995-2-28");
        Patient p5 = new Patient("Mary", "Washington", "", "", "30 W Burlington", "1932-5-31");
        List<Patient> patients = List.of(p1, p2, p3, p4, p5);
        printPatients(patients);

        //save prettyJson to a file named patients.json
        String filePath = "patients.json";
        saveToFile(patients, filePath);
    }
}