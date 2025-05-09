package edu.dio.bancodigital.usercontext;

import edu.dio.bancodigital.exceptions.MinorAccountRestrictionException;

public abstract class AccountFactory {
    public abstract Account createAccount(User holder);

    protected void checkingSameTypeAccount(User holder, Class<? extends Account> accountType) {
        if (holder.hasAccountOfType(accountType)) {
            throw new IllegalArgumentException("Só pode ter uma única conta do mesmo tipo.");
        }
    }

    protected void checkingMinorHolder(User holder) {
        if (holder.isMinor() && holder.hasAccount())
            throw new MinorAccountRestrictionException("Usuários menores de idade só podem ter uma única conta.");
    }
}
