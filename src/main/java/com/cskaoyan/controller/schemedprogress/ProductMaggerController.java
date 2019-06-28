package com.cskaoyan.controller.schemedprogress;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.schemedprogress.OrderMangger;
import com.cskaoyan.bean.schemedprogress.ProductMagger;
import com.cskaoyan.service.schemedprogress.OrderService;
import com.cskaoyan.service.schemedprogress.ProductMaggerService;
import com.cskaoyan.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductMaggerController {

    @Autowired
    ProductMaggerService productMaggerService;

    @Autowired
    HttpSession session;

    @RequestMapping("list")
    @ResponseBody
    public ProductMagger getOrderList(String page, String rows){
        ProductMagger productMagger = productMaggerService.selectProducrsByPage(page, rows);
        return productMagger;
    }

    @RequestMapping("find")
    public ModelAndView getList(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/product_list.jsp");
        String[] sysPermissionList = {"product:add","product:edit","product:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        return modelAndView;
    }

    @RequestMapping("get/{pid}")
    @ResponseBody
    public Product getProductById(@PathVariable("pid") String pid){
        Product product = productMaggerService.getProductById(pid);
        return product;

    }

    @RequestMapping("add_judge")
    @ResponseBody
    public String add(){
        return "";
    }

    @RequestMapping("add")
    public ModelAndView add(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/product_add.jsp");
        return modelAndView;
    }

    @RequestMapping("insert")
    @ResponseBody
    public ResponseVo insertOrder(Product product) {
        int status = productMaggerService.insert(product);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }


    @RequestMapping("delete_judge")
    @ResponseBody
    public String delete_judge(){
        return "";
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseVo delete_batch(String[] ids){
        int status = productMaggerService.delete_batch(ids);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }

    @RequestMapping("search_product_by_productId")
    @ResponseBody
    public List<Product> search_product_by_productId(String searchValue, String page, String rows){
        List<Product> products = productMaggerService.search_custom_by_productId(searchValue, page, rows);
        return products;
    }

    @RequestMapping("search_product_by_productName")
    @ResponseBody
    public List<Product> search_product_by_productName(String searchValue, String page, String rows){
        List<Product> products = productMaggerService.search_product_by_productName(searchValue, page, rows);
        return products;
    }

    @RequestMapping("search_product_by_productType")
    @ResponseBody
    public List<Product> search_product_by_productType(String searchValue, String page, String rows){
        List<Product> products = productMaggerService.search_product_by_productType(searchValue, page, rows);
        return products;
    }

    @RequestMapping("edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "{}";
    }

    @RequestMapping("edit")
    public ModelAndView edit(ModelAndView modelAndView){
        modelAndView.setViewName("/WEB-INF/jsp/product_edit.jsp");
        return modelAndView;
    }

    @RequestMapping("update_all")
    @ResponseBody
    public ResponseVo update_all(Product product){
        int status = productMaggerService.update(product);
        ResponseVo<Object> responseVo = new ResponseVo<>();
        if (status == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("操作失败！请联系管理员！");
        }
        return responseVo;
    }
}
