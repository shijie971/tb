package com.tongbu.datasources.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class BaseService<T> {
    @Autowired
    protected Mapper<T> mapper;

    public BaseService() {
    }

    public List<T> selectAll() {
        return this.mapper.selectAll();
    }

    public T selectByPrimaryKey(T key) {
        return this.mapper.selectByPrimaryKey(key);
    }

    public List<T> selectByExample(Example example) {
        return this.mapper.selectByExample(example);
    }

    public T selectOne(T record) {
        return this.mapper.selectOne(record);
    }

    public int insert(T record) {
        return this.mapper.insert(record);
    }

    public int insertSelective(T record) {
        return this.mapper.insertSelective(record);
    }

    public int updateByPrimaryKey(T record) {
        return this.mapper.updateByPrimaryKey(record);
    }

    public int updateByPrimaryKeySelective(T record) {
        return this.mapper.updateByPrimaryKeySelective(record);
    }

    public int updateByExample(T record, Example example) {
        return this.mapper.updateByExample(record, example);
    }

    public int updateByExampleSelective(T record, Example example) {
        return this.mapper.updateByExampleSelective(record, example);
    }

    public int delete(T record) {
        return this.mapper.delete(record);
    }

    public int deleteByPrimaryKey(Object key) {
        return this.mapper.deleteByPrimaryKey(key);
    }

    @Transactional
    public void deleteBatchByPrimaryKey(List<T> record) throws RuntimeException {
        record.forEach((it) -> {
            this.mapper.delete(it);
        });
    }

    public int deleteByExample(Example example) {
        return this.mapper.deleteByExample(example);
    }

    public PageInfo<T> selectAllByList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum.intValue(), pageSize.intValue());
        return new PageInfo(this.mapper.selectAll());
    }

    public PageInfo<T> selectByList(T record, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum.intValue(), pageSize.intValue());
        return new PageInfo(this.mapper.select(record));
    }

    public PageInfo<T> selectByExampleList(Example example, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum.intValue(), pageSize.intValue());
        return new PageInfo(this.mapper.selectByExample(example));
    }

    public PageInfo<T> selectAllByOffSetList(Integer offset, Integer limit) {
        PageHelper.offsetPage(offset.intValue(), limit.intValue());
        return new PageInfo(this.mapper.selectAll());
    }

    public PageInfo<T> selectByOffSetList(T record, Integer offset, Integer limit) {
        PageHelper.offsetPage(offset.intValue(), limit.intValue());
        return new PageInfo(this.mapper.select(record));
    }

    public PageInfo<T> selectByExampleOffSetList(Example example, Integer offset, Integer limit) {
        PageHelper.offsetPage(offset.intValue(), limit.intValue());
        return new PageInfo(this.mapper.selectByExample(example));
    }

}
