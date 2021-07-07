/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.utils;

/**
 *
 * @author nguye
 */
import java.util.*;

public class DateToSqlDate {

    public static void main(String[] args) {
        Date uDate = new Date();
        System.out.println("Java util date: " + uDate);
        java.sql.Date sql_date = convertDate(uDate);
        System.out.println("sql date is: " + sql_date);
    }

    private static java.sql.Date convertDate(java.util.Date date) {
        java.sql.Date myDate = new java.sql.Date(date.getTime());
        return myDate;
    }
}
