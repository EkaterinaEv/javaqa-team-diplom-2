package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldAddZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(2_000 + 0, account.getBalance());
    }

    @Test
    public void shouldAddMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(9000);

        Assertions.assertEquals(10_000, account.getMaxBalance());

    }

    @Test
    public void shouldAddNegativeBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-1000);

        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void shouldTestPay() {
        SavingAccount account = new SavingAccount(2000, 1000, 10_000, 5);
        account.pay(100);

        Assertions.assertEquals(2000 - 100, account.getBalance());
    }

    @Test
    public void shouldTestPay2() {
        SavingAccount account = new SavingAccount(2000, 1000, 10_000, 5);
        account.pay(1000);

        Assertions.assertEquals(2000 - 1000, account.getBalance());
    }

    @Test
    public void shouldTestPay3() {
        SavingAccount account = new SavingAccount(2000, 1000, 10_000, 5);
        account.pay(10000);

        Assertions.assertEquals(2000, account.getBalance());
    }
    @Test
    public void shouldTestNegativeAmount() {
        SavingAccount account = new SavingAccount(2000, 1000, 10_000, 5);
        account.pay(-500);

        Assertions.assertFalse(account.pay(-500));
    }

    @Test
    public void shouldTestYearChange() {
        SavingAccount account = new SavingAccount(2000, 1000, 10_000, 5);
        account.yearChange();

        Assertions.assertEquals(100, account.yearChange());
    }

    @Test
    public void shouldTestYearChange2() {
        SavingAccount account = new SavingAccount(-2000, 1000, 10_000, 5);
        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void IllegalArgumentExceptionTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(2000, 1000, 10000, -5);
        });
    }
}
