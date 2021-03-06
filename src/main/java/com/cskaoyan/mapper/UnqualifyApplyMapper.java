package com.cskaoyan.mapper;

import com.cskaoyan.bean.UnqualifyApply;
import com.cskaoyan.bean.UnqualifyApplyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnqualifyApplyMapper {
    long countByExample(UnqualifyApplyExample example);

    int deleteByExample(UnqualifyApplyExample example);

    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(UnqualifyApply record);

    int insertSelective(UnqualifyApply record);

    List<UnqualifyApply> selectByExample(UnqualifyApplyExample example);

    UnqualifyApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByExampleSelective(@Param("record") UnqualifyApply record, @Param("example") UnqualifyApplyExample example);

    int updateByExample(@Param("record") UnqualifyApply record, @Param("example") UnqualifyApplyExample example);

    int updateByPrimaryKeySelective(UnqualifyApply record);

    int updateByPrimaryKey(UnqualifyApply record);

    List<UnqualifyApply> getUnqualifyApplyList();

    int getUnqualifyApplyNum();

    List<UnqualifyApply> selectUnqualifyApplyListByProductName(@Param("productName") String productName);

    int countUnqualifyApplyListByProductName(@Param("productName") String productName);
}