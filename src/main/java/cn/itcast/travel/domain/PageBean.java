package cn.itcast.travel.domain;

import java.util.List;

/**
 * @PackageName: cn.itcast.travel.domain
 * @ClassName: PageBean
 * @Author: renpengzhi
 * @Date: 2019/11/2 0002 下午 5:07
 * @Description: //TODO
 */
public class PageBean<T> {
    private Integer totalCount;
    private Integer totalPage;
    private Integer currentPage;
    private Integer pageSize;
    private List<T> list;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
