package br.com.exemplo.persistenciaormlite;

import java.sql.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

public class PessoaDao extends BaseDaoImpl<Pessoa, Integer> {

	public PessoaDao(ConnectionSource connectionSource) throws SQLException {
		super(Pessoa.class);
		setConnectionSource(connectionSource);
		initialize();
	}

}
