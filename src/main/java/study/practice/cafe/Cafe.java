package study.practice.cafe;


import lombok.Builder;

public class Cafe {
    MenuStrategy menu;
    PaymentStrategy payments;


    @Builder
    public Cafe(MenuStrategy menu, PaymentStrategy payments) {
        this.menu = menu;
        this.payments = payments;
    }

    public void order(){
        menu.brew();
        payments.pay();
    }
}
