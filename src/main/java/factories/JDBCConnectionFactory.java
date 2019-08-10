package factories;

import db.DBConfig;
import org.apache.tomcat.dbcp.dbcp.ConnectionFactory;
import org.apache.tomcat.dbcp.dbcp.DriverManagerConnectionFactory;
import org.apache.tomcat.dbcp.dbcp.PoolableConnectionFactory;
import org.apache.tomcat.dbcp.dbcp.PoolingDataSource;
import org.apache.tomcat.dbcp.pool.impl.GenericObjectPool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCConnectionFactory {

    private static GenericObjectPool genPool = null;
    private static volatile JDBCConnectionFactory connectionFactory = null;
    private DataSource dataSource = null;

    private JDBCConnectionFactory() {
        try {
            Class.forName(DBConfig.getDriver());
            genPool = new GenericObjectPool();
            genPool.setMaxActive(30);
            ConnectionFactory factory = new DriverManagerConnectionFactory(DBConfig.getUrl(), DBConfig.getUser(), DBConfig.getPassword());
            PoolableConnectionFactory poolableConnectionFactory =
                    new PoolableConnectionFactory
                            (factory, genPool, null, null, false, true);
            dataSource = new PoolingDataSource(genPool);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static JDBCConnectionFactory getInstance() {
        if (connectionFactory == null) {
            synchronized (JDBCConnectionFactory.class) {
                if (connectionFactory == null) {
                    connectionFactory = new JDBCConnectionFactory();
                }
            }
        }
        return connectionFactory;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static GenericObjectPool getConnectionPool() {
        return genPool;
    }
}