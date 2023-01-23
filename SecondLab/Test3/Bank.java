package SecondLab.Test3;

import java.util.*;


public class Bank {
    static List<ClientAccaunt> clientAccauntList = new ArrayList<>();;
    Scanner scanner = new Scanner(System.in);
    Atm atm = new Atm(100, 90,80,70,60,50,50);
    public static void main(String[] args) {
/*
        String name = "Ilya";
        String nameOfAccaunt = "accaount" + name;
        Map<String, Integer> banknotes_value = new HashMap<>();

        AccauntFactory accauntFactory = new ClientAccauntFactory();
        Accaunt accaunt = accauntFactory.createClientAccaunt(name);
        accaunt.setDeposit_summa(1,450);
        System.out.println(accaunt);
        accaunt.setDeposit_summa(2, 130);
        System.out.println(accaunt);
        accaunt.summaNaDepositePosleMonth(2);
        System.out.println(accaunt);

        name = "Vova";

        Accaunt accaunt1 = accauntFactory.createClientAccaunt(name);
        System.out.println();

 */

        /*
        String name1 = "Ilya";
        String name2 = "Vova";

        GenerateNewAccaunt(name1);
        System.out.println(clientAccauntList);
        GenerateNewAccaunt(name2);
        System.out.println(clientAccauntList);

        int nomerDepositaVova = 1;
        Map<String , Integer> summaVova = new HashMap<>();

        ///
        clientAccauntList.get(1).setDeposit_summa(nomerDepositaVova, summaVova);
        System.out.println(clientAccauntList);

        clientAccauntList.get(1).deleteDeposit(1);
        System.out.println(clientAccauntList);

        //
        clientAccauntList.remove(0);
        System.out.println(clientAccauntList);

        // Снятие с депозита

        clientAccauntList.get(0).setDeposit_summa(nomerDepositaVova, summaVova);
        System.out.println(clientAccauntList);

        clientAccauntList.get(0).getSummaFromDepos(1, 5);
        System.out.println(clientAccauntList);

 */


    }



    public static void GenerateNewAccaunt(String name){
        clientAccauntList.add(new ClientAccaunt(name));
        System.out.println("Client " +name+" was created");
    }

    public void DeleteAccaunt(int index){
        clientAccauntList.remove(index);
        System.out.println("Client on index " + index + " was deleted");
    }

    public void CreateDepositAndAddOnItMoney(int indexOfClient, int nomerDeposita, Map<String, Integer> sumOnDeposit){
        atm.addMoney(sumOnDeposit);
        clientAccauntList.get(indexOfClient).setDeposit_summa(nomerDeposita, sumOnDeposit);
        System.out.println("Client " + clientAccauntList.get(indexOfClient) + " create deposit " + nomerDeposita + " with " + sumOnDeposit + " of money");
    }

    public void GetSumFromDeposit(int indexOfClient, int nomerDeposita, int sumOfDeposit){
        atm.getMoney(sumOfDeposit);
        clientAccauntList.get(indexOfClient).getSummaFromDepos(nomerDeposita, sumOfDeposit);
        System.out.println("Client "+clientAccauntList.get(indexOfClient)+" get "+sumOfDeposit+" from "+nomerDeposita+" deposit");
    }
}


class Atm {

    private final int[] banknotes = new int[7];

    public final static String ONE = "1";
    public final static String FIVE = "5";
    public final static String TEN = "10";
    public final static String FIFTY = "50";
    public final static String ONE_HUNDRED = "100";
    public final static String FIVE_HUNDRED = "500";
    public final static String ONE_THOUSAND = "1000";


    ////////////

    public Atm(int one, int five, int ten, int fifty, int oneHundred, int fiveHundred, int oneThousand) {
        one = banknotes[0];
        five = banknotes[1];
        ten = banknotes[2];
        fifty = banknotes[3];
        oneHundred = banknotes[4];
        fiveHundred = banknotes[5];
        oneThousand = banknotes[6];
    }

    ////////////



    public int getOne() {
        return banknotes[0];
    }

    public int getFive() {
        return banknotes[1];
    }

    public int getTen() {
        return banknotes[2];
    }

    public int getFifty() {
        return banknotes[3];
    }

    public int getOneHundred() {
        return banknotes[4];
    }

    public int getFiveHundred() {
        return banknotes[5];
    }

    public int getOneThousand() {
        return banknotes[6];
    }

    //////////


    ///////////


    @Override
    public String toString() {
        return "Atm{" +
                "one=" + banknotes[0] +
                ", five=" + banknotes[1] +
                ", ten=" + banknotes[2] +
                ", fifty=" + banknotes[3] +
                ", oneHundred=" + banknotes[4] +
                ", fiveHundred=" + banknotes[5] +
                ", oneThousand=" + banknotes[6] +
                '}';
    }



    public void addMoney(Map<String, Integer> dengi){
        String one = "1";
        String five = "5";
        String ten = "10";
        String fifty = "50";
        String oneHundred = "100";
        String fiveHundred = "500";
        String oneThousand = "1000";

        banknotes[0] += dengi.get(one);
        banknotes[1] += dengi.get(five);
        banknotes[2] += dengi.get(ten);
        banknotes[3] += dengi.get(fifty);
        banknotes[4] += dengi.get(oneHundred);
        banknotes[5] += dengi.get(fiveHundred);
        banknotes[6] += dengi.get(oneThousand);

        int sum = 0;
        sum = banknotesToMoney(dengi);



    }

    public void getMoney(int sum) {
        int curSum = getOne() + getFive() * 5 + getTen() * 10 + getFifty() * 50 + getOneHundred() * 100 + getFiveHundred() * 500 + getOneThousand() * 1000;

        Map<String, Integer> backbanknote = null;
        if (curSum < sum) {
            System.out.println("Nedostatochno banknot");
        } else {
            int amountOneThousand = (sum / 1000);
            int amountFiveHundred = (sum - amountOneThousand * 1000) / 500;
            int amountOneHundred = (sum - amountOneThousand * 1000 - amountFiveHundred * 500) / 100;
            int amountFifty = (sum - amountOneThousand * 1000 - amountFiveHundred * 500 - amountOneHundred * 100) / 50;
            int amountTen = (sum - amountOneThousand * 1000 - amountFiveHundred * 500 - amountOneHundred * 100 - amountFifty * 50) / 10;
            int amountFive = (sum - amountOneThousand * 1000 - amountFiveHundred * 500 - amountOneHundred * 100 - amountFifty * 50 - amountTen * 10) / 5;
            int amountOne = (sum - amountOneThousand * 1000 - amountFiveHundred * 500 - amountOneHundred * 100 - amountFifty * 50 - amountTen * 10 - amountFive * 5);

            banknotes[0] -= amountOne;
            banknotes[1] -= amountFive;
            banknotes[2] -= amountTen;
            banknotes[3] -= amountFifty;
            banknotes[4] -= amountOneHundred;
            banknotes[5] -= amountFiveHundred;
            banknotes[6] -= amountOneThousand;

            System.out.println("1000 -> " + amountOneThousand + "\n" +
                    "500 -> " + amountFiveHundred + "\n" +
                    "100 -> " + amountOneHundred + "\n" +
                    "50 -> " + amountFifty + "\n" +
                    "10 -> " + amountTen + "\n" +
                    "5 -> " + amountFive + "\n" +
                    "1 -> " + amountOne);

            backbanknote = new HashMap<>();

            backbanknote = dengiToBanknotes(sum);

        }
    }

    public int banknotesToMoney(Map<String, Integer> banknotes){
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
}