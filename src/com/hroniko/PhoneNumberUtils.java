package com.hroniko;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneNumberUtils {

    private List<Long> phoneNumberList;
    private List<Integer> distanceToGapList;
    private Long currentPhone;
    private Integer currentPosiion;
    private Integer currentRangeSize;

    public PhoneNumberUtils(List<Long> phoneNumberList) {
        Collections.sort(phoneNumberList);
        this.phoneNumberList = phoneNumberList;
        resolveDistanceToGap();
    }

    public List<Long> getPhoneNumberList() {
        return phoneNumberList;
    }


    public List<Integer> getDistanceToGapList() {
        return distanceToGapList;
    }


    public Long getCurrentPhone() {
        return currentPhone;
    }


    public Integer getCurrentPosiion() {
        return currentPosiion;
    }


    public Integer getCurrentRangeSize() {
        return currentRangeSize;
    }


    /* ------------------ UTILS --------------------- */

    private void resolveDistanceToGap(){
        if (this.phoneNumberList == null) return;

        /* re-create from phoneNumberList */
        if (this.distanceToGapList == null
                || this.phoneNumberList.size() != this.distanceToGapList.size()) {
            this.distanceToGapList = this.phoneNumberList.stream()
                    .map(pn -> this.phoneNumberList.size() - 1 - this.phoneNumberList.indexOf(pn))
                    .collect(Collectors.toList());
        }
    }

    public List<Long> getListOfPhoneForContinuousRangeSize(Integer rangeSize){
        rangeSize--;
        List<Long> resultPhoneNumberList = new ArrayList<>();
        for (int i = 0; i < distanceToGapList.size(); i++){
            Integer distanceToGap = distanceToGapList.get(i);
            if (distanceToGap >= rangeSize){
                resultPhoneNumberList.add(phoneNumberList.get(i));
            }
        }
        return resultPhoneNumberList;
    }


    public void selectPhoneWithRange(Long phoneNumber, Integer rangeSize){
        List<Long> goodPhoneList = getListOfPhoneForContinuousRangeSize(rangeSize);
        if (goodPhoneList.contains(phoneNumber)){
            markerAsSelect(phoneNumber, rangeSize);
        }
        this.currentPhone = phoneNumber;
        this.currentPosiion = this.phoneNumberList.indexOf(phoneNumber);
        this.currentRangeSize = rangeSize;
    }

    public void unSelectCurrentPhone(){
        markerAsUnSelect(this.currentPhone, this.currentRangeSize);
        this.currentPhone = null;
        this.currentPosiion = null;
        this.currentRangeSize = 0;
    }

    public void findAndReSelectPhoneWithRange(Integer rangeSize){
        long cPhone = this.currentPhone;
        unSelectCurrentPhone();

        List<Long> goodPhoneList = getListOfPhoneForContinuousRangeSize(rangeSize);
        if (goodPhoneList.isEmpty()) return; // todo message of error
        if (goodPhoneList.contains(cPhone)){
            // unSelectCurrentPhone();
            selectPhoneWithRange(cPhone, rangeSize);
        } else { // goodPhoneList.get(0)
            selectPhoneWithRange(goodPhoneList.get(0), rangeSize);
            //markerAsSelect(this.currentPhone, rangeSize);
        }
    }

    private void resolveLocalDistanceToGap(int pos){

        int distance;

        while (pos < distanceToGapList.size() && distanceToGapList.get(pos) > -1){
            pos++;
        }


        if (pos < phoneNumberList.size() - 1){
            distance = distanceToGapList.get(pos + 1) + 1;
        } else {
            distance = 0;
        }

        pos --;
        while (pos >= 0 && distanceToGapList.get(pos) > -1){
            distanceToGapList.set(pos, distance);
            pos--;
            distance++;
        }

    }

    private void markerAsSelect(Long phoneNumber, Integer rangeSize){
        rangeSize --;
        int pos = phoneNumberList.indexOf(phoneNumber);
        for (int i = pos; i <= pos + rangeSize; i++){
            distanceToGapList.set(i, -1);
        }
        resolveLocalDistanceToGap(pos);
    }

    private void markerAsUnSelect(Long phoneNumber, Integer rangeSize){
        int pos = phoneNumberList.indexOf(phoneNumber);
        for (int i = pos; i <= pos + rangeSize - 1; i++){
            distanceToGapList.set(i, 0);
        }
        resolveLocalDistanceToGap(pos);
    }
}
