package pers.fulsun.blog.web.admin.service;

import pers.fulsun.blog.common.request.InstallRequest;

public interface InstallService {
    void installApplication(InstallRequest installRequest, String osName, String browserName, String ipAddr);

}
