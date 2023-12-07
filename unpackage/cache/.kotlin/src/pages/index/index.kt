package uni.UNI5509411;
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
import io.dcloud.uts.UTSAndroid;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
import uts.sdk.modules.emChat.initChat;
import uts.sdk.modules.emChat.loginEM;
import uts.sdk.modules.emChat.logoutEM;
import uts.sdk.modules.emChat.sendTextMessage;
import uts.sdk.modules.emChat.createUser;
open class GenPagesIndexIndex : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLoad(fun(_: OnLoadOptions) {}, instance);
    }
    @Suppress("UNUSED_PARAMETER")
    override fun `$render`(): VNode? {
        val _ctx = this;
        val _component_button = resolveComponent("button");
        return createElementVNode("view", utsMapOf("class" to "content"), utsArrayOf(
            createElementVNode("image", utsMapOf("class" to "logo", "src" to "/static/logo.png")),
            createElementVNode("view", utsMapOf("class" to "text-area"), utsArrayOf(
                createElementVNode("text", utsMapOf("class" to "title"), toDisplayString(_ctx.title), 1)
            )),
            createElementVNode("view", utsMapOf("class" to "opt-wrap"), utsArrayOf(
                createVNode(_component_button, utsMapOf("type" to "primary", "class" to "btn", "onClick" to _ctx.init), utsMapOf("default" to withCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        " 初始化SDK "
                    );
                }
                ), "_" to 1), 8, utsArrayOf(
                    "onClick"
                )),
                createVNode(_component_button, utsMapOf("class" to "btn", "onClick" to _ctx.createAccount), utsMapOf("default" to withCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        " 注册 "
                    );
                }
                ), "_" to 1), 8, utsArrayOf(
                    "onClick"
                )),
                createVNode(_component_button, utsMapOf("class" to "btn", "onClick" to _ctx.login), utsMapOf("default" to withCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        " 登录 "
                    );
                }
                ), "_" to 1), 8, utsArrayOf(
                    "onClick"
                )),
                createVNode(_component_button, utsMapOf("class" to "btn", "onClick" to _ctx.sendMessage), utsMapOf("default" to withCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        " 发送消息 "
                    );
                }
                ), "_" to 1), 8, utsArrayOf(
                    "onClick"
                )),
                createVNode(_component_button, utsMapOf("type" to "warn", "class" to "btn", "onClick" to _ctx.logout), utsMapOf("default" to withCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        " 登出 "
                    );
                }
                ), "_" to 1), 8, utsArrayOf(
                    "onClick"
                ))
            ))
        ));
    }
    open var title: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("title" to "Eeasemob Android SDK");
    }
    override fun `$initMethods`() {
        this.init = fun() {
            initChat("你自己的环信AppKey");
        }
        ;
        this.createAccount = fun() {
            createUser("uniappx", "123");
        }
        ;
        this.login = fun() {
            loginEM("sttest", "123");
        }
        ;
        this.logout = fun() {
            logoutEM();
        }
        ;
        this.sendMessage = fun() {
            sendTextMessage("你好啊", "yjj");
        }
        ;
    }
    open lateinit var init: () -> Unit;
    open lateinit var createAccount: () -> Unit;
    open lateinit var login: () -> Unit;
    open lateinit var logout: () -> Unit;
    open lateinit var sendMessage: () -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ), utsArrayOf(
                    GenApp.styles
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("content" to padStyleMapOf(utsMapOf("display" to "flex", "alignItems" to "center", "justifyContent" to "center")), "logo" to padStyleMapOf(utsMapOf("height" to "200rpx", "width" to "200rpx", "marginTop" to "200rpx", "marginBottom" to "50rpx")), "opt-wrap" to padStyleMapOf(utsMapOf("width" to "100%")), "title" to padStyleMapOf(utsMapOf("fontSize" to "36rpx", "color" to "#8f8f94")), "btn" to padStyleMapOf(utsMapOf("marginTop" to "20rpx")));
            }
    }
}
