package SplitWise;

import SplitWise.Models.Expense;
import SplitWise.Models.User;
import SplitWise.SplitStrategy.EqualSplit;
import SplitWise.SplitStrategy.ExactSplit;
import SplitWise.SplitStrategy.PercentSplit;
import SplitWise.SplitStrategy.SplitStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static SplitWise.Commands.*;

public class Main {
    public static void main(String[] args) throws Exception {
        User usr1 = new User("u1", "user1");
        User usr2 = new User("u2", "user2");
        User usr3 = new User("u3", "user3");
        User usr4 = new User("u4", "user4");
        SplitWiseApp app = new SplitWiseApp();
        app.addUser(usr1);
        app.addUser(usr2);
        app.addUser(usr3);
        app.addUser(usr4);

        Scanner scn = new Scanner(System.in);

        while(scn.hasNext()){
            String command = scn.nextLine();
            process(command, app);
        }
        scn.close();
    }

    private static void process(String command, SplitWiseApp app) throws Exception {
        String[] items = command.split(" ");
        String action = items[0];

        switch(action){
            case SHOW:
                handleShowCommand(items, app);
                break;
            case EXPENSE:
                handleExpenseCommand(items, app);
                break;
            default:
                throw new Exception("Invalid Command");
        }
    }
    static void handleShowCommand(String[] items, SplitWiseApp app){
        if(items.length == 1)
            app.getAllBalance();
        else
            app.getUserBalance(items[1]);
    }
    private static void handleExpenseCommand(String[] items, SplitWiseApp app) throws Exception {
        String paidByUserId = items[1];
        Double amount = Double.parseDouble(items[2]);
        int noOfUsers = Integer.parseInt(items[3]);
        List<String> paidForUserIds = new ArrayList<>();
        paidForUserIds.addAll(Arrays.asList(items).subList(4, 4 + noOfUsers));
        String expenseType = items[4 + noOfUsers];
        Expense expense = app.createExpense(amount, getSplitStrategy(expenseType, noOfUsers, items));
        app.addTransaction(paidByUserId, paidForUserIds, expense);
    }

    private static SplitStrategy getSplitStrategy(String expenseType, int noOfUsers, String[] items) {
        List<Double> amount = Arrays.asList(items).subList(4 + noOfUsers + 1, items.length).stream().map(Double::parseDouble).collect(Collectors.toList());
        switch (expenseType){
            case EQUAL:
                return new EqualSplit(noOfUsers);
            case EXACT:
                return new ExactSplit(amount);
            case PERCENT:
                return new PercentSplit(amount);
        }
        return null;
    }

}
