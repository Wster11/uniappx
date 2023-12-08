package uts.sdk.modules.emChat;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.unicloud.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.EMConnectionListener;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.chat.EMTextMessageBody;
import com.hyphenate.exceptions.HyphenateException;
import io.dcloud.uts.UTSAndroid;
open class Options (
    @JsonNotNull
    open var appkey: String,
    open var getAppKey: () -> String,
) : UTSObject()
fun initChat(appkey: String): Options {
    val options = EMOptions();
    options.setAppKey(appkey);
    options.setAutoLogin(false);
    console.log(options.getAppKey(), "getappkey", " at uni_modules/em-chat/utssdk/app-android/index.uts:25");
    EMClient.getInstance().init(UTSAndroid.getAppContext(), options);
    EMClient.getInstance().addConnectionListener(ConnectioonListener());
    EMClient.getInstance().chatManager().addMessageListener(MessageListener());
    val getAppKey = fun(): String {
        return options.getAppKey();
    }
    ;
    val res = Options(appkey = options.getAppKey(), getAppKey = getAppKey);
    return res;
}
fun createUser(userId: String, password: String): Unit {
    console.log(userId, password, "createUser params", " at uni_modules/em-chat/utssdk/app-android/index.uts:44");
    CreateAccountThread(userId, password).start();
}
fun loginEM(userId: String, password: String): Unit {
    console.log(userId, password, "login params", " at uni_modules/em-chat/utssdk/app-android/index.uts:52");
    EMClient.getInstance().login(userId, password, LoginEMCallBack());
}
fun logoutEM() {
    EMClient.getInstance().logout(true, LogoutEMCallBack());
}
fun sendTextMessage(msg: String, to: String) {
    val message = EMMessage.createTxtSendMessage(msg, to);
    EMClient.getInstance().chatManager().sendMessage(message);
}
open class LoginEMCallBack : EMCallBack {
    constructor() : super() {}
    override fun onError(params0: Int, params1: String): Unit {
        console.log("login error", params0, params1, " at uni_modules/em-chat/utssdk/app-android/index.uts:84");
    }
    override fun onProgress(params0: Int, params1: String): Unit {
        console.log("login progress", params0, params1, " at uni_modules/em-chat/utssdk/app-android/index.uts:88");
    }
    override fun onSuccess(): Unit {
        console.log("login success", " at uni_modules/em-chat/utssdk/app-android/index.uts:92");
    }
}
open class LogoutEMCallBack : EMCallBack {
    constructor() : super() {}
    override fun onError(params0: Int, params1: String): Unit {
        console.log("logout error", params0, params1, " at uni_modules/em-chat/utssdk/app-android/index.uts:107");
    }
    override fun onSuccess(): Unit {
        console.log("logout success", " at uni_modules/em-chat/utssdk/app-android/index.uts:111");
    }
}
open class ConnectioonListener : EMConnectionListener {
    constructor() : super() {}
    override fun onConnected(): Unit {
        console.log("onConnected 连接成功", " at uni_modules/em-chat/utssdk/app-android/index.uts:126");
    }
    override fun onDisconnected(params0: Int): Unit {
        console.log("onDisconnected 连接断开", params0, " at uni_modules/em-chat/utssdk/app-android/index.uts:130");
    }
}
open class MessageListener : EMMessageListener {
    constructor() : super() {}
    override fun onMessageReceived(messages: MutableList<EMMessage>): Unit {
        console.log("onMessageReceived 收到消息", " at uni_modules/em-chat/utssdk/app-android/index.uts:144");
        messages.map(fun(msg: EMMessage){
            val type = msg.getType();
            val msgBody = msg.getBody();
            console.log("""msgId: ${msg.getMsgId()},msgFrom:${msg.getFrom()},type:${type}""", " at uni_modules/em-chat/utssdk/app-android/index.uts:148");
            if (msgBody is EMTextMessageBody) {
                console.log("""Text Message""", msgBody.getMessage(), " at uni_modules/em-chat/utssdk/app-android/index.uts:150");
            }
        }
        );
    }
}
open class CreateAccountThread : Thread {
    open var userId: String;
    open var password: String;
    constructor(userId: String, password: String) : super() {
        this.userId = userId;
        this.password = password;
    }
    override fun run() {
        try {
            EMClient.getInstance().createAccount(this.userId, this.password);
            console.log("注册成功", " at uni_modules/em-chat/utssdk/app-android/index.uts:172");
        }
         catch (e: Throwable) {
            val err = e as HyphenateException;
            console.log(err.getErrorCode(), err.getDescription(), "注册失败", " at uni_modules/em-chat/utssdk/app-android/index.uts:175");
        }
    }
}
