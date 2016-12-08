package wereh.gradedehorarios.apresentacao;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import wereh.gradedehorarios.R;
import wereh.gradedehorarios.entidade.Disciplina;
import wereh.gradedehorarios.persistencia.DisciplinasDAO;

public class AddDisciplina extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_disciplina);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                recuperarDadosCampoDeTexto(view);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void recuperarDadosCampoDeTexto(View view) {
        EditText edtNome = (EditText) findViewById(R.id.edtTextNomeDisciplina);
        EditText edtHorario = (EditText) findViewById(R.id.edtTextHorario);
        int numeroDiaSemana = 0;
        RadioGroup rg = (RadioGroup) findViewById(R.id.rgDiasSemana);
        int op = rg.getCheckedRadioButtonId();

        RadioButton seg = (RadioButton) findViewById(R.id.rb1);
        RadioButton ter = (RadioButton) findViewById(R.id.rb2);
        RadioButton qua = (RadioButton) findViewById(R.id.rb3);
        RadioButton qui = (RadioButton) findViewById(R.id.rb4);
        RadioButton sex = (RadioButton) findViewById(R.id.rb5);

        if (op == R.id.rb1 ){
            numeroDiaSemana = 1;
        }else if (op == R.id.rb2){
            numeroDiaSemana = 2;
        }else if (op == R.id.rb3){
            numeroDiaSemana = 3;
        }else if (op == R.id.rb4){
            numeroDiaSemana = 4;
        }else if (op == R.id.rb5){
            numeroDiaSemana = 5;
        }else{
            AlertDialog.Builder mensagem=new AlertDialog.Builder(AddDisciplina.this);
            mensagem.setTitle("Atenção");
            mensagem.setMessage("Obrigatorio selecionar um dia da semana");
            mensagem.setNeutralButton("OK", null);
            mensagem.show();
        }
        definirDadosAtributosObjeto(edtNome, edtHorario, numeroDiaSemana);
    }

    private void definirDadosAtributosObjeto(EditText edtNome, EditText edtHorario, int numeroDiaSemana) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(edtNome.getText().toString());
        disciplina.setHorario(edtHorario.getText().toString());
        disciplina.setDiaSemana(numeroDiaSemana);
        salvar(disciplina, edtNome, edtHorario);
    }

    private void salvar(Disciplina disciplina, EditText edtNome, EditText edtHorario) {
        DisciplinasDAO disciplinasDAO = new DisciplinasDAO(this);
        disciplinasDAO.inserir(disciplina);
        notificacaoDeSucesso(edtNome, edtHorario);
    }

    private void notificacaoDeSucesso(EditText edtNome, EditText edtHorario) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Discupplina Salva com Sucesso!").setTitle("Nova Disciplina");
        builder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                }
        );
        AlertDialog dialog = builder.create();
        dialog.show();
        limparCamposTela(edtNome, edtHorario);
    }

    private void limparCamposTela(EditText edtNome, EditText edtHorario) {
        edtNome.setText("");
        edtHorario.setText("");
        RadioGroup rg = (RadioGroup) findViewById(R.id.rgDiasSemana);
        rg.setSelected(false);
    }

}
