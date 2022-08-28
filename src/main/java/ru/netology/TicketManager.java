package ru.netology;

import java.util.Arrays;
import java.util.Objects;

public class TicketManager {
    private TicketRepo repository;

    public TicketManager(TicketRepo repository) {
        this.repository = repository;
    }

    private Ticket[] tickets = new Ticket[0];

    public void add(Ticket tickets) {
        repository.saveTicket(tickets);
    }

    public Ticket[] findTickets(String from, String to) {
        Ticket[] tickets = repository.findAll();
        for (Ticket ticketItem : tickets) {
 //           if (ticketItem.getArrivalAirport().equals(from) && ticketItem.getArrivalAirport().equals(to)) {
           if (ticketItem.getDepartureAirport() == from && ticketItem.getArrivalAirport() == to) {
                Ticket[] tmp = new Ticket[1];
                for (int i = 0; i < tmp.length; i++) {
                  tmp[i] = tickets [i];
                }
               tmp[tmp.length - 1] = ticketItem;
               tmp = tickets;
            }
        }
        Arrays.sort(tickets);
        return tickets;
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
