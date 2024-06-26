package org.example.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.example.blog.model.Blog;
import org.example.blog.service.BlogService;
import org.example.blog.service.CategoryService;

@Controller
@RequestMapping("/blog")
public class BlogController {
    // Constants
    private final String EL_NAME = "blog";
    private final String LIST_PAGE = EL_NAME + "/list";
    private final String LIST_PAGE_2 = EL_NAME + "/list_2";
    private final String CREATE_PAGE = EL_NAME + "/create";
    private final String EDIT_PAGE = EL_NAME + "/edit";
    private final String DELETE_PAGE = EL_NAME + "/delete";
    private final String VIEW_PAGE = EL_NAME + "/view";
    private final String REDIRECT_TO_LIST = "redirect:/" + EL_NAME;

    private final String LIST_MSG = "Total of " + EL_NAME + ": ";
    private final String CREATE_MSG = "Create new " + EL_NAME + " successfully.";
    private final String EDIT_MSG = "Update the " + EL_NAME + " successfully.";
    private final String DELETE_MSG = "Delete the " + EL_NAME + " successfully.";
    private final String DELETE_MANY_MSG = "Delete the selected " + EL_NAME + "(s) successfully.";

    @ModelAttribute
    public void getCommonAttributes(Model model){

    }

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

//    show all blog
//    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public Page<Blog> findAllBlog(@RequestParam("search") String search, @PageableDefault(value = 5) Pageable pageable) {
//        if ("".equals(search)) {
//            return blogService.findAll(pageable);
//        } else {
//            return blogService.findByTitle(pageable, search);
//        }
//    }

    @GetMapping
    public ModelAndView getListPage(@RequestParam(value = "search", defaultValue = "") String search, @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE_2);
        if ("".equals(search)) {
            modelAndView.addObject("eList", blogService.findAll(pageable));
        } else {
            modelAndView.addObject("eList", blogService.findByTitle(pageable, search));
        }
        modelAndView.addObject("search", search);
        modelAndView.addObject("msg", LIST_MSG + "N/A");
        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView getCreatePage() {
        ModelAndView modelAndView = new ModelAndView(CREATE_PAGE);
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("cateList", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView getCreated(@ModelAttribute Blog el, Pageable pageable) {
        blogService.save(el);
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE_2);
        modelAndView.addObject("eList", blogService.findAll(pageable));
        modelAndView.addObject("msg", CREATE_MSG);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditPage(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView(EDIT_PAGE);
        modelAndView.addObject("blog", blogService.findById(id));
        modelAndView.addObject("cateList", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView getEdited(@ModelAttribute Blog el, Pageable pageable) {
        blogService.save(el);
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE_2);
        modelAndView.addObject("eList", blogService.findAll(pageable));
        modelAndView.addObject("msg", EDIT_MSG);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView getViewPage(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);
        modelAndView.addObject("blog", blogService.findById(id));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView getDeletePage(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView(DELETE_PAGE);
        modelAndView.addObject("blog", blogService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView getDeleted(@ModelAttribute Blog el, Pageable pageable) {
        blogService.remove(el.getId());
        ModelAndView modelAndView = new ModelAndView(LIST_PAGE_2);
        modelAndView.addObject("eList", blogService.findAll(pageable));
        modelAndView.addObject("msg", DELETE_MSG);
        return modelAndView;
    }

}
