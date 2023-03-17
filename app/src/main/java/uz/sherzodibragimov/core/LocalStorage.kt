package uz.sherzodibragimov.core

object LocalStorage {
    private val tickets= ArrayList<TicketData>()
     var trueCountSave=0
     var wrongCountSave=0
    var skippedCountSave=0
    fun fillData(){
        val t1= TicketData(
            questions = "O'zbekiston Respublikasining mustaqillik kuni qachon?",
            answer = "1991-yil 1-sentyabr",
            variants = arrayListOf("1991-yil 1-sentyabr","1991-yil 2-sentyabr","1991-yil 29-avgust","1992-yil 18-noyabr")
        )

        val t2= TicketData(
            questions = "1928-yilda Toshkentda telvezorni kashf qilgan olim kim?",
            answer = "Grabovskiy",
            variants = arrayListOf("Grabovskiy","Plexanov","Enshteyn","Zsukerberk")
        )

        val t3= TicketData(
            questions = "U Rossiyada birinchi o'rinda, Fransiyada ikkinchi o'rinda, Germaniyada uchunchi o'rindaturadi ?",
            answer = "R- xarfi",
            variants = arrayListOf("R- xarfi","Non","Choy","Sevgi")
        )

        val t4= TicketData(
            questions = "Dunyodagi eng uzun ko'l qaysi ?",
            answer = "Tangan'ika",
            variants = arrayListOf("Nil","Tangan'ika","O'lik ko'l")
        )

        val t5= TicketData(
            questions = "Dunyodagi eng tez ilon qaysi?",
            answer = "Qora mamba",
            variants = arrayListOf("Qora mamba","Anakonda","Piton","Kulvor ilon")
        )

        val t6= TicketData(
            questions = "Gunohdan nafratlan , Gunohkordan emas- iborasi kimga tegishli?",
            answer = "Lev Tolstoy",
            variants = arrayListOf("Alisher Navoiy","Lev Tolstoy","Pushkin","Chingiz Aytmatov")
        )

        val t7= TicketData(
            questions = "Dunyodagi eng aholisi ko'p shaxar qaysi ?",
            answer = "Tokio",
            variants = arrayListOf("Tokio","Peking","Dehlia")
        )
        tickets.add(t1)
        tickets.add(t2)
        tickets.add(t3)
        tickets.add(t4)
        tickets.add(t5)
        tickets.add(t6)
        tickets.add(t7)
    }

    fun getData(): ArrayList<TicketData> =   tickets
}