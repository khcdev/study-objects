package theater;

public class Theater {

    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }
    // 절차지향형 프로그램처럼 작성한 코드의 예시라고 볼 수 있음
    /** 아래 방식의 문제점
     * -> 결합도가 높음 (enter라는 프로세스를 기준으로 Bag, TicketSeller, TicketOffice, Ticket, Audience에 의존)
     * -> 객체 자체가 독립적이지 못하고 Theater에 의해서 제어되는 '수동적인 형태'
     *     ( 책에서 비유 한것은 티켓 판매원이 내 가방을 뒤져 초대권이 있는지 확인하고 돈을 빼는 것)
     * -> ** 변경에 취약함
     *     ( audience가 현금 말고 신용카드로 결제를 해야 한다면?, audience가 가방을 가지고 오지 않는다면? [전자발권 등])
     *     ( 의존하고 있는 객체에 따라 Theater에도 계속 변경이 일어나야함 )
     *
     * -> 동작이 직관적이지 않음 (의사소통 비용 증가)
     * */
    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            // ticketSeller가 TicketOffice에 대해 알고 있고, ticketOffice에서 티켓을 획득할 수 있음을 알아야함
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);// audience의 Bag에서 ticket을 참조할수 있음을 알아야함
        } else {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
