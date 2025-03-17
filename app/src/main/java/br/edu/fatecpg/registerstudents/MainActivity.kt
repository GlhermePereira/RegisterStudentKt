package br.edu.fatecpg.registerstudents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.registerstudents.dao.StudentDao
import br.edu.fatecpg.registerstudents.model.Student

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val edtNome = findViewById<EditText>(R.id.edtAluno)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)
        val dao = StudentDao.getInstance()

        btnCadastrar.setOnClickListener {
            val nome = edtNome.text.toString()
            val aluno = Student(nome)
            dao.inserir(aluno)

            // Passa para a próxima tela para exibir a matrícula
            val intent = Intent(this, InfoStudent::class.java)
            startActivity(intent)
        }
    }
}