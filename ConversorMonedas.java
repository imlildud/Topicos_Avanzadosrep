import java.util.Scanner;
public class ConversorMonedas {
          public static void main(String[] args) {
                    Scanner tec = new Scanner(System.in);
                    int entrada = 0;
                    boolean verificador = true;;
                    Conversor conv = new Conversor();

                    while(verificador){
                              entrada = tec.nextInt();
                              if (entrada == 0){
                                        verificador = false;
                              }
                              else{
                                        System.out.print(conv.ElContador(entrada));
                              }
                    }
                    tec.close();
          }
}

class Conversor {
          public String ElContador (int entrada){
                    String salida = " \n";
                    int contador500 = 0;
                    int contador200 = 0;
                    int contador100 = 0;
                    int contador50 = 0;
                    int contador20 = 0;
                    int contador10 = 0;
                    int contador5 = 0;
                    int contador2 = 0;
                    int contador = 0;
                    int modificable = entrada;

                    while(true){
                              if (modificable >= 500){
                                        while (modificable >= 500){
                                                  modificable -= 500;
                                                  contador500++;       
                                        }
                              }
                              if (modificable >= 200){
                                        while (modificable >= 200){
                                                  modificable -= 200;
                                                  contador200++;
                                        }
                              }
                              if (modificable >= 100){
                                        while (modificable >= 100){
                                                  modificable -= 100;
                                                  contador100++;
                                        }
                              }
                              if (modificable >= 50){
                                        while (modificable >= 50){
                                                  modificable -= 50;
                                                  contador50++;
                                        }
                              }
                              if (modificable >= 20){
                                        while (modificable >= 20){
                                                  modificable -= 20;
                                                  contador20++;
                                        }
                              }
                              if (modificable >= 10){
                                        while (modificable >= 10){
                                                  modificable -= 10;
                                                  contador10++;
                                        }
                              }
                              if (modificable >= 5){
                                        while (modificable >= 5){
                                                  modificable -= 5;
                                                  contador5++;
                                        }
                              }
                              if (modificable >= 2){
                                        while (modificable >= 2){
                                                  modificable -= 2;
                                                  contador2++;
                                        }
                              }
                              if (modificable >= 1){
                                        while (modificable >= 1){
                                                  modificable -= 1;
                                                  contador++;
                                        }
                              }
                              if (modificable == 0){
                                        break;
                              }
                    }
                    if (contador500 != 0) {
                              System.out.println(contador500 + " de 500");
                    }
                    if (contador200 != 0) {
                              System.out.println(contador200 + " de 200");
                    }
                    if (contador100 != 0) {
                              System.out.println(contador100 + " de 100");
                    }
                    if (contador50 != 0) {
                              System.out.println(contador50 + " de 50");
                    }
                    if (contador20 != 0) {
                              System.out.println(contador20 + " de 20");
                    }
                    if (contador10 != 0) {
                              System.out.println(contador10 + " de 10");
                    }
                    if (contador5 != 0) {
                              System.out.println(contador5 + " de 5");
                    }

                    if (contador2 != 0) {
                              System.out.println(contador2 + " de 2");
                    }
                    if (contador != 0) {
                              System.out.println(contador + " de 1");
                    }
                    return(salida);
          }
}