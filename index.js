var StartApp = require('react-native').NativeModules.StartApp;
module.exports={
    checkAppExist: function(packageName) {
        return StartApp.checkAppExist(packageName);
    },

    startApp: function(packageName) {
        return StartApp.startApp(packageName);
    },
}
