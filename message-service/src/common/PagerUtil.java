package common;

/**
 * Created by chen.Tian on 2017/3/21.
 */
public class PagerUtil {

    public static Pager toPagerResult(Pager pager, int totalRows){
        //�ܼ�¼��
        pager.setTotalRows(totalRows);

        //ÿҳ��С������ԭֵ
        int totalPages = totalRows / pager.getPageSize();//��ҳ��
        if (totalRows % pager.getPageSize() > 0) {         //��ҳ��ȡģ������������ҳ��+1
            totalPages = totalPages + 1;
        }
        pager.setTotalPage(totalPages);

        if (pager.getPageNumber() > totalPages) {   //��ǰҳ
            pager.setPageNumber(totalPages);
        }

        pager.setRowFrom((pager.getPageNumber() -1) * pager.getPageSize());//��¼��ʼ
        pager.setRowTo(pager.getRowFrom() + pager.getPageSize());//��¼����

        return pager;
    }
}
