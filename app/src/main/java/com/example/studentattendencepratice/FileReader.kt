package com.example.studentattendencepratice

import android.content.Context
import java.io.FileNotFoundException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.Scanner

object FileReader {
    fun readFile(content: Context, fileName: String): ArrayList<StudentNames> {
        val students = ArrayList<StudentNames>()

        try{
            val inputStream: InputStream = content.assets.open(fileName)
            val scanner = Scanner(InputStreamReader(inputStream))

            while (scanner.hasNext()) {
                val line = scanner.nextLine()
                val row = line.split(",")
                val student = StudentNames(row[0],row[1].toInt())
                students.add(student)
            }
            scanner.close()
        } catch (e:FileNotFoundException){
            println("The file was not found. Check file name or path")
        }
        return students
    }
}