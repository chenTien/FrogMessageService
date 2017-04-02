package common;

/**
 * Created by chen.Tian on 2017/3/21.
 */
public class PagerUtil {

    public static Pager toPagerResult(Pager pager, int totalRows){
        //总记录数
        pager.setTotalRows(totalRows);

        //每页大小，保持原值
        int totalPages = totalRows / pager.getPageSize();//总页数
        if (totalRows % pager.getPageSize() > 0) {         //总页数取模，不整除，则页数+1
            totalPages = totalPages + 1;
        }
        pager.setTotalPage(totalPages);

        if (pager.getPageNumber() > totalPages) {   //当前页
            pager.setPageNumber(totalPages);
        }

        pager.setRowFrom((pager.getPageNumber() -1) * pager.getPageSize());//记录起始
        pager.setRowTo(pager.getRowFrom() + pager.getPageSize());//记录结束

        return pager;
    }
}
