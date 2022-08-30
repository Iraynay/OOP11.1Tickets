package ru.netology;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TicketRepo repo = new TicketRepo();
        TicketManager manager = new TicketManager(repo);


        Ticket ticket1 = new Ticket(1, 10000, "DME", "GRV", 3.25);
        Ticket ticket2 = new Ticket(2, 15000, "DME", "AER", 4.5);
        Ticket ticket3 = new Ticket(3, 9500, "LED", "SCW", 2);
        Ticket ticket4 = new Ticket(4, 10000, "LED", "AER", 4.45);
        Ticket ticket5 = new Ticket(5, 11000, "DME", "EVN", 3.45);
        Ticket ticket6 = new Ticket(6, 25000, "DME", "RGK", 4.2);
        Ticket ticket7 = new Ticket(7, 4000, "DME", "LED", 1.4);
        Ticket ticket8 = new Ticket(8, 10500, "LED", "SCW", 2);
        Ticket ticket9 = new Ticket(9, 6000, "DME", "LED", 1.4);
        Ticket ticket10 = new Ticket(10, 7500, "LED", "SCW", 2);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] result1 = manager.findTickets("LED", "SCW");
        System.out.println("FindTickets: " + Arrays.toString(result1));
        Ticket[] result2 = manager.allSortedTickets();
        System.out.println("AllTickets" + Arrays.toString(result2));

    }
}
