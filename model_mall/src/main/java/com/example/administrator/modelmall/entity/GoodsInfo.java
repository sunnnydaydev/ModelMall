package com.example.administrator.modelmall.entity;

import java.util.List;

/**
 * Create by SunnyDay on 2019/03/22
 */
public class GoodsInfo {

    private List<ThreeBigImageBean> threeBigImage;
    private List<ThreeSmallImageBean> threeSmallImage;

    public List<ThreeBigImageBean> getThreeBigImage() {
        return threeBigImage;
    }

    public void setThreeBigImage(List<ThreeBigImageBean> threeBigImage) {
        this.threeBigImage = threeBigImage;
    }

    public List<ThreeSmallImageBean> getThreeSmallImage() {
        return threeSmallImage;
    }

    public void setThreeSmallImage(List<ThreeSmallImageBean> threeSmallImage) {
        this.threeSmallImage = threeSmallImage;
    }

    public static class ThreeBigImageBean {
        /**
         * imageurl : https://img14.360buyimg.com/n0/jfs/t1/18670/4/7265/161721/5c6a6445E5aaceb6a/85a35ed9549caa8b.jpg
         */

        private String imageurl;

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }
    }

    public static class ThreeSmallImageBean {
        /**
         * imageurl : https://img14.360buyimg.com/n9/s60x76_jfs/t1/18869/2/7221/116782/5c6a6435E7be4d040/4da11722411e547b.jpg!cc_60x76.jpg
         */

        private String imageurl;

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }
    }
}
