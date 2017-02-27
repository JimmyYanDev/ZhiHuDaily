package com.micheal_yan.zhihudaily.model.bean;

import java.util.List;

/**
 * Created by micheal-yan on 2017/2/25.
 */

public class DailyListBean {

    /**
     * date : 20170225
     * stories : [{"images":["http://pic3.zhimg.com/2d89b3053323fb335d4e666c1d6777f2.jpg"],"type":0,"id":9249500,"ga_prefix":"022519","title":"只要有数据在，数据分析就根本停不下来"},{"images":["http://pic4.zhimg.com/2832bb9b93fb0c2fdae2bbaff35c59af.jpg"],"type":0,"id":9238811,"ga_prefix":"022518","title":"手机都十核了，怎么电脑 CPU 还大多是双核、四核？"},{"images":["http://pic1.zhimg.com/442634191d65009f98c553d4ec738fac.jpg"],"type":0,"id":9249302,"ga_prefix":"022517","title":"一篇好的游戏测评，远不止「好不好玩」的结论而已"},{"images":["http://pic4.zhimg.com/17f50cbe2d118d5e7a733a5cb024b033.jpg"],"type":0,"id":9247730,"ga_prefix":"022516","title":"为什么有的女性讨厌生孩子？"},{"images":["http://pic1.zhimg.com/4a2481e2c8f5499bc57966ba0c8b3e94.jpg"],"type":0,"id":9249241,"ga_prefix":"022515","title":"3 年之后又 3 年，知识产权的春天会到来吗？"},{"images":["http://pic1.zhimg.com/6f25e0a09bcaefe35e16b2f893a1f5b4.jpg"],"type":0,"id":9236514,"ga_prefix":"022514","title":"我知道你比我卖得便宜，但我也不会坐以待毙"},{"title":"口味很重，很爱打架，关于朱鹮都有哪些冷知识？","ga_prefix":"022513","images":["http://pic1.zhimg.com/a404c5bafc57290c3ea74bbb802f48d0.jpg"],"multipic":true,"type":0,"id":9248998},{"images":["http://pic4.zhimg.com/c1b1088bd8ed73c2aa34df165ab8d9cf.jpg"],"type":0,"id":9244783,"ga_prefix":"022512","title":"大误 · 我是卵生的"},{"title":"欧洲有哪些非常值得一去的城堡？","ga_prefix":"022511","images":["http://pic3.zhimg.com/769b89b938593d072d1bc68a4417935a.jpg"],"multipic":true,"type":0,"id":9241755},{"images":["http://pic4.zhimg.com/07090e7ecbd278a6622e392b60cfb64b.jpg"],"type":0,"id":9243255,"ga_prefix":"022510","title":"有了可证伪性标准，还是无法阻止不了解情况的人提出理论"},{"images":["http://pic4.zhimg.com/c5831809416ca0f4b8225731ee5679e7.jpg"],"type":0,"id":9242275,"ga_prefix":"022509","title":"长期在国外工作是一种怎样的体验？"},{"images":["http://pic4.zhimg.com/f5bcda471f9d66d490b170bcb3e1be1b.jpg"],"type":0,"id":9247919,"ga_prefix":"022508","title":"有了中国驾照，想在境外租车自驾还需要知道这些"},{"images":["http://pic2.zhimg.com/45b90139cc67f652911db51d7d43de5d.jpg"],"type":0,"id":9248465,"ga_prefix":"022507","title":"挨饿的长征路上，大脑是如何挺过来的？"},{"images":["http://pic4.zhimg.com/71fbb2f1569de3b90e3733d56dee8ce7.jpg"],"type":0,"id":9242170,"ga_prefix":"022507","title":"一切还要从湿婆撕碎他的丁丁说起"},{"title":"屏幕、性能、拍照、续航\u2026\u2026手把手教你挑到满意的手机","ga_prefix":"022507","images":["http://pic2.zhimg.com/221ec812fe61c266f57790cd77a2df9d.jpg"],"multipic":true,"type":0,"id":9248514},{"images":["http://pic3.zhimg.com/90a1db257d8c7e1dc078d12d3abf0c2a.jpg"],"type":0,"id":9242112,"ga_prefix":"022506","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic4.zhimg.com/306c1d4d2bc6e5f968963f2a37790287.jpg","type":0,"id":9249302,"ga_prefix":"022517","title":"一篇好的游戏测评，远不止「好不好玩」的结论而已"},{"image":"http://pic2.zhimg.com/cb92e9f7bf5804bae035a51593993c99.jpg","type":0,"id":9247730,"ga_prefix":"022516","title":"为什么有的女性讨厌生孩子？"},{"image":"http://pic4.zhimg.com/385fe372f7788fb4247c9705ea81f5bb.jpg","type":0,"id":9247919,"ga_prefix":"022508","title":"有了中国驾照，想在境外租车自驾还需要知道这些"},{"image":"http://pic3.zhimg.com/19de16c4b1852dc7be9bb8ee9019f412.jpg","type":0,"id":9248514,"ga_prefix":"022507","title":"屏幕、性能、拍照、续航\u2026\u2026手把手教你挑到满意的手机"},{"image":"http://pic1.zhimg.com/0995cb735254439b2cef3d5a9ebeb320.jpg","type":0,"id":9247561,"ga_prefix":"022417","title":"很大很贵的苹果新总部，是乔布斯发布的最后一个产品"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["http://pic3.zhimg.com/2d89b3053323fb335d4e666c1d6777f2.jpg"]
         * type : 0
         * id : 9249500
         * ga_prefix : 022519
         * title : 只要有数据在，数据分析就根本停不下来
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : http://pic4.zhimg.com/306c1d4d2bc6e5f968963f2a37790287.jpg
         * type : 0
         * id : 9249302
         * ga_prefix : 022517
         * title : 一篇好的游戏测评，远不止「好不好玩」的结论而已
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
