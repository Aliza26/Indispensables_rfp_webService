package com.indispensables.Entity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ClientIdGenerator implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub

	    String prefix = "MJ";
	JdbcConnectionAccess con = session.getJdbcConnectionAccess();
	        
	            try {
	                JdbcConnectionAccess jdbcConnectionAccess = session.getJdbcConnectionAccess();
	                Connection connection = jdbcConnectionAccess.obtainConnection();
	                Statement statement = connection.createStatement();
	                String query = "select count(rfp_id) as Id from rfp_entity";

	                ResultSet resultSet = statement.executeQuery(query);

	                if (resultSet.next()) {
	                     int id=resultSet.getInt(1)+101;
	                     String generatedId = prefix + new Integer(id).toString();
	                     return generatedId;
	                }

	                resultSet.close();
	                statement.close();
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
		return null;
	}

}
