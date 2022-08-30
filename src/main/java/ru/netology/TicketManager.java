package ru.netology;

import java.util.Arrays;
import java.util.Objects;

public class TicketManager {
    private TicketRepo repository;

    public TicketManager(TicketRepo repository) {
        this.repository = repository;
    }

    private Ticket[] tickets = new Ticket[0];
    Ticket[] resultForFind = new Ticket[0];

    public void add(Ticket tickets) {
        repository.saveTicket(tickets);
    }

    public Ticket[] findTickets(String from, String to) {
        Ticket[] tickets = repository.findAll();
        for (Ticket ticketItem : tickets) {
            if (ticketItem.getDepartureAirport() == from && ticketItem.getArrivalAirport() == to) {
                int resultLength = resultForFind.length + 1;
                Ticket[] tmp = new Ticket[resultLength];
                System.arraycopy(resultForFind, 0, tmp, 0, resultForFind.length);

                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticketItem;
                resultForFind = tmp;
            }
        }
        Arrays.sort(resultForFind);
        return resultForFind;
    }


    public Ticket[] allSortedTickets() {
        Ticket[] tickets = repository.findAll();
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp = tickets;
        Arrays.sort(tickets);
        return tickets;
    }
}
