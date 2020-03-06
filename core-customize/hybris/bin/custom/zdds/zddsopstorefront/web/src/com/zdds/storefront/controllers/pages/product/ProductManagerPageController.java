package com.zdds.storefront.controllers.pages.product;

import com.zdds.core.bean.ResultDTO;
import com.zdds.core.form.ProductForm;
import com.zdds.core.util.ResultUtil;
import com.zdds.facades.service.product.OPProductService;
import com.zdds.storefront.controllers.pages.AbstractPageController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 17:11 2020/3/5
 * @since JDK 11
 */
@Controller
@RequestMapping("/product")
public class ProductManagerPageController extends AbstractPageController {

    @Resource
    private OPProductService opProductService;

    /**
     * 保存或者提交新增商品
     */
    @ResponseBody
    @RequestMapping(value = "/save-submit-product", method = RequestMethod.POST)
    public ResultDTO saveOrSubmitProduct(@RequestBody ProductForm productForm)
    {
        try {
            Boolean flag = opProductService.saveOrSubmitProduct(productForm);
            if(flag){
                return ResultUtil.success();
            }else{
                return ResultUtil.fail("数据保存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.fail(e.getMessage());
        }
    }
}
