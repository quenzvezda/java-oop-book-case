package org.quenzvezda;

import org.quenzvezda.repositroy.RepositoryBook;
import org.quenzvezda.service.impl.AuthorServiceImpl;
import org.quenzvezda.service.impl.BookServiceImpl;
import org.quenzvezda.service.impl.PublisherServiceImpl;
import org.quenzvezda.view.MainView;

public class MainApp {
    public static void main(String[] args) {
        RepositoryBook repositoryBook = new RepositoryBook();
        BookServiceImpl bookService = new BookServiceImpl(repositoryBook);
        AuthorServiceImpl authorService = new AuthorServiceImpl(repositoryBook);
        PublisherServiceImpl publisherService = new PublisherServiceImpl(repositoryBook);
        MainView mainView = new MainView(bookService, authorService, publisherService);

        mainView.showMainMenu();
    }
}
