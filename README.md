# 微信公众平台Java SDK  [![Build Status](https://travis-ci.org/usc/wechat-mp-sdk.svg?branch=master)](https://travis-ci.org/usc/wechat-mp-sdk)

## 功能	
完成了[微信公众平台开发者文档](http://mp.weixin.qq.com/wiki/index.php)上面的大部分的功能，“网页授权”和“支付”等功能会在后续添加。

0. Access Token的获取 AccessTokenUtil
1. 上传下载多媒体文件 MediaUtil
2. 发送客服消息 NewsUtil	
	发送客服消息	
	高级群发接口	
3. 用户管理 UserUtil	
     获取用户基本信息	
     获取关注者列表	
     获取用户地理位置	
4.  分组管理接口 GroupUtil	
     创建分组	
     查询所有分组	
     查询用户所在分组	
     修改分组名 【失败】	
     移动用户分组	
5. 自定义菜单 MenuUtil		
     自定义菜单创建接口	
     自定义菜单查询接口	
     自定义菜单删除接口	
     自定义菜单事件推送	
6. 推广支持 QRcodeUtil	
     生成带参数的二维码	    
7. 基础接口 BasicUtil       
     获取微信服务器IP地址    
     长链接转短链接接口      
	 
## 被动相应消息的序列图
<img src="wechat-mp-sdk/src/site/docs/wechat-mp-reply-sd.png?raw=true">

ps. 后续会继续完善文档

welcome fork & star.
