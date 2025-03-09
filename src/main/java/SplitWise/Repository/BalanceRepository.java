package SplitWise.Repository;

import SplitWise.Models.User;
import SplitWise.Models.UserPair;

import java.util.HashMap;
import java.util.Map;

public class BalanceRepository {
    Map<UserPair, Double> balanceRepository;
    public BalanceRepository(){
        balanceRepository = new HashMap<>();
    }

    public void addBalance(UserPair pair, double amount){

        if(balanceRepository.containsKey(pair)){
            balanceRepository.put(pair, twoDecimalPlace(balanceRepository.get(pair) + amount));
        }else{
            balanceRepository.put(pair, twoDecimalPlace(amount));
        }

        UserPair pair2 = new UserPair(pair.getFrnd(), pair.getUser());

        if(balanceRepository.containsKey(pair2)){
            Double val1 = balanceRepository.get(pair);
            Double val2 = balanceRepository.get(pair2);

            if(val1 > val2){
                balanceRepository.put(pair, val1 - val2);
                balanceRepository.remove(pair2);
            }else if(val1 < val2){
                balanceRepository.put(pair2, val2 - val1);
                balanceRepository.remove(pair);
            }else{
                balanceRepository.remove(pair);
                balanceRepository.remove(pair2);
            }
        }
    }
    public void show(){
        boolean isEmpty = true;
        for(var entry : balanceRepository.entrySet()){
            System.out.println(entry.getKey().getFrnd().getName() + " owes " + entry.getKey().getUser().getName() + ": "+ entry.getValue());
            isEmpty = false;
        }
        if(isEmpty){
            System.out.println("No balance");
        }
    }
    public void show(User user){
        boolean isEmpty = true;
        for(var entry : balanceRepository.entrySet()){
            if(user.equals(entry.getKey().getUser()) || user.equals(entry.getKey().getFrnd())) {
                System.out.println(entry.getKey().getFrnd().getName() + " owes " + entry.getKey().getUser().getName() + ": " + entry.getValue());
                isEmpty = false;
            }
        }

        if(isEmpty) System.out.println("No balance");
    }

    private Double twoDecimalPlace(double amount) {
        return (amount * 100.0)/100.0;
    }
}
