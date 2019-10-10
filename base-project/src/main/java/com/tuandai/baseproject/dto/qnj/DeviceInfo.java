package com.tuandai.baseproject.dto.qnj;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 设备信息
 *
 * @author hujunfei
 * @date 2018-11-30 15:12
 */
public class DeviceInfo {

    /**
     * 设备标识
     */
    @JsonProperty("device_id")
    private String deviceId;

    /**
     * iOS设备专用（同时受App Store影响可能缺失）IDFA标识 BAFA623B-A87F-4F69-85C8-52F76F1464BF
     */
    private String idfa;

    /**
     * identifierForVendor
     */
    private String idfv;

    /**
     * 设备名称 iPhone 6 Plus
     */
    @JsonProperty("device_info")
    private String deviceInfo;

    /**
     * 设备类型 iOS
     */
    @JsonProperty("os_type")
    private String osType;

    /**
     * 系统版本号 9.300000
     */
    @JsonProperty("os_version")
    private String osVersion;

    /**
     * 最后登录时间 1476692044
     */
    @JsonProperty("last_login_time")
    private String lastLoginTime;

    /**
     * 经度 121.5103238932292
     */
    @JsonProperty("gps_longitude")
    private String gpsLongitude;

    /**
     * 纬度 31.30658718532986
     */
    @JsonProperty("gps_latitude")
    private String gpsLatitude;

    /**
     * 具体地址 上海市杨浦区政学路靠近金芭蕾舞蹈(五角场店)
     */
    @JsonProperty("gps_address")
    private String gpsAddress;

    /**
     * 登录设备IP地址 127.0.0.1
     */
    private String ip;

    /**
     * 内存容量
     */
    private String memory;

    /**
     * 总内部存储
     */
    private String storage;

    /**
     * 可使用内部存储
     */
    @JsonProperty("unuse_storage")
    private String unuseStorage;

    /**
     * 是否使用 wifi
     */
    private String wifi;

    /**
     * wifi 名称
     */
    @JsonProperty("wifi_name")
    private String wifiName;

    /**
     * 电量
     */
    private String bettary;

    /**
     * 运营商
     */
    private String carrier;

    /**
     * 运营商编码
     */
    @JsonProperty("tele_num")
    private String teleNum;

    /**
     * 渠道
     */
    @JsonProperty("app_market")
    private String appMarket;

    /**
     * 是否 ROOT 或越狱
     */
    @JsonProperty("is_root")
    private String isRoot;

    /**
     * DNS
     */
    private String dns;

    /**
     * 是否为模拟器
     */
    @JsonProperty("is_simulator")
    private String isSimulator;

    /**
     * 图片数量
     */
    @JsonProperty("pic_count")
    private String picCount;

    /**
     * android_id
     */
    @JsonProperty("android_id")
    private String androidId;

    /**
     * 设备的唯一设备识别符
     */
    private String udid;

    /**
     * 设备标识符UUID
     */
    private String uuid;

    /**
     * 国际移动用户识别码
     */
    private String imsi;

    /**
     * MAC地址
     */
    private String mac;

    /**
     * 内存卡容量
     */
    private String sdcard;

    /**
     * 已经使用容量
     */
    @JsonProperty("unuse_sdcard")
    private String unuseSdcard;

    /**
     * imei
     */
    private String imei;

    /**
     * app 列表
     */
    @JsonProperty("app_list")
    private List<UserApp> appList;

    /**
     * 本地通话记录
     */
    @JsonProperty("call_history")
    private List<LocalContact> callHistory;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getIdfv() {
        return idfv;
    }

    public void setIdfv(String idfv) {
        this.idfv = idfv;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(String gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public String getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(String gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public String getGpsAddress() {
        return gpsAddress;
    }

    public void setGpsAddress(String gpsAddress) {
        this.gpsAddress = gpsAddress;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getUnuseStorage() {
        return unuseStorage;
    }

    public void setUnuseStorage(String unuseStorage) {
        this.unuseStorage = unuseStorage;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getWifiName() {
        return wifiName;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName;
    }

    public String getBettary() {
        return bettary;
    }

    public void setBettary(String bettary) {
        this.bettary = bettary;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getTeleNum() {
        return teleNum;
    }

    public void setTeleNum(String teleNum) {
        this.teleNum = teleNum;
    }

    public String getAppMarket() {
        return appMarket;
    }

    public void setAppMarket(String appMarket) {
        this.appMarket = appMarket;
    }

    public String getIsRoot() {
        return isRoot;
    }

    public void setIsRoot(String isRoot) {
        this.isRoot = isRoot;
    }

    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }

    public String getIsSimulator() {
        return isSimulator;
    }

    public void setIsSimulator(String isSimulator) {
        this.isSimulator = isSimulator;
    }

    public String getPicCount() {
        return picCount;
    }

    public void setPicCount(String picCount) {
        this.picCount = picCount;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getSdcard() {
        return sdcard;
    }

    public void setSdcard(String sdcard) {
        this.sdcard = sdcard;
    }

    public String getUnuseSdcard() {
        return unuseSdcard;
    }

    public void setUnuseSdcard(String unuseSdcard) {
        this.unuseSdcard = unuseSdcard;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public List<UserApp> getAppList() {
        return appList;
    }

    public void setAppList(List<UserApp> appList) {
        this.appList = appList;
    }

    public List<LocalContact> getCallHistory() {
        return callHistory;
    }

    public void setCallHistory(List<LocalContact> callHistory) {
        this.callHistory = callHistory;
    }

    @Override
    public String toString() {
        return "DeviceInfo{" +
                "deviceId='" + deviceId + '\'' +
                ", idfa='" + idfa + '\'' +
                ", idfv='" + idfv + '\'' +
                ", deviceInfo='" + deviceInfo + '\'' +
                ", osType='" + osType + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", gpsLongitude='" + gpsLongitude + '\'' +
                ", gpsLatitude='" + gpsLatitude + '\'' +
                ", gpsAddress='" + gpsAddress + '\'' +
                ", ip='" + ip + '\'' +
                ", memory='" + memory + '\'' +
                ", storage='" + storage + '\'' +
                ", unuseStorage='" + unuseStorage + '\'' +
                ", wifi='" + wifi + '\'' +
                ", wifiName='" + wifiName + '\'' +
                ", bettary='" + bettary + '\'' +
                ", carrier='" + carrier + '\'' +
                ", teleNum='" + teleNum + '\'' +
                ", appMarket='" + appMarket + '\'' +
                ", isRoot='" + isRoot + '\'' +
                ", dns='" + dns + '\'' +
                ", isSimulator='" + isSimulator + '\'' +
                ", picCount='" + picCount + '\'' +
                ", androidId='" + androidId + '\'' +
                ", udid='" + udid + '\'' +
                ", uuid='" + uuid + '\'' +
                ", imsi='" + imsi + '\'' +
                ", mac='" + mac + '\'' +
                ", sdcard='" + sdcard + '\'' +
                ", unuseSdcard='" + unuseSdcard + '\'' +
                ", imei='" + imei + '\'' +
                ", appList=" + appList +
                ", callHistory=" + callHistory +
                '}';
    }
}
