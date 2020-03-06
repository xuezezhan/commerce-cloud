package com.zdds.storefront.controllers.pages.consignment;

import com.zdds.core.util.LogUtil;
import com.zdds.facades.facades.consignment.OPConsignmentFacade;
import com.zdds.facades.utils.ControllerPageUtil;
import com.zdds.storefront.controllers.ControllerConstants;
import com.zdds.storefront.controllers.pages.AbstractPageController;
import com.zddsop.data.OPConsignmentData;
import com.zddsop.data.PageResultBean;
import de.hybris.platform.acceleratorstorefrontcommons.annotations.RequireHardLogIn;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/consignment")
public class ConsignmentManagerPageController  extends AbstractPageController {

    @Resource(name="opConsignmentFacade")
    private OPConsignmentFacade opConsignmentFacade;
    /**
     * 分页查询发货单
     * @param request
     * @return
     */
    @RequestMapping(value = "/consignmentInfo")
    @ResponseBody
    public PageResultBean searchOrderInfo(final Model model, final HttpServletRequest request)
    {
        final SearchPageData searchPageData;
        try{
            final PageableData pageableData = ControllerPageUtil.getPageableData(request);
            final Map<String,Object> queryMap = ControllerPageUtil.getRequestParam(request);
            searchPageData = opConsignmentFacade.searchConsignment(queryMap,pageableData);
        }catch (Exception e ){
            LogUtil.error(e.getMessage());
            return ControllerPageUtil.getPageResultBean(null, e.toString(), 500);
        }
        return ControllerPageUtil.getPageResultBean(searchPageData, null, 0);
    }

    /**
     * 获取发货单详情页信息
     * @param pk
     * @param model
     * @return
     */
    @RequestMapping(value = "/consignmentDetail", method = RequestMethod.POST)
    public String searchOrderInfoForPk(@RequestParam(value = "pk") final String pk, final Model model)
    {
        final OPConsignmentData opConsignmentData = opConsignmentFacade.searchConsignmentInfoForPk(pk);
        model.addAttribute("opConsignmentData", opConsignmentData);
        return  ControllerConstants.Views.Fragments.Consignment.CONSIGNMENT_DATA;
    }
}
