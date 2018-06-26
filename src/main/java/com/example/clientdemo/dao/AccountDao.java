package com.example.clientdemo.dao;

import com.example.clientdemo.entity.Account;
import com.mdl.common.mapper.MdlMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: AccountDao
 * @Package com.example.clientdemo.dao
 * @Description:
 * @Date 2018/5/31下午 2:06
 */
@Repository
public interface AccountDao extends MdlMapper<Account> {

    @Select("SELECT * FROM t_enterprise_account WHERE user_name=#{userName} limit 1")
    Account findUserName(@Param("userName")String userName);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
