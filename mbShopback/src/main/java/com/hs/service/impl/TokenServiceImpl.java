package com.hs.service.impl;

import com.hs.entity.Token;
import com.hs.mapper.TokenDao;
import com.hs.service.TokenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Token表)服务实现类
 *
 * @author makejava
 * @since 2021-10-22 21:49:08
 */
@Service("tokenService")
public class TokenServiceImpl implements TokenService {
    @Resource
    private TokenDao tokenDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tId 主键
     * @return 实例对象
     */
    @Override
    public Token selectById(Integer tId) {
        return this.tokenDao.selectById(tId);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param tVal
     * @return 实例对象
     */
    @Override
    public Token selectByUUID(String tVal) {
        return this.tokenDao.selectByUUID(tVal);
    }

    @Override
    public Token selectByuId(Integer uId) {
        return this.tokenDao.selectByuId(uId);
    }

    /**
     * 分页查询
     *
     * @param start 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Token> selectPage(int start, int limit) {
        return this.tokenDao.selectPage(start, limit);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
     @Override
     public List<Token> selectAll() {
        return this.tokenDao.selectAll();
     }
     
    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<Token> selectList(Token token) {
        return this.tokenDao.selectList(token);
    }
    
    /**
     * 新增数据
     *
     * @param token 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Token token) {
        return this.tokenDao.insert(token);
    }

    /**
     * 批量新增
     *
     * @param tokens 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<Token> tokens) {
        return this.tokenDao.batchInsert(tokens);
    }

    /**
     * 修改数据
     *
     * @param token 实例对象
     * @return 实例对象
     */
    @Override
    public Token update(Token token) {
        this.tokenDao.update(token);
        return this.selectById(token.getTId());
    }

    /**
     * 通过主键删除数据
     *
     * @param tId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer tId) {
        return this.tokenDao.deleteById(tId);
    }
    
    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
     @Override
     public int count(){
        return this.tokenDao.count();
     }

    @Override
    public int deleteTokenByTval(String tVal) {
        return tokenDao.deleteTokenByTval(tVal);
    }

    /**
     * 登录业务时，将实体类token的值插入到token表 主要是插入status和uid
     * @author lt
     */
    @Override
    public int tokenUpdateBytVal(Token token){
        return tokenDao.tokenUpdateBytVal(token);
    }
}