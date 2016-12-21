package jdbc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 保存{@link jdbc.TPreparedStatement}对象创建的方法
 * <p>
 * Created by aude on 2016/12/21.
 */
public enum StatementCreateMethod {
    /*-------------------------Statement创建的命令--------------------------*/
    createStatement,
    /*-------------------------PreparedStatement创建的命令--------------------------*/
    prepareStatement_sql,
    prepareStatement_sql_autoGeneratedKeys,
    prepareStatement_sql_columnIndexes,
    prepareStatement_sql_columnNames;

    public PreparedStatement preparedStatement(Connection conn, Object[] args) throws SQLException {
        switch (this) {
            case prepareStatement_sql:
                return conn.prepareStatement((String) args[0]);
            case prepareStatement_sql_autoGeneratedKeys:
                return conn.prepareStatement((String) args[0], (Integer) args[1]);
            case prepareStatement_sql_columnIndexes:
                return conn.prepareStatement((String) args[0], (int[]) args[1]);
            case prepareStatement_sql_columnNames:
                return conn.prepareStatement((String) args[0],(String[]) args[1]);
            default:
                throw new AudeException("not support prepareStatement(xx) method:"+this);
        }
    }
}
