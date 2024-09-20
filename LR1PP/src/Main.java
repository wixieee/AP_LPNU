import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Створення списку об'єктів FibonacciNum
     *
     * @param N К-сть чисел
     * @return Список об'єктів FibonacciNum
     */
    static ArrayList<FibonacciNum> generateFibonacci(int N) {
        ArrayList<FibonacciNum> fibonacciNums = new ArrayList<>();
        int num1 = 0, num2 = 1;
        if(N >= 1){
            fibonacciNums.add(new FibonacciNum(1, num1));
        }
        if(N >= 2) {
            fibonacciNums.add(new FibonacciNum(2, num2));
        }
        for(int i = 3; i <= N; i++) {
            int num3 = num1 + num2;
            fibonacciNums.add(new FibonacciNum(i, num3));
            num1 = num2;
            num2 = num3;
        }
        return fibonacciNums;
    }

    /**
     * Головний метод програми, що приймає введення від користувача, генерує ряд Фібоначчі
     * і перевіряє, які числа можна задати у формі w^2 - 1
     *
     * @param args Не використовується
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 0;
        // Перевірка правильності вводу
        do{
            System.out.print("Введіть кількість чисел Фібоначчі, які потрібно перевірити: ");
            if(sc.hasNextInt()){
                N = sc.nextInt();
            }
            else{
                sc.next();
            }
        }while(N < 1);

        // Генерація ряду Фібоначчі
        ArrayList<FibonacciNum> arr = generateFibonacci(N);
        System.out.println("Отриманний ряд Фібоначчі:");
        for(FibonacciNum num : arr) {
            System.out.print(num.getValue()+" ");
        }
        System.out.println("\nЧисла які можна задати у формі w^2 - 1:");

        // Перевірка чисел на можливість представлення у формі w^2 - 1
        for(FibonacciNum num : arr) {
            int w = (int)Math.cbrt(num.getValue() - 1);
            if(w * w * w== num.getValue() - 1) {
                System.out.printf("%d = %d^3 +1\n",num.getValue(),w);
            }
        }
    }
}
