package br.com.dio.repository;

import br.com.dio.exception.AccountNotFoundException;
import br.com.dio.exception.AccountWithInvestmentException;
import br.com.dio.model.AccountWallet;
import br.com.dio.model.MoneyAudit;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static br.com.dio.repository.CommonsRepository.checkFundsForTransaction;

public class AccountRepository {

    private final Map<String, AccountWallet> accounts = new HashMap<>();

    public AccountWallet create(final List<String> pix, final Long initialFunds) {
        if (!accounts.isEmpty()) {
            // pega todas as chaves Pix cadastradas
            var pixInUse = accounts.values().stream()
                    .flatMap(a -> a.getPix().stream())
                    .toList();

            for (String p : pix) {
                if (pixInUse.contains(p)) {
                    throw new AccountWithInvestmentException("A conta '" + p + "' já possui um investimento");
                }
            }
        }

        var newAccount = new AccountWallet(initialFunds, pix);

        // associa todas as chaves Pix à conta
        pix.forEach(p -> accounts.put(p, newAccount));

        return newAccount;
    }

    public void deposit(final String pix, final long fundsAmount) {
        var target = findByPix(pix);
        target.addMoney(fundsAmount, "depósito");
    }

    public long withdraw(final String pix, final long amount) {
        var source = findByPix(pix);
        checkFundsForTransaction(source, amount);
        source.reduceMoney(amount);
        return amount;
    }

    public void transferMoney(final String sourcePix, final String targetPix, final long amount) {
        var source = findByPix(sourcePix);
        checkFundsForTransaction(source, amount);
        var target = findByPix(targetPix);
        var message = "pix enviado de '" + sourcePix + "' para '" + targetPix + "'";
        target.addMoney(source.reduceMoney(amount), source.getService(), message);
    }

    public AccountWallet findByPix(final String pix) {
        var wallet = accounts.get(pix);
        if (wallet == null) {
            throw new AccountNotFoundException("A conta com a chave pix  '" + pix + "' não existe ou foi encerrada");
        }
        return wallet;
    }

    public List<AccountWallet> list() {
        return new ArrayList<>(accounts.values());
    }

    public Map<OffsetDateTime, List<MoneyAudit>> getHistory(String pix) throws AccountNotFoundException {
        var wallet = accounts.get(pix);

        if (wallet == null) {
            throw new AccountNotFoundException("Conta não encontrada para a chave pix: " + pix);
        }

        return wallet.getFinancialTransactions().stream()
                .collect(Collectors.groupingBy(MoneyAudit::createdAt,
                        TreeMap::new,
                        Collectors.toList()));
    }
}
