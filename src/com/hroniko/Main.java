package com.hroniko;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Long> phones = new ArrayList<>();
        for (long i = 0L; i <= 10L; i++){
            phones.add(101L + i);
        }

        PhoneNumberUtils u = new PhoneNumberUtils(phones);

        System.out.println("1. Load all phones, distances and phone for range 5:");
        System.out.println(u.getPhoneNumberList());
        System.out.println(u.getDistanceToGapList());
        System.out.println(u.getListOfPhoneForContinuousRangeSize(5));
        System.out.println();

        u.selectPhoneWithRange(106L, 2);
        System.out.println("2. Load all phones, distances and phone for range 2 after select 106:");
        System.out.println(u.getPhoneNumberList());
        System.out.println(u.getDistanceToGapList());
        System.out.println();

        u.selectPhoneWithRange(102L, 2);
        System.out.println("3. Load all phones, distances and phone for range 2 after select 102:");
        System.out.println(u.getPhoneNumberList());
        System.out.println(u.getDistanceToGapList());
        System.out.println(u.getListOfPhoneForContinuousRangeSize(2));
        System.out.println();

        u.findAndReSelectPhoneWithRange(4);
        System.out.println("4. Load all phones, distances and phone for range 2 after increase range to 4:");
        System.out.println(u.getPhoneNumberList());
        System.out.println(u.getDistanceToGapList());
        System.out.println(u.getListOfPhoneForContinuousRangeSize(2));
        System.out.println();

        u.findAndReSelectPhoneWithRange(3);
        System.out.println("5. Load all phones, distances and phone for range 2 after increase range to 3:");
        System.out.println(u.getPhoneNumberList());
        System.out.println(u.getDistanceToGapList());
        System.out.println(u.getListOfPhoneForContinuousRangeSize(2));
        System.out.println();

        // todo method for degrees range or use check in findAndReSelectPhoneWithRange()

        u.unSelectCurrentPhone();
        System.out.println("6. Load all phones, distances and phone for range 2 after unSelect current range:");
        System.out.println(u.getPhoneNumberList());
        System.out.println(u.getDistanceToGapList());
        System.out.println(u.getListOfPhoneForContinuousRangeSize(2));
        System.out.println();

    }
}
