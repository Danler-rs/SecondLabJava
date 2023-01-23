package SecondLab.Test3;

import java.util.HashMap;
import java.util.Map;

public class Client {
    Map<String, Integer> banknotes = new HashMap<>();
    String name;
    long summa = banknotesToDengi(banknotes);

    public Client(String name) {
        this.name = name;
        randomBlanks();
        getSumma();

    }

    public int banknotesToDengi(Map<String, Integer> banknotes){
        int sum = 0;

        for (int value: banknotes.values()){
            sum += value;
        }
        return sum;
    }

    public Map<String, Integer> dengiToBanknotes(int sum){
        int thousand = sum / 1000;
        int five_hundred = (sum % 1000) / 500;
        int hundred = ((sum % 1000) % 500)/ 100;
        int fifty = (((sum % 1000) % 500) % 100)/ 50;
        int ten = ((((sum % 1000) % 500) % 100) % 50) / 10;
        int five = (((((sum % 1000) % 500) % 100) % 50) % 10) / 5;
        int one = ((((((sum % 1000) % 500) % 100) % 50) % 10) % 5);

        Map<String, Integer> backBanknotes = new HashMap<>();

        backBanknotes.put("1", one);
        backBanknotes.put("5", five);
        backBanknotes.put("10", ten);
        backBanknotes.put("50", fifty);
        backBanknotes.put("100", hundred);
        backBanknotes.put("500", five_hundred);
        backBanknotes.put("1000", thousand);

        return backBanknotes;
    }

    public void randomBlanks(){
        String one = "1";
        String five = "5";
        String ten = "10";
        String fifty = "50";
        String oneHundred = "100";
        String fiveHundred = "500";
        String oneThousand = "1000";
        banknotes.put(one, (int) (Math.random()*9));
        banknotes.put(five, (int) (Math.random()*9));
        banknotes.put(ten, (int) (Math.random()*9));
        banknotes.put(fifty, (int) (Math.random()*9));
        banknotes.put(oneHundred, (int) (Math.random()*9));
        banknotes.put(fiveHundred, (int) (Math.random()*9));
        banknotes.put(oneThousand, (int) (Math.random()*9));
    }

    public long getSumma(){
        return summa;
    }

    @Override
    public String toString() {
        return "Client{" +
                "banknotes=" + banknotes +
                ", name='" + name + '\'' +
                ", summa=" + summa +
                '}';
    }
}
