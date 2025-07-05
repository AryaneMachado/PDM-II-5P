package br.edu.ifsuldeminas.mch.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.edu.ifsuldeminas.mch.todolist.domain.Task;
import br.edu.ifsuldeminas.mch.todolist.domain.db.TaskDAO;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formActivityIntent = new Intent(MainActivity.this,
                        FormActivity.class);

                startActivity(formActivityIntent);
            }
        });

        listView = findViewById(R.id.todo_list);
        registerForContextMenu(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {

                Task taskAtPosition = (Task) listView.getItemAtPosition(position);

                Intent intentFormActivity = new Intent(MainActivity.this,
                        FormActivity.class);
                intentFormActivity.putExtra("task", taskAtPosition);

                startActivity(intentFormActivity);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        updateTaskList();
    }

    private void updateTaskList(){
        TaskDAO taskDAO = new TaskDAO(this);
        List<Task> tasks = taskDAO.listAll();

        ArrayAdapter<Task> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, tasks);

        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,
                                    View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        MenuItem itemDelete = menu.add(R.string.task_delete);
        itemDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {

                AdapterView.AdapterContextMenuInfo info =
                        (AdapterView.AdapterContextMenuInfo) menuInfo;
                Task task = (Task) listView.getItemAtPosition(info.position);

                TaskDAO dao = new TaskDAO(MainActivity.this);
                dao.delete(task);

                Toast.makeText(MainActivity.this,
                               "Tarefa deletada com sucesso.",
                               Toast.LENGTH_SHORT).show();
                updateTaskList();
                return true;
            }
        });

        super.onCreateContextMenu(menu, v, menuInfo);
    }
}