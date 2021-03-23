package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.servlet.http.HttpServletRequest;

@Getter
@Setter
@ToString
public class Page {
    private String searchText;//搜索的内容
    private String sortOrder;//排序的方式:升序/降序
    private Integer pageSize;//每页的数量
    private Integer pageNumber;//当前的页码

    /**
     * request输入流只能或企业请求体的数据,依赖程序自己解析
     * request.getParameter
     * @param req
     * @return
     */

    public static Page parse(HttpServletRequest req) { //这里为什么不能使用json的方式解析
        Page p = new Page();
        p.searchText = req.getParameter("searchText");
        p.sortOrder = req.getParameter("sortOrder");
        p.pageSize = Integer.parseInt(req.getParameter("pageSize"));
        p.pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
        return p;
    }
}
