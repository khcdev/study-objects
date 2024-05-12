package theater;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }
    // 문제 해결2: TicketSeller의 Bag, Ticket에대한 의존 제거 (audience encapsulation)
    /**
     * -> TicketSeller는 audience의 인터페이스(buy)를 통해서만 소통
     * -> audience가 어떻게 buy하는지 내부 구현에 대해서는 알 필요가 없어짐
     * */
    public void sellTo(Audience audience) {
        Ticket ticket = ticketOffice.getTicket();
        Long fee = audience.buy(ticket);
        ticketOffice.plusAmount(fee);
    }
}
