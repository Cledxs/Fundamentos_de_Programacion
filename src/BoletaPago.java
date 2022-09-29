
import java.util.Arrays;
import java.util.Scanner;

public class BoletaPago {
    public static double [] salarioBase(int [] horasPorTrabajador,double [] tarifaPorTrabajador ){
        double []salarioBase= new double[tarifaPorTrabajador.length];
        for (int i =0; i<salarioBase.length;i++){
             salarioBase[i]= horasPorTrabajador[i]*tarifaPorTrabajador[i];
        }

        return salarioBase;
    }

    public static double [] descuentoSunat(double [] salaraioBase){
        double [] descuentos = new double[salaraioBase.length];
        for(int i = 0; i<descuentos.length; i++){
            if(salaraioBase[i]>1500){
                descuentos[i]=salaraioBase[i]*0.08;
            }else {
                descuentos[i]=0;
            }

        }
        return descuentos;
    }

    public static double[] salarioNeto (double [] salarioBase, double [] descuentoSunat, int mes, double bono){
        double[] salarioNeto = new double[salarioBase.length];
        for (int i=0; i<salarioNeto.length; i++){
            salarioNeto[i]=salarioBase[i]-descuentoSunat[i];
            if (mes == 7 || mes == 12){
                salarioNeto [i] = salarioBase[i] + salarioBase[i]*bono-descuentoSunat[i] ;
            }
        }
        return salarioNeto;
    }
    public static String mesText(int mes){
        Scanner imput = new Scanner(System.in);
        while (mes < 1 || mes > 12) {
            System.out.println("Mes invalido ingrese nuevamente");
            mes = imput.nextInt();
            imput.nextLine();
        }
        String mesText ="";
        switch (mes) {
            case 1:
                mesText = "ENERO"; break;
            case 2:
                mesText = "FEBRERO";break;
            case 3:
                mesText = "MARZO";break;
            case 4:
                mesText = "ABRIL";break;
            case 5:
                mesText = "MAYO";break;
            case 6:
                mesText = "JUNIO";break;
            case 7:
                mesText = "JULIO";break;
            case 8:
                mesText = "AGOSTO";break;
            case 9:
                mesText = "SETIEMBRE";break;
            case 10:
                mesText = "OCTUBRE";break;
            case 11:
                mesText = "NOVIEMBRE";break;
            case 12:
                mesText = "DICIEMBRE";break;

        }
        return mesText;
    }
    public static String[] trabajadorText(String [] trabajadores){
        String []trabajadoresText = new String[trabajadores.length];
        for (int i=0; i<trabajadores.length; i++){
            if(trabajadores[i].equals("O")){
                trabajadoresText[i]="Obrero";
            } else if (trabajadores[i].equals("T")) {
                trabajadoresText[i]="Tecnico";
            }else {
                trabajadoresText[i]="Administrativo";
            }
        }
        return trabajadoresText;
    }
    public static void resumenDeDatos(String[] nombres, String[] trabajadorText, int[] horasPorTrabajador, double[] tarifaPorTrabajador, String mesText){
        System.out.println("\n******RESUMEN DE DATOS INGRSADOS*****");
        System.out.println("Nombres de Empleados: "+ Arrays.toString(nombres));
        System.out.println("El tipo de empleado es: "+ Arrays.toString(trabajadorText));
        System.out.println("Horas trabajadas por trabajador: "+ Arrays.toString(horasPorTrabajador));
        System.out.println("Tarifa horaria por Trabajador: "+Arrays.toString(tarifaPorTrabajador));
        System.out.println("El mes es: "+mesText);
    }
    public static void resumenMontos(double[] salarioBase, double[] descuentoSunat, double[] salarioNeto){
        System.out.println("Salarios Base: "+Arrays.toString(salarioBase));
        System.out.println("Retencion Sunat: "+Arrays.toString(descuentoSunat));
        System.out.println("Salarios Netos"+Arrays.toString(salarioNeto));
    }
    public static void proyecto(){
        Scanner imput = new Scanner(System.in);
        String password;
        String nombre;
        String tipoTrabajador;
        int mes;
        int horasTrabajadas;
        double tarifaHora;
        final double bonoDiciembreJulio=0.5;

        System.out.print("Ingrese la contraseña para acceder: ");
        password=imput.nextLine();

        while (!password.equals("PROGRAMACION") ) {
            System.out.print("La contraseñae es incorrecta, ingrese nuevamente: ");
            password = imput.nextLine();
        }
        System.out.println("\n***********************************************************");
        System.out.println("\"BIENVENIDO AL SISTEMA DE GENERACION DE BOLETAS DE PAGO\"");
        System.out.println("***********************************************************\n");

        int numEmpleados;

        System.out.print("Ingrese la cantidad de empleados: ");
        numEmpleados= imput.nextInt();
        imput.nextLine();

        String [] tipoTrabajdorCaracter = new String[numEmpleados];
        int [] horasPorTrabajador = new int[numEmpleados];
        double [] tarifaPorTrabajador = new double[numEmpleados];
        String [] nombres= new String[numEmpleados];

        System.out.print("\nIngrese los datos de los "+numEmpleados+" empleados:\n");

        for (int i=0; i<numEmpleados;i++){
            System.out.println("\nDatos del empleado N° "+(i+1)+" :");
            System.out.print("Ingrese el nombre del empleado: ");
            nombre = imput.nextLine();
            nombres[i] = nombre;
            System.out.print("Ingrese el tipo de trabajador (O = Obrero , T =Tecnico, A = Administrativo): ");
            tipoTrabajador = imput.nextLine().toUpperCase();

            while (!tipoTrabajador.equals("O") && !tipoTrabajador.equals("T") && !tipoTrabajador.equals("A")) {
                System.out.println("El tipo de trabajador es incorrecto, ingrese nuevamente.");
                tipoTrabajador = imput.nextLine().toUpperCase();
            }
            tipoTrabajdorCaracter[i]=tipoTrabajador;

            System.out.print("Ingrese las horas trabajadas:");
            horasTrabajadas = imput.nextInt();
            imput.nextLine();

            while (horasTrabajadas <= 0) {
                System.out.println("Numero invalido, el valor debe ser un numero positivo, ingrese nuevamente.");
                horasTrabajadas = imput.nextInt();
                imput.nextLine();
            }

            horasPorTrabajador[i]=horasTrabajadas;

            System.out.print("Ingrese la Tarifa por hora:");
            tarifaHora = imput.nextDouble();
            imput.nextLine();
            while (tarifaHora <= 0) {
                System.out.println("Numero invalido, el valor debe ser un numero positivo, ingrese nuevamente.");
                tarifaHora = imput.nextDouble();
                imput.nextLine();
            }
            tarifaPorTrabajador[i]=tarifaHora;
        }
        System.out.print("\nIngrese el numero del mes (1-12): ");
        mes = imput.nextInt();
        imput.nextLine();
        String mesText=mesText(mes);
        String [] trabajadorText = trabajadorText(tipoTrabajdorCaracter);

        double[] salarioBase= salarioBase(horasPorTrabajador, tarifaPorTrabajador);
        double[] descuentoSunat = descuentoSunat(salarioBase);
        double[] salarioNeto = salarioNeto(salarioBase,descuentoSunat, mes, bonoDiciembreJulio);

        resumenDeDatos(nombres, trabajadorText, horasPorTrabajador, tarifaPorTrabajador, mesText);
        resumenMontos(salarioBase, descuentoSunat, salarioNeto);

        System.out.println("\nPARA IMPRIMIR DIGITE \"P\" - PARA SALIR \"E\"");
        String imprimir = imput.nextLine();
        if (imprimir.equalsIgnoreCase("P")){
            System.out.println("*****************************************************************");
            for (int i=0; i<numEmpleados; i++){
                System.out.println("===BOLETA CORRESPONDIENTE AL MES DE "+mesText+"===");
                System.out.println("Nombre del trabjador: "+nombres[i]);
                System.out.println("Cargo: "+trabajadorText[i]);
                System.out.println("Horas trabajadas: "+horasPorTrabajador[i]);
                System.out.println("Sueldo base: "+salarioBase[i]);
                System.out.println("Retencion Sunat: "+descuentoSunat[i]);
                System.out.println("Sueldo neto: "+salarioNeto[i]);
                System.out.println(" ");
            }

        }else {
            System.out.println("PROCESO FINALIZADO, INGRESE NUEVAMENTE");
        }

    }
    public static void main(String[] args) {
        proyecto();
    }
}
