package org.kongxji.framework.jdbc;
  
import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * 重写数据库配置
 *
 * @author lh
 * @since 1.0.0
 */
public class MySQL5DialectUTF8 extends MySQL5InnoDBDialect{  
  
    @Override  
    public String getTableTypeString() {  
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";    
    }  
}  