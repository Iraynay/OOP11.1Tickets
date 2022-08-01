import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Ticket;
import ru.netology.TicketManager;
import ru.netology.TicketRepo;

public class TicketRepoTest {
    @Test
    public void repoSaveTicketTest() {

        TicketRepo testRepo = new TicketRepo();
        TicketManager manager = new TicketManager(testRepo);
        Ticket ticket1 = new Ticket(1, 10000, "DME", "GRV", 3.25);

        Ticket[] actual = testRepo.saveTicket(ticket1);
        Ticket[] expected = {ticket1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void repoRemoveByIdTest() {

        TicketRepo testRepo = new TicketRepo();
        TicketManager manager = new TicketManager(testRepo);
        Ticket ticket1 = new Ticket(1, 10000, "DME", "GRV", 3.25);
        Ticket ticket2 = new Ticket(2, 15000, "DME", "AER", 4.5);
        Ticket ticket3 = new Ticket(3, 9500, "LED", "SCW", 2);
        Ticket ticket4 = new Ticket(4, 10000, "LED", "AER", 4.45);
        Ticket ticket5 = new Ticket(5, 11000, "DME", "EVN", 3.45);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        Ticket[] actual = testRepo.removeById(1);

        Ticket[] expected = {ticket2, ticket3, ticket4, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void repoFindAllTest() {

        TicketRepo testRepo = new TicketRepo();
        Ticket ticket1 = new Ticket(1, 10000, "DME", "GRV", 3.25);
        Ticket ticket2 = new Ticket(2, 15000, "DME", "AER", 4.5);
        Ticket ticket3 = new Ticket(3, 9500, "LED", "SCW", 2);
        Ticket ticket4 = new Ticket(4, 10000, "LED", "AER", 4.45);
        Ticket ticket5 = new Ticket(5, 11000, "DME", "EVN", 3.45);

        testRepo.saveTicket(ticket1);
        testRepo.saveTicket(ticket2);
        testRepo.saveTicket(ticket3);
        testRepo.saveTicket(ticket4);
        testRepo.saveTicket(ticket5);

        Ticket[] actual = testRepo.findAll();

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }
}
