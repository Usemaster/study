package com.study.controller;

import com.study.pojo.Goods;
import com.study.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/good")

public class GoodController {

    //controller调service层

    @Autowired
    @Qualifier("GoodServiceImpl")
    private GoodService goodService;

    @RequestMapping("/allGood")
    public String list(Model model) {
        List<Goods> list = goodService.queryAllGood();
        model.addAttribute("list", list);
        return "allGood";
    }

    @RequestMapping("/toAddGood")
    public String toAddPaper() {
        return "addGood";
    }

    @RequestMapping("/addGood")
    public String addPaper(Goods goods) {
        System.out.println(goods);
        goodService.addGood(goods);
        return "redirect:/good/allGood";
    }

    @RequestMapping("/toUpdateGood")
    public String toUpdateBook(Model model, int id) {
        Goods goods = goodService.queryGoodById(id);
        System.out.println(goods);
        model.addAttribute("goods", goods);
        return "updateGood";
    }

    @RequestMapping("/updateGood")
    public String updateBook(Model model, Goods good) {
        System.out.println(good);
        goodService.updateGood(good);
        Goods goods = goodService.queryGoodById(good.getId());
        model.addAttribute("goods", goods);
        return "redirect:/good/allGood";
    }

    @RequestMapping("/del/{goodId}")
    public String deleteBook(@PathVariable("goodId") int id) {
        goodService.deleteGoodById(id);
        return "redirect:/good/allGood";
    }

    //查询书籍
    @RequestMapping("/queryGood")
    public String queryBook(String queryBookName,Model model){
        Goods goods = goodService.queryGoodByName(queryBookName);
        List<Goods> list = new ArrayList<Goods>();
        list.add(goods);

        if(goods == null){
            list = goodService.queryAllGood();
            model.addAttribute("error","未查到");
        }

        model.addAttribute("list",list);
        return "allGood";
    }
}
