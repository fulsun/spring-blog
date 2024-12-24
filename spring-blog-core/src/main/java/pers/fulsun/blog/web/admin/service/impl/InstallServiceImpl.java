package pers.fulsun.blog.web.admin.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import pers.fulsun.blog.common.constant.BlogConstant;
import pers.fulsun.blog.common.constant.BlogExceptionEnum;
import pers.fulsun.blog.common.constant.ConfigEnum;
import pers.fulsun.blog.common.request.InstallRequest;
import pers.fulsun.blog.config.BlogConfig;
import pers.fulsun.blog.utils.DateUtil;
import pers.fulsun.blog.utils.ExceptionUtil;
import pers.fulsun.blog.utils.MarkdownUtil;
import pers.fulsun.blog.web.admin.entities.Category;
import pers.fulsun.blog.web.admin.entities.Config;
import pers.fulsun.blog.web.admin.entities.FriendLink;
import pers.fulsun.blog.web.admin.entities.Post;
import pers.fulsun.blog.web.admin.entities.User;
import pers.fulsun.blog.web.admin.service.CategoryService;
import pers.fulsun.blog.web.admin.service.ConfigService;
import pers.fulsun.blog.web.admin.service.FriendLinkService;
import pers.fulsun.blog.web.admin.service.InstallService;
import pers.fulsun.blog.web.admin.service.PostService;
import pers.fulsun.blog.web.admin.service.UserExtendService;
import pers.fulsun.blog.web.admin.service.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InstallServiceImpl implements InstallService {

    @Autowired
    private UserService userService;
    @Autowired
    private UserExtendService userExtendService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private FriendLinkService friendLinkService;
    @Autowired
    private PostService postService;
    @Autowired
    private ConfigService configService;

    @Autowired
    private BlogConfig blogConfig;

    @Override
    public void installApplication(InstallRequest request, String osName, String browser, String ipAddress) {
        // 1. 创建管理员(博主)
        User user = this.createBlogger(request.getUsername(), request.getPassword(), request.getNickname(), request.getEmail());
        // 2. 创建默认分类
        Category category = this.createDefaultCategory();
        //  3. 创建默认文章
        Post post = this.createFirstPost(user, category);
        //  4. 创建友链
        this.createFriendLink();
        // 5. 初始化全局配置
        this.initConfig(user, request.getBlogName(), request.getHomePage(), request.getDescription());

    }

    private void initConfig(User user, String blogName, String homePage, String description) {
        ConfigEnum[] values = ConfigEnum.values();
        List<Config> configList = new ArrayList<>(values.length);
        for (ConfigEnum configEnum : values) {
            Config config = new Config();
            config.setConfigKey(configEnum.getName())
                    .setConfigValue(configEnum.getValue())
                    .setRemark(configEnum.getRemark())
                    .setCreateTime(LocalDateTime.now())
                    .setUpdateTime(config.getCreateTime());

            if (config.getConfigKey().equals(ConfigEnum.IS_INSTALLED.getName())) {
                config.setConfigValue("1");
            }

            if (config.getConfigKey().equals(ConfigEnum.INSTALL_TIME.getName())) {
                config.setConfigValue(DateUtil.ldtToStr(LocalDateTime.now()));
            }

            if (config.getConfigKey().equals(ConfigEnum.BLOG_NAME.getName())) {
                config.setConfigValue(blogName);
            }

            if (config.getConfigKey().equals(ConfigEnum.HOME_PAGE.getName())) {
                config.setConfigValue(homePage);
            }

            if (config.getConfigKey().equals(ConfigEnum.DESCRIPTION.getName())) {
                config.setConfigValue(description);
            }

            if (config.getConfigKey().equals(ConfigEnum.EMAIL.getName())) {
                config.setConfigValue(user.getEmail());
            }

            if (config.getConfigKey().equals(ConfigEnum.BLOG_AUTHOR.getName())) {
                config.setConfigValue(user.getNickname());
            }

            if (config.getConfigKey().equals(ConfigEnum.BACKUP_DIR.getName())) {
                config.setConfigValue(this.blogConfig.getAttachmentDir());
            }

            if (config.getConfigKey().equals(ConfigEnum.LOCAL_FILE_PATH.getName())) {
                // 与 SpringMvcConfig 类中配置的 addResourceHandlers 保持一致
                config.setConfigValue(this.blogConfig.getAttachmentDir());
            }

            configList.add(config);
        }

        this.configService.saveConfigBatch(configList);
    }

    private void createFriendLink() {
        FriendLink friendLink = new FriendLink();
        friendLink.setTitle("java极客")
                .setAuthor("fulsun")
                .setHomeUrl("https://fulsun.github.io")
                .setBackgroundColor("#34495E")
                .setSort(1)
                .setRemark("技术博客");
        this.friendLinkService.saveFriendLink(friendLink);
    }


    private Post createFirstPost(User user, Category category) {

        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonth().getValue();
        int day = now.getDayOfMonth();

        Post post = new Post();
        post.setTitle("第一篇文章")
                .setSummaryHtml("")
                .setContent("""
                        ```java
                        public static void main(String[] args) {
                            System.out.println("Hello World");
                        }
                        ```""")
                .setContentHtml(MarkdownUtil.md2html(post.getContent()))
                .setAuthor(user.getNickname())
                .setPublishDate(DateUtil.ldToStr(now))
                .setCoverUrl(BlogConstant.DEFAULT_POST_COVER)
                .setIsPublish(1)
                .setIsComment(1)
                .setCategoryId(category.getId())
                .setYear(year + "")
                .setMonth(DateUtil.fillTime(month))
                .setDay(DateUtil.fillTime(day))
                .setLink(year + "/" + month + "/" + day + "/" + StringUtils.replace(post.getTitle(), " ", "-") + "/")
                .setCommentNum(1L);

        this.postService.savePost(post);

        return post;
    }

    public Category createDefaultCategory() {
        Category category = new Category();
        category.setName("默认")
                .setCoverUrl(BlogConstant.DEFAULT_CATEGORY_COVER)
                .setState(1)
                .setSort(99)
                .setRemark("默认分类");

        this.categoryService.saveCategory(category);

        return category;
    }

    private User createBlogger(String username, String password, String nickname, String email) {
        int userNum = this.userService.getUserNum();
        if (userNum > 0) {
            ExceptionUtil.throwEx(BlogExceptionEnum.ERROR_HAVE_INSTALLED);
        }

        User user = new User();
        user.setUsername(username)
                .setPassword(DigestUtils.md5DigestAsHex(password.getBytes()))
                .setNickname(StringUtils.isNoneBlank(nickname) ? nickname : "博主")
                .setEmail(StringUtils.isNoneBlank(email) ? email : "")
                .setAvatar(BlogConstant.DEFAULT_AVATAR)
                .setState(1) // 状态为正常
                .setRole(1); // 角色为博主

        this.userService.saveUser(user);

        this.userExtendService.saveUserExtend(user.getId(), "懒人一枚~~");

        return user;
    }
}
;