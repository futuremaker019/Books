package chapter01;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        // 관객의 가방에 초대장이 들어있다면
        if (audience.getBag().hasInvitation()) {
            // 판매원이 초대장과 티켓을 교환해주고
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            // 관객의 가방에 초대장이 들어간다. (ticker 객체를 넣어준다.)
            audience.getBag().setTicket(ticket);
        // 관객이 초대장을 가지고 있지 않다면
        } else {
            // 판매원의 초대장
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            // 관객이 티켓의 돈을 지불함
            audience.getBag().minusAmount(ticket.getFee());
            // 지불한 돈은 판먀원이 보관한다.
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            // 관객의 가방에 초대장이 들어간다.
            audience.getBag().setTicket(ticket);
        }
    }
}
