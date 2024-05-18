package ru.yandex.practicum;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку => ");
        final String input = scanner.nextLine();
        final String encoded = org.apache.commons.codec.binary.Base64.encodeBase64String(
                input.getBytes()
        );
        System.out.println(encoded);

    }
}