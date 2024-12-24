ALTER TABLE `t_post`
    ADD COLUMN `summary_html` TEXT NOT NULL COMMENT '摘要（html 格式）' AFTER `summary`;

ALTER TABLE `t_post`
    ADD COLUMN `content_html` MEDIUMTEXT NOT NULL COMMENT '内容（html 格式）' AFTER `content`;

ALTER TABLE `t_post`
    CHANGE COLUMN `content` `content` MEDIUMTEXT NOT NULL COMMENT '内容（原内容）' AFTER `summary_html`;