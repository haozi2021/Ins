package com.http.bean;

public class TtUserVo {
    //    @ApiModelProperty(value = "用户ID")
    public Integer id;
    //    @ApiModelProperty(value = "用户标识（email）")
    public String userId;
    //    @ApiModelProperty(value = "用戶類別  1 tiktok 2 facebook 3 ins")
    public Integer userType;//用戶類別  1 tiktok 2 facebook 3 ins
    //    @ApiModelProperty(value = "firstName")
    public String firstName;//用户名
    //    @ApiModelProperty(value = "lastName")
    public String lastName;//用户名
    //    @ApiModelProperty(value = "性别")
    public Integer gender;//性别
    //    @ApiModelProperty(value = "抖音账户ID")
    public String tiktokId;//抖音账户ID
    //    @ApiModelProperty(value = "密码")
    public String pwd;//密码
    //    @ApiModelProperty(value = "登錄時的瀏覽器ua")
    public String ua;//登錄時的瀏覽器ua
    //    @ApiModelProperty(value = "cookie")
    public String cookie;//cookie
    //    @ApiModelProperty(value = "绑定手机好")
    public String phone;//绑定手机好
    //    @ApiModelProperty(value = "账号图片")
    public String img;//账号图片
    //    @ApiModelProperty(value = "账号动图")
    public String img2;//账号动图
    //    @ApiModelProperty(value = "标签ID")
    public Integer tagId;//标签ID
    //    @ApiModelProperty(value = "1正常 2 不能登录")
    public Integer status;//1正常 2 不能登录
    //    @ApiModelProperty(value = "所属商户")
    public Integer merchantId;//所属商户
    //    @ApiModelProperty(value = "简介")
    public String introduction;//简介
    //    @ApiModelProperty(value = "手机设备ID")
    public String phoneId;//手机设备ID
    //    @ApiModelProperty(value = "个人主页")
    public String url;//个人主页
    //    @ApiModelProperty(value = "是否在手机上更新  0未更新  1更新")
    public Integer updateState;//是否在手机上更新  0未更新  1更新
    //    @ApiModelProperty(value = "观看视频数")
    public Integer look;//观看视频数
    //    @ApiModelProperty(value = "点赞数")
    public Integer great;
    //    @ApiModelProperty(value = "评论数")
    public Integer comment;//评论数
    //    @ApiModelProperty(value = "关注数")
    public Integer follow;//关注数
    //    @ApiModelProperty(value = "粉丝数")
    public Integer fans;//粉丝数
    //    @ApiModelProperty(value = "被分享数")
    public Integer link;//被分享数
    //    @ApiModelProperty(value = "视频数量")
    public Integer videos;//视频数量
    //    @ApiModelProperty(value = "賬號區域")
    public Integer area;//賬號區域
    //    @ApiModelProperty(value = "註冊郵箱id")
    public Integer emailId;//註冊郵箱id
    //    @ApiModelProperty(value = "状态 0有效 1无效")
    public Integer isDelete;
    //    @ApiModelProperty(value = "创建时间")
    public String createdTime;//创建时间


}
