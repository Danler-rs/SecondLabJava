/*package SecondLab.Task3;

import java.util.*;

public class Bank_old {

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

    public void addClientPlusGiveId(String name){
      if (!listClient.contains(name)){
          listClient.add(name);
          System.out.println("Client was created");
      } else {
          System.out.println("Client already exist");
      }
    }

    public void addClientDeposit(int Id, int nomerDepos, int sumOfMoney){
        Map<Integer, Integer> nomerDepos_sumOfMoney = new HashMap<>();
        nomerDepos_sumOfMoney.put(nomerDepos, sumOfMoney);
        listsDengiFromId.add(Id, nomerDepos_sumOfMoney);
    }

    public int getClientId(String name){
        int id;
        id = listClient.indexOf(name);
        return id;
    }


    }



 */