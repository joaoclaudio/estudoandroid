package br.com.exemplo.persistenciaormlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
	 
    private static final String DATABASE_NAME = "persistenciaormlite.db";
    private static final int DATABASE_VERSION = 1;
 
    private RuntimeExceptionDao<Pessoa, Integer> simpleRuntimeDao = null;
 
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Pessoa.class); //Aqui é definido as classes modelos que representam uma tabela no banco.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, Pessoa.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        } catch (Exception e) {
			e.printStackTrace();
		}
    }
 
    public RuntimeExceptionDao<Pessoa, Integer> getPessoaDao() {
        if (simpleRuntimeDao == null) {
            simpleRuntimeDao = getRuntimeExceptionDao(Pessoa.class);
        }
        return simpleRuntimeDao;
    }
 
    @Override
    public void close() {
        super.close();
        simpleRuntimeDao = null;
    }
}
