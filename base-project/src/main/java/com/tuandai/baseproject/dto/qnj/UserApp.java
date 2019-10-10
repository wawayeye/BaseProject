package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 用户手机app
 *
 * @author hujunfei
 * @date 2018-12-13 10:56
 */
public class UserApp {

    /**
     * 应用名称
     */
    @JsonProperty("app_name")
    private String appName;

    /**
     * 安装包名称
     */
    @JsonProperty("package_name")
    private String packageName;

    /**
     * 安装包版本号
     */
    @JsonProperty("version_code")
    private String versionCode;

    /**
     * 版本
     */
    private String appVersion;

    /**
     * 抓取时间
     */
    @JsonProperty("obtain_time")
    private String obtainTime;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getObtainTime() {
        return obtainTime;
    }

    public void setObtainTime(String obtainTime) {
        this.obtainTime = obtainTime;
    }

    @Override
    public String toString() {
        return "UserApp{" +
                "appName='" + appName + '\'' +
                ", packageName='" + packageName + '\'' +
                ", versionCode='" + versionCode + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", obtainTime='" + obtainTime + '\'' +
                '}';
    }
}
