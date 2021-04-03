package chapter01;

public class TicketSeller {
    private TicketOffice ticketOffice;

    // 판매원 (ticketSeller)는 자신이 일하는 매표소(ticketOffice)를 알고 있어야 한다.
    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice() {
        return ticketOffice;
    }
}
