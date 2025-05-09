package edu.dio.bancodigital.usercontext;

public class MinorAccountFactory extends AccountFactory {

    @Override
    public Account createAccount(User holder) {
        super.checkingMinorHolder(holder);
        return new MinorAccount(holder);
    }

    
}