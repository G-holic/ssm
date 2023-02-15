package cn.itcast.factory;

import cn.itcast.pojo.Dept;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Dept> {
    /**
     * getObject():参与对象创建的方法
     * @return
     * @throws Exception
     */
    @Override
    public Dept getObject() throws Exception {
        Dept dept = new Dept(101,"研发部门");
        // 。。。。。。
        return dept;
    }

    /**
     * 设置参数对象Class
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Dept.class;
    }

    /**
     * 设置当前对象是否为单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
