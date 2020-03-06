package com.zdds.storefront.controllers.pages.product;

import com.zdds.core.bean.ResultDTO;
import com.zdds.core.form.ProductForm;
import com.zdds.core.util.LogUtil;
import com.zdds.core.util.ResultUtil;
import com.zdds.facades.facades.product.OPProductFacade;
import com.zdds.facades.service.product.OPProductService;
import com.zdds.facades.utils.ControllerPageUtil;
import com.zdds.storefront.controllers.pages.AbstractPageController;
import com.zddsop.data.PageResultBean;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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

    @Resource
    private OPProductFacade opProductFacade;

    /**
     * 分页查询商品列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/productInfo")
    @ResponseBody
    public PageResultBean searchOrderInfo(final Model model, final HttpServletRequest request)
    {
        final SearchPageData searchPageData;
        try{
            final PageableData pageableData = ControllerPageUtil.getPageableData(request);
            final Map<String,Object> queryMap = ControllerPageUtil.getRequestParam(request);
            searchPageData = opProductFacade.searchProduct(queryMap,pageableData);
        }catch (Exception e ){
            LogUtil.error(e.getMessage());
            return ControllerPageUtil.getPageResultBean(null, e.toString(), 500);
        }
        return ControllerPageUtil.getPageResultBean(searchPageData, null, 0);
    }

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
