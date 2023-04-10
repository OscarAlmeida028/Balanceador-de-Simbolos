import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese los símbolos:");
        String texto = sc.nextLine();
        int tam = texto.length();
        int x=0;

        Stack<Character> pila= new Stack<>();

        for (int i=0; i<tam; i++ ){
            char simbolo = texto.charAt(i);
            if(simbolo == '(' || simbolo == '[' || simbolo == '{') {
                pila.push(simbolo);
            } else if (simbolo == ')' || simbolo == ']' || simbolo == '}') {
                if(pila.isEmpty()){
                    x=1;
                    break;
                } else if (simbolo == ')' && pila.peek()=='(' || simbolo == ']' && pila.peek()=='[' || simbolo == '}' && pila.peek()=='{') {
                    pila.pop();
                }
            }
        }
        if (pila.isEmpty() && x==1) {
            System.out.println("la pila está vacía");
        }else if (pila.isEmpty() && x==0){
            System.out.println("Los símbolos están balanceados");
        } else
            System.out.println("Los símbolos no están balanceados");
    }
}