package uz.sherzodibragimov.core

class GameController(private var tickets:ArrayList<TicketData>) {
     private var currentIndex=0

     private var trueCount = 0

     private var skipCount =0

     private var wrongCount = 0
     init {
         tickets.shuffled()
     }
     private fun getCurrentTicket(): TicketData = tickets[currentIndex]
     fun getQuestion():String =getCurrentTicket().questions

     fun getVariants(): List<String> = getCurrentTicket().variants.shuffled()

     fun getCurrentLeve():Int=currentIndex+1

     fun getTotalLevel():Int=tickets.size

     fun checkAnswer(userAnswer:String){

          if (userAnswer.equals(getCurrentTicket().answer,ignoreCase = true)){
               trueCount++
          }else{
               wrongCount++
          }

          currentIndex++
     }

     fun isFinished():Boolean = tickets.size==currentIndex

     fun skipQusetion():Boolean{
          currentIndex++
          return !isFinished()
     }

     fun totalVariants(): Int = getCurrentTicket().variants.size

     fun getTotalTruCount():Int=trueCount

     fun getTotalWrongCount():Int=wrongCount

     fun getTotalSkipped():Int=tickets.size-(trueCount+wrongCount)
}