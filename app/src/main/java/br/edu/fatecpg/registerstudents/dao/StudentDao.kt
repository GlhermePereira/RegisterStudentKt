package br.edu.fatecpg.registerstudents.dao

import br.edu.fatecpg.registerstudents.model.Student
import java.util.*

class StudentDao private constructor(){
    private val alunos = mutableListOf<Student>()

    // Função para inserir aluno
    fun inserir(aluno: Student) {
        alunos.add(aluno)
    }

    // Função para obter o último aluno inserido
    fun getUltimo(): Student? {
        return alunos.lastOrNull()
    }

    // Função para acessar a instância do DAO
    companion object {
        @Volatile
        private var INSTANCE: StudentDao? = null

        fun getInstance(): StudentDao {
            return INSTANCE ?: synchronized(this) {
                val instance = StudentDao()
                INSTANCE = instance
                instance
            }
        }
    }
}