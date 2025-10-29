import java.io.FileWriter;
import java.io.IOException;

//this class handles all calculations, validation, and saving the report to a file
public class MovieTickets {

    //method to validate data entered by user
    public boolean validateData(String movieName, int numberOfTickets, double ticketPrice) {
        if (movieName == null || movieName.isEmpty()) {
            return false;
        }
        if (numberOfTickets <= 0 || ticketPrice <= 0) {
            return false;
        }
        return true;
    }

    //method to calculate total ticket price including VAT
    public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
        double subtotal = numberOfTickets * ticketPrice;
        return subtotal + (subtotal * 0.14);
    }

    //method to save report text to a file
    public void saveReportToFile(String reportText) throws IOException {
        try (FileWriter writer = new FileWriter("report.txt")) {
            writer.write("MOVIE TICKET REPORT\n");
            writer.write("******************************\n");
            writer.write(reportText + "\n");
            writer.write("******************************\n");
        }
    }
}
