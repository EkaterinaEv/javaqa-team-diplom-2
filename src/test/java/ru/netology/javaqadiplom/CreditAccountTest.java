package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CreditAccountTest {

    @Test// amount >0
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                300,
                5_000,
                15
        );
        account.add(3_000);
        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test// amount <0
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                300,
                5_000,

                15
        );
        account.add(-3_000);
        Assertions.assertEquals(300, account.getBalance());
    }

    @Test//amount =0
    public void shouldAddToZeroBalance() {
        CreditAccount account = new CreditAccount(
                300,
                5_000,
                15
        );
        account.add(0);
        Assertions.assertEquals(300, account.getBalance());
    }


    @Test// BAG! initialBalance - неотрицательное число
    public void shouldAddToNegativeInitialBalance() {
        CreditAccount account = new CreditAccount(
                -300,
                5_000,
                15
        );
        account.add(3000);
        Assertions.assertEquals(3000, account.getBalance());
    }

    @Test// initialBalance=0
    public void shouldAddToZeroInitialBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.add(3000);
        Assertions.assertEquals(3000, account.getBalance());
    }

    @Test// BAG! creditLimit - неотрицательное число
    public void shouldAddToNegativeCreditLimit() {
        CreditAccount account = new CreditAccount(
                300,
                -5_000,
                15
        );
        account.add(3000);
        Assertions.assertEquals(3000, account.getBalance());
    }

    @Test// creditLimit =0
    public void shouldAddToZeroCreditLimit() {
        CreditAccount account = new CreditAccount(
                300,
                0,
                15
        );
        account.add(3000);
        Assertions.assertEquals(3000, account.getBalance());
    }

    @Test// amount >0
    public void shouldAddToPositivePay() {
        CreditAccount account = new CreditAccount(
                300,
                5_000,
                15
        );

        account.pay(6000);

        Assertions.assertEquals(-5700, account.getBalance());
    }

    @Test// amount =0
    public void shouldAddToZeroPay() {
        CreditAccount account = new CreditAccount(
                300,
                5_000,
                15
        );
        account.pay(0);
        Assertions.assertEquals(300, account.getBalance());
    }

    @Test// amount <0

    public void shouldAddToNegativePay() {
        CreditAccount account = new CreditAccount(
                300,
                5_000,
                15
        );
        account.pay(-3_000);
        Assertions.assertEquals(300, account.getBalance());
    }

//    @Test// ДОПИСАТЬ! на выброс исключения в конструкторе

//    public void illegalArgumentExceptionTest() {
//        CreditAccount account = new CreditAccount(
//                300,
//                5_000,
//                -10
//        );
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            account.что - то;
//        });
//
//    }

    @Test// BAG??? если на счёте 200, expected = 0
    public void yearChangeTest() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );
        account.yearChange();
        Assertions.assertEquals(30, account.yearChange());
    }

    @Test// если на счёте -200
    public void yearChangeTest2() {
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );
        account.yearChange();
        Assertions.assertEquals(-30, account.yearChange());
    }

}
