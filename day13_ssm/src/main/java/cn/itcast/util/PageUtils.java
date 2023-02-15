package cn.itcast.util;

import cn.itcast.pojo.Employee;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageUtils {

    /**
     * 将分页功能所有信息凭借到一个字符串中，作为返回结果，直接传递jsp页面使用，拼接效果如下：
     * 首页   上一页  1  2  3  4  5  下一页   尾页
     */
    public static String getPageInfo(PageInfo<Employee> pageInfo, HttpServletRequest request){
        // String basePath = "/当前项目名/";
        String basePath = request.getContextPath() + "/";

        // 定义结果字符串StringBuilder
        StringBuilder builder = new StringBuilder();

        // 拼接首页
        builder.append("<a href='"+basePath+"emps/1'>首页</a>");
        builder.append("&nbsp;&nbsp;");

        // 拼接上一页
        if (pageInfo.isHasPreviousPage()){
            builder.append("<a href='"+basePath+"emps/"+(pageInfo.getPageNum()-1)+"'>上一页</a>");
            builder.append("&nbsp;&nbsp;");
        }else {
            builder.append("上一页");
            builder.append("&nbsp;&nbsp;");
        }

        // 拼接页码超链接   1   2   3   4  5
        int [] nums = pageInfo.getNavigatepageNums();
        for (int i : nums) {
            if (i==pageInfo.getPageNum()){
                builder.append("<a style='text-decoration: none;' href='"+basePath+"emps/"+i+"'>"+i+"</a>");
                builder.append("&nbsp;&nbsp;");
            }else {
                builder.append("<a href='"+basePath+"emps/"+i+"'>"+i+"</a>");
                builder.append("&nbsp;&nbsp;");
            }
        }

        // 拼接下一页
        if (pageInfo.isHasNextPage()){
            builder.append("<a href='"+basePath+"emps/"+(pageInfo.getPageNum()+1+"'>下一页</a>"));
            builder.append("&nbsp;&nbsp;");
        }else {
            builder.append("下一页");
            builder.append("&nbsp;&nbsp;");
        }

        // 拼接尾页
        builder.append("<a href='"+basePath+"emps/"+pageInfo.getPages()+"'>尾页</a>");

        return builder.toString();

    }
}
