# Mybatis

## MapperProxy

## DefaultSqlSession

## Configuration

```
# 在初始化Mapper的时候，Mybatis将SQL保存到下面的Map中
# 保存SQL
Map<String, MappedStatement> mappedStatements;
```

## MapperFactoryBean
在`MapperFactoryBean`初始化的时候，会调用`DaoSupport`的`afterPropertiesSet`方法，
从而会调用到子类`MapperFactoryBean`的`checkDaoConfig`方法。

# Mybatis与Spring

> 最重要的几个类

- MapperScan
- MapperFactoryBean（代理类）
- SqlSessionTemplate（代理类）

