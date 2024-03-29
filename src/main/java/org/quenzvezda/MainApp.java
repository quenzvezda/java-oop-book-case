package org.quenzvezda;

import org.quenzvezda.repositroy.RepositoryBook;
import org.quenzvezda.service.AuthorService;
import org.quenzvezda.service.BookService;
import org.quenzvezda.service.PublisherService;
import org.quenzvezda.view.MainView;

public class MainApp {
    public static void main(String[] args) {
        RepositoryBook repositoryBook = new RepositoryBook();
        BookService bookService = new BookService(repositoryBook);
        AuthorService authorService = new AuthorService(repositoryBook);
        PublisherService publisherService = new PublisherService(repositoryBook);
        MainView mainView = new MainView(bookService, authorService, publisherService);

        mainView.showMainMenu();
    }
}
