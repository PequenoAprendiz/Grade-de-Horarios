package wereh.gradedehorarios.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import wereh.gradedehorarios.entidade.Disciplina;

/**
 * Created by Were on 08/12/2016.
 */
public class DisciplinasDAO {
    private Context contexto;
    private static final String TABELA_DISCUPLINAS = "disciplinas";
    private static final String SQL_SELECT_TODAS = "SELECT + FROM disciplinas";
    private BDutil util;
    private SQLiteDatabase db;

    public DisciplinasDAO(Context context){
        this.contexto =  context;
        this.util = new BDutil(context);
    }

    //Método Inserir- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public void inserir(Disciplina disciplina){
        ContentValues values = new ContentValues();

        values.put("nome",disciplina.getNome());
        values.put("horario", disciplina.getHorario());
        values.put("dia", disciplina.getDiaSemana());

        BDutil bdUtil = new BDutil(contexto);
        bdUtil.getWritableDatabase().insert(TABELA_DISCUPLINAS,null,values);
        bdUtil.close();
    }
    //  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    //  Método Listar - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public List<Disciplina> listar() throws Exception{

        List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();

        // Definição da Instrução SQL
        String sql = "Select [_id], nome, horario, dia from disciplinas order by nome";

        BDutil bdUtil = new BDutil(contexto);
        Cursor cursor = bdUtil.getReadableDatabase().rawQuery(sql, null);

        try {
            while (cursor.moveToNext()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setId(cursor.getInt(0));
                disciplina.setNome(cursor.getString(1));
                disciplina.setHorario(cursor.getString(2));
                disciplina.setDiaSemana(cursor.getInt(3));
                listaDisciplinas.add(disciplina);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            cursor.close();
            bdUtil.close();
        }
        return listaDisciplinas;
    }

//    //Método deletar
//    public void deletar(int id_manobra){
//        try {
//            db = util.getReadableDatabase();
//            String where = " [_id] = " + String.valueOf(id_manobra);
//            db.delete(TABELA_MANOBRA, where, null);
//            Toast.makeText(this.contexto, "Feito!", Toast.LENGTH_LONG).show();
//            db.close();
//        }catch (Exception e){
//            Log.e("Qtd",e.getMessage());
//        }
//    }
//
//    public void alteraRegistro(Manobra manobra){
//        ContentValues values;
//        values = new ContentValues();
//        db = util.getWritableDatabase();
//        String where = " [_id] = " + String.valueOf(manobra.getId());
//
//        values.put("nome", manobra.getNome());
//        values.put("descricao", manobra.getDescricao());
//        values.put("dica", manobra.getDica());
//        db.update(TABELA_MANOBRA, values, where, null);
//        db.close();
//
//
//    }


}

