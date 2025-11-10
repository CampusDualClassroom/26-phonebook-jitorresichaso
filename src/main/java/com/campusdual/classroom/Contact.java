package com.campusdual.classroom;

import java.text.Normalizer;

public class Contact implements ICallActions {

    private String name;
    private String surnames;
    private String phone;
    private String code;

    public Contact(String name, String surnames, String phone) {
        this.name = name;
        this.surnames = surnames;
        this.phone = phone;
        this.code = createCode(name, surnames);
    }

    private String createCode(String name, String surnames) {
        String nameNormalized = Normalizer.normalize(name, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "").toLowerCase();
        String surnamesNormalized = Normalizer.normalize(surnames, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "").toLowerCase();
        String[] nameParts = nameNormalized.split(" ");
        String[] surnameParts = surnamesNormalized.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(nameParts[0].charAt(0));
        if (surnameParts.length == 1) {
            sb.append(surnameParts[0]);
        } else if (surnameParts.length == 2) {
            sb.append(surnameParts[0].charAt(0));
            sb.append(surnameParts[1]);
        } else {
            sb.append(surnameParts[0].charAt(0));
            for (int i = 1; i < surnameParts.length; i++) {
                sb.append(surnameParts[i]);
            }
        }
        return sb.toString().replaceAll(" ", "");
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public String getPhone() {
        return phone;
    }

    public String getCode() {
        return code;
    }

    @Override
    public void callMyNumber() {
        System.out.println(this.name + " " + this.surnames + " está llamando a su propio número " + this.phone);
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println(this.name + " " + this.surnames + " está llamando a " + number);
    }

    @Override
    public void showContactDetails() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ");
        sb.append(this.name);
        sb.append("\n");
        sb.append("Apellidos: ");
        sb.append(this.surnames);
        sb.append("\n");
        sb.append("Teléfono: ");
        sb.append(this.phone);
        sb.append("\n");
        sb.append("Código: ");
        sb.append(this.code);
        sb.append("\n");
        return sb.toString();
    }
}
