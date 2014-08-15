package br.com.exemplo.persistenciaormlite.test;

import java.sql.SQLException;
import java.util.Date;

import android.test.AndroidTestCase;
import br.com.exemplo.persistenciaormlite.DatabaseHelper;
import br.com.exemplo.persistenciaormlite.Pessoa;
import br.com.exemplo.persistenciaormlite.PessoaDao;

public class PessoaDaoTest extends AndroidTestCase {

	public void test_quando_eu_criar_uma_pessoa_ao_persistir_com_o_dao_devera_conter_1_registro_na_tabela()
			throws SQLException {
		Pessoa p = new Pessoa();
		p.setNome("Carlos");
		p.setDataNascimento(new Date());

		DatabaseHelper helper = new DatabaseHelper(getContext());

		PessoaDao dao;
		dao = new PessoaDao(helper.getConnectionSource());
		dao.delete(dao.queryForAll());
		dao.create(p);
		assertEquals(1, dao.queryForAll().size());
	}

	public void test_quando_eu_criar_uma_pessoa_ao_persistir_com_o_dao_devera_gravar_os_dados_corretamente()
			throws SQLException {
		Date data = new Date();
		
		Pessoa p = new Pessoa();
		p.setDataNascimento(data);
		p.setNome("Cláudio");
		p.setTelefone("(85) 8800-7896");
		
		DatabaseHelper helper = new DatabaseHelper(getContext());
		
		PessoaDao dao = new PessoaDao(helper.getConnectionSource());
		dao.delete(dao.queryForAll());
		dao.create(p);
		
		Pessoa persistido = (Pessoa) dao.queryForEq("nome", "Cláudio").get(0);
		assertNotNull(persistido);
		assertEquals("Cláudio", persistido.getNome());
		assertEquals("(85) 8800-7896", persistido.getTelefone());
		assertEquals(data, persistido.getDataNascimento());
	}

}
