package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ArrayList<Message> messages = readCsv();

        for (Message message : messages) {
            System.out.println(message.toString());
        }
        System.out.println("Hello world!");
    }

    private static ArrayList<Message> readCsv() {
        ArrayList<Message> messageArrayList = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get("train.csv"));
             CSVReader csvReader = new CSVReader(reader)) {

            String[] records;
            int k = 0;
            while ((records = csvReader.readNext()) != null) {
                Message message = Message.builder()
                        .passengerId(Integer.parseInt(checkRecord(records[k++])))
                        .survived(Integer.parseInt(checkRecord(records[k++])))
                        .pClass(Integer.parseInt(checkRecord(records[k++])))
                        .name(checkRecord(records[k++]))
                        .sex(checkRecord(records[k++]))
                        .age(Double.parseDouble(checkRecord(records[k++])))
                        .sibSp(Integer.parseInt(checkRecord(records[k++])))
                        .parch(Integer.parseInt(checkRecord(records[k++])))
                        .ticket(checkRecord(records[k++]))
                        .fare(Double.parseDouble(checkRecord(records[k++])))
                        .cabin(checkRecord(records[k++]))
                        .eMarked(checkRecord(records[k++]))
                        .build();
                k = 0;
                messageArrayList.add(message);
            }
        } catch (IOException | CsvValidationException ex) {
            ex.printStackTrace();
        }
        return messageArrayList;
    }

    private static String checkRecord(String record) {
        if (Objects.equals(record, "")) {
            return "-1";
        } else {
            return record;
        }
    }
}