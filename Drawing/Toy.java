package Drawing;

import java.util.ArrayList;
import java.util.Scanner;


public class Toy {
    private int id;
    private String name;
    private int quantity;
    private int chance;

    public Toy (int id, String name, int quantity, int chance){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.chance = chance;
    }
    
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int newQuantity){
        this.quantity = newQuantity;
    }

    public int getChance(){
        return chance;
    }

    public void setChance(int newChance){
        this.chance = newChance;
    }

    public String toString(){
        return "ID :" + this.id + ", Имя :" + this.name + ", Колличество :" + this.quantity + ", Шанс выпадения :" + this.chance;
       }
// Обработка ввода числа
    public static int getNum(Scanner sc){
            int num;
            do {
                while(!sc.hasNextInt()){
                    System.out.println("Неправильный ввод !!!");
                    sc.next();
                }
                num = sc.nextInt();
            }
            while (num <= 0);
            return num;
    }
// Метод добавления игрушки
    public static void addToy(ArrayList<Toy> toys){
        boolean flag = false;
        int toyId = toys.size()+1;
        Scanner sc = new Scanner(System.in, "Cp866");
        System.out.println("Введите название игрушки :");
        String toyName = sc.nextLine();
        System.out.println("Введите колличество :");
        int toyQuantity = getNum(sc);
        System.out.println("Введите шанс выпадения игрушки :");
        int toyChance = getNum(sc);
        for (int i = 0; i < toys.size(); i++) {
            if (toys.get(i).getName().equals(toyName)){
                toys.get(i).quantity += toyQuantity;
                flag = true;
            }
        }
        if (flag == false){
            Toy addetToy = new Toy(toyId, toyName, toyQuantity, toyChance);
            toys.add(addetToy);
        }
    }
// Метод смены шанса выпадения
    public static void setToy(ArrayList<Toy> toys){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID игрушки :");
        int id = getNum(sc);
        boolean flag = false;
        for (int i = 0; i < toys.size(); i++) {
            if (id == toys.get(i).getId()){
                System.out.println("Введите новый шанс выпадения игрушки :");
                int newChance = getNum(sc);
                toys.get(i).chance = newChance;
                System.out.println(toys.get(i).toString());
                flag = true;
            } 
        }
        if (flag == false){
            System.out.println("Такого ID не найдено");
        }
    }
// Создание игрушек по умолчанию
    static void defaultToys(ArrayList<Toy> toys) {
        Toy toy1 = new Toy(toys.size()+1, "bear", 2, 10);
        toys.add(toy1);
        Toy toy2 = new Toy(toys.size()+1, "lego", 1, 15);
        toys.add(toy2);
        Toy toy3 = new Toy(toys.size()+1, "car", 1, 20);
        toys.add(toy3);
    }

   

    }

