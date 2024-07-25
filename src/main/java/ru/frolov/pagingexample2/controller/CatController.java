package ru.frolov.pagingexample2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.frolov.pagingexample2.model.Cat;
import ru.frolov.pagingexample2.server.CatService;

import java.util.List;

@Controller
@RequestMapping("api")
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @GetMapping("allCats")
    public String showAll(Model model) {
        model.addAttribute("allCats", this.catService.findAllCats());
        return "justTable";
    }

    @GetMapping("page/{pageNumber}")
    public String allCats(
            Model model,
            @PathVariable(name = "pageNumber") int pageNumber) {

        Page page = this.catService.getPage(pageNumber);

        List<Cat> pageContent = page.getContent();
        long totalElements = page.getTotalElements();
        long totalPages = page.getTotalPages();

        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("pageContent", pageContent);
        model.addAttribute("totalElements", totalElements);
        model.addAttribute("totalPages", totalPages);

        return "paging";
    }
}
