package ru.frolov.pagingexample2.server;


import org.springframework.data.domain.Page;
import ru.frolov.pagingexample2.model.Cat;

import java.util.List;


public interface CatService {
    List<Cat> findAllCats();

    Page getPage(int pageNumber);
}
