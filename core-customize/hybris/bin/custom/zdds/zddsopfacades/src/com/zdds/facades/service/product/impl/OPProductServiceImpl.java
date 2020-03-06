package com.zdds.facades.service.product.impl;

import com.zdds.core.form.ProductForm;
import com.zdds.core.util.LogUtil;
import com.zdds.facades.service.product.OPProductService;
import de.hybris.platform.commerceservices.search.flexiblesearch.PagedFlexibleSearchService;
import de.hybris.platform.commerceservices.search.pagedata.PageableData;
import de.hybris.platform.commerceservices.search.pagedata.SearchPageData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 20:34 2020/3/5
 * @since JDK 11
 */
@Service(value = "opProductService")
public class OPProductServiceImpl implements OPProductService {

    @Resource
    private ModelService modelService;

    @Resource
    private PagedFlexibleSearchService pagedFlexibleSearchService;

    @Resource
    private UserService userService;

    @Override
    public Boolean saveOrSubmitProduct(ProductForm productForm) {
        try {
            ProductModel productModel = this.modelService.create(ProductModel.class);
            productModel.setName(productForm.getName());
            this.modelService.save(productModel);
            return Boolean.TRUE;
        }catch (Exception e){
            LogUtil.error(e.getMessage());
            return Boolean.FALSE;
        }
    }

    @Override
    public SearchPageData searchProduct(Map<String, Object> params, PageableData pageableData) {
        final StringBuilder sql = new StringBuilder("select {p.pk} from {Product as p join CatalogVersion AS cv on {cv.pk}={p.catalogVersion} ");
        final Map<String, Object> queryParams = new HashMap<>();
        final StringBuilder conditionSql = new StringBuilder("} where 1=1 and {p.supplier}= '"+userService.getCurrentUser().getPk().getLongValueAsString()+"' ");
        conditionSql.append(" and {cv.version} ='Online' ");


        if(params.get("name")!=null){
            conditionSql.append(" and {p.name[zh]} like ?name ");
            queryParams.put("name", "%"+params.get("name")+"%");
        }
        if(params.get("code")!=null){
            conditionSql.append(" and {p.code} like ?code ");
            queryParams.put("code", "%"+params.get("code")+"%");
        }
        if(params.get("approvalStatus")!=null){
            sql.append(" join ArticleApprovalStatus AS s on {s.pk}={p.approvalStatus} ");
            conditionSql.append(" and {s.code} =?approvalStatus ");
            queryParams.put("approvalStatus", params.get("approvalStatus"));
        }
        if(params.get("checkStatus")!=null){
            sql.append(" join CheckStatus AS cs on {cs.pk}={p.checkStatus} ");
            conditionSql.append(" and {cs.code} =?checkStatus ");
            queryParams.put("checkStatus", params.get("checkStatus"));
        }


        sql.append(conditionSql).append(" order by {p.creationtime} desc");

        try{
            return pagedFlexibleSearchService.search(sql.toString(), queryParams, pageableData);
        }catch (Exception e){
            LogUtil.error(e.getMessage(),e);
            return null;
        }
    }
}
