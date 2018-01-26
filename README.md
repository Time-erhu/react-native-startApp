# react-native-startApp

背景：Android中，检查手机中，是否存在包个APK，当存在的时候，直接打开此APK。

使用方式：

npm install react-native-startapp --save


引入：

import StartApp from 'react-native-startapp'


使用如下：

componentDidMount(){
        this.startAPP();
};


startAPP = async () => {
        try {
            //手机中浏览器包名
            const packageName = 'com.android.browser';
            const isExist = await StartApp.checkAppExist(packageName);
            if (isExist) {
                ToastAndroid.show('APK存在', ToastAndroid.SHORT);
                StartApp.startApp(packageName);
            } else {
                ToastAndroid.show('APK不存在，请下载', ToastAndroid.SHORT);
            }
        } catch (e) {
            ToastAndroid.show('出现异常，help!!!!!SOS!!!!!!', ToastAndroid.SHORT);
        }
};
    
    
