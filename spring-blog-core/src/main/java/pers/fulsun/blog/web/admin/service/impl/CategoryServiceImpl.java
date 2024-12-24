package pers.fulsun.blog.web.admin.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.fulsun.blog.common.constant.BlogConstant;
import pers.fulsun.blog.common.constant.BlogExceptionEnum;
import pers.fulsun.blog.utils.ExceptionUtil;
import pers.fulsun.blog.web.admin.entities.Category;
import pers.fulsun.blog.web.admin.mapper.CategoryMapper;
import pers.fulsun.blog.web.admin.service.CategoryService;
import tk.mybatis.mapper.entity.Example;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public void saveCategory(Category category) {
        Category db = this.getCategoryByName(category.getName().trim());
        if (db != null) {
            ExceptionUtil.throwEx(BlogExceptionEnum.ERROR_CATEGORY_NAME_REPEAT);
        }

        if (StringUtils.isBlank(category.getCoverUrl())) {
            category.setCoverUrl(BlogConstant.DEFAULT_CATEGORY_COVER);
        }
        categoryMapper.insertSelective(category);
    }

    @Override
    public Category getCategoryByName(String name) {
        Example example = new Example(Category.class);
        example.createCriteria().andEqualTo("name", name);
        return categoryMapper.selectOneByExample(example);
    }
}
