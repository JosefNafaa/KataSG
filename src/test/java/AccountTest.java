import exceptions.BanqueExceptions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    Account account;

    @Before
    public void init() {
        account = new Account();
    }


    @Test
    public void should_increase_amount_by_1000_when_deposit_is_1000() {
        //given
        account = new Account();

        int oldBalance = account.getBalance();
        //when
        account.deposit(1000);
        //then
        assertThat(account.getBalance() - oldBalance).isEqualTo(1000);
    }

    @Test
    public void balance_should_return_100_after_deposit_100() {
        //given
        account = new Account();
        //when
        account.deposit(100);
        int balance = this.account.getBalance();
        //then
        assertThat(balance).isEqualTo(100);
    }

    @Test
    public void should_decrease_amount_by_500_when_withdraw_is_500() {
        //given
        account = new Account();
        //when
        account.deposit(1000);
        int oldBalance = account.getBalance();
        account.withraw(500);
        //then
        assertThat(oldBalance - account.getBalance()).isEqualTo(500);
    }


    @Test
    public void balance_should_be_100_after_deposit_500_and_500_and_withdraw_500_and_400() {
        //given
        account = new Account();
        //when
        account.deposit(500);
        account.withraw(500);
        account.deposit(500);
        account.withraw(400);
        int balance = account.getBalance();
        //then

        assertThat(100).isEqualTo(balance);
    }

    @Test
    public void should_throw_exception_when_deposit_is_negative() {
        assertThrows(BanqueExceptions.class, () -> account.deposit(-200), MessageConstants.AMOUNT_DEPOSIT_WITHDRAWAL_NEGATIVE);

    }

    @Test
    public void should_throw_exception_when_withdraw_is_negative() {
        assertThrows(BanqueExceptions.class, () -> account.withraw((int) -200.00), MessageConstants.AMOUNT_DEPOSIT_WITHDRAWAL_NEGATIVE);
    }

    @Test
    public void should_throw_exception_when_withdraw_is_big_then_balance() {
        //give
        account = new Account();
        assertThrows(BanqueExceptions.class, () -> account.withraw((int) 3000.00), MessageConstants.WITHDRAWAL_AMOUNT_BIG_TO_BALANCE);

    }


}
