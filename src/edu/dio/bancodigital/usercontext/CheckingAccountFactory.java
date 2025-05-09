package edu.dio.bancodigital.usercontext;

import edu.dio.bancodigital.exceptions.MinorAccountRestrictionException;

public class CheckingAccountFactory extends AccountFactory {

    @Override
    public Account createAccount(User holder) {
        if (holder.isMinor())
            throw new MinorAccountRestrictionException(
                    "Titulares menores de idade só podem ter contas do tipo menor de idade");
        super.checkingSameTypeAccount(holder, CheckingAccount.class);
        return new CheckingAccount(holder);
    }

}