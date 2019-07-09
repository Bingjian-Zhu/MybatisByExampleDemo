package com.example.demo.dto;

import java.util.List;
import java.io.Serializable;

import com.github.pagehelper.Page;

@SuppressWarnings("rawtypes")
public class MyPageInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    // 总记录数
    protected long total;
    // 当前页
    protected int pageNum;
    // 每页的数量
    protected int pageSize;
    // 结果集
    protected List<T> list;

    public MyPageInfo() {
    }

    /**
     * 包装Page对象
     *
     * @param list
     */
    public MyPageInfo(List<T> list) {
        this.list = list;
        if (list instanceof Page) {
            Page page = (Page) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.total = page.getTotal();
        } else {
            this.pageNum = 1;
            this.pageSize = list.size();
            this.total = list.size();
        }
    }

    public static <T> MyPageInfo<T> of(List<T> list) {
        return new MyPageInfo<T>(list);
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyPageInfo{");
        sb.append("total=").append(total);
        sb.append(", pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}
