import java.util.Scanner;

public class MovieDriver extends Movie {
	
public static void main(String [] args)  {
	String playAgain;
	Scanner input = new Scanner(System.in);
	Movie movie = new Movie();
	do {
	System.out.println("Please enter the title of the movie: ");
	String title = input.nextLine();
	movie.setTitle(title);
	System.out.println("Enter the movie's rating: ");
	String rating = input.nextLine();
	movie.setRating(rating);
	System.out.println("Enter the number of tickets sold for this movie: ");
	int numTickets = input.nextInt();
	movie.setSoldTickets(numTickets);
	System.out.println(movie.toString());
	input.nextLine();
	System.out.println("Do you want to enter another movie? (y or n)");
	playAgain = input.nextLine();
	}while(playAgain.charAt(0) == 'y');
	System.out.println("Goodbye");
	input.close();
}

}
