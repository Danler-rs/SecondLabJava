package SecondLab.Test3;

import java.util.HashMap;
import java.util.Map;

public class ClientAccaunt {
    String name;
    Map<Integer, Integer> deposit_summa = new HashMap<>();

    public ClientAccaunt(String name) {
        this.name = name;
    }

    public void setDeposit_summa(int nomerDiposita, Map<String, Integer> banknotes) {
        int summa = banknotesToDengi(banknotes);
        if (deposit_summa.containsKey(nomerDiposita)) {
            int newSumma = deposit_summa.get(nomerDiposita) + summa;
            deposit_summa.replace(nomerDiposita, summa, newSumma);
        } else {
            deposit_summa.put(nomerDiposita, summa);
        }
    }

    public void deleteDeposit(int index){
        deposit_summa.remove(index);
    }

    public void summaNaDepositePosleMonth(int nomerDeposita) {
        int summaPosleMonth = 0;
        int percent = deposit_summa.get(nomerDeposita);
        percent = (percent / 100) * 3;
        summaPosleMonth = deposit_summa.get(nomerDeposita) + percent;
        deposit_summa.replace(nomerDeposita, summaPosleMonth);
        System.out.println("Депозит после начисления %: " + deposit_summa.get(nomerDeposita));
    }

    public Object getSummaFromDepos(int nomerDepos, int sum){
        int sumNaDepos = deposit_summa.get(nomerDepos);
        boolean checkSumNaDepos = sumNaDepos >= sum;
        if(checkSumNaDepos) {
            int oldsum = deposit_summa.get(nomerDepos);
            int lastSum = oldsum - sum;
            deposit_summa.replace(nomerDepos, oldsum, lastSum);
            return dengiToBanknotes(sum);
        }else {
            return 0;
        }
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

    @Override
    public String toString() {
        return "Accaunt{" +
                "name='" + name + '\'' +
                ", deposit_summa=" + deposit_summa +
                '}';
    }

}