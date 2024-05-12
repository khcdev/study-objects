package theater;

public class Theater {

    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    // 문제 해결1 : Theater가  tickerSeller의 인터페이스에만 의존하도록 수정
    /**
     * -> TicketSeller를 Encapsulation함으로써 객체가 독립적, 능동적으로 동작하게 함으로써 변경에 유연하지게 변경
     * */
    public void enter(Audience audience) {
        // Theater와 ticketSeller는 `sellTo`라는 인터페이스를 통해서만 소통하게 됨
        // Theater가 ticketSeller 내부 구현이 어떻게 되었는지는 이제 알 필요가 없음
        // Encapsulation
        ticketSeller.sellTo(audience);
    }
}
