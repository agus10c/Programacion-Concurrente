package TPOBLIGATORIO;

import java.util.concurrent.Semaphore;

public class MaquinaTickets {
    private int cantTicketVendidos;
    private int cantTotal;
    private Semaphore sTicket;

    public MaquinaTickets(int cantTotal) {
        cantTicketVendidos = 0;
        this.cantTotal = cantTotal;
        this.sTicket = new Semaphore(1);
    }

    public int getCantTicketVendidos() {
        return cantTicketVendidos;
    }

    public boolean comprarTicket() throws InterruptedException {
        boolean ret;
        sTicket.acquire();
        if(this.cantTicketVendidos<this.cantTotal) {
            System.out.println(Thread.currentThread().getName()+" compro Ticket");
            this.cantTicketVendidos++;
            ret = true;
            if(this.cantTicketVendidos==this.cantTotal) {
                System.out.println("Tickets agotados");
            }
        } else {
            System.out.println(Thread.currentThread().getName()+" no hay ticket");
            ret = false;
        }
        Thread.sleep(200);
        sTicket.release();
        return ret;
    }
}
