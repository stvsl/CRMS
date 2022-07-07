package Entity;

public interface iEntity<T> {

    /**
     * 当前对象存入数据库
     * 
     * @return
     */
    public int insertToDB();

    /**
     * 当前对象从数据库中删除
     * 
     * @return
     */
    public int deleteFromDB();

    /**
     * 当前对象从数据库中更新
     * 
     * @return
     */
    public T searchFromDB();

    /**
     * 更新数据库中的当前对象
     * 
     * @return
     */
    public int updateToDB();

}
