package br.edu.fatecpg.registerstudents
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.registerstudents.dao.StudentDao
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random
class InfoStudent : AppCompatActivity(R.layout.activity_info_student) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = StudentDao.getInstance()
        val aluno = dao.getUltimo()

        val txtNome = findViewById<TextView>(R.id.txtNome)
        val txtMatricula = findViewById<TextView>(R.id.txtMatricula)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fabVoltar)
        val btnMatricula = findViewById<Button>(R.id.btnMatricula)

        aluno?.let {
            txtNome.text = "Nome: ${it.nome}"

            btnMatricula.setOnClickListener {
                // Gerando número de matrícula aleatório
                val matricula = Random.nextInt(500, 9999)
                txtMatricula.text = "Matrícula: $matricula"
            }

            fabVoltar.setOnClickListener {
                finish()
            }
        }
    }
}