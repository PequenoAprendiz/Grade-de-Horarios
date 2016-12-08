package wereh.gradedehorarios.persistencia;

/**
 * Created by Were on 08/12/2016.
 */


    import android.content.Context;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;

    public class BDutil extends SQLiteOpenHelper {

        private static final int VERSAO=1;
        private static final String TABELA_DISCUPLINAS = "disciplinas";
        private static final String DATABASE = "db_disciplinas.db";


        public BDutil(Context context){
            super(context,DATABASE,null,VERSAO);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            String ddlDisciplina = "CREATE TABLE "+ TABELA_DISCUPLINAS + " ( "
                    +"[_id] INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +"nome TEXT, "
                    +"horario TEXT, "
                    +"dia INTEGER) ";
            db.execSQL(ddlDisciplina);
        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }