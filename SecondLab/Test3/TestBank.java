package SecondLab.Test3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class TestBank {
    static List<Client> clients;
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        clients = new ArrayList<>();
        System.out.println("Введите имя 1 клиента");

        String name1Client = scanner.nextLine();
        GenerateNewClient(name1Client);
        System.out.println();
        System.out.println(clients.get(0));


        System.out.println("Введите имя 2 клиента");
        String name2Client = scanner.nextLine();
        GenerateNewClient(name2Client);
        System.out.println();
        System.out.println(clients.get(1));

        System.out.println();
        Bank.GenerateNewAccaunt(name1Client);
        Bank.clientAccauntList.get(0).setDeposit_summa(1,clients.get(0).banknotes);
        System.out.println(Bank.clientAccauntList);


    }

    public static void GenerateNewClient(String name){
        clients.add(new Client(name));
        System.out.println("Human " + name + " was created");
    }
}