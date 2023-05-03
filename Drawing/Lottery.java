package Drawing;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class Lottery {
    // Метод получения имени выйгрышной игрушки.
    public static String getWinName(List<Toy> toys){
    // Вспомогательный словарь с именем и списком выйгрышных чисел
    // Чем больше шанс выйгрыша, тем больше чисел и все это умножить 
    // на колличество.
    Map<String, List<Integer>> lotteryMap; 
    lotteryMap = new HashMap<>();
                String winName = "";
                int totalCount = 0;
                int count = 0;
                int tempCount = 0;
                for (int i = 0; i < toys.size(); i++) {
                    List<Integer> numbers = new ArrayList<Integer>();
                    totalCount += toys.get(i).getQuantity() * toys.get(i).getChance();
                    tempCount = toys.get(i).getQuantity() * toys.get(i).getChance();
                    for (int j = 0; j <= tempCount - 1; j++) {
                        count++;
                        numbers.add(count);
                    }
                    lotteryMap.put(toys.get(i).getName(), numbers);
                }

                Random r = new Random();
                int winNum = r.nextInt(totalCount) + 1;
            // Читаем словарь с игрушками и шансом попадания.
            Iterator<Map.Entry<String,List<Integer>>> entries = lotteryMap.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String,List<Integer>> entry = entries.next();
                System.out.println("Название игрушки = " + entry.getKey() + " Номера для выйгрыша = " + entry.getValue());
            } 
            // Находим выйгрышное число в словаре и получаем имя игрушки.
            for(Map.Entry<String,List<Integer>> entry : lotteryMap.entrySet()){
                List<Integer> tempList = entry.getValue();
                for (int i = 0; i < tempList.size(); i++) {
                    if (tempList.get(i) == winNum){
                        winName = entry.getKey();
                        }
                }
            }
            System.out.println("Выйгрышная игрушка " + winName + " с номером : " + winNum);
            return winName;
        }

// Метод удаления игрушки из основного списка.
// Удаляет игрушку полностью, если она одна 
// или уменьшает колличество, если игрушек больше чем одна.
        public static void removeToy(List<Toy> toys, String winName) {
            for (int i = 0; i < toys.size(); i++) {
                if (toys.get(i).getName() == winName){
                    if (toys.get(i).getQuantity() > 1){
                        toys.get(i).setQuantity(toys.get(i).getQuantity() - 1); 
                        System.out.println(toys.get(i).toString());
                    }
                    else toys.remove(i);  
                }
            } 
        }

    }
