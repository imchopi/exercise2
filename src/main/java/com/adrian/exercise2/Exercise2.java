package com.adrian.exercise2;

import java.util.Arrays;
import java.io.IOException;

public class Exercise2 {
    public static void main(String[] args) {

        /*
         * Code copied from Teacher
         */
        if (args.length <= 0) {
            System.out.println("Debe indicarse el comando a ejecutar");
            System.exit(1);
        }

        ProcessBuilder processBuilder = new ProcessBuilder(args);
        processBuilder.inheritIO();

        try {
            Process process = processBuilder.start();
            int returnCode = process.waitFor();
            System.out.println("La ejecución de " + Arrays.toString(args)
                    + " ha devuelto el código " + returnCode
                    + " " + (returnCode == 0 ? "ejecución correcta" : "ERROR"));

        } catch (IOException e) {
            System.err.println("Error durante la ejecución del proceso");
            System.err.println("======================================");
            e.printStackTrace();
            System.exit(2);

        } catch (InterruptedException e) {
            System.err.println("Proceso interrumpido");
            System.exit(3);
        }

    }
}