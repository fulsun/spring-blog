package pers.fulsun.blog.web.admin.service;

import pers.fulsun.blog.web.admin.entities.Category;

public interface CategoryService {
    /**
     * 保存分类
     *
     * @param category
     */
    void saveCategory(Category category);

    /**
     * 通过名称获取分类
     *
     * @param name
     * @return
     */
    Category getCategoryByName(String name);

}
