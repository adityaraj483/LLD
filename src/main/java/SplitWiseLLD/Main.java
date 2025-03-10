package SplitWiseLLD;

import SplitWiseLLD.Enum.Command;
import SplitWiseLLD.Enum.ExpenseType;
import SplitWiseLLD.Models.Expense;
import SplitWiseLLD.Models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            SplitApp app = new SplitApp();
            User user1 = new User("u1", "user1");
            User user2 = new User("u2", "user2");
            User user3 = new User("u3", "user3");
            User user4 = new User("u4", "user4");
            app.addUser(user1);
            app.addUser(user2);
            app.addUser(user3);
            app.addUser(user4);

            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNext()){
                String command = scanner.nextLine();
                String[] cmd = command.split(" ");
                process(cmd, app);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void process(String[] cmd, SplitApp app) throws Exception {
        Command command = Command.valueOf(cmd[0]);
        switch (command){
            case SHOW:
                processShow(cmd, app);
                break;
            case EXPENSE:
                processExpense(cmd, app);
                break;
            default:
                throw new Exception("Command is not supported " + command);

        }
    }

    private static void processExpense(String[] cmd, SplitApp app) throws Exception {
        int userCount = Integer.parseInt(cmd[3]);
        ExpenseType expenseType = ExpenseType.valueOf(cmd[userCount + 4]);
        switch (expenseType){
            case EQUAL:
                processEqual(cmd, app);
                break;
            case EXACT:
                processExact(cmd, app);
                break;
            case PERCENT:
                processPercent(cmd, app);
                break;
            default:
                throw new Exception("Expense type is not Supported" + expenseType);
        }

    }

    private static void processPercent(String[] cmd, SplitApp app) throws Exception {
        User paidBy  = app.userRepository.getUser(cmd[1]);
        int userCount = Integer.parseInt(cmd[3]);
        Double totalAmount = Double.parseDouble(cmd[2]);


        List<User> paidFor = new ArrayList<>();
        for(int i=4;i<4+userCount;i++){
            paidFor.add(app.userRepository.getUser(cmd[i]));
        }

        List<Double> percentage = new ArrayList<>();
        for(int i=userCount+ 5; i< cmd.length;i++){
            percentage.add(Double.parseDouble(cmd[i]));
        }

        Expense expense = app.createExpense(totalAmount, userCount, ExpenseType.PERCENT, percentage);
        app.createTransaction(paidBy, paidFor, expense);
    }

    private static void processExact(String[] cmd, SplitApp app) throws Exception {
        User paidBy  = app.userRepository.getUser(cmd[1]);
        int userCount = Integer.parseInt(cmd[3]);
        Double totalAmount = Double.parseDouble(cmd[2]);


        List<User> paidFor = new ArrayList<>();
        for(int i=4;i<4+userCount;i++){
            paidFor.add(app.userRepository.getUser(cmd[i]));
        }

        List<Double> amounts = new ArrayList<>();
        for(int i=userCount+ 5; i< cmd.length;i++){
            amounts.add(Double.parseDouble(cmd[i]));
        }

        Expense expense = app.createExpense(totalAmount, userCount, ExpenseType.EXACT, amounts);
        app.createTransaction(paidBy, paidFor, expense);
    }

    private static void processEqual(String[] cmd, SplitApp app) throws Exception {
        User paidBy  = app.userRepository.getUser(cmd[1]);
        int userCount = Integer.parseInt(cmd[3]);
        Double totalAmount = Double.parseDouble(cmd[2]);


        List<User> paidFor = new ArrayList<>();
        for(int i=4;i<4+userCount;i++){
            paidFor.add(app.userRepository.getUser(cmd[i]));
        }

        Expense expense = app.createExpense(totalAmount, userCount, ExpenseType.EQUAL, new ArrayList<>());
        app.createTransaction(paidBy, paidFor, expense);
    }


    private static void processShow(String[] cmd, SplitApp app) {
        if(cmd .length == 1)
            app.transactionRepository.show();
        else
            app.transactionRepository.show(app.userRepository.getUser(cmd[1]));
    }
}
