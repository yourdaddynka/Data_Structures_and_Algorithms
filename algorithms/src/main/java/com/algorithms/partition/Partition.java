package com.algorithms.partition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Partition {

    private static long pivot(List<Long> entitiesList,int size,long pivot) {
        int first = 0;
        for (int i = 0; i < size; i++) {
            long current = entitiesList.get(i);
            if (current < pivot) {
                first++;
            }
        }
        return first;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        String[] stringBuff = reader.readLine().split(" ");
        List<Long> entitiesList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            entitiesList.add(Long.parseLong(stringBuff[i]));
        }
        long pivot = Long.parseLong(reader.readLine());


        long first = pivot(entitiesList,size,pivot);
        System.out.println(first);
        System.out.println(size-first);
    }
}
