package tools;

import enity.News;

import java.util.List;

public class Page {
    private int totalPageCount = 1;//总页数
    private int pageSize = 0;//没页显示内容数
    private int totalCount = 0;//总记录数
    private int currPageNo = 1;//当前页面编号
    private List<News> newsList;

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        totalPageCount = this.totalPageCount % pageSize == 0 ?
                (this.totalCount/pageSize):this.totalCount/pageSize+1;
        this.totalPageCount = totalPageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > 0){
            this.pageSize = pageSize;
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount > 0){
            this.totalCount = totalCount;
        }
    }

    public int getCurrPageNo() {
        if (totalPageCount == 0){
            return 0;
        }
        return currPageNo;
    }

    public void setCurrPageNo(int currPageNo) {
        this.currPageNo = currPageNo;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}