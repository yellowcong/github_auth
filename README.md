##GITHUBの授权管理

1、用户点击github登录本地应用引导用户跳转到第三方授权页这里就不拐歪了 跳转地址为：

https://github.com/login/oauth/authorize?client_id=xxxxx&state=xxx&redirect_uri=xxxx

    参数说明  :client_id  就不说是啥了吧   redirect_uri：就是上面刚刚填的啦   state:随机字符串（授权成功会原样返回）

2 、授权成功后会回调我们平台，响应信息中会带code其他参数不理他了哈哈，我们带着这个code再次访问github 地址：

https://github.com/login/oauth/access_token?client_id=xxxx&client_secret=xxx&code=xxx&redirect_uri=xxxx

参数不解释了，这次会得到响应的access_token

3、成功获取access_token后用这玩意再去换取用户信息 地址：

https://api.github.com/user?access_token=xxx

之后我们就能得到用户信息了，接下来就可以做想做的事情了

<img src="http://7rf288.com1.z0.glb.clouddn.com/github/github.png"/>