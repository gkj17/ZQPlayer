package com.zq.zqplayer

import android.graphics.Color
import cn.jpush.android.api.JPushInterface
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.ziq.base.mvp.BaseApplication
import com.ziq.base.utils.RetrofitUtil
import com.zq.zqplayer.common.Constants

/**
 *author: wuyanqiang
 *2018/11/20
 */
class ZQPlayerApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()

        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

        RetrofitUtil.getInstance().init(Constants.baseUrl)
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            val header = ClassicsHeader(context)
            header.setTextSizeTitle(14f)
            header.setTextSizeTime(12f)
            header.setPrimaryColor(Color.WHITE)
            header
        }
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
            val footer = ClassicsFooter(context)
            footer.setTextSizeTitle(14f)
            footer.setPrimaryColor(Color.WHITE)
            footer
        }
    }

}