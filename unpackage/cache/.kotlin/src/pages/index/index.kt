package uni.HBuilder;
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
import io.dcloud.uniapp.extapi.createWebviewContext as uni_createWebviewContext;
import io.dcloud.uniapp.extapi.showModal as uni_showModal;
open class GenPagesIndexIndex : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onReady(fun() {
            this.webviewContext = uni_createWebviewContext("web-view", this);
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER")
    override fun `$render`(): VNode? {
        val _ctx = this;
        val _component_button = resolveComponent("button");
        return createElementVNode("view", utsMapOf("class" to "uni-flex-item"), utsArrayOf(
            createElementVNode("web-view", utsMapOf("id" to "web-view", "class" to "uni-flex-wv", "src" to _ctx.src, "webview-styles" to _ctx.webview_styles, "onMessage" to _ctx.message, "onError" to _ctx.error, "onLoading" to _ctx.loading, "onLoaded" to _ctx.loaded, "onDownload" to _ctx.download), null, 40, utsArrayOf(
                "src",
                "webview-styles",
                "onMessage",
                "onError",
                "onLoading",
                "onLoaded",
                "onDownload"
            )),
            createElementVNode("view", utsMapOf("class" to "uni-padding-wrap uni-common-mt"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "uni-input-v"), utsArrayOf(
                    createElementVNode("input", utsMapOf("class" to "uni-input", "confirmType" to "go", "placeholder" to "输入网址跳转", "onConfirm" to _ctx.confirm), null, 40, utsArrayOf(
                        "onConfirm"
                    ))
                )),
                createElementVNode("view", utsMapOf("class" to "uni-row uni-btn-v"), utsArrayOf(
                    createVNode(_component_button, utsMapOf("class" to "uni-flex-item", "type" to "primary", "onClick" to _ctx.back), utsMapOf("default" to withCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            "后退"
                        );
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "onClick"
                    )),
                    createVNode(_component_button, utsMapOf("class" to "uni-btn-ml uni-flex-item", "type" to "primary", "onClick" to _ctx.forward), utsMapOf("default" to withCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            "前进"
                        );
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "onClick"
                    ))
                )),
                createElementVNode("view", utsMapOf("class" to "uni-row uni-btn-v"), utsArrayOf(
                    createVNode(_component_button, utsMapOf("class" to "uni-flex-item", "type" to "primary", "onClick" to _ctx.reload), utsMapOf("default" to withCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            "重新加载"
                        );
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "onClick"
                    )),
                    createVNode(_component_button, utsMapOf("class" to "uni-btn-ml uni-flex-item", "type" to "primary", "onClick" to _ctx.stop), utsMapOf("default" to withCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            "停止加载"
                        );
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "onClick"
                    ))
                )),
                createElementVNode("view", utsMapOf("class" to "uni-btn-v"), utsArrayOf(
                    createVNode(_component_button, utsMapOf("type" to "primary", "onClick" to _ctx.nativeToWeb), utsMapOf("default" to withCtx(fun(): UTSArray<Any> {
                        return utsArrayOf(
                            "原生和Web通信"
                        );
                    }
                    ), "_" to 1), 8, utsArrayOf(
                        "onClick"
                    ))
                ))
            ))
        ));
    }
    open var src: String by `$data`;
    open var webview_styles: UTSJSONObject by `$data`;
    open var webviewContext: WebviewContext? by `$data`;
    open var loadError: Boolean by `$data`;
    open var conn: Any? by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("src" to "../static/index.html", "webview_styles" to object : UTSJSONObject() {
            var progress = object : UTSJSONObject() {
                var color = "#FF3333"
            }
        }, "webviewContext" to null as WebviewContext?, "loadError" to false, "conn" to null);
    }
    override fun `$initMethods`() {
        this.back = fun() {
            this.webviewContext?.back();
        }
        ;
        this.forward = fun() {
            this.webviewContext?.forward();
        }
        ;
        this.reload = fun() {
            this.webviewContext?.reload();
        }
        ;
        this.stop = fun() {
            this.webviewContext?.stop();
        }
        ;
        this.nativeToWeb = fun() {
            this.webviewContext?.evalJS("alert('hello uni-app x')");
        }
        ;
        this.message = fun(event: WebViewMessageEvent) {
            if (event.detail.data !== null) {
                val data = event.detail.data;
                val websdk: Any = data?.get("websdk") as Any;
                this.initSdk(websdk);
            }
        }
        ;
        this.initSdk = fun(sdk: Any) {
            console.log((sdk as Web).connection, "sdk", " at pages/index/index.uvue:74");
        }
        ;
        this.error = fun(event: WebViewErrorEvent) {
            this.loadError = true;
            console.log(JSON.stringify(event), " at pages/index/index.uvue:78");
        }
        ;
        this.loading = fun(event: WebViewLoadingEvent) {
            console.log(JSON.stringify(event), " at pages/index/index.uvue:81");
        }
        ;
        this.loaded = fun(event: WebViewLoadedEvent) {
            console.log(JSON.stringify(event), " at pages/index/index.uvue:84");
        }
        ;
        this.download = fun(event: WebViewDownloadEvent) {
            console.log(JSON.stringify(event), " at pages/index/index.uvue:87");
            uni_showModal(ShowModalOptions(content = "下载链接: " + event.detail.url + "\n文件大小: " + event.detail.contentLength / 1024 + "KB", showCancel = false));
        }
        ;
        this.confirm = fun(event: InputConfirmEvent) {
            console.log(JSON.stringify(event), " at pages/index/index.uvue:94");
            var url = event.detail.value;
            if (!url.startsWith("https://") && !url.startsWith("http://")) {
                url = "https://" + url;
            }
            this.src = url;
        }
        ;
    }
    open lateinit var back: () -> Unit;
    open lateinit var forward: () -> Unit;
    open lateinit var reload: () -> Unit;
    open lateinit var stop: () -> Unit;
    open lateinit var nativeToWeb: () -> Unit;
    open lateinit var message: (event: WebViewMessageEvent) -> Unit;
    open lateinit var initSdk: (sdk: Any) -> Unit;
    open lateinit var error: (event: WebViewErrorEvent) -> Unit;
    open lateinit var loading: (event: WebViewLoadingEvent) -> Unit;
    open lateinit var loaded: (event: WebViewLoadedEvent) -> Unit;
    open lateinit var download: (event: WebViewDownloadEvent) -> Unit;
    open lateinit var confirm: (event: InputConfirmEvent) -> Unit;
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
                return utsMapOf("uni-flex-wv" to padStyleMapOf(utsMapOf("width" to "100%", "height" to 200)), "uni-input-v" to padStyleMapOf(utsMapOf("padding" to "10rpx 0")), "uni-btn-ml" to padStyleMapOf(utsMapOf("marginLeft" to "10rpx")));
            }
    }
}
