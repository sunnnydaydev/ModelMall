package com.example.administrator.modelmall.icon;

import com.joanzapata.iconify.Icon;

/**
 * Create by SunnyDay on 2019/03/17
 * <p>
 * 实现 Icon 接口
 */
public enum IconModel implements Icon {
    // &#xe6c3  支付宝
    // &#xe502  扫一扫
    icon_scan('\ue502'),
    icon_shop('\ue612'),
    icon_kefu('\ue506'),
    icon_guanzhu('\ue503'),
    icon_gengduo('\ue63e'),
    icon_ali_pay('\ue6c3');

    private char character;
    IconModel(char character) {
        this.character = character;
    }

    /**
     * 参考 font
     */
    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
