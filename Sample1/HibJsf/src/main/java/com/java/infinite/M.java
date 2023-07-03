package com.java.infinite;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class M {
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	StudentDAO d = new StudentDAO();
	d.validateEmail(null, null, s.next());
}
}
