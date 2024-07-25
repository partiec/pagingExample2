package ru.frolov.pagingexample2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.frolov.pagingexample2.model.Cat;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
}
