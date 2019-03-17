package com.example.administrator.modelmall.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * Create by SunnyDay on 2019/03/17
 *
 * 自定义字体图标模块
 *
 * 使用其他的第三方字体图标
 */
public class FontModel implements IconFontDescriptor {
    /**
     * 返回下载的ttf文件
     * */
    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    /**
     * 返回个icon类型数组
     *
     * */
    @Override
    public Icon[] characters() {
        return  IconModel.values();
    }
}
