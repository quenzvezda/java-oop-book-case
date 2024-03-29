package org.quenzvezda;

import org.quenzvezda.model.Author;
import org.quenzvezda.model.Mangaka;
import org.quenzvezda.model.Novelis;
import org.quenzvezda.repositroy.RepositoryBook;

public class Main {
    public static void main(String[] args) {
        RepositoryBook books = new RepositoryBook();

        System.out.println(books.getAllBooks().toString());
    }
}