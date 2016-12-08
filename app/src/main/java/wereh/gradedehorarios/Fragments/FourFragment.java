package wereh.gradedehorarios.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import wereh.gradedehorarios.R;
import wereh.gradedehorarios.entidade.Disciplina;
import wereh.gradedehorarios.persistencia.DisciplinasDAO;


public class FourFragment extends Fragment {
    ListView mListView;
    private List<Disciplina> listaDiscuplinas;

    public FourFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override  // Inflate the layout for this fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onResume() {
        try {
            super.onResume();
            this.carregarLista();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void carregarLista(){
        ArrayAdapter<Disciplina> adapter;
        int adapterLayout = android.R.layout.simple_list_item_1;
        DisciplinasDAO disciplinasDAO = new DisciplinasDAO(this.getContext());

        try {
            this.listaDiscuplinas = disciplinasDAO.listar();
            adapter = new ArrayAdapter<Disciplina>(this.getContext(), adapterLayout, listaDiscuplinas);
         //   mListView = (ListView)getActivity().findViewById(R.id.listViewDisciplinas);
            this.mListView.setAdapter(adapter);
            registerForContextMenu(mListView);                    /// registrar a listview no menu de conteexto senão o menus de opções não carrega
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
