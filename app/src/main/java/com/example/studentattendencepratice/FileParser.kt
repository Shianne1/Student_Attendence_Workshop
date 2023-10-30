package com.example.studentattendencepratice

object FileParser {
    fun PopulateLetter(studentNames: ArrayList<StudentNames>): ArrayList<SortingNames>{
        val sortingNames = ArrayList<SortingNames>()

        for(studentLetter in studentNames) {

            if(sortingNames.isEmpty()){
                val newSortingNames = SortingNames(studentLetter.names.first().toString(), ArrayList())
                newSortingNames.students.add(studentLetter)
                sortingNames.add(newSortingNames)
            }
            else {
                var letterExits = false
                for(s in sortingNames){
                    if(s.letter.equals(studentLetter.names.first().toString(), true)){
                        s.students.add(studentLetter)
                        letterExits = true
                    }
                }

                if(!letterExits){
                    val newSortingNames = SortingNames(studentLetter.names.first().toString(), ArrayList())
                    newSortingNames.students.add(studentLetter)
                    sortingNames.add(newSortingNames)
                }
            }
        }
        return sortingNames
    }
}