package SplitWiseLLD.Repository;

import SplitWiseLLD.Models.User;
import SplitWiseLLD.Models.UserPair;

import java.util.HashMap;
import java.util.Map;

public class TransactionRepository {
    Map<UserPair, Double> transactionRepository;
    public TransactionRepository(){
        transactionRepository = new HashMap<>();
    }

    public void addTransaction(UserPair userPair1, Double amount1){

        if(transactionRepository.containsKey(userPair1)){
            transactionRepository.put(userPair1, transactionRepository.get(userPair1)+ amount1);
        }else {
            transactionRepository.put(userPair1, amount1);
        }


        UserPair userPair2 = new UserPair(userPair1.getFrnd(), userPair1.getUser());


        if(transactionRepository.containsKey(userPair2)){
            Double amount2 = transactionRepository.get(userPair2);

            if(amount2 > amount1) {
                transactionRepository.put(userPair2, amount2 - amount1);
                transactionRepository.remove(userPair1);
            }else if(amount1 > amount2) {
                transactionRepository.put(userPair1, amount1 - amount2);
                transactionRepository.remove(userPair2);
            }else {
                transactionRepository.remove(userPair2);
                transactionRepository.remove(userPair1);
            }
        }
    }

    public void show(){
        boolean isEmpty = true;
        for(var entry : transactionRepository.entrySet()){
            User user = entry.getKey().getUser();
            User frnd = entry.getKey().getFrnd();
            System.out.println(user.getName() + " owes " + frnd.getName()+": " + entry.getValue());
            isEmpty = false;
        }

        if(isEmpty)
            System.out.println("No balance");
    }

    public void show(User user1){
        boolean isEmpty = true;
        for(var entry : transactionRepository.entrySet()){
            User user = entry.getKey().getUser();
            User frnd = entry.getKey().getFrnd();
            if(user1.equals(user)|| user1.equals(frnd)) {
                System.out.println(user.getName() + " owes " + frnd.getName() + ": " + entry.getValue());
                isEmpty = false;
            }
        }

        if(isEmpty)
            System.out.println("No balance");
    }
}
