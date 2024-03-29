package org.quenzvezda.view;

import lombok.AllArgsConstructor;
import org.quenzvezda.model.*;
import org.quenzvezda.service.AuthorService;
import org.quenzvezda.service.BookService;
import org.quenzvezda.service.PublisherService;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class MainView {
    private BookService bookService;
    private AuthorService authorService;
    private PublisherService publisherService;

    public void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Main Menu");
            System.out.println("1. Book");
            System.out.println("2. Author");
            System.out.println("3. Publisher");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showBookMenu();
                    break;
                case 2:
                    showAuthorMenu();
                    break;
                case 3:
                    showPublisherMenu();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void showBookMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nBook Menu");
            System.out.println("1. Find the cheapest book");
            System.out.println("2. Find the most expensive book");
            System.out.println("3. Find books by price range");
            System.out.println("4. Find comics by mangaka rating");
            System.out.println("5. Find books by publisher's country");
            System.out.println("6. Find books by author's country");
            System.out.println("7. Find the most expensive comic");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    CommercialBook cheapestBook = bookService.findCheapestBook();
                    System.out.println("Cheapest Book: " + cheapestBook);
                    break;
                case 2:
                    CommercialBook mostExpensiveBook = bookService.findMostExpensiveBook();
                    System.out.println("Most Expensive Book: " + mostExpensiveBook);
                    break;
                case 3:
                    System.out.print("Enter minimum price: ");
                    double minPrice = scanner.nextDouble();
                    System.out.print("Enter maximum price: ");
                    double maxPrice = scanner.nextDouble();
                    List<CommercialBook> booksInRange = bookService.findBooksByPriceRange(minPrice, maxPrice);
                    System.out.println("Books in price range " + minPrice + " - " + maxPrice + ":");
                    booksInRange.forEach(System.out::println);
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("Enter mangaka rating (New Commer, Good, Best Seller): ");
                    String rating = scanner.nextLine();
                    List<Comic> comicsByRating = bookService.findComicsByMangakaRating(rating);
                    System.out.println("Comics with mangaka rating " + rating + ":");
                    comicsByRating.forEach(System.out::println);
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.print("Enter publisher's country (Indonesia, England, United State, Japan): ");
                    String publisherCountry = scanner.nextLine().toUpperCase();
                    List<CommercialBook> booksByPublisherCountry = bookService.findBooksByPublisherCountry(publisherCountry);
                    System.out.println("Books published in " + publisherCountry + ":");
                    booksByPublisherCountry.forEach(System.out::println);
                    break;
                case 6:
                    scanner.nextLine(); // Menangkap newline karakter yang tersisa
                    System.out.print("Enter author's country (Indonesia, England, United State, Japan): ");
                    String authorCountry = scanner.nextLine().toUpperCase();
                    List<CommercialBook> booksByAuthorCountry = bookService.findBooksByAuthorCountry(authorCountry);
                    System.out.println("Books with authors from " + authorCountry + ":");
                    booksByAuthorCountry.forEach(System.out::println);
                    break;
                case 7:
                    Comic mostExpensiveComic = bookService.findMostExpensiveComic();
                    System.out.println("Most Expensive Comic: " + mostExpensiveComic);
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void showAuthorMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nAuthor Menu");
            System.out.println("1. Find all Mangaka");
            System.out.println("2. Find all Authors");
            System.out.println("3. Find all Novelists");
            System.out.println("4. Find authors by age range");
            System.out.println("5. Find authors by country");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    List<Mangaka> allMangaka = authorService.findAllMangaka();
                    System.out.println("All Mangaka:");
                    allMangaka.forEach(System.out::println);
                    break;
                case 2:
                    List<Author> allAuthors = authorService.findAllAuthors();
                    System.out.println("All Authors:");
                    allAuthors.forEach(System.out::println);
                    break;
                case 3:
                    List<Novelis> allNovelists = authorService.findAllNovelists();
                    System.out.println("All Novelists:");
                    allNovelists.forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Enter minimum age: ");
                    int minAge = scanner.nextInt();
                    System.out.print("Enter maximum age: ");
                    int maxAge = scanner.nextInt();
                    List<Author> authorsByAgeRange = authorService.findAuthorsByAgeRange(minAge, maxAge);
                    System.out.println("Authors in age range " + minAge + " - " + maxAge + ":");
                    authorsByAgeRange.forEach(System.out::println);
                    break;
                case 5:
                    scanner.nextLine(); // Menangkap newline karakter yang tersisa
                    System.out.print("Enter author's country (Indonesia, England, United State, Japan): ");
                    String authorCountry = scanner.nextLine().toUpperCase();
                    List<Author> authorsByCountry = authorService.findAuthorsByCountry(authorCountry);
                    System.out.println("Authors from " + authorCountry + ":");
                    authorsByCountry.forEach(System.out::println);
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void showPublisherMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nPublisher Menu");
            System.out.println("1. Find publisher with the highest production cost");
            System.out.println("2. Find publisher with the lowest production cost");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Publisher highestCostPublisher = publisherService.findPublisherWithHighestProductionCost();
                    System.out.println("Publisher with the highest production cost: " + highestCostPublisher);
                    break;
                case 2:
                    Publisher lowestCostPublisher = publisherService.findPublisherWithLowestProductionCost();
                    System.out.println("Publisher with the lowest production cost: " + lowestCostPublisher);
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

}
