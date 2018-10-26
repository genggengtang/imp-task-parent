package org.zxs.imp.task.service.interf;

/**
 * 对Token进行操作的接口
 * @author ScienJus
 * @date 2015/7/31.
 */
public interface ITokenManager<T> {

	 /**
     * 创建一个token关联上指定用户
     * @param user 指定用户
     * @return 生成的token
     */
    public String createToken(T user);

    /**
     * 检查token是否有效
     * @param model token
     * @return 是否有效
     */
    public boolean checkToken(String token);

    /**
     * 根据key获取用户登录缓存信息
     * @param token 加密后的字符串
     * @return
     */
    public T getTokenObject(String token);

    /**
     * 清除token
     * @param token 
     */
    public void deleteToken(String token);

}
