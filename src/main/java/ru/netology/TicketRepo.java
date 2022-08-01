package ru.netology;

public class TicketRepo {
    protected Ticket[] ticketItems = new Ticket[0];

    public Ticket[] saveTicket(Ticket item) {
        int length = ticketItems.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(ticketItems, 0, tmp, 0, ticketItems.length);
        int lastItem = tmp.length - 1;
        tmp[lastItem] = item;
        ticketItems = tmp;
        return tmp;
    }

    public Ticket[] removeById(int id) {
        int length = ticketItems.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket item : ticketItems) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        return tmp;
    }

    public Ticket[] findAll() {
        Ticket[] allResult = new Ticket[ticketItems.length];
        for (int i = 0; i < allResult.length; i++) {
            int index = i;
            allResult[i] = ticketItems[index];
        }
        return allResult;
    }
}
