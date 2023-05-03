package Drawing;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;


public class Main {

    public static final String PATH = "Drawing/received.txt";
    
    public static void main(String[] args) {
        
        System.out.print("\033[H\033[2J");
        ArrayList <Toy> toys = new ArrayList<>(); //Основной список игрушек.
        Deque<String> toIssue = new ArrayDeque<String>(); // Список игрушек на выдачу
        Toy.defaultToys(toys);
        File received = new File(PATH);
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println(" =========== Меню ===========");
            System.out.println("1. Вывод списка игрушек.");
            System.out.println("2. Добавить игрушку в список.");
            System.out.println("3. Редактировать игрушку.");
            System.out.println("4. Разыграть игрушку.");
            System.out.println("5. Выдать игрушку.");
            System.out.println("6. Выход.");
            
            int menuCase = Toy.getNum(sc);
            if (menuCase == 1){
                for (int i = 0; i < toys.size(); i++) {
                    System.out.println(toys.get(i).toString());
                }
            }
            else if (menuCase == 2){
                Toy.addToy(toys);
                for (int i = 0; i < toys.size(); i++) {
                    System.out.println(toys.get(i).toString());
                }
            }
            else if (menuCase == 3){
                for (int i = 0; i < toys.size(); i++) {
                    System.out.println(toys.get(i).toString());
                }
                Toy.setToy(toys);
            }
            else if (menuCase == 4){
                // Тут проверяем список игрушек на наличие содержимого. 
                // Если игрушки есть, то проводим розагрыш.
                if (toys.isEmpty()){
                    System.out.println("Игрушек больше нет...");
                }
                else{
                    String winName = Lottery.getWinName(toys);
                    Lottery.removeToy(toys, winName);
                    toIssue.add(winName);
                }
                System.out.println("Очередь игрушек на выдачу : " + toIssue);
                
            }

            else if (menuCase == 5){
                // Проверка наличия файла. Если его нет - создаем.
                if (!received.exists()){
                    try {
                        received.createNewFile();
                    } 
                    catch (IOException e) {
                        System.out.println("Проблеммы с файлом.");
                    }
                }

            if (!toIssue.isEmpty()){
                String toFile = toIssue.pop();
                System.out.println("Игрушка " + toFile + " выдана.");

                try {
                    FileWriter fr = new FileWriter(received, true);
                    BufferedWriter br = new BufferedWriter(fr);
                    br.write(toFile + "\n");
                    br.close();
                    fr.close();
                } 
                catch (IOException e) {
                    System.out.println("Проблеммы с файлом.");
                }
            }
            else System.out.println("Все игрушки выданы.");
            }

            else if (menuCase == 6){
                sc.close();
                break;

            }
            else System.out.println("Неправильный выбор!");
    }
}
}