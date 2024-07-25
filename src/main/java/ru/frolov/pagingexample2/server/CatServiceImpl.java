package ru.frolov.pagingexample2.server;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.frolov.pagingexample2.CatRepository;
import ru.frolov.pagingexample2.model.Cat;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    @Override
    public List<Cat> findAllCats() {
        return this.catRepository.findAll();
    }

    @Override
    public Page getPage(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber-1, 10);
        return this.catRepository.findAll(pageable);
    }
}
