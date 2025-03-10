package SplitWiseLLD;

import SplitWiseLLD.Enum.ExpenseType;
import SplitWiseLLD.Models.Expense;
import SplitWiseLLD.Models.Transaction;
import SplitWiseLLD.Models.User;
import SplitWiseLLD.Models.UserPair;
import SplitWiseLLD.Repository.TransactionRepository;
import SplitWiseLLD.Repository.UserRepository;
import SplitWiseLLD.SplitStrategy.EqualSplitStrategy;
import SplitWiseLLD.SplitStrategy.ExactSplitStrategy;
import SplitWiseLLD.SplitStrategy.ISplitStrategy;
import SplitWiseLLD.SplitStrategy.PercentSplitStrategy;

import java.util.List;

public class SplitApp {
    UserRepository userRepository;
    TransactionRepository transactionRepository;
    public SplitApp(){
        this.userRepository = new UserRepository();
        this.transactionRepository = new TransactionRepository();
    }


    public void addUser(User user){
        userRepository.addUser(user);
    }

    public void createTransaction(User paidBy, List<User> paidFor, Expense expense) throws Exception {
        Transaction transaction = new Transaction(paidBy, paidFor, expense);

        for(var entry : transaction.getSplits().entrySet()){
            User user = entry.getKey();
            transactionRepository.addTransaction(new UserPair(user, paidBy), entry.getValue());
        }
    }

    public Expense createExpense(Double totalAmount, int noOfUsers, ExpenseType expenseType, List<Double> amounts) throws Exception {
        return new Expense(totalAmount, getSplitStrategy(expenseType, amounts, noOfUsers));
    }

    public ISplitStrategy getSplitStrategy(ExpenseType expenseType, List<Double> amounts, int noOfUsers) throws Exception {

        switch (expenseType){
            case EQUAL:
                return new EqualSplitStrategy(noOfUsers);
            case EXACT:
                return new ExactSplitStrategy(amounts);
            case PERCENT:
                return new PercentSplitStrategy(amounts);
            default:
                throw new Exception("Invalid Expense type");
        }
    }
}