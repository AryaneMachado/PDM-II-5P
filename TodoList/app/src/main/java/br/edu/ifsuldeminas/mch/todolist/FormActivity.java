package br.edu.ifsuldeminas.mch.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;

import br.edu.ifsuldeminas.mch.todolist.domain.Task;
import br.edu.ifsuldeminas.mch.todolist.domain.db.TaskDAO;

public class FormActivity extends AppCompatActivity {

    private Task task;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        task = null;
        Intent intentChamadora = getIntent();
        task = (Task) intentChamadora.getSerializableExtra("task");

        if (task != null) {
            TextInputEditText editText = findViewById(R.id.task_description);
            editText.setText(task.getDescription());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_form, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.save_task) {
            TextInputEditText textInputEditText = findViewById(R.id.task_description);
            String description = textInputEditText.getText().toString();

            if ("".equals(description)) {
                Toast.makeText(this, "Descrição da tarefa não pode ser vaza",
                        Toast.LENGTH_LONG).show();

                return false;
            }

            TaskDAO taskDAO = new TaskDAO(this);

            if (task == null) {
                task = new Task(0);
                task.setDescription(description);
                task.setActive(true);
                taskDAO.save(task);
                Toast.makeText(this, "Tarefa salva com sucesso!", Toast.LENGTH_SHORT).show();
            } else {
                task.setDescription(description);
                taskDAO.update(task);
                Toast.makeText(this, "Tarefa atualizada com sucesso!", Toast.LENGTH_SHORT).show();
            }

            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
