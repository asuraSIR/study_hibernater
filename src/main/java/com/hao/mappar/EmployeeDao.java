package com.hao.mappar;

/**
 * @Description:
 * @Company:
 * @version: 1.0
 * @date 2021/1/19 - 15:44
 */
public interface EmployeeDao {
    /**
     * 保存
     */
    public abstract String save(String firstName,String lastName, Integer salary) throws Exception;

    /**
     * 获取所有
     */
    public abstract void getAll();

    /**
     * 更新
     */
    public abstract void update(String id,int salary);
    /**
     * 删除
     */
    public abstract void delete(String id);
}
