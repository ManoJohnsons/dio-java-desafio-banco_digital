package edu.dio.bancodigital.accountcontext;

import edu.dio.bancodigital.usercontext.User;

public class MinorAccountFactory extends AccountFactory {

    @Override
    public Account createAccount(User holder) {
        super.checkingMinorHolder(holder);
        return new MinorAccount(holder);
    }

}