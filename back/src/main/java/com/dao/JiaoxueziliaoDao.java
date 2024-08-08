package com.dao;

import com.entity.JiaoxueziliaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaoxueziliaoView;

/**
 * 教学资料 Dao 接口
 *
 * @author 
 */
public interface JiaoxueziliaoDao extends BaseMapper<JiaoxueziliaoEntity> {

   List<JiaoxueziliaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
