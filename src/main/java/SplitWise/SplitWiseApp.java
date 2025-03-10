package SplitWise;

import SplitWise.Models.Expense;
import SplitWise.Models.Transaction;
import SplitWise.Models.User;
import SplitWise.Models.UserPair;
import SplitWise.Repository.BalanceRepository;
import SplitWise.Repository.UserRepository;
import SplitWise.SplitStrategy.SplitStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class SplitWiseApp {
    UserRepository userRepository;
    BalanceRepository balanceRepository;
    public SplitWiseApp(){
        this.userRepository = new UserRepository();
        this.balanceRepository = new BalanceRepository();
    }

    public void addUser(User user){
        userRepository.addUser(user);

    }

    public Expense createExpense(Double amount, SplitStrategy splitStrategy){
        return new Expense(amount, splitStrategy);
    }
    public void getAllBalance(){
        balanceRepository.show();
    }
    public void getUserBalance(String userId){
        balanceRepository.show(userRepository.getUser(userId));
    }

    public void addTransaction(String paidBy, List<String> paidFor, Expense expense) throws Exception {
        User paidByUser = userRepository.getUser(paidBy);
        List<User> paidForUsers = paidFor.stream()
                .map(u -> userRepository.getUser(u)).
                collect(Collectors.toList());
        Transaction transaction = new Transaction(paidByUser, paidForUsers, expense);
        transaction.populateSplits();

        addEntryInUserBalance(paidByUser, transaction);
    }

    private void addEntryInUserBalance(User paidBy, Transaction transaction) {

        for(var entry : transaction.getSplits().entrySet()){
            User paidFor = entry.getKey();
            Double amount = entry.getValue();
            UserPair pair = new UserPair(paidBy, paidFor);
            balanceRepository.addBalance(pair, amount);
        }
    }

}
